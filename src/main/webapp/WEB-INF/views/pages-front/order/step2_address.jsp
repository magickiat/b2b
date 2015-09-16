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
				<c:when test="${empty brandId }">
					<h3>Not found Brand.</h3>
				</c:when>

				<c:otherwise>
					<!-- Quick Order -->
					<div class="col-md-2" style="margin-top: 30px;">
						<a href='<c:url value="/frontend/order/step2_search?brand_id=${ brandId }" />'> <img alt="Quick Order"
							src='<c:url value="/images/pages-front/icon/quick_order.png" />' />
						</a>
					</div>

					<!-- Upload Order -->
					<div class="col-md-2" style="margin-top: 30px;">
						<a href="#"> <img alt="Upload Order"
							src='<c:url value="/images/pages-front/icon/upload_order.png" />' />
						</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>