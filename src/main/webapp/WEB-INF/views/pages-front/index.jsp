<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
<link type="text/css" href="<c:url value="/css/pages-front/index.css"/>" rel="stylesheet"></link>
</head>
<body>
	<div class="background">
		<div class="first"
			style="position: absolute; z-index: 100; width: 100%; top: 8%;">
			<img src="<c:url value="/images/pages-front/icon/windsurf_banner.jpg" />"
				style="width: 100%;" />
		</div>
	</div>
	<div id="nextprevhover"
		style="position: absolute; z-index: 100; width: 100%; top: 8%;">
		<div id="slider">
			<ul>
				<li style="display: none;"><img
					src="<c:url value="/images/pages-front/icon/sup_banner.jpg"/>"
					style="width: 100%;" /></li>
				<li style="background: rgba(238, 238, 238, 0.5); display: none;"><img
					src="<c:url value="/images/pages-front/icon/surf_banner.jpg"/>"
					style="width: 100%;" /></li>
				<li style="display: none;"><img
					src="<c:url value="/images/pages-front/icon/2014_AIRUSH_BANNER.jpg"/>"
					style="width: 100%;" /></li>
				<li style="background: rgba(238, 238, 238, 0.5); display: none;"><img
					src="<c:url value="/images/pages-front/icon/windsurf_banner.jpg"/>"
					style="width: 100%;" /></li>
			</ul>
		</div>
		<a href="#" class="control_next">&gt;</a> <a href="#"
			class="control_prev">&lt;</a>
	</div>

	<div align="center" style="padding-top: 185px;">
		<div
			style="background-color: rgba(238, 238, 238, 0.5); color: #000; height: 280px; width: 450px; position: relative; z-index: 9999"
			id="shadow1">
			<form action="<c:url value="FntLoginAction"/>" method="POST">
				<input id="method" name="method" type="hidden" value="performLogin">
				<table width="380px" border="0">
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><span style="color: #d43f3a; font-weight: bold">${errormessage }</span></td>
					</tr>
					<tr>
						<td width="100px" style="font-size: 16px" class="fontface_log">USERNAME</td>
						<td class="fontface_log"><input type="text"
							class="form-control" placeholder="Username" name="username"
							id="username" style="width: 87%"></td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="100px" style="font-size: 16px" class="fontface_log">PASSWORD</td>
						<td class="fontface_log"><input type="password"
							name="password" id="password" class="form-control"
							placeholder="Password" style="width: 87%"></td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td style="font-size: 14px"><input type="checkbox"
							name="remem" value="remem" id="remem">&nbsp;&nbsp;REMEMBER
							PASSWORD</td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td><input type="submit" class="btnRG" id="loginicon"
							value="LOGIN"> &nbsp;&nbsp; <input type="reset"
							class="btnGG" id="cancelicon" value="CANCEL"></td>
					</tr>
					<tr>
						<td width="100px">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>