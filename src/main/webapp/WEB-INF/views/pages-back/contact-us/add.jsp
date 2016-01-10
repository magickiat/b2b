<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title>Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">

		<div class="row bg_color">
			<div class="col-sm-12">
				<h2>Contact Us</h2>
			</div>
		</div>

		<div class="row">&nbsp;</div>

		<div class="row">
			<div class="col-sm-12">
				<form:form servletRelativeAction="/backend/contactus/add"
					modelAttribute="createForm" cssClass="form-horizontal"
					method="post">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					
					<div class="form-group">
						<label for="title">Title</label>
						<form:input path="title" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="name">Name</label>
						<form:input path="name" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="email">Email</label>
						<form:input path="email" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="detail">Detail</label>
						<form:textarea path="detail" cssClass="form-control" rows="5" />
					</div>

					<div class="form-group">
						<label for="tel">Tel</label>
						<form:input path="tel" cssClass="form-control" />
					</div>

					<button type="submit" class="btn btn-default">Save</button>
				</form:form>
			</div>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
