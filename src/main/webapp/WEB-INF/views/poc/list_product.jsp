<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Product</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

		<div class="row">
			<h2>Welcome User Home</h2>
		</div>

		<div class="row">${ products }</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>