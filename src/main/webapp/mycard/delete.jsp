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
 
<DIV class='title'>카드 삭제</DIV>
 
<DIV class='content' style='width: 500px; text-align: center;'>
  <FORM name='frm' method='POST' action='./delete.do'>
    <input type="hidden" name='mno' id='mno' value='${mno }'>
    <input type='hidden' name='mycardno' value='${mycardno}'> 
    카드를 삭제하면 복구 할 수 없습니다.<br><br>
    정말로 삭제하시겠습니까?<br><br>         
        
    <button type="submit">카드 삭제</button>
    <button type="button" onclick="location.href='./list.do'">돌아가기(목록)</button>
 
  </FORM>
</DIV>
 
</DIV> <!-- content END -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</DIV> <!-- container END -->
</body>
 
</html> 