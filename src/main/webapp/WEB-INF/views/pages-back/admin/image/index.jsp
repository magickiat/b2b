<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="container">
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
		<div class="row">
			<div class="col-sm-12">
				<h2>Image upload page</h2>
			</div>
		</div>

		<%-- Folder --%>
		<div class="row bg_color">
			<div class="col-sm-12">
				<form id="newFolderForm"
					action='<c:url value="/backend/admin/new-folder" />' method="post"
					style="display: none;">
					<input type="hidden" id="subFolder" name="subFolder"
						value="${ subFolder }" />
					<div>
						Folder name: <input type="text" id="folderName" name="folderName" />
					</div>

					<div>
						<input type="submit" value="Create" />
					</div>
				</form>
				<button class="btn btn-default" onclick="newFolder()">New
					Folder</button>
				<button class="btn btn-default" onclick="back()">Back</button>
			</div>
		</div>
		<div class="row bg_color">
			<div class="col-sm-12">
				<c:if test="${ not empty folders }">
					<select id="selectedFolder" name="selectedFolder"
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
						<th>No</th>
						<th>File name</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${ listFile }" varStatus="rowNum">
						<tr>

							<td>${ rowNum.index + 1 }</td>
							<td><c:choose>
									<c:when test="${ item.folder }">
										<a href="#" onclick="list('${ item.nameWithPath }')">${ item.nameWithPath }</a>
									</c:when>
									<c:otherwise>
										<a href='<c:url value="/upload/${ item.nameWithPath }" />'>${ item.nameWithPath }</a>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${ item.folder }"> Folder</c:when>
									<c:otherwise>File</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		function list(folder) {
			if (folder.value) {
				folder = folder.value;
			}
			window.location.href = '<c:url value="/backend/admin/image/list?folder='
					+ folder + '" />';
		}

		function back() {
			list($('#selectedFolder').val());
		}

		function newFolder() {
			$('#newFolderForm').dialog();
		}
	</script>
</body>
</html>