<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.html" name="frm" method="post">
		<p><span>이름</span><input type="text" name="name" /></p>
		<p><span>나이</span><input type="text" name="age" /></p>
		<p><span>지역</span><input type="text" name="loc" /></p>
		<p><input type="submit" value="commit" /></p>
	</form>
</body>
</html>