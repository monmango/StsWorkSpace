<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>관리자 페이지 - 구인</title>

 <!-- Custom fonts for this template-->
  <link href="mypage/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="mypage/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="mypage/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">
	<!-- Navbar -->
	<jsp:include page="/WEB-INF/view/admin/common/admin_nav.jsp"></jsp:include>
	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/admin/common/admin_sidebar.jsp"></jsp:include>
		<div id="content-wrapper">
			<div class="container-fluid">
        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> 구인 목록
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                  	<th>회사명</th>
                    <th>근무지역</th>
                    <th>모집인원</th>
                    <th>성별</th>
                    <th>구인연령</th>
                    <th>작성자 코드</th>
                    <th>삭제</th>
                  </tr>
                </thead>
               
                <tbody id="tbody">
					<c:forEach items="${job}" var="dto" varStatus="status">
						<tr>
						<c:url var="delete" value="adminJobDelete.do">
						<c:param name="job" value="${dto.job}" />
						</c:url>
							<td>${dto.j_company}</td>
							<td>${dto.j_area}</td>
							<td>${dto.j_recruitment}</td>
							<td>${dto.j_gender}</td>
							<td>${dto.j_age}</td>
							<td>${dto.usercode}</td>
							<td><a href="${delete}" ><input type="button" value="삭제" id="reviewBtn" name="reviewBtn" /></a></td>
						</tr>
					</c:forEach>
                </tbody>
              </table>
            </div>
          </div>
         
        </div>

      

			</div>
			<!-- /.container-fluid -->
			
			<!-- Footer -->
			<jsp:include page="/WEB-INF/view/admin/common/admin_footer.jsp"></jsp:include>
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

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
