<%@include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${resume.id}</title>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/ajax-common.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/util-common.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/calendarDateInput.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/sorttable.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/wysiwyg.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/scripts/wysiwyg-settings.js"></script>

<link href="${pageContext.request.contextPath}/css/ss.css"
	rel="stylesheet" type="text/css" media="screen,print">



</head>

<body height="100%">

<table border="0" cellpadding="0" cellspacing="0" align="center"
	width="100%">
	<thead>
		<tr>
			<td width="100%">
			<table width="950" align="center" border="0" class="print-logo-bg">
				<tr>
					<td>
					<tr class="print-logo-bg">
						<td width="8%" rowspan="2"><img
							src="${pageContext.request.contextPath}/images/logo_jobsitonline.jpg"></td>
						<td width="92%" align="right" valign="top" class="print-logo-bg">

						&nbsp;<font color="#993300"><b>Jobs IT Online </b></font>Co., Ltd.<br>
						540 Mercury Tower 11th Floor Ploenchit Rd., Lumpini, Phathumwan,
						Bangkok 10330<br>
						<font color="#009900"><b>T</b></font> +662 305 8758 <font
							color="#009900"><b>F</b></font> +662 658 7554 <font
							color="#009900"><b>W</b></font> www.jobsitonline.com <br>
						<br>

						</td>

					</tr>
					<tr class="print-logo-bg">
						<td align="right" valign="bottom" class="print-logo-bg"><c:if
							test="${user!=null}">
    &nbsp;&nbsp;&nbsp;    </c:if></td>
					</tr>
					<tr class="print-logo-bg">
						<td colspan="2" class="top-menu-pad"></td>
					</tr>
					<tr class="print-logo-bg">
						<td colspan="2">&nbsp;</td>
					</tr>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</thead>

	<tr valign="top">
		<td colspan="2" valign="top">

		<table width="950" align="center" border="0">
			<tr>
				<td valign="top">