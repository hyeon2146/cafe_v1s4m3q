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
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
  $(function() {

  });
</script>
</head>

<body>
  <DIV class='container'>
    <jsp:include page="/menu/top.jsp" flush='false' />
    <DIV class='content'>

      <DIV class='title'>결제 목록</DIV>

      <TABLE class='table'>
        <caption>관리자만 접근가능합니다.</caption>
        <colgroup>
          <col style='width: 5%;' />
          <col style='width: 5%;' />
          <col style='width: 10%;' />
          <col style='width: 10%;' />
          <col style='width: 5%;' />
          <col style='width: 30%;' />
          <col style='width: 5%;' />
          <col style='width: 10%;' />
          <col style='width: 10%;' />
          <col style='width: 10%;' />
        </colgroup>
        <TR>
          <TH class='th'>결제 번호</TH>
          <TH class='th'>mno</TH>
          <!-- id로 바꿀것 -->
          <TH class='th'>이름</TH>
          <TH class='th'>전화번호</TH>
          <TH class='th'>우편번호</TH>
          <TH class='th'>주소</TH>
          <TH class='th'>카드</TH>
          <TH class='th'>합계금</TH>
          <TH class='th'>결제일</TH>
          <TH class='th'>수정/취소</TH>
        </TR>

        <c:forEach var="payVO" items="${list }">
          <TR>
            <TD class='td'>${payVO.payno }</TD>
            <TD class='td'>${payVO.mno }</TD>
            <TD class='td'>${payVO.rname }</TD>
            <TD class='td'>${payVO.tel }</TD>
            <TD class='td'>${payVO.zipcode }</TD>
            <TD class='td'>${payVO.address1 } ${payVO.address2 } <%-- <c:choose>
               <c:when test="${payVO.address1.length() > 15 }">
                 ${memberVO.address1.substring(0,15) }...
               </c:when>             
               <c:otherwise>
                 ${memberVO.address1 }
               </c:otherwise>
             </c:choose> --%>
            </TD>
            <TD class='td'>${payVO.mycardno }</TD>
            <TD class='td'>${payVO.total }</TD>
            <TD class='td'>${payVO.rdate }</TD>
            <TD class='td'><A
              href="./update.do?payno=${payVO.payno }">결제 수정</A>/<A
              href="./delete.do?payno=${payVO.payno }">결제 취소</A></TD>


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
