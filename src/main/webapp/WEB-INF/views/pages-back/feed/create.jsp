<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 10/1/2015
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<div class="col-sm-12 bg_color showline2">
			<div class="row row-header2 header2 txtupper">Feed Content</div>
			
			<form:form class="form-horizontal" servletRelativeAction="/backend/feed-contents/create" method="post"
	               modelAttribute="feedContentForm">
	
		        <div class="row">
		            <div class="col-sm-12">
		                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
		            </div>
		        </div>
		
		        <div class="form-group">
		            <label class="col-sm-1">Title(*):</label>
		            <div class="col-sm-11">
		                <form:input path="title" cssClass="form-control"></form:input>
		            </div>
		        </div>
		
		        <div class="form-group">
		            <label class="col-sm-1">Content:</label>
		            <div class="col-sm-11">
		                <form:textarea path="content" rows="5" cols="30" cssClass="form-control"></form:textarea>
		            </div>
		        </div>
		
		        <div class="form-group">
		            <div class="col-sm-12">
		                <button type="submit" class="btn btn-primary pull-right">Submit</button>
		            </div>
		        </div>
		
		    </form:form>
			
		</div>
		
	    
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<script src="<c:url value="/scripts/ckeditor/ckeditor.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			CKEDITOR.replace('content');
	    });
	</script>
</body>
</html>
