<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title>Create Customer - Starboard Windsurfing</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		<div class="row">
		
			<div class="col-sm-12 bg_color">
				<div class="row row-header2 header2 txtupper">Create Customer</div>
				
				<form:form servletRelativeAction="/backend/customer/create"
					class="form-horizontal" modelAttribute="customerForm" method="post">
					<div class="row">
						<div class="col-sm-12">
							<form:errors path="*" cssClass="alert alert-danger" element="div" />
						</div>
					</div>
	
					<div class="form-group row">
						<label class="control-label col-sm-2" for="code">Code:</label>
						<div class="col-sm-4">
							<form:input path="code" class="form-control"
								placeholder="Enter Code" />
						</div>
						<label class="control-label col-sm-2" for="name">Name:</label>
						<div class="col-sm-4">
							<form:input path="name" class="form-control"
								placeholder="Enter Name" />
						</div>
					</div>
	
					<div class="form-group row">
						<div class="col-sm-11"></div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form:form>
				
			</div>
			
			
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
