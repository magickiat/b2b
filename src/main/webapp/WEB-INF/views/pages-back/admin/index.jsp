<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

		<div class="col-md-12">

			<div class="row">
				<div class="col-md-12 bg_color">
					<div class="row row-header2 header2">Admin page</div>
				</div>
			</div>
			<div class="row">&nbsp;</div>
			<div class="row bg_color showline2" style="min-height: 200px;">
				<div class="col-sm-12">&nbsp;</div>
				<div class="col-sm-12">
					<a class="btn btn-primary" href='<c:url value="/backend/admin/file/list" />'>Upload image</a>
					<a class="btn btn-primary" style="margin-right: 10px;"
						href='<c:url value="/backend/product/upload/product-price" />'>Upload Product Price</a>
				</div>
			</div>


			<div class="row">&nbsp;</div>
			
			<%-- Sync B2b -> AX --%>
			<div class="row bg_color">

				<div class="col-sm-12 header2" style="margin-bottom: 10px;">Sync <font color="red">B2B</font> -> <font color="blue">AX</font></div>
				<div class="col-sm-12 bg_color text-center" style="min-height: 100px;">
					<a class="btn btn-primary" href='#' title="Copy order and ord_detail to tmp_ro table and copy from tmp_ro to tmp_so and tmp_invoice">Sync RO</a>
				</div>

			</div>
			
			<%-- Sync AX -> B2B --%>
			<div class="row">&nbsp;</div>
			<div class="row bg_color">

				<div class="col-sm-12 header2" style="margin-bottom: 10px;">Sync <font color="blue">AX</font> -> <font color="red">B2B</font></div>
				<div class="col-sm-12 bg_color text-center" style="min-height: 100px;">
					<a class="btn btn-primary" href='#'>Sync Selling Order</a>
				</div>

			</div>

		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
