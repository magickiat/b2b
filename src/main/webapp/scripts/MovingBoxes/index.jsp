<%@include file="/WEB-INF/views/common/include.jsp" %>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/MovingBoxes/css/style.css" type="text/css"
	media="screen" charset="utf-8"><script
	src="${pageContext.request.contextPath}/scripts/MovingBoxes/js/jquery-1.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/scripts/MovingBoxes/js/slider.js" type="text/javascript" charset="utf-8"></script>

<script language="JavaScript1.2" type="text/javascript" >

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
	var d=document; 
  	if(d.images)
  	{ 
	  	if(!d.MM_p) d.MM_p = new Array();
    	var i, j = d.MM_p.length, a = MM_preloadImages.arguments; 
    	for(i = 0; i < a.length; i++)
    		if (a[i].indexOf("#") != 0){ 
        		d.MM_p[j] = new Image; 
        		d.MM_p[j++].src=a[i];
        	}
  	}
}

function MM_findObj(n, d) { //v4.0
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && document.getElementById) x=document.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function onclickLogo(custId, custName){
	document.forms['logoSlideForm'].custId.value = custId;
	document.forms['logoSlideForm'].keywordL.value = custName;
	document.forms['logoSlideForm'].submit();
}

function onloadPage(){
	if(navigator.appName == 'Microsoft Internet Explorer'){ // ie
		el = document.getElementById('buttonLeft');
		el.style.left = '10px';
		el = document.getElementById('buttonRight');
		el.style.left = '60px';
		el = document.getElementById('scroll');
		el.style.top = '10px';
		el.style.left = '400px';
	}
}
</script>
</head>
<body onLoad="onloadPage(); MM_preloadImages('${pageContext.request.contextPath}/images/icon_thai_black.gif','${pageContext.request.contextPath}/images/bottom_search_w.jpg','${pageContext.request.contextPath}/images/bottom_register_w.jpg','${pageContext.request.contextPath}/images/home_black2.jpg','${pageContext.request.contextPath}/images/home_next2.jpg','${pageContext.request.contextPath}/images/icon_eng_color.gif')">
	<form name="logoSlideForm" id="logoSlideForm" action="${pageContext.request.contextPath}/FrontPageAction.do" method="POST" target="_parent">
		<input type="hidden" name="method" id="method" value="performSearch"/>
		<input type="hidden" name="keywordL" id="keywordL" value=""/>
		<input type="hidden" name="custId" id="custId" value=""/>
		<input type="hidden" name="selectSearch" id="selectSearch" value="Company"/>
	</form>
	<div id="wrapper">
		<div id="slider">
			<a href="javascript: void(0);" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('Image53','','${pageContext.request.contextPath}/images/home_black2.jpg',1)">
				<img class="scrollButtons left" name="Image53" border="0" id="buttonLeft" src="${pageContext.request.contextPath}/images/home_black1.jpg" width="27" height="27">
			</a>
			<div class="scroll" id="scroll">
				<div class="scrollContainer" id="scrollContainer">
					<c:forEach var="picture" items="${pictureList}" varStatus="rowCount">
						<div class="panel" id="panel_${rowCount.count}">
							<div class="inside">
							  <table id="tablePanel${rowCount.count}" border="0" cellpadding="0" cellspacing="0" height="100%">
								  <tr>
								  	<td align="center" valign="middle">
										<a href="javascript:void(0)" onclick="onclickLogo('${picture.custId}','${picture.custName}')">
											<img src="${pageContext.request.contextPath}${picture.imagePath}" width="80px" alt="picture" />
										</a>
									</td>
								  </tr>
						 	  </table>
							</div>
						</div>
					</c:forEach>
					<div id="left-shadow"></div>
					<div id="right-shadow"></div>
				</div>
			</div>
			<div align="right">
				<a href="javascript:void(0)" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('Image61','','${pageContext.request.contextPath}/images/home_next2.jpg',1)">
					<img class="scrollButtons right" name="Image61" border="0" id="buttonRight" src="${pageContext.request.contextPath}/images/home_next1.jpg" width="27" height="27">
				</a>
			</div>
		</div>
	</div>
</body>
</html>