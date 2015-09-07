$(document).ready(function() {
	
});
function createUser(){
	var id = $("#cusId").val();
	window.location.href = "../user?id="+id;
	//window.location.replace("../user?id="+id);
}