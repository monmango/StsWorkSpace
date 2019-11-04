<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="css/header.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/header.js" ></script>
<title>Insert title here</title>
<script type="text/javascript">

 $(document).ready(function(){
	var chk = '${empty sessionScope.chk}'=='true'?true:false;
	init(chk);

});
</script>
</head>
<body>
	<p id="logInPage">
		<a href="login.do?returnUrl=${param.returnUrl}">로그인</a>
	</p>
	<p id="logOutPage">
		<a href="logout.do">로그아웃</a>
	</p>
	<div>
		<p>index page</p>
	</div>
	<p>
		<a href="noticeList.do">notice</a>
	</p>
</body>
</html>