<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>


		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step1.png" />'
				width="100%">
		</div>

		<div class="row">&nbsp;</div>
		<div class="row">
			<c:choose>
				<c:when test="${empty brandGroupList }">
					<h3>Not found Customer.</h3>
				</c:when>
				<c:when test="${empty user.customer.brands }">

					<h3>Not found any brand for this customer.</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${ brandGroupList }" var="brand">

						<!-- Brand Logo -->
						<div class="col-md-4" style="margin-top: 30px;">
							<a
								href='<c:url value="/frontend/order/step2?brand_id=${ brand.id }" />'>
								<c:choose>
									<c:when test="${brand.brandGroupId == 30}">
										<img
											src="${pageContext.request.contextPath}/pages-front/images/icon/airush.png"
											id="airushicon">
									</c:when>
									<c:when test="${brand.brandGroupId == 20}">
										<img
											src="${pageContext.request.contextPath}/pages-front/images/icon/starboard.png"
											id="starboardicon">
									</c:when>
									<c:when test="${brand.brandGroupId == 40}">
										<img
											src="${pageContext.request.contextPath}/pages-front/images/icon/severne.png"
											id="severneicon">
									</c:when>

									<c:when test="${brand.brandGroupId == 10}">
										<img
											src="${pageContext.request.contextPath}/pages-front/images/icon/starboard.png"
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
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>