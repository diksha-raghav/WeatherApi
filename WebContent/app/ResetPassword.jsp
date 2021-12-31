<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/mainSheet.css" type="text/css"/> 
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/header_menu.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
  

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/popper.js@1.14.3/dist/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

<style>
form {
	font: 35px Calibri !important;
	font-weight: bold !important;
}

.form-control {
	font-size: 15px !important;
}
/*#parent{
display: table;
width: 50%;
margin-left:170px;
margin-right:150px;
}

#form-reset{
display: table-cell;
text-align: center;
vertical-align: middle;
}*/


</style>

</head>
<body >
	<jsp:include page="Header.jsp"></jsp:include>
	
	
	<div class="main-body-section">
		<div class="container mt-7 rounded" style="background-color: white; max-width:700px;">
		<div class="br-space"></div>
		<div class="br-space"></div>
		<h1>Reset Password</h1>
		<br>
		<br>
		
		
		
		<div id="parent">
		
		<form class="" id="form-reset" method="post" action="/WeatherApi/ResetPasswordController" onSubmit="return validatepassword()">
		
			<div class="row mx-5">
			<div class="form-group col-6">
				<label class="h4"><b>Enter Mobile Number To Search</b></label>
			</div>
			<div class=" form-group col-6">
				<input class="form-control"  type="text" placeholder="Search.." id="mobileSearch" name="mobileSearch" onkeyup="search_mobile();">
				<span id="incorrect_mobile" style="color: red; font-size: 10px;"></span>
			</div>
			</div>
				
				<div class="row mx-5">
					<div class="form-group col-6 ">
					<label class="h4 "><b>Enter Mobile Number From The List</b></label>
					</div>
					<div class="form-group col-6 ">
					<select class="form-control" id="mobile" name="mobile">
						<option>Select</option>
					</select>
					</div>
				</div>
				
				<div class="row mx-5">
					<div class="form-group col-6 ">
					<label class="h4 "><b>Enter Password</b></label>
					</div>
						
					<div class="form-group col-6 ">
						<input type="password" id="pass" name="pass" placeholder="enter password" class="form-control" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,30}$" title="Length must be atleast 8-30 characters, 1 uppercase ,1 lowercase, 1 number and 1 special character">	
					</div>
				</div>
				
				
				<div class="row mx-5">
					<div class=" form-group col-6">
						<label class="h4 "><b>Confirm Password</b></label>
					</div>
						
					<div class=" form-group col-6">
						<input type="password" id="cpass" name="cpass" placeholder="confirm password" class="form-control" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,30}$" title="Length must be atleast 8-30 characters, 1 uppercase ,1 lowercase, 1 number and 1 special character">	
						<span style="color:red; font-size: 10px;" id="error_msg"></span>
					</div>
				</div>
			
				
					<div class="br-space"></div>
					<div class="br-space"></div>
			
				<div class="submitbuttondiv">	
										
					<button class="mainsubmit" style="background-color: green;" type="submit">Reset Password</button>
				</div>
			
				
					<div class="br-space"></div>
					<div class="br-space"></div>
					
		</form>
		</div>			
				
		</div>
	</div>
	

</body>
<script>

	$(document).ready(function(){
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		const page_type = urlParams.get('status');
//			alert("page type is "+page_type);
		//console.log(page_type);
		if (page_type == "done") {
			swal({
				title : "Reset Device ID successfull",
				icon : "success",
				timer : "200000",
				buttons: {
				    Reset: "Reset Password",
				    home_page: "Go to Home Page",
				}
			}).then((value) => {
				  switch (value) {
				  
				    case "Reset":
				    	window.location.href = "/WeatherApi/app/ResetPassword.jsp";
				      break;
				    case "home_page":
				    	window.location.href = "/WeatherApi/app/HomePage.jsp";
				      break;
				  }
			});

		}
	});

</script>
<script>


	     
	function search_mobile()
	     {
	    	 var mob = document.getElementById("mobileSearch");
	    	 if(mob.value.length>1)
	    		 {
	    		 	console.log(mob.value);
	    		 	var mobile_num = mob.value;
	    		 	$.ajax({
						url : '/WeatherApi/ResetDeviceController',
						data:{mobileNumber:mobile_num},
						success : function(responseText) {
	 								console.log("function returned success");
	 								$("#mobile").empty();
	 								$("#mobile").append("<option value=''> --Select---- </option>");
	 								document.getElementById("incorrect_mobile").innerHTML = "";
	 								for (m in responseText.Mobile) {
	 									$("#mobile").append(
	 											"<option value='"+responseText.Mobile[m]+"'>"
	 													+ responseText.Mobile[m]
	 													+ "</option>");
//	 		 							console.log(responseText.Mobile[m]);
	 								}
	 								if( $('#mobile').has('option').length == 0 )
	 									{
	 										document.getElementById("incorrect_mobile").innerHTML = "enter Valid number";
	 									}
	 						
	 						},
	 					error: function (jqXHR, exception) {
	 					        var msg = '';
	 					        if (jqXHR.status === 0) {
	 					            msg = 'Not connect.\n Verify Network.';
	 					        } else if (jqXHR.status == 404) {
	 					            msg = 'Requested page not found. [404]';
	 					        } else if (jqXHR.status == 500) {
	 					            msg = 'Internal Server Error [500].';
	 					        } else if (exception === 'parsererror') {
	 					            msg = 'Requested JSON parse failed.';
	 					        } else if (exception === 'timeout') {
	 					            msg = 'Time out error.';
	 					        } else if (exception === 'abort') {
	 					            msg = 'Ajax request aborted.';
	 					        } else {
	 					            msg = 'Uncaught Error.\n' + jqXHR.responseText;
	 					        }
	 					        
	 					        console.log(msg);
	 					    } 
					});
	    		 	
	    		 }
	     }
	
	function validatepassword()
	{
		var password = document.getElementById("pass").value;
		var cpassword = document.getElementById("cpass").value;
		var error_pass="";
		if(cpassword!=password)
			{
				error_pass = "*Passwords do not match*";
				document.getElementById("error_msg").innerHTML = error_pass;
				return false;
			}
		return true;
	}
      

</script>
</html>