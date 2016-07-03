$(document).ready(function() {
	
});
function editUser(id){
	var cusId = $("#cusId").val();
	window.location.href = "../user/edit?id="+id+"&cusId="+cusId;
	//window.location.replace("../user?id="+id);
}