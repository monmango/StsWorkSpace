<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="js/header.js" ></script>
<script type="text/javascript">
$(document).ready(function() {
	var logchk  = '${empty sessionScope.chk}'=='true'?false:true;
	if('${param.returnUrl}' != ""){
		alert("요청한 페이지는 회원에게만 제공됩니다.");
	}
});




</script>


</head>
<body>
	<form action="logpro.do" name="frm" method="post">
		<p>
			<label for="id">아이디</label> <input type="text" name="id">
		</p>
		<p>
			<label for="pass">비밀번호</label> <input type="text" name="pass">
		</p>
		<p>
		<input type="text" name="returnUrl" value="${param.returnUrl}"/>
			<input type="submit" value="로그인">
		</p>
	</form>
</body>
</html>