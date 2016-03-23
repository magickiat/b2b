<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

				<div class="col-sm-12 bg_color">
					<div class="row row-header2 header2 txtupper">My Information</div>


					<div>&nbsp;</div>

					<div class="row bg_color">

						<div class="col-md-2">Name</div>
						<div class="col-md-10">${ user.name }</div>

						<div class="col-md-2">Username</div>
						<div class="col-md-10">${ user.username }</div>

						<div class="col-md-2">Email</div>
						<div class="col-md-10">${ user.email }</div>

						<div class="col-md-2">Last active</div>
						<div class="col-md-10">
							<fmt:formatDate pattern="dd-MM-yyyy HH:mm"
								value="${user.lastActive }" />
						</div>

					</div>
					<div>&nbsp;</div>
				</div>


			</div>

		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
</body>
</html>
