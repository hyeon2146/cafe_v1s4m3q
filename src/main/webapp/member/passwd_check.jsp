<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
  
  $(function() {
    $('#popup').hide();
  });
 
  function send() {
    if ($('#passwd').val() != $('#passwd2').val()) { // 패스워드 입력 확인
      $('#popup').show();
      return false;
    }
    
    return true; 
  }
</script>
 
</head> 
 
 
<body>
<DIV class='container'>
<jsp:include page="/menu/top.jsp" flush='false' />
<DIV class='content' style='width: 60%;'>
 
  <!-- 레이어 선언 -->
  <DIV id='popup' class='popup1' style='height: 200px; display: none;'>
    알림 <br><br>
    패스워드가 일치하지 않습니다.<br><br><br>
    <SPAN class='box1'><A href="javascript: $('#popup').hide(); $('#passwd').focus();">CLOSE</A></SPAN>
  </DIV>
 
<DIV class='title'>패스워드 변경</DIV>
 
<FORM name='frm' method='POST' action='./passwd_update.do' 
            onsubmit="return send();">
  <input type='hidden' name='mno' id='mno' value='${mno }'>
                
  <fieldset>
    <ul>
      <li>
        <label class='label' for='old_passwd'>현재 패스워드</label>
        <input type='password' name='old_passwd' id='old_passwd' value='1234' required="required">
      </li>
      <li>  
        <label class='label' for='passwd'>새로운 패스워드</label>
        <input type='password' name='passwd' id='passwd' value='1234' required="required">
      </li>
      <li>
        <label class='label' for='passwd2'>새로운 패스워드 확인</label>
        <input type='password' name='passwd2' id='passwd2' value='1234' required="required">
      </li>
      <li class='right'>
        <button type="submit">변경</button>
        <button type="button" onclick="location.href='./list.do'">목록</button>
      </li>         
    </ul>
  </fieldset>
</FORM>
 
</DIV> <!-- content END -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</DIV> <!-- container END -->
</body>
 
</html> 