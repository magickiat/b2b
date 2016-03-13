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
	
		<div class="col-md-12">
		
			<div class="row">
				<div class="bg_color">
					<div class="row row-header2 header2 txtupper">Upload product</div>
				</div>
			</div>
			
			<div class="row">&nbsp;</div>
			
			<div class="row">
				
				<div class="col-sm-12 bg_color showline2">
				
					<div style="padding-top: 10px; padding-bottom: 10px;">
					
						<form id="uploadForm" action='<c:url value="/backend/product/upload" />' method="post"
							enctype="multipart/form-data" role="form">
							<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<div class="form-group">
								<label for="file">Select Excel Product:</label>
								<input type="file" name="file">
							</div>
							<input type="submit" value="Upload" class="btn btn-success" />
						</form>
					
					</div>
				
					
				</div>
				
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
