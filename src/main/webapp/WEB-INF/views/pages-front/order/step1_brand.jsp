<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>
<body>

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step1.png" />'
				width="100%">
		</div>

		<div class="row">&nbsp;</div>
		<div class="row">
			<c:choose>
				<c:when test="${empty brandGroupList }">
					<h3>Not found any brand for this customer.</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${ brandGroupList }" var="brand"
						varStatus="rowCount">

						<!-- Brand Logo -->
						<div class="col-md-4" style="margin-top: 30px;">
							<a
								href='<c:url value="/frontend/order/step2/index?brand_id=${ brand.brandGroupId }" />'>
								<c:choose>
									<c:when test="${brand.brandGroupId == 30}">
										<img
											src='<c:url value="/images/pages-front/icon/airush.png" />'
											id="airushicon">
									</c:when>
									<c:when test="${brand.brandGroupId == 20}">
										<img
											src='<c:url value="/images/pages-front/icon/starboard.png" />'>
									</c:when>
									<c:when test="${brand.brandGroupId == 40}">
										<img
											src='<c:url value="/images/pages-front/icon/severne.png" />'
											id="severneicon">
									</c:when>

									<c:when test="${brand.brandGroupId == 10}">
										<img
											src='<c:url value="/images/pages-front/icon/starboard.png" />'
											id="starboardicon">
									</c:when>
								</c:choose>
							</a>
						</div>

					
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
	</script>
</body>
</html>