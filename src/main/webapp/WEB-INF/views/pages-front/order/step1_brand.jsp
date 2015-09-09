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
		<c:choose>
			<c:when test="${empty user.customer }">
				<div class="row">
					<h3>Not found Customer.</h3>
				</div>
			</c:when>
			<c:when test="${empty user.customer.brands }">
				<div class="row">
					<h3>Not found any brand for this customer.</h3>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${ user.customer.brands }" var="brand">
					<div>${ brand }</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>