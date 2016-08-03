<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 1/22/2016
  Time: 21:31
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
	<link rel="stylesheet" href="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.css"/>" media="screen">
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		<div class="col-md-12 bg_color showline2">
			<div class="row row-header2 header2 txtupper">Event</div>
			<form:form class="form-horizontal" servletRelativeAction="/backend/event/create" method="post"
	               modelAttribute="eventForm">
		        <div class="row">
		            <div class="col-sm-12">
		                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-1">Title(*):</label>
		            <div class="col-sm-11">
		                <form:input path="title" cssClass="form-control"/>
		            </div>
		        </div>
				<div class="form-group">
					<label class="col-sm-1">Event Date:</label>
					<div class="col-sm-3">
						<div id="dateFromPicker" class="input-group date">
							<form:input path="timeEvent" cssClass="form-control" />
							<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
				</div>
		        <div class="form-group">
		            <label class="col-sm-1">Content:</label>
		            <div class="col-sm-11">
		                <form:textarea path="content" rows="5" cols="30" cssClass="form-control"/>
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
	<script src="<c:url value="/scripts/assets/datepicker/moment-with-locales.js"/>"></script>
	<script src="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.js"/>"></script>
	<script src="<c:url value="/scripts/ckeditor/ckeditor.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			// datepicker
			var timeEventPicker = $('#timeEvent');
			timeEventPicker.datetimepicker({ locale: 'en', format: 'YYYY-MM-DD H:mm'});
			CKEDITOR.replace('content');
	    });
	</script>
</body>
</html>
