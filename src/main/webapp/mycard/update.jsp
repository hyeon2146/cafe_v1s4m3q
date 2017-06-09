<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
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
$(function(){

});

</script>
 
</head> 
 
<body>
<DIV class='container'>
<DIV class='content'>
 
<DIV style='font-size: 20px; padding: 100px;'> 
  <A href="./proc.jsp?productno=1&price=20000&count=1">카드 이름 수정</A><br> 
 
  <br>
  <form name='frm' id='frm' method='post' action='./update.do'> 
    <input type="hidden" name='mno' id='mno' value='${mno }'>
    <input type='hidden' name='mycardno' value='${mycardVO.mycardno}'>     
       카드 별칭: <input type='text' name='cname' id='cname' value='${mycard.cname }'><br>    
    <button type='submit'>수정</button><br>
  </form>
</DIV>
 
 
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
 
</html> 