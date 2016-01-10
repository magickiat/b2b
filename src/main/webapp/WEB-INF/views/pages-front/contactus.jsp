<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title>Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
		<div class="row showline2">
			<div class="col-sm-12">
				<c:choose>

					<c:when test="${ not empty resultPage.result  }">
						<c:forEach items="${ resultPage.result }" var="contact"
							varStatus="rowNum">
							<div class="row">
								<div class="col-sm-12">
									<h4>${ contact.contactTitle }</h4>
								</div>


								<div class="col-sm-1">Name</div>
								<div class="col-sm-11">${ contact.contactName }</div>


								<div class="col-sm-1">Email</div>
								<div class="col-sm-11">${ contact.contactEmail }</div>


								<div class="col-sm-1">Detail</div>
								<div class="col-sm-11">${ contact.contactDetail }</div>

								<div class="col-sm-1">Tel</div>
								<div class="col-sm-11">${ contact.contactTel }</div>


							</div>
							<hr />
						</c:forEach>

					</c:when>

					<c:otherwise>
					Not found contact
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

</body>
</html>
