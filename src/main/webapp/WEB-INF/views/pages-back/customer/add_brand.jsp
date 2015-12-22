<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Brand</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		<form:form servletRelativeAction="/backend/customer/add_brand"
			cssClass="form-horizontal" commandName="brandForm" method="post">

			<form:hidden path="custId" />

			<form:checkboxes items="${ brands }" path="selectedBrand"
				itemLabel="productTypeName" itemValue="productTypeId" element="span class='checkbox'" />


			<div class="form-group">
				<input type="submit" value="Save" />
			</div>
		</form:form>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>