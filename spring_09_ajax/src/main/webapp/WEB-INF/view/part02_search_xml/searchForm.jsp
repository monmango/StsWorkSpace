<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="ajaxsrc/jquery02.js" ></script>
<title>Insert title here</title>
<style type="text/css">
table, td, th {
	border: 1px solid;
	border-collapse: collapse;
}

table {
	width: 80%;
	margin: auto;
}

th{
	background-color: yellow;
}
</style>
</head>
<body>
	<span>검색이름</span>
	<input type="text" name="data" id="data" />
	<input type="button" id="btn" value="commit" />
	<table id="wrap"></table>
</body>
</html>