<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dev.mvc.member.MemberVO" %>
 
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
 
</head> 
<body>
<DIV class='container'>
<jsp:include page="/menu/top.jsp" flush='false' />
<DIV class='content'>
 
<DIV class='title'>결제 취소</DIV>
 
<DIV class='content' style='width: 500px; text-align: center;'>
  <FORM name='frm' method='POST' action='./delete.do'>
    결제를 취소하면 복구 할 수 없습니다.<br><br>
    정말로 취소하시겠습니까?<br><br>         
    <input type='hidden' name='payno' value='${payno}'>     
        
    <button type="submit">결제 취소</button>
    <button type="button" onclick="location.href='./list.do'">돌아가기(목록)</button>
 
  </FORM>
</DIV>
 
</DIV> <!-- content END -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</DIV> <!-- container END -->
</body>
 
</html> 