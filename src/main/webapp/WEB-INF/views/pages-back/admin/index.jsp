<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
<link rel="stylesheet"
	href="<c:url value="/scripts/backend/css/bginfo.css"/>">
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">

		<div class="col-md-12">

			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<div class="col-md-6 row row-header2 header2 txtupper">System</div>

					<div class="row"></div>

					<div class="col-sm-3">
						<div class="panel-stat3 bg-info" id="sync-ax">
							<h3 class="m-top-none">
								<span id="serverloadCount"> <a style="color: #fff;"
									href='<c:url value="/backend/admin/sync-from-ax" />'>Sync from AX</a>
								</span>
							</h3>
							<h5>Sync data from AX</h5>
							<div class="stat-icon">
								<i class="fa fa-refresh fa-3x"></i>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="panel-stat3 bg-info" id="syncAx">
							<h3 class="m-top-none">
								<span> <a style="color: #fff;"
									href='<c:url value="/backend/email" />'>Set email</a>
								</span>
							</h3>
							<h5>Email Settings</h5>
							<div class="stat-icon">
								<i class="fa fa-envelope fa-3x"></i>
							</div>
						</div>
					</div>
					<div class="col-sm-3"></div>
					<div class="col-sm-3"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">&nbsp;</div>
			</div>
			<div class="row">
				<div class="col-sm-12 bg_color showline2">

					<div class="col-md-6 row row-header2 header2 txtupper">Products</div>
					<div class="col-sm-12"></div>
					<div class="col-sm-3">
						<div class="panel-stat3 bg-info" id="set_image">
							<h3 class="m-top-none">
								<span id="serverloadCount"> <a style="color: #fff;"
									href='<c:url value="/backend/admin/file/list" />'>Image</a>
								</span>
							</h3>
							<h5>Upload Image</h5>
							<div class="stat-icon">
								<i class="fa fa-picture-o fa-3x"></i>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel-stat3 bg-info" id="set_prdprice">
							<h3 class="m-top-none">
								<span id="serverloadCount"> <a style="color: #fff;"
									href='<c:url value="/backend/product/upload/product-price" />'>Product
										Price</a>
								</span>
							</h3>
							<h5>Upload Product Price</h5>
							<div class="stat-icon">
								<i class="fa fa-money fa-3x"></i>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<%-- <a href='<c:url value="/backend/product/download" />' class="pull-right btn btn-primary">Download Template</a> --%>
						<div class="panel-stat3 bg-info" id="download_template">
							<h3 class="m-top-none">
								<span id="serverloadCount"> <a style="color: #fff;"
									href='<c:url value="/backend/product/download" />'>Download
										Template</a>
								</span>
							</h3>
							<h5>Download Template</h5>
							<div class="stat-icon">
								<i class="fa fa-file-excel-o fa-3x"></i>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<form id="uploadForm"
							action='<c:url value="/backend/product/upload" />' method="get">
							<input type="hidden" id="csrftoken_"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
							<div class="panel-stat3 bg-info" id="upload_product">
								<h3 class="m-top-none">
									<span id="serverloadCount"> <input type="submit"
										value="Upload Product" class=""
										style="margin-right: 5px; background: none; border: none;" />
									</span>
								</h3>
								<h5>Upload Product</h5>
								<div class="stat-icon">
									<i class="fa fa-cloud-upload fa-3x"></i>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">&nbsp;</div>
			</div>
			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<div class="col-md-6 row row-header2 header2 txtupper">Template Settings</div>

					<div class="row"></div>

					<div class="col-sm-3">
						<div class="panel-stat3 bg-info" 
							onclick="window.location='<c:url value="/backend/admin/template/list?currentPath=Frontend&folder=Frontend" />'">
							<h3 class="m-top-none">
								<span> <a style="color: #fff;"
									href='<c:url value="/backend/admin/template/list?currentPath=Frontend&folder=Frontend" />'>Background Image</a>
								</span>
							</h3>
							<h5>Settings Background Image</h5>
							<div class="stat-icon">
								<i class="fa fa-th-large fa-3x"></i>
							</div>
						</div>
					</div>

					<div class="col-sm-3"></div>
					<div class="col-sm-3"></div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript">
		$(function() {
			$('#set_email').click(function() {
				window.location = '<c:url value="/backend/email" />';
			});
			$('#set_image').click(function() {
				window.location = '<c:url value="/backend/admin/file/list" />';
			});
			$('#set_prdprice')
					.click(
							function() {
								window.location = '<c:url value="/backend/product/upload/product-price" />';
							});
		});
	</script>
</body>
</html>
