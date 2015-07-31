<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Environment</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<form:form servletRelativeAction="/gen_user" class="form-horizontal"
			commandName="registerForm" method="post">

			<div class="form-group">
				<label class="control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-10">
					<form:input path="username" class="form-control"
						placeholder="Enter Username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-10">
					<form:password class="form-control" path="password"
						placeholder="Enter password" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>