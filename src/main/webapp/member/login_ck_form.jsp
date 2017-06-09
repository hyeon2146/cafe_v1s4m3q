<%@ page contentType="text/html; charset=UTF-8" %>
 
<%

Cookie[] cookies = request.getCookies();
Cookie cookie = null;
 
String ck_id = ""; // id 저장 변수
String ck_id_save = ""; // id 저장 여부를 체크하는 변수
String ck_passwd = ""; // passwd 저장 변수
String ck_passwd_save = ""; // passwd 저장 여부를 체크하는 변수
 
if (cookies != null) {
  for (int i=0; i < cookies.length; i++){
    cookie = cookies[i];
    
    if (cookie.getName().equals("ck_id")){
      ck_id = cookie.getValue();         // test1
    }else if(cookie.getName().equals("ck_id_save")){
      ck_id_save = cookie.getValue();  // Y, N
    }else if (cookie.getName().equals("ck_passwd")){
      ck_passwd = cookie.getValue();         // 1234
    }else if(cookie.getName().equals("ck_passwd_save")){
      ck_passwd_save = cookie.getValue();  // Y, N
    }
  }
}
%>
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title>로그인</title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
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
 
<DIV class='title' style='width: 20%;'>로그인</DIV>
 
<DIV style='width: 60%; margin: 0px auto;'>
<FORM name='frm' method='POST' action='./login.do'>
  <fieldset>
    <ul>
      <li>
        <label class='label' for='email'>ID</label>
        <input type='text' name='id' id='id' value='user1<%=ck_id %>' style='width: 50%;' autocomplete="off">
        <label>
        <input type='checkbox' name='id_save' value='Y' <%=(ck_id_save.equals("Y"))?"checked='checked'": "" %>> 저장
        </label>
      </li>
      <li>
        <label class='label' for='passwd'>패스워드</label>
        <input type='password' name='passwd' id='passwd' value='1234<%=ck_passwd %>' style='width: 50%;' autocomplete="off">
        <label>
        <input type='checkbox' name='passwd_save' value='Y' <%=(ck_passwd_save.equals("Y"))?"checked='checked'":"" %>> 저장
        </label>
      </li>
      <li class='center'>
        <button type='submit'>로그인</button>
        <button type='button' onclick="history.back();">취소</button>
        
      </li>
    </ul>
  </fieldset>
</FORM>
</DIV>
 
</DIV> <!-- content END -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</DIV> <!-- container END -->
</body>
 
</html> 
 