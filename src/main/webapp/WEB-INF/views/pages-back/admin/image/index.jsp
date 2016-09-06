<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
<link rel="stylesheet"
	href="<c:url value="/scripts/dropzone/dropzone.css" />">

</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-12 bg_color showline2">
				<div class="row col-md-6 row-header2 header2 txtupper">Image
					upload page</div>
				<div class="" style="margin-top: 10px;">
					<button style="" class="btn btn-danger pull-right"
						onclick="deleteFile()">Delete</button>
					<button style="margin-right: 5px;"
						class="btn btn-default pull-right" onclick="upload()">Upload</button>
					<button style="margin-right: 5px;"
						class="btn btn-default pull-right" onclick="newFolder()">New
						Folder</button>
					<button style="margin-right: 5px;"
						class="btn btn-default pull-right" onclick="back()">Back</button>
				</div>
				<div class="col-sm-12">&nbsp;</div>
			</div>
		</div>
		<%-- Folder --%>
		<div class="row bg_color showline2" style="margin-top: 10px;">
			<form action='<c:url value="/backend/admin/file/list"></c:url>'>
				<input type="hidden" id="folder" name="folder" value="${ folder }" />
				<input type="hidden" id="currentPath" name="currentPath"
					value="${ currentPath }" />
				<div class="col-sm-12">&nbsp;</div>
				<div class="col-sm-4">
					<label for="selectedFolder">Image Path:</label>
					<c:if test="${ not empty folders }">
						<select id="selectedFolder" name="selectedFolder"
							style="width: 200px;" class="form-control" onchange="list(this)">
							<c:forEach var="f" items="${ folders }">
								<c:set var="selected" value="" />
								<c:if test="${ folder eq f }">
									<c:set var="selected" value="selected" />
								</c:if>
								<option value="${ f }" ${ selected }>${ f }</option>
							</c:forEach>
						</select>
					</c:if>
				</div>
				<div class="col-sm-4">
					<label for="keyword">Filename:</label> <br /> <input type="text"
						id="keyword" name="keyword" class="form-control"
						value="${ keyword }" />
				</div>
				<div class="col-sm-4" style="">
					<label>&nbsp;</label> <br /> <input type="submit" value="Search"
						class="btn btn-success" />
				</div>
				<div class="col-sm-12">&nbsp;</div>
			</form>
		</div>



		<c:set var="baseUrl"
			value="/backend/admin/file/list?keyword=${ keyword }&folder=${ folder }" />
		<div class="row pull-right">
			<div class="col-sm-12">
				<c:choose>
					<c:when
						test="${not empty resultPage.total && resultPage.total > resultPage.pageSize}">

						<c:url var="firstUrl" value="${baseUrl}&page=1" />
						<c:url var="lastUrl"
							value="${baseUrl}&page=${resultPage.totalPage}" />
						<c:url var="prevUrl"
							value="${baseUrl}&page=${resultPage.current - 1}" />
						<c:url var="nextUrl"
							value="${baseUrl}&page=${resultPage.current + 1}" />

						<ul class="pagination">
							<!-- Previous 5 page -->
							<c:choose>
								<c:when test="${resultPage.current == 1}">
									<li><a>Total: ${ resultPage.total }</a></li>
									<li class="disabled"><a href="#">&lt;&lt;</a></li>
									<li class="disabled"><a href="#">&lt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a>Total: ${ resultPage.total }</a></li>
									<li><a href="${firstUrl}" onclick="${firstUrl}">&lt;&lt;</a>
									</li>
									<li><a href="${prevUrl}" onclick="${prevUrl}">&lt;</a></li>
								</c:otherwise>
							</c:choose>


							<c:forEach var="i" begin="${resultPage.beginPage }"
								end="${ resultPage.endPage }">
								<li
									<c:if test="${ i == resultPage.current }">class="active"</c:if>>
									<a href='<c:url value="${baseUrl}&page=${ i }" />'>${ i }</a>
								</li>

							</c:forEach>

							<c:choose>
								<c:when test="${resultPage.current == resultPage.totalPage}">
									<li class="disabled"><a href="#">&gt;</a></li>
									<li class="disabled"><a href="#">&gt;&gt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${nextUrl}" onclick="${nextUrl}">&gt;</a></li>
									<li><a href="${lastUrl}" onclick="${lastUrl}">&gt;&gt;</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</c:when>
					<c:otherwise>
						<div class="pagination">
							<div class="col-sm-12">
								&nbsp;<br />
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row"></div>


		<%-- Files --%>
		<div class="row bg_color showline2" style="margin-top: 10px;">

			<table class="table table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll" class="checkbox"
							onclick="checkAll()" /></th>
						<th width="20%">No</th>
						<th width="60%">File name</th>
						<th width="20%">Type</th>
					</tr>
				</thead>
				<tbody>


					<c:set var="rowBegin"
						value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>

					<c:forEach var="item" items="${ resultPage.result }"
						varStatus="rowNum">
						<tr>
							<td style="text-align: center; width: 50px;"><input
								type="checkbox" id="${ item.nameWithPath }" name="selectFile"
								class="checkbox" value="${ item.nameWithPath }" /></td>
							<td>${ rowBegin + (rowNum.index + 1) }</td>
							<td><c:choose>
									<c:when test="${ item.folder }">
										<span style="cursor: pointer; color: blue;"
											onclick="list('${ item.nameWithPath }')">${ item.name }</span>
									</c:when>
									<c:otherwise>
										<a href='<c:url value="/upload/${ item.nameWithPath }" />'>${ item.name }</a>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${ item.folder }">Folder</c:when>
									<c:otherwise>File</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	</div>



	<%-- New folder form --%>
	<%--
	<form id="newFolderForm"
		action='<c:url value="/backend/admin/file/new-folder" />'
		method="post" style="display: none;">

		<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<input type="hidden" id="subFolder" name="subFolder"
			value="${ subFolder }" />
		<div>
			Folder name:
			<input type="text" id="folderName" name="folderName" />
		</div>
	</form>
	--%>
	<div id="div_dialog_newfolder" class="modal fade" tabindex="-1"
		role="dialog" aria-labelledby="myLargeModalLabel01"
		style="display: none;">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title">New Folder</h5>
				</div>
				<div class="modal-body">
					<form id="newFolderForm" method="post"
						action='<c:url value="/backend/admin/file/new-folder" />'>
						<input type="hidden" id="subFolder" name="subFolder"
							value="${ subFolder }" /> <input type="hidden" id="csrftoken_"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="form-horizontal">
							<div class="row">
								<label for="txtEmail" class="col-sm-12 ">Folder name:</label>
								<div class="col-sm-12">
									<input type="text" id="folderName" class="form-control"
										name="folderName" />
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-success">Create</button>
				</div>
			</div>
		</div>
	</div>

	<%-- Upload dialog --%>
	<div id="uploadDialog" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="modal-title">
						<ul class="nav nav-pills" id="ImgTab">
							<li class="active"><a href="#uplod">Upload</a></li>
						</ul>
					</div>
					<div id='content' class="tab-content">
						<div class="tab-pane active" id="uplod">
							<form action="UploadImages" class="dropzone"
								id="my-awesome-dropzone" enctype="multipart/form-data">

								<input type="hidden" id="csrftoken_"
									name="${_csrf.parameterName}" value="${_csrf.token}" />

							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="model-cl1">Done</button>
				</div>
			</div>
		</div>
	</div>

	<%-- confirm delete --%>
	<div id="div_dialog_folder_confirm_delete" class="modal fade"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel01"
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
					<button type="button" class="btn btn-danger">Delete</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript"
		src='<c:url value="/scripts/dropzone/dropzone.js" />'></script>

	<script type="text/javascript">
		$('#div_dialog_newfolder').on('hide.bs.modal', function() {
			$('#folderName').val('');
		}).on('shown.bs.modal', function() {
			$('#folderName').select();
		});
		$('#div_dialog_newfolder .btn-success').on('click', function() {
			$('#newFolderForm').submit();
		});

		$('#div_dialog_folder_confirm_delete .btn-danger')
				.on(
						'click',
						function() {

							var subFolder = '${subFolder}';
							var files = [];
							$('input[name=selectFile]:checked').each(
									function(index, value) {
										files.push($(value).val());
									});
							if (files.length > 0) {

								console.log('files[0] = ' + files);
								var param = {
									'subFolder' : subFolder,
									'files[]' : files
								};

								$
										.post(
												'<c:url value="/backend/admin/file/delete.json" />',
												param)
										.done(
												function(data, statusText) {
													console.log('Delete '
															+ data + ' files');
												})
										.fail(
												function(xhr, textStatus,
														errorThrown) {
													alert('Error occured, please contact Administrator\n'
															+ xhr.responseText);
												});
							}

							list(subFolder);
						});

		function list(path) {
			var pathValue = '';
			if (path.value) {
				pathValue = path.value;
			} else {
				pathValue = path;
			}
			window.location.href = '<c:url value="/backend/admin/file/list?currentPath='
					+ pathValue
					+ '&folder='
					+ $('#selectedFolder').val()
					+ '" />';
		}

		function back() {
			list($('#selectedFolder').val());
		}

		function newFolder() {
			$('#div_dialog_newfolder').modal();
		}

		function upload() {
			$("#uploadDialog").modal('show');
		}

		var uploadURL = '<c:url value="/backend/admin/file/upload.json" />';
		Dropzone.options.myAwesomeDropzone = {
			paramName : "file",
			maxFilesize : 10,
			url : uploadURL + '?subFolder=${currentPath}',
			uploadMultiple : true,
			parallelUploads : 5,
			maxFiles : 100,
			acceptedFiles : "image/*",
			init : function() {
				var cd;
				this.on("success", function(file, response) {
					$('.dz-progress').hide();
					$('.dz-size').hide();
					$('.dz-error-mark').hide();
					console.log(response);
					console.log(file);
					cd = response;
				});
			}
		};
		$(document).on('click', '#model-cl1', function(f) {
			$('#uploadDialog').modal('hide');
			list('${currentPath}');
		});

		function checkAll() {
			$('input[name=selectFile]').click();
		}

		function deleteFile() {
			$('#div_dialog_folder_confirm_delete').modal();
		}
	</script>
</body>
</html>
