<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<img src='<c:url value="/images/pages-front/icon/step1.png" />' />
			</div>

			<div class="row">&nbsp;</div>

			<div class="row bg_color showline2">
				<div class="col-md-12">
					<div class="row row-header2 header2 txtupper">Choose Brand</div>
					<c:choose>
						<c:when test="${empty brandGroupList }">
							<h3>Not found any brand for this customer.</h3>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ brandGroupList }" var="brand"
								varStatus="rowCount">
								<!-- Brand Logo -->
								<div class="col-md-3">

									<a href='<c:url value="/frontend/order/step2/index?brand_id=${ brand.brandGroupId }" />'>
										<c:choose>
											<c:when test="${brand.brandGroupId == 10}">
												<img title="starboard"
													src='<c:url value="/upload/brand/logo/starboard.png" />'
													id="starboardicon" onerror="getDefaultFileImageName(this)"
													class="default-thumbnail" />
											</c:when>

											<c:when test="${brand.brandGroupId == 30}">
												<img title="airush"
													src='<c:url value="/upload/brand/logo/airush.png" />'
													id="airushicon" onerror="getDefaultFileImageName(this)"
													class="default-thumbnail" />
											</c:when>

											<c:when test="${brand.brandGroupId == 40}">
												<img title="severne"
													src='<c:url value="/upload/brand/logo/severne.png" />'
													id="severneicon" onerror="getDefaultFileImageName(this)"
													class="default-thumbnail" />
											</c:when>

											<c:when test="${brand.brandGroupId == 50}">
												<img title="drake"
													src='<c:url value="/upload/brand/logo/drake.png" />'
													id="drake" onerror="getDefaultFileImageName(this)"
													class="default-thumbnail" />
											</c:when>
										</c:choose>
									</a>

								</div>

							</c:forEach>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

</body>
</html>
