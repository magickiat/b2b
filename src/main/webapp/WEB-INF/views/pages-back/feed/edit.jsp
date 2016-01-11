<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title>Backend-Create Feed Content</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
	    <form:form class="form-horizontal" servletRelativeAction="/backend/feed-contents/edit" method="post"
	               modelAttribute="feedContentForm">
			<form:hidden path="id"/>
	        <div class="row">
	            <div class="col-sm-12">
	                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="col-sm-1">Title:</label>
	            <div class="col-sm-5">
	                <form:input path="title" cssClass="form-control"/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="col-sm-1">Content:</label>
	            <div class="col-sm-5">
	                <form:textarea path="content" rows="5" cols="30" cssClass="form-control"/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <div class="col-sm-5">
	                <button type="submit" class="btn btn-primary">Submit</button>
	            </div>
	        </div>
	
	    </form:form>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	<script src="<c:url value="/scripts/ckeditor/ckeditor.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			CKEDITOR.replace('content');
	    });
	</script>
</body>
</html>