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
				<c:when test="${empty products }">
					<h3>Not found any product.</h3>
				</c:when>

				<c:otherwise>
					<c:forEach items="${ products }" var="product">
						<!-- Product -->
						<div class="col-md-2 product">
							<a href="#"> <img alt="${ product.name }"
								src='<c:url value="${ product.pictureMedium }" />' /> <span
								style="text-align: center;">${ product.model.name }</span>
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