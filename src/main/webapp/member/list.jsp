<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
  src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
  $(function() {

  });
</script>
</head>

<body>
  <DIV class='container'>
    <jsp:include page="/menu/top.jsp" flush='false' />
    <DIV class='content'>

      <DIV class='title'>회원 목록</DIV>

      <TABLE class='table'>
        <caption>관리자만 접근가능합니다.</caption>
        <colgroup>
          <col style='width: 5%;' />
          <col style='width: 10%;' />
          <col style='width: 10%;' />
          <col style='width: 20%;' />
          <col style='width: 30%;' />
          <col style='width: 15%;' />
          <col style='width: 10%;' />
        </colgroup>
        <TR>
          <TH class='th'>번호</TH>
          <TH class='th'>ID</TH>
          <TH class='th'>성명</TH>
          <TH class='th'>전화번호</TH>
          <TH class='th'>주소</TH>
          <TH class='th'>등록일</TH>
          <TH class='th'>기타</TH>
        </TR>

        <c:forEach var="memberVO" items="${list }">
          <c:set var="mno" value="${memberVO.mno }" />
          <TR>
            <TD class='td'>${mno }</TD>
            <TD class='td'><A href="./read.do?mno=${mno }">${memberVO.id }</A></TD>
            <TD class='td'><A href="./read.do?mno=${mno }">${memberVO.mname }</A></TD>
            <TD class='td'>${memberVO.tel }</TD>
            <TD class='td'>
             <c:choose>
               <c:when test="${memberVO.address1.length() > 15 }">
                 ${memberVO.address1.substring(0,15) }...
               </c:when>             
               <c:otherwise>
                 ${memberVO.address1 }
               </c:otherwise>
             </c:choose>
            </TD>
            <TD class='td'>  ${memberVO.mdate.substring(0,10) }</TD>
            <!-- 년월일 -->
            <TD class='td'><A
              href="./passwd_update.do?mno=${mno }"><IMG
                src='./images/passwd.png' title='패스워드 변경'></A> <A
              href="./read.do?mno=${mno }"><IMG
                src='./images/update.png' title='수정'></A> <A
              href="./delete.do?mno=${mno }"><IMG
                src='./images/delete.png' title='삭제'></A></TD>

          </TR>
        </c:forEach>

      </TABLE>

      <DIV class='bottom_menu'>
        <button type='button' onclick="location.href='./create.do'">등록</button>
        <button type='button' onclick="location.reload();">새로
          고침</button>
      </DIV>

    </DIV>
    <!-- content END -->
    <jsp:include page="/menu/bottom.jsp" flush='false' />
  </DIV>
  <!-- container END -->
</body>

</html>
