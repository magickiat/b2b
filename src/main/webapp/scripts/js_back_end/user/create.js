$(document).ready(function() {
	
});
function validateForm(){
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();
	console.log(password+":"+confirmPassword);
	if(password.length>0 && confirmPassword.length>0 && (password == confirmPassword)){
		return true;
	}else{
		alert("กรุณาตรวจสอบ Password");
		return false;
	}
}