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
			<form:form servletRelativeAction="/backend/user/create" cssClass="form-horizontal"
			commandName="registerForm" method="post" onsubmit="return validateForm()">
			<form:hidden path="cusId"/>
			<form:hidden path="roles" value="ROLE_USER"/>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-4">
					<form:input path="name" class="form-control"
						placeholder="Enter Name" />
				</div>
				<label class="control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-4">
					<form:input path="username" class="form-control"
						placeholder="Enter Username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-4">
					<form:password class="form-control" path="password" id="password"
						placeholder="Enter password" />
				</div>
				<label class="control-label col-sm-2" for="confirmPassword">Confirm Password:</label>
				<div class="col-sm-4">
					<form:password class="form-control" path="confirmPassword"  id="confirmPassword"
						placeholder="Enter password" />
				</div>
				
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2"> Contact Email:</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="email"
						placeholder="Enter email" />
				</div>
			</div>
			<%-- <div class="form-group">
				<label class="control-label col-sm-2"> User role:</label>
				<div class="col-sm-10">
					<form:checkboxes element="span class='checkbox-inline'"
						items="${ roles }" path="roles" />
				</div>
			</div> --%>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/user/create.js" />'></script>
</body>
</html>
