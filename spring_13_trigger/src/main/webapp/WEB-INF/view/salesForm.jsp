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
	<form action="salesPro.do" name="frm" method="post">
		<table>
			<caption>물품입력</caption>
			<tr>
				<th>상품코드</th>
				<td>
					<select name="code">
						<c:forEach items="${aList}" var="dto">
							<option value="${dto}"> ${dto}
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>출고수량</th>
				<td><input type="text" name="sacnt" /></td>
			</tr>
			<tr>
				<th>출고단가</th>
				<td><input type="text" name="saprice" /></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="commit">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>