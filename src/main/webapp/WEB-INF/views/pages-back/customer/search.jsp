<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backend</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
		<div class="row">
			<div class="col-sm-10">
				<h2>Customer</h2>
			</div>
			<div class="col-sm-2">
				<form:form servletRelativeAction="/backend/customer/create"
					method="get">
					<input type="submit" value="Add Customer"
						class="btn btn-default pull-right" />
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover" id="list_customer">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resultPage.result }" var="customer">
							<tr style="cursor: pointer;"
								onclick="javascript:createUser('${customer.custId }');">
								<td>${customer.custCode }</td>
								<td>${customer.nameEn }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row pull-right">
			<div class="col-sm-12">
				<c:choose>
					<c:when test="${!empty resultPage.total and resultPage.total > 0}">
						<c:url var="firstUrl" value="/backend/customer?page=1" />
						<c:url var="lastUrl"
							value="/backend/customer?page=${resultPage.totalPage}" />
						<c:url var="prevUrl"
							value="/backend/customer?page=${resultPage.current - 1}" />
						<c:url var="nextUrl"
							value="/backend/customer?page=${resultPage.current + 1}" />

						<ul class="pagination">
							<!-- Previous 5 page -->
							<c:choose>
								<c:when test="${resultPage.current == 1}">
									<li class="disabled"><a href="#">&lt;&lt;</a></li>
									<li class="disabled"><a href="#">&lt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${firstUrl}">&lt;&lt;</a></li>
									<li><a href="${prevUrl}">&lt;</a></li>
								</c:otherwise>
							</c:choose>

							<c:forEach var="i" begin="${resultPage.beginPage }"
								end="${ resultPage.endPage }">
								<li
									<c:if test="${ i == resultPage.current }">class="active"</c:if>><a
									href='<c:url value="/backend/customer?page=${ i }" />'>${ i }</a></li>

							</c:forEach>

							<c:choose>
								<c:when test="${resultPage.current == resultPage.totalPage}">
									<li class="disabled"><a href="#">&gt;</a></li>
									<li class="disabled"><a href="#">&gt;&gt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${nextUrl}">&gt;</a></li>
									<li><a href="${lastUrl}">&gt;&gt;</a></li>
								</c:otherwise>
							</c:choose>

						</ul>

					</c:when>
					<c:otherwise>
						<h3>Not found data</h3>
					</c:otherwise>
				</c:choose>
			</div>

		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/search.js" />'></script>
</body>
</html>