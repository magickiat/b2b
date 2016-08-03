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

			<div class="row col-sm-12 bg_color showline2">
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
			            
			            	<div class="form-horizontal">
								 
								 <div class="form-group">
								    <label for="title" class="col-sm-2 control-label">Title(*): </label>
								    <div class="col-sm-10">
								      <form:input path="title" cssClass="form-control" />
								    </div>
								 </div>
								 
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">Name(*):</label>
									<div class="col-sm-10">
										<form:input path="name" cssClass="form-control" />
									</div>
								</div>
				
								<div class="form-group">
									<label for="email" class="col-sm-2 control-label">Email:</label>
									<div class="col-sm-10">
										<form:input path="email" cssClass="form-control" />
									</div>
								</div>
				
								<div class="form-group">
									<label for="detail" class="col-sm-2 control-label">Detail:</label>
									<div class="col-sm-10">
										<form:textarea path="detail" cssClass="form-control" rows="5" />
									</div>
								</div>
				
								<div class="form-group">
									<label for="tel" class="col-sm-2 control-label">Tel:</label>
									<div class="col-sm-10">
										<form:input path="tel" cssClass="form-control" />
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</div>
								 
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
