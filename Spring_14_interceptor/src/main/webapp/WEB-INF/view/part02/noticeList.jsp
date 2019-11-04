<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<link href="css/header.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/header.js" ></script>
<script type="text/javascript">
	$(document).ready(function() {
		process("${param.returnUrl}");
	
	});


</script>
</head>
<body>
<div id="body">
<jsp:include page="logout.jsp" />
<p>noticeList</p>
</div>


</body>
</html>