<%@include file="/WEB-INF/views/common/include.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JOBS IT ONLINE - Management System</title>
    <script language="javascript" src="${pageContext.request.contextPath}/scripts/ajax-common.js" ></script>
    <script language="javascript" src="${pageContext.request.contextPath}/scripts/util-common.js" ></script>
    <script language="javascript" src="${pageContext.request.contextPath}/scripts/calendarDateInput.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/sorttable.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/wysiwyg.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/wysiwyg-settings.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/ckeditor/ckeditor.js" ></script>
	
    <link href="${pageContext.request.contextPath}/css/ss.css" rel="stylesheet" type="text/css" media="screen,print">

</head>

<body class="body-page" onload="timing();">
<SCRIPT language="JavaScript1.2" type="text/javascript" >

    var timer;
    function timing() {
        timer = setTimeout("getAppointment()",100000);
    }

    function getAppointment() {
        var url = "${pageContext.request.contextPath}/AppointmentAction.do";
        var query = "method=getUnfinishedAppointment";
        ajaxCall(url, getAppointment_callback, query);
        timing();
    }

    function getAppointment_callback(){

        if (req.readyState == 4)  {// Complete
            if (req.status == 200) { // OK response
                var responseText = req.responseText;
                var alertText = "แจ้งเตือนบันทึกช่วยจำ";
                if (responseText != "")
                    alert(alertText + responseText);
            }
        }
    }

    

</SCRIPT>

<c:if test="${!empty msgError}">
	<script>
		alert("Error: " + "${msgError}");
	</script>
</c:if>
<c:if test="${!empty msgAlert}">
	<script>
		alert("${msgAlert}");
	</script>
</c:if>

<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%">

<thead>
<tr><td width="100%">
<table width="950" align="center" border="0" class="logo-bg"><tr><td>
<tr class="logo-bg" >
    <td width="8%" rowspan="2" ><img src="${pageContext.request.contextPath}/images/logo_jobsitonline.jpg" ></td>
    <td width="92%" align="right" valign="top" class="logo-bg">

&nbsp;<font color="#993300"><b>Jobs IT Online </b></font>Co., Ltd.<br>
540 Mercury Tower 11th Floor Ploenchit Rd., Lumpini, Phathumwan, Bangkok 10330<br>
<font color="#009900"><b>T</b></font> +662 305 8758       <font color="#009900"><b>F</b></font>   +662 658 7554
<font color="#009900"><b>W</b></font> www.jobsitonline.com   <br>
<br>


    </td>

</tr>
<tr class="logo-bg">
    <td align="right" valign="bottom" class="logo-bg"><c:if test="${user!=null}">
    User Name :  ${user.name}&nbsp;&nbsp;&nbsp;    </c:if></td>
</tr>
<tr class="logo-bg">
    <td colspan="2" class="top-menu-pad" ></td>
</tr>
<tr class="logo-bg">
    <td colspan="2" class="top-menu" ><table border="0" align="right" cellpadding="0" cellspacing="0" class="topmenu-list">
            <tr>
                <c:if test="${user!=null}">

					<td><a href="${pageContext.request.contextPath}/AdminAction.do" class="topmenu-list"> Home </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>

                	<td><a href="${pageContext.request.contextPath}/PackagesAction.do" class="topmenu-list"> Package </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                
                	<td><a href="${pageContext.request.contextPath}/EmployerAction.do" class="topmenu-list"> Employer </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                	
                	<td><a href="${pageContext.request.contextPath}/NewsAction.do" class="topmenu-list"> News </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                	
                	<td><a href="${pageContext.request.contextPath}/BannerAction.do?method=performSearch" class="topmenu-list"> Banner </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                    
                    <perm:permission object="appointment.view">
                        <td><a href="${pageContext.request.contextPath}/AppointmentAction.do" class="topmenu-list"> Appointment </a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                    </perm:permission>

                    <perm:permission object="staff">
                    <td><a href="${pageContext.request.contextPath}/ResumeAction.do?method=performSearch" class="topmenu-list"> Resume</a></td>
                    <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                    
                    <td><a href="${pageContext.request.contextPath}/ResumeAction.do?method=openImportFile&resumeId=${resume.id}" class="topmenu-list"> import resume </a></td>
                    <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                    </perm:permission>

                	<perm:permission object="email" >
                    <td ><a href="${pageContext.request.contextPath}/ResumeAction.do?method=openEmail" class="topmenu-list"> Send Mail </a></td>
                    <td valign="top" class="topmenu-separator">&nbsp;|&nbsp;</td>
                     </perm:permission>
					
					<perm:permission object="staff" >
                    <td ><a href="${pageContext.request.contextPath}/UserAction.do?method=openUserProfile&id=${user.id}" class="topmenu-list"> My Info </a></td>
                    <td valign="top" class="topmenu-separator">&nbsp;|&nbsp;</td>
                     </perm:permission>
                     
                    <perm:permission object="user.view" >
                    <td ><a href="${pageContext.request.contextPath}/UserAction.do" class="topmenu-list"> User</a></td>
                         <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                   </perm:permission>
                    <perm:permission object="role.view" >
                    <td ><a href="${pageContext.request.contextPath}/RoleAction.do" class="topmenu-list"> Group</a></td>
                        <td valign="top" class="topmenu-separator" >&nbsp;|&nbsp;</td>
                    </perm:permission>
                     
                    <td><a href="${pageContext.request.contextPath}/LoginAction.do?method=performLogout" class="topmenu-list"> Logout </a></td>
             
                </c:if>
              
                <td>&nbsp;&nbsp;</td>
            </tr>
    </table>

    </td>
</tr>
</td></tr></table>
</td></tr>

</thead>

<tr height="400px" valign="top">
<td height="490px" colspan="2" valign="top">


<table width="950" align="center" border="0"><tr><td>

