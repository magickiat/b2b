//----------------------------------------------------------------------------------------[DISABLE ADD TO CART BUTTON 1,2]     [START]
$( document ).ready(function() { 
	$('#btnsubmit').attr("disabled", "disabled").css('opacity',0.6);
	$('#btnsubmit2').attr("disabled", "disabled").css('opacity',0.6);
});
//----------------------------------------------------------------------------------------[DISABLE ADD TO CART BUTTON 1,2]     [STOP]


//----------------------------------------------------------------------------------------[WITHNOSE CONTROL]     [START]   // Fixed Hear FILM You Know !!!
$( document ).ready(function() {
	$(".tbright div.productWithNose0 div:first-child a:first-child").addClass("outline"); // Set  
	$(".tbright div.productWithNose1 div:first-child a:first-child").addClass("outline");
	
	var checkWithNose = "${checkWithNose}";
	if(checkWithNose.toString() == "0"){
		$(".withNose").hide();
	}
	$(".productWithNose1").hide();
	$( "#multitable" ).hide();
	$( "#btnmulti2" ).hide();
	$("#btnmulti1").click(function(){
		$( "#btnmulti2" ).show();
		$('html, body').animate({
            scrollTop: $(document).height()
        },
        1500);
        $( "#multitable" ).show();
		$( "#btnmulti1" ).hide();
		});
	$("#btnmulti2").click(function(){
		$( "#btnmulti2" ).hide();
		$( "#multitable" ).hide(1);
		$( "#btnmulti1" ).show();
		}); 
	$('.withnose').change(
			function(){
				
				if($( ".withnose:checked" ).val()=="1"){
					/* alert( "productWithNose" + $( ".withnose:checked").val()); */
					$(".productWithNose0").hide();
					$(".productWithNose1").show();
				}else{
					$(".productWithNose0").show();
					$(".productWithNose1").hide();
				}
				

			});
});

//----------------------------------------------------------------------------------------[WITHNOSE CONTROL]     [STOP]


//----------------------------------------------------------------------------------------[CART ITEM]     [START] 
// [ INSERT TO INLINE ]
//----------------------------------------------------------------------------------------[CART ITEM]     [STOP] 

//----------------------------------------------------------------------------------------[ENABLE BUTON SUBMIT]     [START]
function getValueAmount(valueM){
	if(valueM == 0){
		$('#btnsubmit').attr("disabled", "disabled").css('opacity',0.6);	
	}
	else{
		$('#btnsubmit').removeAttr('disabled').css('opacity',1);	
	}
	
}
//----------------------------------------------------------------------------------------[ENABLE BUTON SUBMIT]     [STOP]
function myajaxsubmit()
{
	document.getElementById("checksubmitflag").value = "true";
	document.productForm.submit();
}
//----------------------------------------------------------------------------------------[GET TOTAL VALUE MULTIPLE ORDER]     [START]
function getValueAmount2(id , value ){
	var valueSum = 0;
	//var valueThis = $('#' + id).val();
	var valueThis = value;
	var technology1 = id.toString();
	var technology;	
	var mapCode_Count = 1;
	var countunderscore = id.indexOf("_");
	
//	alert(id+":"+value);
	
	if (countunderscore>=0)
		{		
		  technology = id.toString().split("_");
	      mapCode_Count = technology[technology.length] + "_" + valueThis;
		}
	else
		{ 
		   technology = new Array();
		   technology[0] = technology1;
		   mapCode_Count = technology1 + "_" + valueThis;
		}
		
	
	//alert(mapCode_Count);
	
	$.ajax({
 		url: "${pageContext.request.contextPath}/../OrderAction.do?method=mapvalueSession&map=" + mapCode_Count,
          type: "POST",
         	success: function( data, textStatus, jqXHR) {         		        		 
         	},
	           error: function(jqXHR, textStatus, errorThrown){
                	console.log("Something really bad happened " + textStatus);
           	}
	});	
	$('input[name=' + technology[0] + ']').each(function() {
		valueSum = valueSum + parseInt($(this).val());
	});
	if(valueSum >= 0){
		$("#" + technology[0] + "_div").text(valueSum);
		$('#btnsubmit2').removeAttr('disabled').css('opacity',1);
	}
	else{
		$("#" + technology[0] + "_div").text(0);
		$('#btnsubmit2').attr("disabled", "disabled").css('opacity',0.6);
	}
	//alert("valueSum:= "+valueSum);
	return valueSum;
}

//----------------------------------------------------------------------------------------[GET TOTAL VALUE MULTIPLE ORDER]     [STOP]


//----------------------------------------------------------------------------------------[ADD MULTIPLE ORDER BUTTON]     [START]   F  I  X  I  N  G ! ! !  
//[ INSERT TO INLINE ]
//----------------------------------------------------------------------------------------[ADD MULTIPLE ORDER BUTTON]     [STOP]

//----------------------------------------------------------------------------------------[CHECK VALUE AMOUNT 01]     [START]
function CheckValue1()
{
	var varnum = document.getElementById('amount').value;
	// alert(varnum);
	 if (varnum == 0)
		 {
		  window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';
		 }
	 else
	 {
		 //alert("value != 0");
		 Alert_previos1.render('Do you save order');		 
	 }
}
//----------------------------------------------------------------------------------------[CHECK VALUE AMOUNT 01]     [STOP]

//----------------------------------------------------------------------------------------[CHECK VALUE AMOUNT 02]     [START]  ULCOMPLETE !!!!!!

function CheckValue2(){	
	//alert("Hay");
	window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';
	var valueSums = getValueAmount2();
	alert("valuSum := "+valueSums);	
	if(valueSums > 0){
		alert("ValueSum =: "+valueSums);
		Alert_previos2.render('Do you save order');
		
	}
	else{
		alert("ValueSum =: "+valueSums);
		window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';
	}
}

//----------------------------------------------------------------------------------------[CHECK VALUE AMOUNT 02]     [STOP]

//----------------------------------------------------------------------------------------[CUSTOM MESSAGE BOX CONFIRM_1]     [START] 
function CustomAlert1(){
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

	document.getElementById('dialogboxhead').innerHTML = "Add Order To Cart ?";

	    document.getElementById('dialogboxbody').innerHTML = dialog;

	document.getElementById('dialogboxfoot').innerHTML = '<input class="btnGreen" type="button" onclick="Alert_previos1.ok()" value="OK"> <input class="btnGray" type="button"  onclick="Alert_previos1.cancle()" value="CANCLE">';


	}

	this.ok = function(){		
		//alert("OK!");		
		document.getElementById('dialogbox').style.display = "none";
		document.getElementById('dialogoverlay').style.display = "none";
		document.getElementById("productForm").submit();  // Submit Form
		window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';
		
	}
	this.cancle = function(){
		//alert("CANCLE!");
		document.getElementById('dialogbox').style.display = "none";
		document.getElementById('dialogoverlay').style.display = "none";
		window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';

		}
	
	}

	var Alert_previos1 = new CustomAlert1();
//----------------------------------------------------------------------------------------[CUSTOM MESSAGE BOX CONFIRM_1]     [STOP] 
//----------------------------------------------------------------------------------------[CUSTOM MESSAGE BOX CONFIRM_2]     [START] 
	function CustomAlert2(){
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

		document.getElementById('dialogboxhead').innerHTML = "Add Order To Cart ?";

		    document.getElementById('dialogboxbody').innerHTML = dialog;

		document.getElementById('dialogboxfoot').innerHTML = '<input class="btnGreen" type="button" onclick="Alert_previos2.ok()" value="OK"> <input class="btnGray" type="button"  onclick="Alert_previos2.cancle()" value="CANCLE">';


		}

		this.ok = function(){
			//this.form.submit();
			//alert("OK!");
			document.getElementById('dialogbox').style.display = "none";
			document.getElementById('dialogoverlay').style.display = "none";
			window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';

		}
		this.cancle = function(){
			//alert("CANCLE!");
			document.getElementById('dialogbox').style.display = "none";
			document.getElementById('dialogoverlay').style.display = "none";
			window.location='${pageContext.request.contextPath}/../FntOrderAction.do?method=openModelFilter&fromMethod=addCatList';

			}
		}

		var Alert_previos2 = new CustomAlert2();
//----------------------------------------------------------------------------------------[CUSTOM MESSAGE BOX CONFIRM_2]     [STOP] 	
function doSubmit(form)
{
	alert("onsubmit");
	alert(form.test.value);
}
;