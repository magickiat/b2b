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
				<div class="col-sm-12 bg_color showline2">
					<div class="col-md-6 row row-header2 header2 txtupper">Admin</div>
					<div class="" style="margin-top: 15px;">
						<a class="btn btn-primary pull-right" href='<c:url value="/backend/admin/file/list" />'>Upload image</a>
						<a class="btn btn-primary pull-right" style="margin-right: 10px;"
							href='<c:url value="/backend/product/upload/product-price" />'>Upload Product Price</a>
					</div>
				</div>
			</div>
			<div class="row">&nbsp;</div>
			
			<%-- Sync B2b -> AX --%>
			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<div class="col-md-6 row row-header2 header2 txtupper">
						Sync <font color="red">B2B</font> -> <font color="blue">AX</font>
					</div>
					<div class="" style="margin-top: 15px;">
						<a class="btn btn-primary pull-right" href='#' title="Copy order and ord_detail to tmp_ro table and copy from tmp_ro to tmp_so and tmp_invoice">Sync RO</a>
					</div>
				</div>
			</div>
			<div class="row">&nbsp;</div>
			
			<%-- Sync AX -> B2B --%>
			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<div class="col-md-6 row row-header2 header2 txtupper">
						Sync <font color="blue">AX</font> -> <font color="red">B2B</font>
					</div>
					<div class="" style="margin-top: 15px;">
						<a class="btn btn-primary pull-right" href='#'>Sync Selling Order</a>
					</div>
				</div>
			</div>

		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
