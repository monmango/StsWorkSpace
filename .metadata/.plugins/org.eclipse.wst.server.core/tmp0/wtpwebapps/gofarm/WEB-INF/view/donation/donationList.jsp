<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나눔</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">

<!-- Font -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400,700"
	rel="stylesheet">

<!-- Stylesheets -->

<link href="product/p_plugin-frameworks/bootstrap.min.css" rel="stylesheet">
<link href="product/p_plugin-frameworks/swiper.css" rel="stylesheet">
<link href="product\p_fonts\ionicons\css\ionicons.css" rel="stylesheet">
<link href="product/common/styles.css" rel="stylesheet">

<style type="text/css">
.ftco-section {
	margin-top: 100px;
}

.bar {
	float: left;
	
}
.product-category{
	margin-bottom: 50px;
}


.pagelist a{
	text-decoration: none;
	color: black;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	vertical-align: middle;
}
.pagelist a:hover, .pagelist .pagecolor {
	text-decoration: none;
	color: #82EA46;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	vertical-align: middle;
}

</style>
<script src="main/plugin-frameworks/jquery-3.2.1.min.js"></script>
</head>
<body class="goto-here">
	<!-- nav -->
	<jsp:include page="/WEB-INF/view/common/main_nav.jsp"></jsp:include>
	<!-- END nav -->
	
	<section class="ftco-section">
	
		  <div class="container">
			<div class="row justify-content-center">
				<div class="col-md-10 mb-5 text-center">
					<ul class="product-category">
						<li><a href="productList.do" >판매</a></li>
						<li><a href="donationList.do" class="active">나눔</a></li>
						<li><a href="auctionList.do" >경매</a></li>
						<li><a href="donationProduce.do">나눔등록</a></li>
					</ul>
				</div>
			</div> 
			
			<!-- 상품 들어가는곳 -->
			<div class="row">
			<c:forEach items="${do_dto}" var="dto" varStatus="status">
			
				<div class="col-md-6 col-lg-3 ftco-animate">
				
				<input type="hidden" value="${dto.docode}" name="num" >
				
				<c:url var="path" value="donationView.do">
						<c:param name="currentPage" value="${pv.currentPage}" />
						<c:param name="docode" value="${dto.docode}" />
					</c:url>
					
					<div class="product">
						<a href="${path}" class="img-prod"><img class="img-fluid"
							src="/gofarm/profileUpload/${dto.do_file}" alt="Colorlib Template" style="width: 200px; height: 250px;"> 
							 </a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="${path}">${dto.do_product}</a>
							</h3>
							<%-- <div class="d-flex">
								<div class="pricing">
									<p class="price">
									<label>시작가</label>
										<span class="price-sale">${dto.stprice}</span>
									</p>
									<p class="price">
									<label>현재가</label>
										<span class="price-sale">${dto.ctprice}</span>
									</p>
									<input type="hidden" value="${dto.fin_time}" id="end">
									<p class="price" >
									<label>남은 시간</label>
										<p class="price-sale  ${status.count } ${dto.fin_time}" >
											<script type="text/javascript">
											timecount("${dto.fin_time}", ${status.count},${dto.auctioncode});
											</script> 
										</p>
										
									</p>
								</div>
							</div> --%>
						</div>
						
					</div>
				</div>
				
				</c:forEach>
				
				
			</div>
			<div class="pagelist">
		<!-- 이전 출력 시작 -->
		<c:if test="${pv.startPage >1}">
			<a href="donationList.sb?currentPage=${pv.startPage - pv.blockPage}">이전</a>
		</c:if>
		<!-- 이전 출력 끝 -->
			<!-- 페이지 출력시작 -->
			<c:forEach var="i" begin="${pv.startPage }" end="${pv.endPage }">
				<span> <c:url var="currPage" value="donationList.do">
							<c:param name="currentPage" value="${i}" />
					   </c:url>
					   <c:choose>
					        <c:when test="${i==pv.currentPage }">
								<a href="${currPage }" class="pagecolor"> <c:out value="${i}"></c:out></a>
					        </c:when>
					           <c:otherwise>
						            <a href="${currPage }"> <c:out value="${i}" /> </a>
					           </c:otherwise>
					  </c:choose>
					 </span>
			</c:forEach>
			<!-- 페이지 출력끝 -->
			<!-- 다음 출력 시작 -->
		<c:if test="${pv.totalPage >pv.endPage}">
			<a href="donationList.sb?currentPage=${pv.startPage +pv.blockPage}">다음</a>
		</c:if>
		
		<!-- 다음 출력 끝 -->
		</div>
		</div>
		
	</section>
	<!-- footer -->
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
	<!-- footer -->

	<script src="product/p_js/jquery.min.js"></script>
	<script src="product/p_js/jquery-migrate-3.0.1.min.js"></script>
	<script src="product/p_js/popper.min.js"></script>
	<script src="product/p_js/bootstrap.min.js"></script>
	<script src="product/p_js/jquery.easing.1.3.js"></script>
	<script src="product/p_js/jquery.waypoints.min.js"></script>
	<script src="product/p_js/jquery.stellar.min.js"></script>
	<script src="product/p_js/owl.carousel.min.js"></script>
	<script src="product/p_js/jquery.magnific-popup.min.js"></script>
	<script src="product/p_js/aos.js"></script>
	<script src="product/p_js/jquery.animateNumber.min.js"></script>
	<script src="product/p_js/bootstrap-datepicker.js"></script>
	<script src="product/p_js/scrollax.min.js"></script>
	
	<script src="product/p_js/main.js"></script>
	
	<!-- SCIPTS -->
	<script src="main/plugin-frameworks/bootstrap.min.js"></script>
	<script src="main/plugin-frameworks/swiper.js"></script>
	<script src="main/common/scripts.js"></script>
	
</body>
</html>