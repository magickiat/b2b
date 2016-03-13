<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

			<div class="row col-sm-12 bg_color">
				<div class="row row-header2 header2 txtupper">Contact Us</div>
				
				<form:form servletRelativeAction="/backend/contactus/add"
					modelAttribute="createForm" cssClass="form-horizontal"
					method="post">
					
					<div class="">
			            <div class="col-sm-12">
			                <form:errors path="*" cssClass="alert alert-danger" element="div" />
			            </div>
			        </div>
					
					<div class="">
			            <div class="col-sm-12">
			        		<div class="form-group">
								<label for="title">Title*</label>
								<form:input path="title" cssClass="form-control" />
							</div>
			
							<div class="form-group">
								<label for="name">Name*</label>
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
							
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
			            </div>
			        </div>
					
				</form:form>
			</div>
		
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
