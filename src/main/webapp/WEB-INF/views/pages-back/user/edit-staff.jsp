<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

				<div class="col-sm-12 bg_color showline2">
					<div class="row row-header2 header2 txtupper">Edit Account</div>

					<form:form id="userForm"
						servletRelativeAction="/backend/user/edit-staff"
						class="form-horizontal" modelAttribute="registerForm"
						method="post">

						<form:errors path="*" cssClass="alert alert-danger" element="div" />

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
								<form:password class="form-control" path="password"
									id="password" placeholder="Enter password" />
							</div>
							<label class="control-label col-sm-2" for="confirmPassword">Confirm
								Password:</label>
							<div class="col-sm-4">
								<form:password class="form-control" path="confirmPassword"
									id="confirmPassword" placeholder="Enter password" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-sm-2"> Contact Email:</label>
							<div class="col-sm-10">
								<form:input class="form-control" path="email"
									placeholder="Enter Email" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2"> Active:</label>
							<div class="col-sm-10">
								<form:checkbox path="enable" placeholder="Enter Email" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</div>
						<form:hidden path="userId" />
					</form:form>

				</div>


			</div>

		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
</body>
</html>
