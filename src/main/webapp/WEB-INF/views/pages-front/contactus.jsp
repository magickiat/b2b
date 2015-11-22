<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<div class="col-md-12 bg_color showline">
				<div class="row row-header header1 txtupper">contact us</div>
				<div style="min-height: 300px;">


					<div class="col-md-3">
						<div class="input-group date">
							<input type="text" class="form-control" value="12-02-2012">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-th"></span>
							</div>
						</div>

					</div>



				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"/>"></script>
	
	<script>
		jQuery(document).ready(function() {
			$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
			$('.date').datepicker();
		});
	
	</script>
</body>
</html>