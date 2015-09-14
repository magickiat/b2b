<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Customer</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
		<div class="row">
			<form:form servletRelativeAction="/backend/customer/create"
				class="form-horizontal" modelAttribute="customerForm" method="post">
				<div class="row">
					<div class="col-sm-2">&nbsp;</div>
					<div class="col-sm-10">
						<form:errors path="*" cssClass="text-danger" element="div" />
					</div>
				</div>

				<div class="form-group">
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

				<div class="form-group">
					<div class="col-sm-11"></div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>