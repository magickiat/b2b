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
				<img src='<c:url value="/images/pages-front/icon/step2.png" />'>
			</div>
		
		
			<div class="row">

				<div class="col-md-12 bg_color">
					<div class="row row-header2 header2">ADD PRODUCT</div>
					<div class="row">&nbsp;</div>
					<div class="row">
	
						<c:choose>
							<c:when test="${empty brandId }">
								<h3>Not found Brand.</h3>
							</c:when>
	
							<c:otherwise>
								<!-- Quick Order -->
								<div class="col-md-2" style="margin-top: 30px;">
									<a
										href='<c:url value="/frontend/order/step2/search?brand_id=${ brandId }" />'>
										<img alt="Quick Order"
										src='<c:url value="/images/pages-front/icon/quick_order.png" />' />
									</a>
								</div>
	
								<!-- Upload Order -->
								<div class="col-md-2" style="margin-top: 30px; cursor: pointer;"
									data-toggle="modal" data-target="#upload-form">
									<img alt="Upload Order"
										src='<c:url value="/images/pages-front/icon/upload_order.png" />' />
								</div>
							</c:otherwise>
						</c:choose>
					</div>
	
					<div class="row">&nbsp;</div>
	
				</div>
			</div>
		
		</div>

	</div>
	
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script src="<c:url value="/scripts/frontend/order/order.upload.js"/>"></script>
	
</body>
</html>
