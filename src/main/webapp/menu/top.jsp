<%@ page contentType="text/html; charset=UTF-8" %>
<% String root = request.getContextPath(); %>
<!-- 화면 상단 메뉴 --> 
<DIV style='text-align: left'>
  IT 개발자 Blog ver 0.6
  <IMG src='<%=root %>/menu/images/top_image.JPG' width='100%' height='200px'><br>
  <nav>
    <span><a href='<%=root %>/index.jsp'>Home</a></span>
    <span class='hdiv'>ㅣ</span>
    <%
    if (session.getAttribute("id") == null){ // 회원 로그인 여부 검사
    %>
      <span><a href='<%=root %>/member/login.do'>로그인</a></span>
      <span class='hdiv'>ㅣ</span>
    <%     
    } else {
    %>
      <span><a href='<%=root %>/member/logout.do'>${id } 로그 아웃</a></span>
      <span class='hdiv'>ㅣ</span>     
    <%
    }
    %>   
    
    <span><a href='<%=root %>/member/create.do'>회원가입</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/member/list.do'>회원 목록</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/pay/create.do'>결제</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/pay/list.do'>결제 목록</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/pay/list_all.do'>전체 결제 목록(관리자)</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/mycard/list.do'>카드 목록</a></span>
    <span class='hdiv'>ㅣ</span>
    <span><a href='<%=root %>/mycard/list_all.do'>전체 카드 목록(관리자)</a></span>
    
  </nav>  
  <HR>
</DIV>