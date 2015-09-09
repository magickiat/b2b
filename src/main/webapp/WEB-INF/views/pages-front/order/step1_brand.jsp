<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>


		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step1.png" />'
				width="100%">
		</div>

		<div class="row">
			<img alt="logo"
				src='<c:url value="/upload/brand/logo/starboard.png" />'>
		</div>

		<div class="row">
			<input type="button" value="Click Me" onclick="openModal()" />

			<div id="add_brand" style="display: none;">Hello Modal Dialog</div>
		</div>


	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript">
		function openModal() {
			$("#add_brand").dialog({
				autoOpen : true,
				show : "fade",
				modal : true,
				width : 300,
				height : 330,
				buttons : {
					"Done" : function() {
						alert('complete');
					}
				}
			});
		}
	</script>
</body>
</html>