<%@include file="/WEB-INF/views/common/include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Starboard Windsurfing</title>
 	<script language="javascript" src="${pageContext.request.contextPath}/scripts/ajax-common.js" ></script>
    <script language="javascript" src="${pageContext.request.contextPath}/scripts/util-common.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/sorttable.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/ckeditor/ckeditor.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.min.js" ></script> 
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/jquery-ui-1.8.5.custom.min.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/scripts/bootstrap3.2/js/bootstrap.js"></script> 
	<link type="text/css" href="${pageContext.request.contextPath}/scripts/bootstrap3.2/css/bootstrap.css" rel="stylesheet" />    
    <link type="text/css" href="${pageContext.request.contextPath}/css/custom-theme/jquery-ui-1.8.5.custom.css" rel="stylesheet" />  	
	<script type="text/javascript" language="JavaScript1.2" src="${pageContext.request.contextPath}/scripts/stm31.js"></script>
    <link href="${pageContext.request.contextPath}/pages-front/css/ss2.0.css" rel="stylesheet" type="text/css" media="screen,print">
 	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/plugins/jquery.highlight-3.yui.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jdMenu/jquery.jdMenu.css" type="text/css" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/start/jquery-ui-1.8.4.custom.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/page-front/css/ss2.0.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/calendar.js"></script>
	<link type="text/css" href="${pageContext.request.contextPath}/css/calendar.css" rel="stylesheet"  />


<!--------------------------------------------------------------------- CUSTOM MESSAGE BOX -->	
<script>

function CustomAlert(){

this.render = function(dialog){

var winW = window.innerWidth;

    var winH = window.innerHeight;

var dialogoverlay = document.getElementById('dialogoverlay');

    var dialogbox = document.getElementById('dialogbox');

dialogoverlay.style.display = "block";

    dialogoverlay.style.height = winH+"px";

dialogbox.style.left = (winW/2) - (550 * .5)+"px";

    dialogbox.style.top = "100px";

    dialogbox.style.display = "block";

document.getElementById('dialogboxhead').innerHTML = "Acknowledge This Message";

    document.getElementById('dialogboxbody').innerHTML = dialog;

document.getElementById('dialogboxfoot').innerHTML = '<input class="btnGreen" type="button"  onclick="Alert.ok()" value="OK">';

}

this.ok = function(){

document.getElementById('dialogbox').style.display = "none";

document.getElementById('dialogoverlay').style.display = "none";

}

}

var Alert = new CustomAlert();

</script>
<!--------------------------------------------------------------------- CUSTOM MESSAGE BOX -->	
		
	
	
<script type="text/JavaScript">

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script> 	
<script>
$(function() {
	  var valueitem = ${itemsize};
	  if(valueitem >= 1){
		  setTimeout(function(){
			  $('#bitem').text(valueitem);
			  $("#cartItem").slideDown();
			    },100);
		  setTimeout(function(){
			  $("#cartItem").slideUp();  
			    },2000);
	  }
	});
</script>
<style type="text/css">
	@font-face {
    font-family: 'francois_oneregular';
    src: url('${pageContext.request.contextPath}/font/francoisone/francoisone-webfont.eot');
    src: url('${pageContext.request.contextPath}/font/francoisone/francoisone-webfont.eot?#iefix') format('embedded-opentype'),
         url('${pageContext.request.contextPath}/font/francoisone/francoisone-webfont.woff') format('woff'),
         url('${pageContext.request.contextPath}/font/francoisone/francoisone-webfont.ttf') format('truetype'),
         url('${pageContext.request.contextPath}/font/francoisone/francoisone-webfont.svg#francois_oneregular') format('svg');
    font-weight: normal;
    font-style: normal;

}
.fontface_1{
	font-family:'francois_oneregular';
}
</style>
</head>
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

	<style type="text/css">
 
.homeicon{
	font-family: francois_oneregular;
	font-size: 14px;
	font-weight: bold;
	cursor: pointer;
	text-decoration: none;
	valign:center;
	color:#444444;
}
.homeicon:hover{
	cursor: pointer;
	color:#75BD48;
}
.homeicon:active{
	cursor: pointer;
	color:#666666;
}
 
#searchb{
		background: url("${pageContext.request.contextPath}/pages-front/images/icon/bg_txt_search.png");
		background-repeat: repeat-x;
	}
#shadow2{
background: rgb(206,206,206); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(206,206,206,1) 0%, rgba(182,182,182,1) 43%, rgba(182,182,182,1) 43%, rgba(182,182,182,1) 43%, rgba(149,149,149,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(206,206,206,1)), color-stop(43%,rgba(182,182,182,1)), color-stop(43%,rgba(182,182,182,1)), color-stop(43%,rgba(182,182,182,1)), color-stop(100%,rgba(149,149,149,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(206,206,206,1) 0%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(149,149,149,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(206,206,206,1) 0%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(149,149,149,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(206,206,206,1) 0%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(149,149,149,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(206,206,206,1) 0%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(182,182,182,1) 43%,rgba(149,149,149,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#cecece', endColorstr='#959595',GradientType=0 ); /* IE6-9 */
}
body{
	background-image:url("${pageContext.request.contextPath}/pages-front/images/starboardbglogin.png");
	background-size: 100% auto;
	background-repeat: no-repeat;
	background-position-y:-200px;
	background-attachment: fixed;
}

input.btnGG, a.btnGG{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-gray.png') no-repeat top left;
	text-align: center;
	color: #FFFFFF;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	
}
input.btnGG:hover, a.btnGG:hover, input.btnRG:hover{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-green.png') no-repeat top left;
}

a.btnGG{
	padding: 6px 10px;
	line-height: 38px;
	margin-right: 5px;
	font-size: 14px;
}

input.btnGG{
	padding: 5px 30px;
	
}

input.btnGreen, a.btnGreen{ /* GREEN ONLY  NO HOVER  */
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-green.png') no-repeat top left;
	text-align: Center; 
	color: #FFFFFF;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	margin: 0px 22px 5px 0px;
	padding: 5px;	
	} 
	
	a.btnGreen{
	padding: 6px 10px;
	line-height: 32px;
	margin-right: 5px;
}

input.btnGreen{
	padding: 5px 30px;	
	
	
}


input.btnGray, a.btnGray{ /* GRAY ONLY  NO HOVER  */
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-gray.png') no-repeat top left;
	text-align: Center; 
	color: #FFFFFF;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	margin: 0px 22px 5px 0px;
	padding: 5px;	
	} 
	
	a.btnGray{
	padding: 6px 10px;
	line-height: 32px;
	margin-right: 5px;
}

input.btnGray{
	padding: 5px 30px;	
	
	
}
	

input.btnGG_01, a.btnGG_01{ /* เซตตัวนี้แหละ  */
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-gray.png') no-repeat top left;
	text-align: Center; 
	color: #FFFFFF;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	margin: 0px 22px 5px 0px;
	padding: 5px;	
	} 

input.btnGG_01:hover, a.btnGG_01:hover, input.btnRG_01:hover{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-green.png') no-repeat top left;
}

a.btnGG_01{
	padding: 6px 10px;
	line-height: 32px;
	margin-right: 5px;
}

input.btnGG_01{
	padding: 5px 30px;	
	
	
}



input.btnRG{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-red.png') no-repeat top left;
	text-align: center;
	color: #FFFFFF;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	padding: 5px 30px;
	
}

button[disabled].btnRG:hover, html input[disabled].btnRG:hover{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-red.png') no-repeat top left;
}
.outline{
	/*background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-green.png') no-repeat top left !important;*/
}
button[disabled].btnGG:hover, html input[disabled].btnGG:hover{
 background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-gray.png') no-repeat top left;
}

button[disabled].btnGG_01:hover, html input[disabled].btnGG:hover{
 background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-gray.png') no-repeat top left;
}

a.outline{
	background: url('${pageContext.request.contextPath}/pages-front/images/icon/btn-green.png') no-repeat top right !important;
}


	</style>
<%-- background="${pageContext.request.contextPath}/pages-front/images/starboardbglogin.jpg"	 --%>
<body>
<div id="dialogoverlay"></div>

<div id="dialogbox">

  <div>

    <div id="dialogboxhead"></div>

    <div id="dialogboxbody"></div>

    <div id="dialogboxfoot"style="padding: 2%"></div>

  </div>

</div>
<table bgcolor="#FEFEFE" class="t1" border="0" cellSpacing="5" cellPadding="5" width="100%"  align="center">
  <tr height="1px">
  <td valign="top">
<!--   	<table width="100%"> -->
<!--   		<tr> -->
<!--     		<td valign="top" height="35px" width="29%"> -->
<%--     			<img src="${pageContext.request.contextPath}/pages-front/images/star-board-logo_new.png" border="0"> --%>
<!--     		</td> -->
<!--     		<td valign="top" height="35px" align="center"> -->
<%--     			<img src="${pageContext.request.contextPath}/pages-front/images/severne-logo-new.png" border="0"> --%>
<!--     		</td> -->
<!--     		<td valign="top" height="35px" align="right"> -->
<%--     			<img src="${pageContext.request.contextPath}/pages-front/images/airush-logo_new.png" border="0"> --%>
<!--     		</td> -->
<!--     	</tr> -->
<!--     </table> -->
  </td>
  </tr>
   <tr height="35px">
    <td class="t1" valign="top" >
    <c:if test="${custUser != null}">
    <div style="background-color:rgba(238, 238, 238, 0.5);color: #000;width:100%;height:50px;box-shadow: 0px 1px 2px 2px rgba(0, 0, 0, .5);" >
    <table width="80%" border="0" height="100%" align="center" style="min-width: 1024px;">
    	<tr width="100%" align="center">
    	   	<td valign="center"><div class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntHomeAction.do?method=openHome' ">
    	   	HOME
    	   	</div>
   			</td>
   			<td valign="center" width="160px"><div  class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntOrderAction.do?method=openCOCurrencyProduct' ">
   			CREATE ORDER
   			</div>
   			</td>
   			<td valign="center" width="160px"><div  class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntOrderAction.do?method=performSearch' ">
   			ORDER SUMMARY
   			</div>
   			</td>
   			<td valign="center"><div  class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntDownloadAction.do?method=openDownload' ">
   			DOWNLOAD
<%--    			onclick="window.location = '${pageContext.request.contextPath}/FntDownloadAction.do?method=openDownload' " --%>
   			</div>
   			</td>
   			<td valign="center"><div  class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntCustAction.do?method=openProfile' ">
   			PROFILE
   			</div>
   			</td >
   			<td valign="center"><div  class="homeicon" onclick="Alert.render('UNDERCONSTRUCTION')">ACCOUNTING</td>
   			<td valign="center"><div  class="homeicon"onclick="Alert.render('UNDERCONSTRUCTION')">CONTACT US</td>
   			<td valign="center"><div  class="homeicon" onclick="window.location = '${pageContext.request.contextPath}/FntLogoutAction.do' ">
   			LOG OUT
   			</div>
   			</td>
<!--    			<td width="200px"><input type="text" name="searchb" id="searchb" placeholder="SEARCH" class="form-control" style="height: 25px;width:185px"> -->
<!--    			</td> -->
<!--    			<td width="25px"> -->
<%--    			<img alt="search" src="${pageContext.request.contextPath}/pages-front/images/icon/searchbar.png" width="25px" height="25px" style="cursor:pointer"> --%>
<!--    			</td> -->
    	</tr>
    </table>
    </div>
    </c:if>
    
  	</td>
  	</tr>
  	<tr height="35px">
    <td class="t1" valign="top" >
    <c:if test="${custUser != null}">
    <div style="background-color:#666666;color: #000;width:100%;height:50px;box-shadow: -1px -1px 2px 0px rgba(0, 0, 0, .5)" id="shadow2">
    <table width="80%" border="0" height="100%" align="center" style="min-width: 1024px;">
    	<tr width="100%" align="center">
    	   	<td valign="center" width="50px">
    	   	<img alt="search" src="${pageContext.request.contextPath}/pages-front/images/icon/usericon.png" width="15px" height="15px" style="cursor: pointer">
   			</td>
   			<td  width="200px" style="font-size: 12px;font-weight:bold;color:#000;text-align:left"><c:if test="${custUser != null}"><div align="left">Welcome! ${custUser.name}</div></c:if>
   			</td>
   			<td valign="center">&nbsp;
   			</td>
   			<td valign="center">&nbsp;
   			</td >
   			<td valign="center" width="180px">&nbsp;
   			</td>
   			<td valign="center" width="180px" style="padding-right:20px">
   			<div id="openItem" style="width:160px;height:32px;background-image: url('${pageContext.request.contextPath}/pages-front/images/icon/bg_dd_gray.png');background-repeat: repeat-x;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;cursor:pointer">
   			<table border="0"  width="150px" height="32px" id="tbitem">
   				<tr>
   					<td style="border-right:1px solid #ABABAB"><img src="${pageContext.request.contextPath}/pages-front/images/icon/ico_cart.png" /></td>
   					<td>&nbsp;</td>
   					<td style="color:#FFFFFF">(<span id="bitem">0</span>) items</td>
   					<td><img src="${pageContext.request.contextPath}/pages-front/images/icon/ico_dropdown_square.png" /></td>
   				</tr>
   			</table>
   			</div>
   			</div>
   			</td>
    	</tr>
    </table>
    </div>
    </c:if>
    
  	</td>
  	</tr>
  <tr>
    <td class="t1" valign="top">