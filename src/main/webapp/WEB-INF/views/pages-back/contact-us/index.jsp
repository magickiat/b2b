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

		<div class="row">
			<div class="col-sm-12">
				<h2>Contact us</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 text-right">
				<input type="button" class="btn btn-default" value="ADD" />
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12">&nbsp;</div>
		</div>


		<div class="row bg_color">
			<div class="col-sm-12">
				<div class="col-sm-1">Search:</div>
				<div class="col-sm-5">
					<input type="text" id="keyword" name="keyword" class="form-control" />
				</div>
				
				<div class="col-sm-6"><input type="button" class="btn btn-success" value="SEARCH" /></div>
			</div>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
