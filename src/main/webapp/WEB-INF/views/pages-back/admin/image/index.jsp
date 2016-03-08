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
			<div class="col-sm-12 bg_color">
				<div class="row row-header2 header2">Image upload page</div>
				<div class="col-sm-12" style="text-align: right;">
					<button class="btn btn-danger" onclick="deleteFile()">Delete</button>
					<button class="btn btn-default" onclick="upload()">Upload</button>
					<button class="btn btn-default" onclick="newFolder()">New
						Folder</button>
					<button class="btn btn-default" onclick="back()">Back</button>
				</div>


			</div>
		</div>
		<%-- Folder --%>
		<div class="row bg_color">
			<div class="col-sm-12">
				<label for="selectedFolder">Image Path:</label>
				<c:if test="${ not empty folders }">
					<select id="selectedFolder" name="selectedFolder" style="width : 200px;"
						class="form-control" onchange="list(this)">
						<c:forEach var="folder" items="${ folders }">
							<c:set var="selected" value="" />
							<c:if test="${ selectedFolder eq folder }">
								<c:set var="selected" value="selected" />
							</c:if>
							<option value="${ folder }" ${ selected }>${ folder }</option>
						</c:forEach>
					</select>
				</c:if>
			</div>
		</div>

		<%-- Files --%>
		<div class="row bg_color">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkAll" class="checkbox"
								onclick="checkAll()" />
						</th>
						<th>No</th>
						<th>Sub folder</th>
						<th>File name</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${ listFile }" varStatus="rowNum">
						<tr>
							<td align="center">
								<input type="checkbox" id="${ item.nameWithPath }"
									name="selectFile" class="checkbox"
									value="${ item.nameWithPath }" />
							</td>
							<td>${ rowNum.index + 1 }</td>
							<td>${ subFolder }</td>
							<td>
								<c:choose>
									<c:when test="${ item.folder }">
										<a href="#" onclick="list('${ item.nameWithPath }')">${ item.name }</a>
									</c:when>
									<c:otherwise>
										<a href='<c:url value="/upload/${ item.nameWithPath }" />'>${ item.name }</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${ item.folder }"> Folder</c:when>
									<c:otherwise>File</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	</div>



	<%-- New folder form --%>
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

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript"
		src='<c:url value="/scripts/dropzone/dropzone.js" />'></script>

	<script type="text/javascript">
		function list(folder) {
			if (folder.value) {
				folder = folder.value;
			}
			window.location.href = '<c:url value="/backend/admin/file/list?folder='
					+ folder + '" />';
		}

		function back() {
			list($('#selectedFolder').val());
		}

		function newFolder() {
			$('#newFolderForm').dialog({
				modal : true,
				resizable : false,
				buttons : [ {
					text : "Create",
					click : function() {
						newFolderForm.submit();
					},
					type : "submit"
				}, {
					text : "Close",
					click : function() {
						$(this).dialog("close");
					}
				} ]
			});
		}

		function upload() {
			$("#uploadDialog").modal('show');
		}

		Dropzone.options.myAwesomeDropzone = {
			paramName : "file",
			maxFilesize : 10,
			url : 'upload.json?subFolder=${subFolder}',
			uploadMultiple : true,
			parallelUploads : 5,
			maxFiles : 20,
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
			list('${subFolder}');
		});

		function checkAll() {
			$('input[name=selectFile]').click();
		}

		function deleteFile() {

			$("#dialog-confirm")
					.dialog(
							{
								resizable : false,
								height : 140,
								modal : true,
								buttons : {
									"Delete" : function() {
										var subFolder = '${subFolder}';

										var files = [];
										$('input[name=selectFile]:checked')
												.each(function(index, value) {
													files.push($(value).val());
												});

										if (files.length > 0) {

											var param = {
												'subFolder' : subFolder,
												'files[]' : files
											};

											$
													.post(
															'<c:url value="/backend/admin/file/delete.json" />',
															param)
													.done(
															function(data,
																	statusText) {
																console
																		.log('Delete '
																				+ data
																				+ ' files');
															})
													.fail(
															function(xhr,
																	textStatus,
																	errorThrown) {
																alert('Error occured, please contact Administrator\n'
																		+ xhr.responseText);
															});
										}

										list(subFolder);

										$(this).dialog("close");
									},
									Cancel : function() {
										$(this).dialog("close");
									}
								}
							});
		}
	</script>
</body>
</html>
