<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
	
		<div class="col-md-12">
	
			<div class="row">
				<div class="col-md-12 bg_color showline2">
					<div class="row col-md-6 row-header2 header2 txtupper">Search Contact us</div>
					<div class="" style="margin-top:10px;">
						<form action='<c:url value="/backend/contactus/add" />'>
							<input type="submit" value="Add Contact"
								class="btn btn-default pull-right"
								style="width: 100px; " />
						</form>
					</div>
					<div class="col-sm-12">&nbsp;</div>
					<div class="col-sm-12">
						<form:form name="searchForm"
							servletRelativeAction="/backend/contactus/search"
							modelAttribute="searchForm" cssClass="form form-horizontal"
							method="GET">
		
							<%-- for paging --%>
							<form:hidden path="page" />
							
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-sm-2 control-label">SEARCH:</label>
									<div class="col-sm-10">
										<input type="text" id="keyword" name="keyword" class="form-control" />
									</div>
								</div>
							</div>
							
							<div class="col-md-6">
								<input type="button" class="btn btn-success pull-right" value="SEARCH" />
							</div>
							
						</form:form>
					</div>
					<div class="col-sm-12">&nbsp;</div>
				</div>
				
				
			</div>
			
			<div class="col-sm-12">&nbsp;</div>
			
			<c:choose>
				<c:when test="${ not empty resultPage.result }">
	
	
					<!-- Base URL for pagination -->
					<c:set var="baseUrl" value="/backend/contactus/search" />
					<div class="row">
						<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
					</div>
	
					<div class="row">
	
						<c:set var="rowBegin"
							value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>
	
						<div class="col-md-12 bg_color showline2">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>No.</th>
										<th>Title</th>
										<th>Name</th>
										<th>Email</th>
										<th>Detail</th>
										<th>Tel</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ resultPage.result }" var="contact"
										varStatus="rowNum">
		
										<tr>
											<td style="width: 20px;">${ rowBegin + (rowNum.index + 1) }</td>
											<td>${ contact.contactTitle }</td>
											<td>${ contact.contactName }</td>
											<td>${ contact.contactEmail }</td>
											<td>${ contact.contactDetail }</td>
											<td>${ contact.contactTel }</td>
											<td>
												<form id="${ contact.contactId }"
													action='<c:url value="/backend/contactus/delete" />'
													method="post">
													<input type="hidden" id="csrftoken_"
														name="${_csrf.parameterName}" value="${_csrf.token}" />
		
													<input type="hidden" name="id" value="${ contact.contactId }" />
													<input type="button" value="Delete" class="btn btn-danger btn-xs pull-right"
														onclick="return confirm(${ contact.contactId });">
		
		
												</form>
											</td>
		
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">&nbsp;</div>
					<div class="row bg_color">
						<div class="col-md-12 bg_color showline2"><div style="padding-bottom: 10px; padding-top: 10px;">Not found contact us</div></div>
					</div>
				</c:otherwise>
			</c:choose>
	
		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		function confirm(id) {
			$('<div></div>').appendTo('body')
			  .html('<div><h6>Do you want to delete contact?</h6></div>')
			  .dialog({
				dialogClass : 'style1',
				modal : true,
				title : 'message',
				zIndex : 10000,
				autoOpen : true,
				width : 'auto',
				resizable : false,
				buttons : {
					Yes : function() {
						$('#' + id).submit();
						$(this).dialog("close");
					},
					No : function() {
						$(this).dialog("close");
					}
				},
				close : function(event, ui) {
					$(this).remove();
				}
			});
		}
	</script>
</body>
</html>
