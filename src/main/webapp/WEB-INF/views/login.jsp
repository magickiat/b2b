<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
<link type="text/css" href="<c:url value="/css/pages-back/login.css"/>"
	rel="stylesheet"></link>
</head>
<body>
	<div id="container">
		<div class="col-md-6 col-md-offset-2">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">Invalid UserName and Password.
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-2">
				<form:form servletRelativeAction="/login" class="form-horizontal"
					modelAttribute="loginForm" method="post">

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
							<div class="checkbox">
								<label><form:checkbox path="rememberMe" /> Remember me</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
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