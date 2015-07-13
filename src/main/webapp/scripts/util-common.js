function setDisable(src, target) {
	if (src.checked == true) {
		target.disabled = true;
	} else {
		target.disabled = false;
	}
	
}

function checkAll(field)
{
    for (i = 0; i < field.length; i++)
        field[i].checked = true ;
}

function uncheckAll(field)
{
    for (i = 0; i < field.length; i++)
        field[i].checked = false ;
}

function toggleCheckAll(sender, field)
{
    if (sender.checked == true)
        checkAll(field);
    else
        uncheckAll(field);
}

function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode != 46))
        return false;
    return true;
}

function isEnterKey(){
    return (event.keyCode == 13);
}

function handle(selectBox) {

    var index = selectBox.selectedIndex;
    if (index == 0) {
        document.getElementById("divFromDate").style.display = "none";
        document.getElementById("divToDate").style.display = "none";
        document.getElementById("divFromDateLabel").style.display = "none";
        document.getElementById("divToDateLabel").style.display = "none";
    } else {
        document.getElementById("divFromDate").style.display = "block";
        document.getElementById("divToDate").style.display = "block";
        document.getElementById("divFromDateLabel").style.display = "block";
        document.getElementById("divToDateLabel").style.display = "block";
    }
}

function validateEmail(textbox) {

    var str = textbox.value;

    if (str == "") {
        return true;
    }
    var errorMessage = "Invalid E-mail Address";

    var at="@";
    var dot=".";
    var lat=str.indexOf(at);
    var lstr=str.length;
    var ldot=str.indexOf(dot);
    if (str.indexOf(at)==-1){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.indexOf(at,(lat+1))!=-1){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.indexOf(dot,(lat+2))==-1){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    if (str.indexOf(" ")!=-1){
        alert(errorMessage);
        textbox.select();
        return false;
    }

    return true;
}

function diffTime(time1, time2) {

    var timediff = time2 - time1;
    var days = Math.floor(timediff / (1000 * 60 * 60 * 24));
    timediff -= days * (1000 * 60 * 60 * 24);

    var hours = Math.floor(timediff / (1000 * 60 * 60));
    timediff -= hours * (1000 * 60 * 60);

    var mins = Math.floor(timediff / (1000 * 60));
    timediff -= mins * (1000 * 60);

    var text = "";
    if (mins < 10)
        mins = "0"+mins;
    if (hours < 10)
        hours = "0"+hours;

    if (days > 0) {
        text = days + " วัน " + hours + ":" + mins;
    } else {
        text = hours + ":" + mins ;
    }
    
    return text;

}

function validateTime(textbox) {
    // Checks if time is in HH:mm format.

    var timeStr = textbox.value;

    var timePat = /^(\d{1,2}):(\d{2})$/;

    var matchArray = timeStr.match(timePat);
    if (matchArray == null) {
        alert("เวลาผิดรูปแบบ HH:mm กรุณากรอกใหม่");
        textbox.select();
        return false;
    }

    //
    hour = matchArray[1];
    minute = matchArray[2];

    if (hour < 0  || hour > 23) {
        alert("ตัวเลขชั่วโมงมีค่าได้ตั้งแต่ 0 - 23 เท่านั้น กรุณากรอกใหม่");
        textbox.select();
        return false;
    }

    if (minute<0 || minute > 59) {
        alert ("ตัวเลขนาทีมีค่าได้ตั้งแต่ 0 - 59 เท่านั้น กรุณากรอกใหม่");
        textbox.select();
        return false;
    }

    return false;
}

function isIntegerNumber(evt)
{
	//alert("dfgr");
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if ((charCode < 48 || charCode > 57)&&(charCode!= 08)) 	
    	return false;    
    return true;
}