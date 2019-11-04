<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
</head>
<body>
	<table>
		<caption>상품리스트</caption>
		<tr>
			<th>code</th>
			<th>name</th>
			<th>company</th>
			<th>price</th>
			<th>cnt</th>
		</tr>
		<c:forEach items="${aList }" var="dto">
			<tr>
				<td>${dto.code }</td>
				<td>${dto.name }</td>
				<td>${dto.company }</td>
				<td>${dto.price }</td>
				<td>${dto.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="productIns.do">입고</a>
		<a href="salesIns.do">판매</a>
	</p>
</body>
</html>