<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>마이페이지 - 구매</title>

 <!-- Custom fonts for this template-->
  <link href="mypage/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="mypage/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="mypage/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">
	<!-- Navbar -->
	<jsp:include page="/WEB-INF/view/mypage/common/mypage_nav.jsp"></jsp:include>
	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/mypage/common/mypage_sidebar.jsp"></jsp:include>
		<div id="content-wrapper">
			<div class="container-fluid">
        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> 내 구매 목록
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                  	<th>번호</th>
                    <th>상품명</th>
                    <th>구매수량</th>
                    <th>판매자 이름</th>
                    <th>판매자 연락처</th>
                    <th>구매일자</th>
                    <th>리뷰</th>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                 	<th>번호</th>
                    <th>상품명</th>
                    <th>구매수량</th>
                    <th>판매자 이름</th>
                    <th>판매자 연락처</th>
                    <th>구매일자</th>
                    <th>리뷰</th>
                  </tr>
                </tfoot>
                <tbody id="tbody">
					<c:forEach items="${myBuy_dto}" var="dto" varStatus="status">
						<tr>
						<c:url var="write" value="reviewWriteForm.do">
						<c:param name="prod_code" value="${dto.prod_code}" />
						</c:url>
							<td>${status.count}</td>
							<td><a href="productView.do?currentPage=1&prod_code=${dto.prod_code}">${dto.pd_name}</a></td>
							<td><fmt:formatNumber value="${dto.de_cnt}" pattern="###,###"/>개</td>
							<td>${dto.name}</td>
							<td>${dto.phone}</td>
							<td><fmt:formatDate value="${dto.de_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><a href="${write}" ><input type="button" value="쓰기" id="reviewBtn" name="reviewBtn" /></a></td>
						</tr>
					</c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>

			</div>
			<!-- /.container-fluid -->
			
			<!-- Footer -->
			<jsp:include page="/WEB-INF/view/mypage/common/mypage_footer.jsp"></jsp:include>
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- /#wrapper -->

  <!-- logOut -->
  <jsp:include page="/WEB-INF/view/mypage/common/mypage_logOut.jsp"></jsp:include>

  <!-- Bootstrap core JavaScript-->
  <script src="mypage/vendor/jquery/jquery.min.js"></script>
  <script src="mypage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="mypage/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="mypage/vendor/datatables/jquery.dataTables.js"></script>
  <script src="mypage/vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="mypage/js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="mypage/js/demo/datatables-demo.js"></script>

</body>

</html>
