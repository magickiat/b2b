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
				<div class="col-md-12 bg_color" style="padding-bottom: 50px;">
					<div class="row row-header2 header2 txtupper">Download</div>
					<div class="row">&nbsp;</div>
					<div class="row">
						<div class="col-sm-2">
							<img alt="download product image"
								src='<c:url value="/images/pages-front/icon/download-productimage.png" />'
								onclick="popupDownloadProductImage()" data-toggle="modal"
								data-target="#display">
						</div>
						<div class="col-sm-10"></div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<div id="display" class="modal fade" role="dialog">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3>
						<span id="dialog-title"></span>
					</h3>
				</div>
				<div id="dialog-body" class="modal-body"></div>
				<div class="modal-footer">
					<div class="col-sm-12 text-right">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


	</div>


	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		function popupDownloadProductImage() {
			resetDialog();

			setDialogTitle('Download Product Image');

			$.get('<c:url value="/frontend/download/list-brand.json" />',
				function(data) {
					var result = '<ul>';
					$.each(data, function(key, value) {
						result += '<li><a href="<c:url value="/frontend/download/product-image/' +value.productTypeId+'" />">' + value.productTypeName + '</a></li>';
					});
					result += '</ul>';
					setDialogBody(result);
				});
		}

		function setDialogTitle(title) {
			$('#dialog-title').text(title);
		}

		function setDialogBody(content) {
			$('#dialog-body').html(content);
		}

		function resetDialog() {
			$('#dialog-title').text('');
			$('#dialog-body').html('');
		}
	</script>
</body>
</html>
