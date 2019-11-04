<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Member data</p>
	
	<form action="mem.htm" name="frm" method="post">
		<label for="fname">이름</label>
		<input type="text" name="name" id="fname" value="" /><br />
		<label for="fage">나이</label>
		<input type="text" name="age" id="fage" value="" /><br />
		<input type="submit" value="send" /><br />
	</form>
</body>
</html>