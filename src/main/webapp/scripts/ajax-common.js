var req;
var which;

/* return XMLHttpRequest for specific browsers IE or Non-IE

 */
function getXMLHttpRequest() {
    if (window.XMLHttpRequest) { // Non-IE browsers
		return new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE browser
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}
/* 	common AJAXcall method
	url = url to call
	callback_func = callback function after call ajax
         */
function ajaxCall(url,callback_func,query) {
    req = getXMLHttpRequest();
    if (req) {
        req.onreadystatechange = callback_func;
        req.open("POST", url, true);
        req.setRequestHeader( "Content-Type",
            "application/x-www-form-urlencoded");
        req.send(query);
    }
    
}