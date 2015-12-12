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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Backend-Create Feed Content</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	
	<div class="container">
	    <form:form class="form-horizontal" servletRelativeAction="/backend/feed-contents/create" method="post"
	               modelAttribute="feedContentForm">
	
	        <div class="row">
	            <div class="col-sm-12">
	                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="col-sm-1">หัวข้อ</label>
	            <div class="col-sm-5">
	                <form:input path="title" cssClass="form-control"></form:input>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="col-sm-1">เนื้อหา</label>
	            <div class="col-sm-5">
	                <form:textarea path="content" rows="5" cols="30" cssClass="form-control"></form:textarea>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <div class="col-sm-5">
	                <button type="submit" class="btn btn-primary">ตกลง</button>
	            </div>
	        </div>
	
	    </form:form>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	<script type="text/javascript">
	    $(document).ready(function () {
	
	    });
	</script>
</body>
</html>
