<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

			<div class="row showline2">
				<div class="col-md-12">
					<div class="row row-header2 header2">Sync from AX</div>
				</div>


				<div class="col-sm-12">&nbsp;</div>

				<div class="col-sm-6">
					<input type="button" class="btn btn-success center-block"
						onclick="confirmSync()" value="Begin Sync" />
				</div>
				<div class="col-sm-6">
					<input type="button" class="btn btn-success center-block"
						onclick="refresh()" value="Refresh" />
				</div>
				<div class="col-sm-12">&nbsp;</div>
			</div>



			<!-- Base URL for pagination -->
			<c:set var="baseUrl" value="/backend/admin/sync" />
			<div class="row">
				<%@include file="/WEB-INF/views/include/paging.jspf"%>
			</div>



			<div class="row bg_color showline2">
				<div class="col-sm-12">
					<table class="table table-hover" id="list_user">
						<thead>
							<tr>
								<th width="25%">No.</th>
								<th width="25%">Sync Date</th>
								<th width="25%">Status</th>
								<th width="25%">Remark</th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${ empty resultPage.result }">
									<tr>
										<td colspan="4" class="text-center">Not found any sync
											information</td>
									</tr>
								</c:when>
								<c:otherwise>

									<c:set var="rowBegin"
										value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>


									<c:forEach items="${ resultPage.result }" var="sync"
										varStatus="rowNum">
										<tr id="${user.id }" style="cursor: pointer;">
											<td nowrap="nowrap">${ rowBegin + (rowNum.index + 1) }</td>
											<td nowrap="nowrap"><fmt:formatDate
													pattern="dd-MM-yyyy HH:mm" value="${sync.syncDate }" /></td>
											<td nowrap="nowrap">${ sync.status }</td>
											<td nowrap="nowrap">${ sync.remark }</td>

										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>


						</tbody>
					</table>
				</div>
			</div>







		</div>

	</div>



	<div id="div_dialog_confirm_sync" class="modal fade" tabindex="-1"
		role="dialog" aria-labelledby="myLargeModalLabel01"
		style="display: none;">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title">Confirm?</h5>
				</div>
				<div class="modal-body">Are you sure?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-success">Confirm</button>
				</div>
			</div>
		</div>
	</div>


	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>



	<script type="text/javascript">
		$('#div_dialog_confirm_sync .btn-success')
				.on(
						'click',
						function() {
							console.log('begin sync ax');
							$
									.post(
											'<c:url value="/backend/admin/sync-from-ax"/>')
									.done(
											function(response) {
												$('#div_dialog_confirm_sync')
														.hide();
												showDialog('Sync process has begin<br/>Please wait for a moment for process complete.');
												setTimeout(
														function() {
															window.location.href = '<c:url value="/backend/admin/sync-from-ax" />';
														}, 3000);
											})
									.fail(
											function(result) {
												$('#div_dialog_confirm_sync')
														.hide();
												console.log('Error: '
														+ result.responseText);
												showDialog(result.responseText);
											});
						});

		function confirmSync() {
			$('#div_dialog_confirm_sync').modal();
		}

		function refresh() {
			window.location.href = "";
		}
	</script>

</body>
</html>
