<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-12 bg_color">
				<div class="col-md-6 row row-header2 header2 txtupper">Product price</div>
				<div class="" style="margin-top: 15px;">
					<a href='<c:url value="/upload/product/product-price.xlsx" />' class="pull-right btn btn-primary">Download Template</a>
				</div>
			</div>
		</div>
		
		<div class="row">&nbsp;</div>

		<div class="row">
			<div class="col-sm-12 bg_color showline2">
				<div class="row">&nbsp;</div>
				<form id="uploadForm" action='<c:url value="/backend/product/upload/product-price" />'
					method="post" enctype="multipart/form-data" role="form">
					<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-group">
						<label for="file">Select Excel Product Price:</label>
						<input type="file" name="file">
					</div>
					<input type="submit" value="Upload" class="btn btn-success" />
				</form>
				<div class="row">&nbsp;</div>
				
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<c:if test="${ not empty msg }">

		<script type="text/javascript">
			var msg = '${msg}';
			showDialogAutoClose(msg);
		</script>
	</c:if>
</body>
</html>
