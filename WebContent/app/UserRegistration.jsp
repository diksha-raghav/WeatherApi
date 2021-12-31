<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Create New User</title>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />

<script src="js/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/header_menu.css" type="text/css">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<style>
form {
	font: 35px Calibri !important;
	font-weight: bold !important;
}

.form-control {
	font-size: 15px !important;
}
</style>
</head>
<body style="background-color: #ebebeb !important;" onload="fetchStates();">
	<jsp:include page="Header.jsp"></jsp:include>
<!--  <div class="br-space"></div>-->	
	<div class="br-space"></div>

	<div class="main-body-section">

			
			<!--  <div>
				<h3 align="center" style="font: 25px Calibri !important;">
					<b>New User Registration<b></b>
				</h3>
			</div>
			<div class="br-space"></div>-->
			

		<!--  <center>
			<h3>New User Registration</h3>
		</center>-->
		<form action="/WeatherApi/UserDetailsController" method="post" onclick="return validate()" >
			<div>
				<h3 align="center" style="font: 25px Calibri !important;">
					<b>New User Registration</b>
				</h3>
			</div>
			<div class="row  g-3 row-grid mt-5">
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Level <span
						style="color: red; font-size: large;">*</span></label> <select
						name="level" class="form-control" id="Level" required>
						<option value="level">Level</option>
						<option value="L1">L1</option>
					</select>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">State <span
						style="color: red; font-size: large;">*</span></label> <select
						name="State" class="form-control" id="state" required>
						<option>State</option>
						<option value="MP">MP</option>
					</select>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">District <span
						style="color: red; font-size: large;">*</span></label> <select
						name="District" class="form-control" id="sel1" required>
						<option>District</option>
						<option value="Gwalior">Gwalior</option>
					</select>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">L4 <span
						style="color: red; font-size: large;">*</span></label> <select name="l4"
						class="form-control" id="sel2" required>
						<option>L4</option>
						<option value="yes">yes</option>
					</select>
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputL5" class="form-label field">L5 <span
						style="color: red; font-size: large;">*</span></label> 
						<input required
						type="text" name="l5" id="L5" class="form-control"
						placeholder="L5" aria-label="L5" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputUsername" class="form-label field">UserName
						<span style="color: red; font-size: large;">*</span>
					</label> 
					<input onclick="autofill()" type="text" name="User" id="uname"
						required class="form-control" placeholder="User name"
						aria-label="User name" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputdesignation" class="form-label field">Designation
						<span style="color: red; font-size: large;">*</span>
					</label> <input type="text" required name="Designation" id="desig"
						class="form-control" placeholder="Designation" value=""
						aria-label="Designation">
				</div>
				<div class="col-md-3 mb-5 md-form ">
					<label class="control-label field" for="date">Date Of Birth
						<span style="color: red; font-size: large;">*</span>
					</label> <input class="form-control" required name="dob" id="dateofbirth"
						placeholder="YYYY-MM-DD" type="date" value=""/>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputMobile" class="form-label field">Mobile (User ID) <span
						style="color: red; font-size: large;">*</span></label> <input type="number"
						name="mobile1" required id="m1" class="form-control txtPhoneNo"
						placeholder="Mobile" aria-label="Mobile" pattern="[6-9]{1}[0-9]{9}" 
       					title="Phone number with 6-9 and remaing 9 digit with 0-9" value="" onfocus="Validate()" >
					<p id="alertmobile"></p>
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputAlternateMobile" class="form-label field">Alternate
						Mobile </label> <input type="number" name="mobile2" id="m2"
						class="form-control txtPhoneNo" placeholder="Alternate Mobile"
						aria-label="Alternate Mobile" " pattern="[6-9]{1}[0-9]{9}" 
       					title="Phone number with 6-9 and remaing 9 digit with 0-9" value="" maxlength="10" onchange="checkMobile()" onfocus="Validate()" >
					<p id="alertmobile"></p>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputEmail" id="txtEmail" class="form-label field">Email
						<span style="color: red; font-size: large;">*</span>
					</label> 
					<input type="email" name="email" id="mailid"
						class="form-control" placeholder="Email" aria-label="Email" value="" required>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Educational Qualification</label> 
					<select
						name="educational_qualification" class="form-control" id="qual">
						<option>Graduation</option>
						<option value="graduate">graduate</option>
					</select>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputLocatedAt" class="form-label field">Located
						At <span style="color: red; font-size: large;">*</span>
					</label> 
					<input type="text" required name="office_location" id="location"
						class="form-control" placeholder="Located At"
						aria-label="Located At" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputyears" class="form-label field">Experience
						In Crop Insurance <span style="color: red; font-size: large;">*</span>
					</label> 
					<input type="number" required name="exp_crop_ins_year" id="years"
						value="" class="form-control" placeholder="In years" aria-label="years" pattern="[0-9]{2}" title="Enter experience in number only">
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputmonths" class="form-label field">Experience
						In Crop Insurance <span style="color: red; font-size: large;">*</span>
					</label> 
					<input type="number" required name="exp_crop_ins_month"
						value="" id="months" class="form-control" placeholder="In Months"
						aria-label="months" pattern="[0-9]{2}" title="Enter experience in number only">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputphotoid" class="form-label field">
						PAN/Aadhar/Passport <span style="color: red; font-size: large;">*</span>
					</label> <input name="photo_card" required type="file" class="form-control" accept="application/pdf,image/png,image/jpeg">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputphotocardid" class="form-label field">Photo
						Card ID <span style="color: red; font-size: large;">*</span>
					</label> 
					<input type="text" name="card_id" required class="form-control"
						placeholder="ID Number" aria-label="ID Number" id="photo" value="">
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Gender <span
						style="color: red; font-size: large;">*</span></label> <select
						name="gender" class="form-control" id="gender" required>
						<option>Gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>

				<div class="col-md-3 mb-5 ">
					<label for="inputphotoid" class="form-label field">Photo </label> 
					<input
						name="photo" type="file" class="form-control">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputbanknum" class="form-label field">Bank
						Account Number</label> 
						<input type="text" name="bank_num"
						class="form-control" placeholder="Bank Account Number"
						aria-label="Bank Num" id="accno" maxlength="16" minlength="6" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputIFSC" class="form-label field">Bank IFSC</label> 
					<input type="text" name="bank_ifsc" class="form-control" value=""
						placeholder="Bank IFSC" aria-label="Bank IFSC" id="ifscno" maxlength="11" minlength="11">
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Bank Name</label> <select
						value="" name="bank_name" class="form-control" id="bank">
						<option>Bank Name</option>
					</select>
				</div>
				<div class="col-md-3  mb-5">
					<label for="inputBank_Branch_Name" class="form-label field">Bank
						Branch Name</label> <input type="text" name="bank_branch"
						class="form-control" placeholder="Bank Branch Name" value=""
						aria-label="Bank Branch Name" id="branch">
				</div>
				<div class="col-md-3  mb-5">
					<label for="inputBank_Branch_State" class="form-label field">Bank
						Branch State</label> <input type="text" name="bank_state"
						class="form-control" placeholder="Bank Branch State" value=""
						aria-label="Bank Branch State" id="bankstate">
				</div>
				<div class="col-md-12  mb-5">
					<label for="inputBank_Branch_Address" class="form-label field">Bank
						Branch Address</label> <input type="text" name="bank_branch_address"
						class="form-control" placeholder="Bank Branch Address" id="addr"
						aria-label="Bank Branch Address" value="">
				</div>


			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="col-md-12">
				<div style="width: 18%; margin: auto; padding-top: 20px;">
					<span> <input type="submit" value="Submit"
						class="btn btn-primary " id="submit_btn" onsubmit="return Validate()"/>
						<!-- <form onsubmit=" return validate()">-->
						<input type="submit" value="Autofill"
						class="btn btn-primary " id="submit_autofillbtn" onclick="autofill()"/>
						<!--</form>--></form>
					</span>
				</div>
			</div>
</div>
		

	</div>
	<script>
	function checkMobile()
	{
		alert("checkMobile called");
		var mobile=$("#m1").value;
		console.log(mobile);
		$.ajax({
			url : '/WeatherApi/MobileAjaxController',
			data: {
				mobile1:mobile
				},
			success : function(responseText)
			{
				//yaha se controller main bhejna h response aur true/false return krwana h
				console.log(responseText.mobile);
				
				
				if(responseText.mobile=="true")
					{
					$("#alertmobile").innerHTML="<span style='color: red;font-size:12px'>**UserId Already Exists!Kindly try with a different number</span>";
					}
				else
					{
					$("#alertmobile").innerHTML="<span style='color: green;font-size:12px'>**UserId is available!</span>";
					}
			}
		
	});
	}
	 function fetchStates()
		{
			alert("fetchStates called");
			
			$.ajax({
				url : '/WeatherApi/StateJSONController',
				success : function(responseText) {
					alert("function returned success");
					console.log(responseText.States);
					
					alert(responseText.States);
					for(s in responseText.States)
						{
						$("#state").append("<option value='"+responseText.States[s]+"'>"+responseText.States[s]+"</option>");
						console.log(responseText.States[s]);
						}
				}
			});
			
			
			
		} 
	function autofill()
	{
		document.getElementById("Level").value = "L1";
		document.getElementById("state").value = "MP";
		document.getElementById("sel1").value = "Gwalior";
		document.getElementById("sel2").value = "yes";
		document.getElementById("L5").value = "no";
		document.getElementById("uname").value = "yoyo";
		document.getElementById("desig").value = "executive";
		document.getElementById("dateofbirth").value = "2000-11-24";
		var digits = Math.floor(Math.random() * 9000000000) + 1000000000;
		document.getElementById("m1").value = digits;
		document.getElementById("m2").value = "2010304050";
		document.getElementById("mailid").value = "yohoo@gmail.com";
		document.getElementById("qual").value = "graduate";
		document.getElementById("location").value = "morena";
		document.getElementById("years").value = "5";
		document.getElementById("months").value = "11";
		document.getElementById("photo").value = "BTC192";
		document.getElementById("gender").value = "male";
		document.getElementById("accno").value = "458296315724";
		document.getElementById("ifscno").value = "PNB02010504";
		document.getElementById("bank").value = "Gramin Bank";
		document.getElementById("branch").value = "morena";
		document.getElementById("bankstate").value = "MP";
		document.getElementById("addr").value = "morena 124,mp";
		
		
	}
	function ValidateNo() {
	    var phoneNo = document.getElementsByClassName('txtPhoneNo');

	if (phoneNo.value == "" || phoneNo.value == null) {
	        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Please enter your mobile number</span>";
	        return false;
	    }
	    if (phoneNo.value.length < 10 || phoneNo.value.length > 10) {
	        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Enter valid mobile Number</span>";
	        return false;
	    }
		if ((phoneNo.value < 92  && phoneNo.value > 64) || (phoneNo.value < 123  && phoneNo.value > 96) ) {
	        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Enter valid mobile Number</span>";
	        return false;
	    }


	    return true;
	    }

	</script>
<script>
	$(document).ready(function() {

		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		const page_type = urlParams.get('status');
		console.log(page_type);
		if (page_type == "done") {
			swal({
				title : "User ID created successfully",
				icon : "success",
				timer : "200000",
				buttons: {
				    create: "Create New User",
				    home_page: "Go to Home Page",
				}
			}).then((value) => {
				  switch (value) {
				  
				    case "create":
				    	window.location.href = "/WeatherApi/app/NewUser.jsp";
				      break;
				    case "home_page":
				    	window.location.href = "/WeatherApi/app/HomePage.jsp";
				      break;
				  }
			});

		}
		if (page_type == "invalid") {
			swal({
				title : "Something went wrong! Please try again",
				icon : "error",
				timer : "200000",
				buttons: {
				    create: "Create New User",
				    home_page: "Go to Home Page",
				}
			}).then((value) => {
				  switch (value) {
				  
				    case "create":
				    	window.location.href = "/WeatherApi/app/NewUser.jsp";
				      break;
				    case "home_page":
				    	window.location.href = "/WeatherApi/app/HomePage.jsp";
				      break;
				  }
			});

		}
	})
</script>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS
	<script src="/app/js/NewUser.js"></script> -->
	

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>