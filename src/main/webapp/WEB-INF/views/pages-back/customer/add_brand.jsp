<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title><spring:message code="page.header"></spring:message></title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		
		<div class="row">
		
			<form:form servletRelativeAction="/backend/customer/add_brand"
					cssClass="form-horizontal" commandName="brandForm" method="post">
		
				<div class="col-sm-12 bg_color">
					<div class="row">
						<div class=" col-sm-9">
							<div class="row row-header2 header2 txtupper">Brand</div>
						</div>
						<div class="col-sm-3" style="margin-top: 10px;">
							<input type="submit" value="Save" class="btn btn-default pull-right" />
						</div>
					</div>
					<div class="col-sm-6 bg_color">
						<div style="margin-left: 10px;">
							<form:hidden path="custId" />
							<form:checkboxes items="${ brands }" path="selectedBrand"
								itemLabel="productTypeName" itemValue="productTypeId" element="span class='checkbox'" />
						</div>
					</div>
					<div class="col-sm-12">&nbsp;</div>
				</div>
			
			</form:form>
			
		</div>
	
	
		
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
</body>
</html>
