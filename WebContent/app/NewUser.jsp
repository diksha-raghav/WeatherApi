<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<!--  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">-->

<!-- Required css -->
<!--     <link rel="stylesheet" href="/css/main-style.css" type="text/css" /> -->
<!--     <link rel="stylesheet" href="/app/css/header_menu.css" type="text/css"> -->
<!--     <link rel="stylesheet" href="/app/css/NewUser.css"> -->

<title>Create New User</title>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/mainSheet.css" type="text/css"/>
<script type="text/javascript" src="js/state.js"></script>
<script src="js/sweet//////alert.min.js"></script>
<link rel="stylesheet" href="css/header_menu.css" type="text/css">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/sweet//////alert.min.js"></script>
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
<body  onload="getBanks();">
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
		<form action="/WeatherApi/UserDetailsController" method="post"
			enctype="multipart/form-data">
			<div>
				<h3 align="center" style="font: 25px Calibri !important;">
					<b>New User Registration</b>
				</h3>
			</div>

			<hr>
			<div class="h2">Location Details</div>
			<div class="row  g-3 row-grid mt-5">
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Level <span
						style="color: red; font-size: large;">*</span></label> <select
						name="level" id="level" class="form-control"
						onchange="Levelfunction()" required>
						<option selected disabled>Select</option>
						<option>State</option>
						<option>District</option>
						<option>Taluka/Tehsil/Block</option>
						<option>Others</option>

					</select>

				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">State <span
						style="color: red; font-size: large;">*</span></label> <select
						name="state" class="form-control" id="state" required>
						<option>State</option>

					</select>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">District <span
						style="color: red; font-size: large;">*</span></label> <select
						name="district" class="form-control" id="district" required>
						<option selected disbaled>District</option>


					</select>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">L4 <span
						style="color: red; font-size: large;">*</span></label> <select
						name="subdistrict" class="form-control" id="subdistrict" required>
						<option selected disbaled>SubDsitrict</option>

					</select>
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputL5" class="form-label field">L5 <span
						style="color: red; font-size: large;">*</span></label> <input required
						type="text" name="l5" id="L5" class="form-control"
						placeholder="L5" aria-label="L5" value="">
				</div>
			</div>
			<hr>
			<div class="h2">Personal Details</div>
			<div class="row">
				<div class="col-md-3 mb-5 ">
					<label for="inputUsername" class="form-label field">Name of
						the User <span style="color: red; font-size: large;">*</span>
					</label> <input type="text" name="User" id="uname" required
						class="form-control" placeholder="Name of the User"
						aria-label="User name" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputdesignation" class="form-label field">Designation
						<span style="color: red; font-size: large;">*</span>
					</label> <select name="designation" class="form-control" id="designation"
						required>
						<option selected disabled>Select</option>
						<option>Field Supervisor</option>
						<option>Field Supervisor: District</option>
						<option>Field Supervisor: Tehsil/Block/Taluka</option>
						<option>District Manager</option>


					</select>
				</div>
				<div class="col-md-3 mb-5 md-form ">
					<label class="control-label field" for="date">Date Of Birth
						<span style="color: red; font-size: large;">*</span>
					</label> <input class="form-control" required name="dob" id="dateofbirth"
						placeholder="YYYY-MM-DD" type="date" value="" max="2003-12-31" />
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputMobile" class="form-label field">Mobile
						(User ID)<span style="color: red; font-size: large;">*</span>
					</label> <input type="text" name="mobile1" required id="m1"
						class="form-control txtPhoneNo" placeholder="Mobile"
						aria-label="Mobile" pattern="[6-9]{1}[0-9]{9}"
						title="Phone number with 6-9 and remaining 9 digit with 0-9"
						value="" maxlength="10" onchange="ValidateNo();">
					<p id="alertmobile"></p>
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputAlternateMobile" class="form-label field">Alternate
						Mobile </label> <input type="text" name="mobile2" id="m2"
						class="form-control txtPhoneNo" placeholder="Alternate Mobile"
						aria-label="Alternate Mobile" pattern="[6-9]{1}[0-9]{9}"
						title="Phone number with 6-9 and remaing 9 digit with 0-9"
						value="" maxlength="10" onchange="checknum();">
					<p id="alertmobile"></p>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputEmail" id="txtEmail" class="form-label field">Email
						<span style="color: red; font-size: large;">*</span>
					</label> <input type="email" name="email" id="mailid" class="form-control"
						placeholder="Email" aria-label="Email" value=""
						style="text-transform: lowercase;" required>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Educational Qualification</label> <select
						name="educational_qualification" class="form-control" id="qual">
						<option selected disabled>Select</option>
						<option>10th</option>
						<option>12th</option>
						<option value="Graduate">Graduate</option>
						<option>Post Graduate</option>
						<option>Diploma</option>
					</select>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputLocatedAt" class="form-label field">Located
						At <span style="color: red; font-size: large;">*</span>
					</label> <input type="text" required name="office_location" id="location"
						class="form-control" placeholder="Located At"
						aria-label="Located At" value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputyears" class="form-label field">Experience
						In Crop Insurance <span style="color: red; font-size: large;">*</span>
					</label> <input type="number" required name="exp_crop_ins_year" id="years"
						value="" class="form-control" placeholder="In years"
						aria-label="years" pattern="[0-9]{2}" max="99" min="0">
				</div>
				<div class="col-md-3 mb-5">
					<label for="inputmonths" class="form-label field">Experience
						In Crop Insurance <span style="color: red; font-size: large;">*</span>
					</label> <input type="number" required name="exp_crop_ins_month" value=""
						id="months" class="form-control" placeholder="In Months"
						aria-label="months" pattern="[0-9]{2}" max="11" min="0">

				</div>


				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Gender <span
						style="color: red; font-size: large;">*</span></label> <select
						name="gender" class="form-control" id="gender" required>
						<option selected disabled>Select</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
			</div>
			<hr>

			<div class="h2">Intermediary Details</div>

			<div class="row">
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Type <span
						style="color: red; font-size: large;">*</span></label> <select
						name="intermediary_type" class="form-control"
						id="intermediary_type" required>
						<option selected disabled>Select</option>
						<option value="Broker">Broker</option>
						<option value="Field Functionary">Field Functionary</option>
						<option value="Outsource">Outsource</option>
					</select>
				</div>

				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Name </label> <select
						name="intermediary_name" class="form-control"
						id="intermediary_name" required>
						<option selected disabled>Select</option>

					</select>
				</div>
				<div class="col-md-3  mb-5">
					<label for="" class="form-label field">Spoc Name</label> <input
						type="text" name="int_spoc_name" class="form-control"
						placeholder="" id="int_spoc_name" aria-label="" value="">
				</div>
				<div class="col-md-3  mb-5">
					<label for="" class="form-label field">Email ID</label> <input
						type="text" name="int_emailid" class="form-control" placeholder=""
						id="int_emailid" aria-label="" value="">
				</div>
				<div class="col-md-3  mb-5">
					<label for="inputBank_Branch_Address" class="form-label field">Phone
						Number</label> <input type="text" name="int_phonenumber"
						class="form-control" placeholder="" id="int_phonenumber"
						aria-label="" value="">
				</div>
				<div class="col-md-6  mb-5">
					<label for="inputBank_Branch_Address" class="form-label field">Address</label>
					<input type="text" name="int_address" class="form-control"
						placeholder="" id="int_address" aria-label="" value="">
				</div>
			</div>
			<div class="br-space"></div>
			<hr>
			<div class="h2">Photo ID Details</div>
			<div class="row">

				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">ID Type <span
						style="color: red; font-size: large;">*</span></label> <select
						name="doc_type" class="form-control" id="doc_type" required>
						<option selected disabled>Select</option>
						<option>Aadhar</option>
						<option>Driving License</option>
						<option>PAN Card</option>
						<option>Passport</option>
						<option>Voter ID</option>
					</select>
				</div>


				<div class="col-md-3 mb-5 ">
					<label for="inputphotoid" class="form-label field"> Upload
						ID Card <span style="color: red; font-size: large;">*</span>
					</label> <input name="photo_card" type="file" class="form-control"
						accept="application/pdf,image/png,image/jpeg" multiple="multiple"
						required>
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputphotocardid" class="form-label field">Photo
						Card ID <span style="color: red; font-size: large;">*</span>
					</label> <input type="text" name="card_id" required class="form-control"
						placeholder="ID Number" aria-label="ID Number" id="card_id"
						value="" maxlength="16">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputphotoid" class="form-label field">Photo </label> <input
						name="photo" type="file" class="form-control">
				</div>
			</div>

			<hr>
			<div class="h2">Bank Details</div>
			<div class="row">
				<div class="col-md-3 mb-5 ">
					<label for="inputbanknum" class="form-label field">Bank
						Account Number</label> <input type="text" name="bank_num"
						class="form-control" placeholder="Bank Account Number"
						aria-label="Bank Num" id="accno" maxlength="16" minlength="6"
						value="">
				</div>
				<div class="col-md-3 mb-5 ">
					<label for="inputIFSC" class="form-label field">Bank IFSC</label> <input
						type="text" name="bank_ifsc" class="form-control" value=""
						placeholder="Bank IFSC" aria-label="Bank IFSC" id="ifscno"
						maxlength="11" minlength="11" onchange="checkIFSC()"> <span
						id="branchspan"></span>
				</div>
				<div class="form-group col-md-3 mb-5 ">
					<label class="field" for="sel1">Bank Name</label> <select value=""
						name="bank_name" class="form-control" id="bank_name">
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
				<div class="col-md-3  mb-5">
					<label for="inputBank_Branch_Address" class="form-label field">Bank
						Branch Address</label> <input type="text" name="bank_branch_address"
						class="form-control" placeholder="Bank Branch Address" id="addr"
						aria-label="Bank Branch Address" value="">
				</div>


			</div>

			<div class="br-space"></div>
			<div class="col-md-12">
				<div class="submitbuttondiv">
					<span> <input type="submit" value="Submit"
						onClick="checkMobile();" class="mainsubmit" id="submit_btn" />
						<form onsubmit=" return validate()">
							<!-- 						<input type="submit" value="Autofill" -->
							<!-- 						class="btn btn-primary " id="submit_autofillbtn" onclick="autofill()"/> -->
						</form>
		</form>
		</span>
	</div>
	</div>
	</div>


	</div>
	<script>
	function autofill()
	{
// 		document.getElementById("Level").value = "L1";
// 		document.getElementById("state").value = "MP";
// 		document.getElementById("sel1").value = "Gwalior";
// 		document.getElementById("sel2").value = "yes";
		document.getElementById("L5").value = "no";
		document.getElementById("uname").value = "yoyo";
		document.getElementById("desig").value = "executive";
		document.getElementById("dateofbirth").value = "2000-11-24";
		document.getElementById("m1").value = "5478963217";
		document.getElementById("m2").value = "2010304050";
		document.getElementById("mailid").value = "yohoo@gmail.com";
		document.getElementById("qual").value = "Graduate";
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
	function Levelfunction()
	{
		var level = document.getElementById('level');
		if(level.value=="State")
			{
				
				document.getElementById("district").disabled=true;
				document.getElementById("subdistrict").disabled=true;
				document.getElementById("L5").disabled=true;
			}
		else if(level.value=="District")
			{
			document.getElementById("district").disabled=false;
			document.getElementById("subdistrict").disabled=true;
			document.getElementById("L5").disabled=true;
			}
		else if(level.value=="Taluka/Tehsil/Block")
		{
			document.getElementById("district").disabled=false;
			document.getElementById("subdistrict").disabled=false;
			document.getElementById("L5").disabled=true;
		}
		else if(level.value=="Others")
		{
			document.getElementById("district").disabled=false;
			document.getElementById("subdistrict").disabled=false;
			document.getElementById("L5").disabled=false;
		}
		
	}
	
/*	$('level').change(function(){
		   if ($(this).children('option:selected').value=="State") { 
			   document.getElementById("district").disabled=true;
				document.getElementById("subdistrict").disabled=true;
				document.getElementById("L5").disabled=true;
		  }
		   else if
		 }); */
	
	function checknum()
	{
		var m1 = document.getElementById('m1');
		var m2 = document.getElementById('m2');
		if(m1.value==m2.value)
			{
			//////alert('Alternate phone number should be different');
			}
	}
	
	
	function ValidateNo() {
		checkMobile();
	    var phoneNo = document.getElementsById('m1');

	if (phoneNo.value == "" || phoneNo.value == null) {
		 //////alert("Enter a Valid 10 digit number");
	    }
	if (phoneNo.value.length != 10) {
	     //////alert("Enter a Valid 10 digit number");
	  }
	if ((phoneNo.value < 92  && phoneNo.value > 64) || (phoneNo.value < 123  && phoneNo.value > 96) ) {
		//////alert("Enter a Valid 10 digit number");
	   }


	    return true;
	    }

	</script>
	<script>
	$(document).ready(function() {
		
	////alert("Into the ready function");
		$('#intermediary_type').on('change',function(){
			var selectedType = $(this).children("option:selected").text();
			
// 			console.log(selectedType);
		
			var interMap = ${interMap}
			JSON.stringify(interMap);
		
			document.getElementById("intermediary_name").innerHTML = "";
			////alert(interMap);		
			if(selectedType=="Broker")
			{
// 				console.log("hello");
				var drop = "<select class='form-control' id='intermediary_name' name='intermediary_name'></select>"
			   	 $("#intermediary_name").replaceWith(drop);
					$("#intermediary_name").append("<option value=''> --Select---- </option>"); 	
				for (var i = 0; i < interMap.Broker.length; i++) 
				{
					$("#intermediary_name").append("<option value='"+interMap.Broker[i]+"'>" +interMap.Broker[i]+ "</option>");
				}
					document.getElementById("int_spoc_name").value = "";
					document.getElementById("int_emailid").value = "";
					document.getElementById("int_phonenumber").value = "";
					document.getElementById("int_address").value = "";
					
					$("#intermediary_name").trigger("change");
					  $('#intermediary_name').on('change',function(){
// 						  console.log("name selected");
							
							
							var selectedBroker = $(this).children("option:selected").val();
// 			 				//////alert(selectedBroker);
			 				
			 				$.ajax({
								url : '/WeatherApi/AutofillController',
								data:{intermediary_name:selectedBroker},
								success : function(responseText) {
			 								console.log("function returned success");
			 								document.getElementById("int_spoc_name").value = responseText.Details[0];
			 								document.getElementById("int_emailid").value = responseText.Details[1];
			 								document.getElementById("int_phonenumber").value = responseText.Details[2];
			 								document.getElementById("int_address").value = responseText.Details[3];
			 						
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
			 				
			 		}) 
	
			}
			
			else
			{
				var txt = "<input type='text' maxlength=50 class='form-control text-alphanumeric-field-alignment' id='intermediary_name' name='intermediary_name'>"
					   $("#intermediary_name").replaceWith(txt);
				document.getElementById("intermediary_name").value = "";
				document.getElementById("int_spoc_name").value = "";
				document.getElementById("int_emailid").value = "";
				document.getElementById("int_phonenumber").value = "";
				document.getElementById("int_address").value = "";
			}
			
		}) ;
		
		var banks =["State Bank Of India","Hdfc Bank Ltd.","Indian Overseas Bank","Punjab National Bank","Uttar Banga Kshetriya Gramin Bank","West Bengal State Cooperative Bank Ltd","Uco Bank","Union Bank Of India","United Bank Of India","Syndicate Bank","Indusind Bank Ltd","Axis Bank Limited","The Jalpaiguri  Central Cooperative Bank Ltd.","Icici Bank Limited","Allahabad Bank","Bandhan Bank Limited","Bank Of Baroda","Bank Of India","Central Bank Of India","Idbi Bank Limited","Vijaya Bank","Corporation Bank","Canara Bank","Indian Bank","Vidyasagar  Central Cooperative Bank Ltd.","Andhra Bank","Karnataka Bank Ltd","Kotak Mahindra Bank Ltd.","Oriental Bank Of Commerce","Punjab And Sind Bank","Dena Bank","Paschim Banga Gramin Bank","Hooghly District Central Cooperative Bank Ltd.","Federal Bank Ltd","Howrah District Central Cooperative Bank Ltd","Yes Bank Ltd.","Karur Vysya Bank Ltd","The Dhanalakshmi Bank Ltd","Bank Of Maharashtra","The Howrah District Central Cooperative Bank Ltd.","South Indian Bank Ltd","Hongkong And Shanghai Banking Corpn.ltd.","Standard Chartered Bank","Sonali Bank","Darjeeling District Central Cooperative Bank Ltd.","Bangiya Gramin Vikash Bank","Dakshin Dinajpur District Central Cooperative Bank Ltd.","Raiganj Central Cooperative Bank Ltd.","Lakshmi Vilas Bank Ltd","Purulia Central Cooperative Bank Ltd.","Balageria Central Cooperative Bank Ltd.","Mugberia Central Cooperative Bank Ltd.","Tamluk-ghatal  Central Cooperative Bank Ltd.","The Burdwan Central Co-operative Bank  Ltd.","Burdwan Co-Operative Agriculture & Rural Development Bank","Zila Sahkari Bank Ltd, Budaun","Catholic Syrian Bank Ltd","Nadia District Central Cooperative Bank Ltd.","Murshidabad District Central Cooperative Bank Ltd.","Malda District Central Cooperative Bank Ltd.","Tamilnad Mercantile Bank Ltd","City Union Bank Limited","Rbl Bank Ltd.","Dcb Bank Limited","Citibank N.a","Bank Of America , National Association","Jammu & Kashmir Bank Ltd","Bnp Paribas","Deutsche Bank Ag","Idfc Bank Limited","Dbs Bank Ltd.","The Royal Bank Of Scotland Plc","Bankura District Central Cooperative Bank Ltd.","Uttarakhand Gramin Bank","Zila Sahkari Bank Ltd","Almora Urban Co-Operative Bank Ltd.","Nainital Bank Ltd","Sarva U.p. Gramin Bank","Zila Sahkari Bank Ltd,Hardwar","Gramin Bank Of Aryavart","Aligarh Distcrit Co-operative Bank Ltd.","Allahabad Up Gramin Bank","Zila Sahkari Bank Ltd. Meerut","Agra District Co-operative Bank Agra","Uttar Pradesh Co-operative Bank Ltd.","Commercial Test Bank","Kashi Gomti Samyut Gramin Bank","District Co-operative Bank Ltd, Varanasi","Zila Sahkari Bank Ltd.unnao","Baroda Uttar Pradesh Gramin Bank","Zila Sahkari Bank Ltd. Mirzapur","Purvanchal Bank","Dcb Muzaffarnagar","Shahjahanpur Distric Co-operative Bank Ltd.","Prathama Bank","Zila Shakari Bank Moradabad","District Co-operative Bank Ltd.","District co-operative Bank Ltd, saharanpur","Rampur Zila Sahkari Bank Ltd.","District Co-operative Bank Ltd. Raebareli","Dcb Pratapgarh","Etawahdistrict Co-operative Bank Ltd.","Pilibhit District Co-operative Bank Ltd.","Distric Co-operative Bank Ltd.mau","Mathura Zila Sahkari Bank Ltd.","Zila Sahkari Bank Ltd. Mainpuri","Hamirpur District Co Operative Bank Ltd.","Distt. Co-operative Bank Ltd. Lucknow","Zila Sahkari Bank Ltd. Lalitpur","Distt Co Operative Bank Ltd Lakhimpur Kheri","Allahabad District Co-operative Bank Ltd.","Etah District Co-operative Bank Ltd.","Zila Sahkari Bank Ltd. Kanpur","The Farrukhabad District Co Operative Bank Ltd.","Zila Sahkari Bank Ltd Jhansi","Jalaun District Cooperative Bank","Zila Sahkari Bank Ltd.gaziabad","District Central Co-operative Bank Ltd, Ghazipur","District Co-operative Bank Ltd, Ambedkar Nagar","District Cooperative Bank Ltd.","Firozabad District Co-operative Bank Ltd.","District Cooperative Bank Ltd Barabanki","District Co-operative Bank Lt, Faizabad","Banda District Co-operative Bank Ltd.","Distt.cooperative Bank Ltd. Bijnor","Dist. Co-operative Bank Ltd. Bareilly","Zila Sahkari Bank Ltd Balia","Tripura Gramin Bank","Tripura State Cooperative Bank Ltd","Bharatiya Mahila Bank Ltd.","District Cooperative Central Bank Ltd.","Andhra Pradesh Grameena Vikas Bank","District Cooperative Central Bank Ltd., Khammam","Telangana Grameena Bank","District Cooperative Central Bank Ltd., Karimnagar","District Cooperative Central Bank Ltd., Nizamabad","District Cooperative Central Bank Ltd., Mahbubnagar","District Cooperative Central Bank Ltd., Warangal","District Cooperative Central Bank Ltd., Adilabad","District Cooperative Central Bank Ltd., Nalgonda","Krishna  Bhima  Samruddhi   Lab Ltd.","District Cooperative Central Bank Ltd., Hyderabad","District Cooperative Central Bank Ltd., Medak","Telangana State Cooperative Apex Bank Ltd.","The Ap Stcb Ltd.","Sbm Bank (mauritius)ltd.","Barclays Bank Plc","Bank Of Bahrain & Kuwait B.s.c.","Pallavan Grama Bank","Coimbatore District Central Cooperative Bank Ltd.","Dharmapuri District Central Cooperative Bank Ltd.","Tiruchirappalli District Central Cooperative Bank Ltd.","Pandyan Grama Bank","Kanya Kumari District Central Cooperative Bank Ltd.","Shinhan Bank","Ctbc Bank Co., Ltd.","Kancheepuram Central Cooperative Bank Ltd.","Erode District Central Cooperative Bank Ltd.","Dindigul Central Cooperative Bank Ltd.","Virudhunagar District Central Cooperative Bank Ltd.","Villupuram District Central Cooperative Bank Ltd.","Vellore District Central Cooperative Bank Ltd.","Tiruvannamalai District Central Cooperative Bank Ltd.","Tirunelveli District Central Cooperative Bank Ltd.","Thoothukudi District Central Cooperative Bank Ltd.","Kumbakonam Central Cooperative Bank Ltd.","Thanjavur Central Cooperative Bank Ltd.","Madurai District Central Cooperative Bank Ltd.","Cuddalore District Central Cooperative Bank Ltd.","Nilgiris District Central Cooperative Bank Ltd.","Sivganga District Central Cooperative Bank Ltd.","Salem District Central Cooperative Bank Ltd.","Ramanathapuram District Central Cooperative Bank Ltd.","Pudukottai District Central Cooperative Bank Ltd.","Sikkim State Co-operative Bank Ltd.","Baroda Rajasthan Kshetriya Gramin Bank","The Central Co-operative Bank Ltd, Ajmer","Au Small Finance Bank Limited","Rajasthan Rajya Sahakari Bhoomi Vikas Bank Ltd, Jaipur","The Central Co-operative Bank Ltd, Alwar","The Bank Of Tokyo-mitsubishi Ufj Ltd","Ing Vysya Bank Ltd","State Bank Of Mysore","State Bank Of Travancore","The Central Co-operative Bank Ltd, Banswara","The Central Co-operative Bank Ltd, Baran","Rajasthan Marudhara Gramin Bank","The Central Co-operative Bank Ltd, Barmer","The Central Co-operative Bank Ltd, Bharatpur","The Central Co-operative Bank Ltd, Bhilwara","The Central Co-operative Bank Ltd, Bikaner","The Central Co-operative Bank Ltd, Jaipur","The Central Co-operative Bank Ltd, Bundi","The Central Co-operative Bank Ltd, Chittaurgarh","The Central Co-operative Bank Ltd, Churu","The Central Co-operative Bank Ltd, Dausa","The Central Co-operative Bank Ltd, Dungarpur","Hanumangarh Kendriya Sahakari Bank Ltd.","Shamrao Vithhal Co-Op Bank Ltd.","A P Mahesh Co-op Urban Bank Ltd.","The Central Co-operative Bank Ltd, Jaisalmer","The Central Co-operative Bank Ltd, Jalore","The Central Co-operative Bank Ltd, Jhalawar","The Central Co-operative Bank Ltd, Jhunjhunu","The Central Co-operative Bank Ltd, Jodhpur","The Central Co-operative Bank Ltd, Sawai Madhopur","The Central Co-operative Bank Ltd, Kota","The Central Co-operative Bank Ltd, Nagaur","The Central Co-operative Bank Ltd, Pali","The Central Co-operative Bank Ltd, Udaipur","The Central Co-operative Bank Ltd, Sikar","The Central Co-operative Bank Ltd, Sirohi","The Central Co-operative Bank Ltd, Ganganagar","The Central Co-operative Bank Ltd, Tonk","Capital  Local  Area  Bank  Ltd.","Punjab Gramin Bank","Coop Bank Amritsar","Rural Test Bank","Cooperative Test Bank","Malwa Gramin Bank","Sutlej Gramin Bank","The Bathinda Central Cooperative Bank Ltd","The Ferozepur Central Coop Bank Ltd","The Gurdaspur Central Cooperative Bank Ltd","The Hoshiarpur Central Coop Bank Ltd","The Kapurthala Central Cooperative Bank Ltd. Kapurthala","The Ludhiana Central Cooperative Bank Ltd.","The Mansa Central Cooperative Bank Ltd Mansa","The Moga Central Cooperative Bank Ltd; Moga","The Muktsar Central Co-operative Bank Ltd.","The Ropar Central Cooperative Bank Ltd.,","The Sas Nagar Central Cooperative Bank Ltd","The Sangrur Central Coop Bank Ltd","Dccb Nawanshahr","The Tarn Taran Central Coop Bank Ltd","Puduvai Bharathiar Grama Bank","Odisha Gramya Bank","Angul UCC Bank Ltd.","Utkal Grameen Bank","Berhampur CC Bank Ltd.","Sambalpur Dist. CC Bank LTd.","Cuttack CC Bank Ltd.","Banki CC Bank Ltd.","Balasore-Bhadrak CC Bank Ltd.","Boudh CC Bank Ltd.","Sundargarh Disct. CC Bank Ltd.","Bolangir Dist CC Bank Ltd.","Koraput CCBank Ltd.","Khurda CC Bank Ltd.","United Puri-Nimapara CC Bank Ltd.","Bhawanipatna CC Bank Ltd.","Nayagarh District CC Bank Ltd.","Mayurbhanj CC Bank Ltd.","Keonjhar CC Bank Ltd.","Central Co Operative Bank Ltd. (ara)","The Aska CC Bank Ltd.","Nagaland Rural Bank","Nagaland State Cooperative Bank Ltd","Mizoram Rural Bank","Mizoram Cooperative Apex Bank Ltd. (mcab)","Megalaya Rural Bank","Meghalaya Co-op Apex Bank Ltd","Manipur Rural Bank","Manipur State Co-operative Bank Ltd","Akola District Central Co-op Bank Ltd","Maharashtra Scb","Vidharbha Konkan Gramin Bank","Gadchiroli District Central Co-op. Bank Ltd","Thane District Central Co-op Bank Ltd","Dhule And Nandurbar District Central Cooperative Bank Ltd","Dhule Dccb","Maharashtra Gramin Bank","Chandrapur District Central Co-operative Bank Ltd","Buldana District Central Cooperative Bank Ltd","Beed District Central Cooperative Bank Ltd","Bhandara District Central Co-operative Bank Ltd","Ahmednagar District Central Co-op Bank Ltd","Yeotmal District Central Co-operative Bank Ltd","Solapur District Central Co-op. Bank Ltd","Sindhudurg District Central Cooperative Bank Ltd","Aurangabad District Central Cooperative Bank Ltd","Satara District Central Co-op. Bank Ltd","Sangli District Central Cooperative Bank Ltd","Subhadra Local Area Bank Ltd.","Ratnagiri District Central Cooperative Bank Ltd","Raigad District Central Cooperative Bank Ltd","Pune District Central Co.op Bank Ltd","Credit Agricole Corporate And Investment Bank","Parbhani District Central Cooperative Bank Ltd","Valmiki Urban Co Operative Bank Ltd., Pathri","Osmanabad District Central Cooperative Bank Ltd","Nasik District Central Co-operative Bank Ltd","Amravati District Central Co-operative Bank Ltd","Nanded District Central Cooperative Bank Ltd","Nagpur District Central Cooperative Bank Ltd","Firstrand Bank Ltd","Industrial And Commercial Bank Of China","Jpmorgan Chase Bank National Association","National Bank Of Abudhabi Pjsc","United Overseas Bank Ltd","Westpac Banking Corporation","Ab Bank Limited","Commonwealth Bank Of Australia","Cooperative Centrale Raiffeisen-boerenleenbank B.a.","Credit Suisse Ag","Kbc Bank Nv","Krung Thai Bank Public Company Limited","Mashreq Bank Psc","National Australia Bank","Pt Bank Maybank Indonesia Tbk","Mumbai District Central Cooperative Bank Ltd","Bank Of Nova Scotia","Doha Bank Qsc","Mizuho Bank Ltd","Societe Generale","Australia And New Zealand Banking Group Limited","Abu Dhabi Commercial Bank Ltd","Latur District Central Co-op Bank Ltd","Kolhapur District Central Co-operative Bank Ltd","Jalna District Central Co-operative Bank Ltd","Mantha Urban Co-Op Bank Ltd. Mantha","Priyadarshani Nagari Sahakari Bank Maryadit Jalna","Jalgaon District Central Cooperative Bank Ltd","Gondia District Central Co-op. Bank Ltd","Jila Sahakari Kendriya Bank., Vidisha","Central Madhya Pradesh Gramin Bank","Jila Sahakari Kendriya Bank., Ujjain","Narmada Jhabua Gramin Bank","Jila Sahakari Kendriya Bank., Tikamgarh","Madhyanchal Gramin Bank","Jila Sahakari Kendriya Bank., Sidhi","Jila Sahakari Kendriya Bank., Shivpuri","Jila Sahakari Kendriya Bank., Shajapur","Jila Sahakari Kendriya Bank., Shahdol","Jila Sahakari Kendriya Bank., Seoni","Jila Sahakari Kendriya Bank., Sehore","Jila Sahakari Kendriya Bank., Satna","Jila Sahakari Kendriya Bank., Sagar","Jila Sahakari Kendriya Bank., Rewa","Jila Sahakari Kendriya Bank., Ratlam","Jila Sahakari Kendriya Bank., Rajgarh","Jila Sahakari Kendriya Bank., Raisen","Jila Sahakari Kendriya Bank., Panna","Jila Sahakari Kendriya Bank., Mandsaur","Jila Sahakari Kendriya Bank., Narsimhapur","Jila Sahakari Kendriya Bank., Morena","Jila Sahakari Kendriya Bank","Jila Sahakari Kendriya Bank., Mandla","Jila Sahakari Kendriya Bank., Khargone (West Nimar)","Jila Sahakari Kendriya Bank., Khandwa (East Nimar)","Jila Sahakari Kendriya Bank., Jhabua","Jila Sahakari Kendriya Bank., Jabalpur","Indore Premior Co-operative Bank  Ltd","Jila Sahakari Kendriya Bank., Hoshangabad","Jila Sahakari Kendriya Bank., Gwalior","Jila Sahakari Kendriya Bank., Guna","Jila Sahakari Kendriya Bank. Dhar","Jila Sahakari Kendriya Bank., Dewas","Jila Sahakari Kendriya Bank., Datia","Jila Sahakari Kendriya Bank., Damoh","Jila Sahakari Kendriya Bank., Chhindwara","Jila Sahakari Kendriya Bank., Chhatarpur","Bhopal Central Co-operative Bank Limited Bhopal","Jila Sahakari Kendriya Bank., Bhind","Betul Nagrik Sahakari Bank Ltd.","Jila Sahakari Kendriya Bank., Betul","Jila Sahakari Kendriya Bank., Balaghat","Alappuzha Dist.co-op:bank","Kerala State Co-operative Bank","Kerala Gramin Bank","Ernakulam District Co-operative Bank","Idukki District Co-operative Bank","Kannur Dist.co-op:bank","Kasaragod Dist:co-op:bank","Kollam Dist. Co-op: Bank","Kottayam District Central Co-operative Bank Ltd","Kozhikode District     Co-operative Bank Ltd","Malappuram District Co Op Bank Ltd","The Palakkad District Co-op. Bank","Pathanamthitta District Co-operative Bank Ltd.","Tvm Dcb","Thrissur District Central Co-operative Bank Ltd","Wayanad District Co-operative Bank","Pragathi Krishna Gramin Bank","Kanara Dcc Bank Ltd.","Karnataka Vikas Grameena Bank","Tumkur Dcc Bank Ltd.","Kaveri Grameena Bank","Shimoga Dcc Bank Ltd.","Raichur Dcc Bank Ltd.","Mysore & Chamrajnagar Dcc Bank Ltd.","Mandya Dcc Bank Ltd.","Kolar And Chikballapura Dcc Bank Ltd.","Kodagu Dcc Bank Ltd.","Kalburgi & Yadgiri Dcc Bank Ltd.","Hassan  Dcc Bank Ltd.","Kcc Bank Dharwad Ltd.","Davangere Dcc Bank Ltd.","South Canara Dcc Bank Ltd.","Chitradurga Dcc Bank Ltd.","Chikmagalur Dcc Bank Ltd.","Bijapur Dcc Bank Ltd.","Bidar Dcc Bank Ltd.","Bellary Dcc Bank Ltd.","Belgaum Dcc Bank Ltd.","Bangalore Rural & Ramnagar Dcc Bank Ltd.","Bagalkot Dcc Bank Ltd.","Jharkhand State Cooperative Bank Limited","Jharkhand Gramin Bank","Vananchal Gramin Bank","Dhanbad Central Co-operative Bank Ltd.","Vaishali District Central Co Operative Bank Ltd.","Uttar Bihar Gramin Bank","Ellaquai Dehati Bank","J & K Grameen Bank","The Jammu Central Co-Opertive Bank Ltd","Himachal Pradesh State Co-Operative Bank Ltd.","Himachal Pradesh Gramin Bank","Kcc Bank Ltd","Jogindra Central Cooperative Bank Ltd Solan","Ambala Central Coop. Bank Ltd.","Panchkula Central Coop. Bank","Sarva Haryana Gramin Bank","Bhiwani Central Coop. Bank Ltd;","Faridabad Central Coop. Bank Ltd;","The Fatehabad Central Coop. Bank Ltd","Gurgaon Central Coop. Bank Ltd;","American Express Banking Corp.","Hisar Central Coop. Bank Ltd;","The Jhajjar Central Cooperative Bank Ltd.","Jind Central Coop. Bank Ltd","Kaithal Central Coop. Bank Ltd","Karnal Central Coop. Bank Ltd","Kurukshetra  Central Coop. Bank","Mahendergarh  Central Coop. Bank","The Haryana State Coop. Apex Bank Ltd;","Panipat  Central Coop. Bank Ltd","Rewari  Central Coop. Bank Ltd.","Rohtak  Central Coop. Bank Ltd","Sirsa  Central Coop. Bank Ltd","Sonepat  Central Coop. Bank Ltd","Yamuna Nagar  Central Coop. Bank","Valsad District Central Co.op.bankltd","Baroda Gujarat Gramin Bank","The Baroda Central Co-operative Bank Ltd","The Surat District Co. Op. Bank Ltd.,surat","The Surendranagar Dist. Co-op Bank Ltd","Saurashtra Gramin Bank","Dena Gujarat Gramin Bank","Shri Rajkot District Co.op.bank Ltd.","The Junagadh Jilla Sahakari Bank Ltd","The Banaskantha District Central Co-op Bank Ltd.","The Mehsana Dccb","The Panchmahal Dist Coop Bank Ltd.","The Jamnagar Dist. Co. Op. Bank Ltd.","The Kaira District Central Co.operative Bank Ltd.","The Kachchh District Central Co. Op. Bank Ltd.","The Kodinar Taluka Co-operative Banking Uniuon Ltd","The Ahmedabad District Co. Op. Bank Ltd.","Bhavanagar Dist. Co-op. Bank Ltd","The Bharuch Dist. Central Co-op Bank Ltd","The Sabarkantha District Central Co Operative Bank Ltd","Amreli Jilla Madhyastha Sahkari Bank Ltd.","The Gujarat State Cooperative Bank Ltd","The Goa State Co.operative Bank Ltd.","Industrial Bank Of Korea","Jsc Vtb Bank","Sberbank","Sumitomo Mitsui Banking Corporation","Jskb, Durg","Chhattisgarh Rajya Gramin Bank","Chhattisgarh State Cooperative Bank Ltd","J.s.k. Bank Mydt. Bilaspur","Dccb Raipur","Jskb Jagdalpur","J.s.k Bank Ambikapur","Rajnandgaon District Central Cooperative Bank Ltd","Dccb, Rajnandgaon","Raipur District Central Cooperative Bank Ltd","The Chandigarh State Cooperative Bank Ltd","The Punjab State Cooperative Bank Ltd., Chandigarh","Magadh Central Co Operative Bank Ltd.","Madhya Bihar Gramin Bank","Bihar State Co Operative Bank Ltd.","Bihar Gramin Bank","Bhagalpur Central Co Operative Bank Ltd","Begusarai Central Co Operative Bank Ltd.","Purnea District Central Co Operative Bank  Ltd.","Siwan Central Co Operative Bank Ltd.","Sitamarhi Central Co Operative Bank Ltd.","Munger- Jamui Central Co Operative Bank Ltd.","Samastipur District Central Co Operative Bank Ltd.","Sasaram-bhabhua Central Co Operative Bank Ltd.","Motihari Central Co Operative Bank Ltd.","Patliputra Central Cooperative Bank Ltd.","National Central Co Operative Bank Ltd Bettiah","Nawada Central Cooperative Bank Ltd.","Nalanda Central Co Operative Bank Ltd.","Muzaffarpur Central Co Operative Bank Ltd.","Rohika Central Co Operative Bank Ltd.","Khagaria District Central Co Operative Bank Ltd.","Katihar District Central Co Operative Bank Ltd.","Gopalganj Central Co Opreative Bank Ltd.","The Assam Co-operative Apex Bank Ltd. (acab)","Assam Gramin Vikash Bank","Langpi Dehangi Rural Bank","Arunachal Pradesh State Co-operative Apex Bank Ltd.","Arunachal Pradesh Rural Bank","Anantapur District Cooperative Central Bank Ltd","Andhra Pragathi Grameena Bank","Chittoor District Cooperative Central Bank Ltd","Saptagiri Grameena Bank","Kakinada District Cooperative Central Bank Ltd","Chaitanya Godavari Grameena Bank","Coastal  Local  Area  Bank  Ltd.","Guntur District Cooperative Central Bank Ltd","Krishna District Cooperative Central Bank Ltd","Kurnool District Cooperative Central Bank Ltd","Prakasam District Cooperative Central Bank Ltd","Sri Potti Sri Ramulu Nellore District Cooperative Central Bank Ltd","Nellore Dccb","Srikakulam District Cooperative Central Bank Ltd","Visakhapatnam District Cooperative Central Bank Ltd","Vizianagaram District Cooperative Central Bank Ltd","Eluru District Cooperative Central Bank Ltd","Kadapa District Cooperative Central Bank Ltd","Cuddapah Dccb","Andaman & Nicobar State Cooperative Bank Ltd.","THE ZOROASTRIAN COOPERATIVE BANK LIMITED","THE VARACHHA COOPERATIVE BANK LIMITED","THE SURATH PEOPLES COOPERATIVE BANK LIMITED","THE SHAMRAO VITHAL COOPERATIVE BANK","THE NAVNIRMAN CO-OPERATIVE BANK LIMITED","THE NASIK MERCHANTS COOPERATIVE BANK LIMITED","THE MEHSANA URBAN COOPERATIVE BANK","THE GUJARAT STATE COOPERATIVE BANK LIMITED","THE COSMOS CO OPERATIVE BANK LIMITED","TAMILNAD MERCANTILE BANK LIMITED","SUTEX COOPERATIVE BANK LIMITED","SURAT NATIONAL COOPERATIVE BANK LIMITED","STATE BANK OF PATIALA","STATE BANK OF HYDERABAD","STATE BANK OF BIKANER AND JAIPUR","SARASWAT COOPERATIVE BANK LIMITED","RAJKOT NAGRIK SAHAKARI BANK LIMITED","PUNJAB AND MAHARSHTRA COOPERATIVE BANK","PRIME COOPERATIVE BANK LIMITED","NUTAN NAGARIK SAHAKARI BANK LIMITED","NKGSB COOPERATIVE BANK LIMITED","NEW INDIA COOPERATIVE BANK LIMITED","KAPOL COOPERATIVE BANK LIMITED","KALUPUR COMMERCIAL COOPERATIVE BANK","JANATA SAHAKARI BANK LIMITED","HSBC BANK","EQUITAS SMALL FINANCE BANK LIMITED","DEUSTCHE BANK","B N P PARIBAS","BHARATIYA MAHILA BANK LIMITED","BHARAT COOPERATIVE BANK MUMBAI LIMITED","ABHYUDAYA COOPERATIVE BANK LIMITED","ABU DHABI COMMERCIAL BANK","AIRTEL PAYMENTS BANK LIMITED","ALMORA URBAN COOPERATIVE BANK LIMITED","BANK INTERNASIONAL INDONESIA","BANK OF AMERICA","BANK OF BAHARAIN AND KUWAIT BSC","BANK OF CEYLON","BANK OF TOKYO MITSUBISHI LIMITED","CAPITAL SMALL FINANCE BANK LIMITED","CHINATRUST COMMERCIAL BANK LIMITED","CREDIT AGRICOLE CORPORATE AND INVESTMENT BANK CALYON BANK","CREDIT SUISEE AG","DEVELOPMENT BANK OF SINGAPORE","DEPOSIT INSURANCE AND CREDIT GUARANTEE CORPORATION","DEOGIRI NAGARI SAHAKARI BANK LTD. AURANGABAD","DOHA BANK","EXPORT IMPORT BANK OF INDIA","GURGAON GRAMIN BANK","HSBC BANK OMAN SAOG","IDUKKI DISTRICT CO OPERATIVE BANK LTD","INDUSTRIAL AND COMMERCIAL BANK OF CHINA LIMITED","JP MORGAN BANK","JANAKALYAN SAHAKARI BANK LIMITED","JANASEVA SAHAKARI BANK BORIVLI LIMITED","JANASEVA SAHAKARI BANK LIMITED","KEB HANA BANK","KALLAPPANNA AWADE ICHALKARANJI JANATA SAHAKARI BANK LIMITED","MAHANAGAR COOPERATIVE BANK","MASHREQBANK PSC","NAGAR URBAN CO OPERATIVE BANK","NATIONAL AUSTRALIA BANK LIMITED","NATIONAL BANK OF ABU DHABI PJSC","NORTH MALABAR GRAMIN BANK","OMAN INTERNATIONAL BANK SAOG","RABOBANK INTERNATIONAL","RAJGURUNAGAR SAHAKARI BANK LIMITED","SBER BANK","SBM BANK MAURITIUS LIMITED","SAHEBRAO DESHMUKH COOPERATIVE BANK LIMITED","SAMARTH SAHAKARI BANK LTD","SHRI CHHATRAPATI RAJASHRI SHAHU URBAN COOPERATIVE BANK LIMITED","SOLAPUR JANATA SAHAKARI BANK LIMITED","STATE BANK OF MAURITIUS LIMITED","THE AKOLA DISTRICT CENTRAL COOPERATIVE BANK","THE BANK OF NOVA SCOTIA","THE BARAMATI SAHAKARI BANK LTD","THE DELHI STATE COOPERATIVE BANK LIMITED","THE GADCHIROLI DISTRICT CENTRAL COOPERATIVE BANK LIMITED","THE GREATER BOMBAY COOPERATIVE BANK LIMITED","THE JALGAON PEOPELS COOPERATIVE BANK LIMITED","THE KURMANCHAL NAGAR SAHAKARI BANK LIMITED","THE MUMBAI DISTRICT CENTRAL COOPERATIVE BANK LIMITED","THE MUNICIPAL COOPERATIVE BANK LIMITED","THE ROYAL BANK OF SCOTLAND N V","THE SEVA VIKAS COOPERATIVE BANK LIMITED","THE THANE DISTRICT CENTRAL COOPERATIVE BANK LIMITED","UNITED OVERSEAS BANK LIMITED","ZILA SAHAKRI BANK LIMITED GHAZIABAD","ADITYA BIRLA IDEA PAYMENTS BANK","AHMEDABAD MERCANTILE COOPERATIVE BANK","AKOLA JANATA COMMERCIAL COOPERATIVE BANK","AMBARNATH JAIHIND COOP BANK LTD AMBARNATH","APNA SAHAKARI BANK LIMITED","AXIS BANK","BARCLAYS BANK","BASSEIN CATHOLIC COOPERATIVE BANK LIMITED","BHAGINI NIVEDITA SAHAKARI BANK LTD PUNE","CITI BANK","CATHOLIC SYRIAN BANK LIMITED","CITIZEN CREDIT COOPERATIVE BANK LIMITED","DMK JAOLI BANK","DHANALAKSHMI BANK","DOMBIVLI NAGARI SAHAKARI BANK LIMITED","DURGAPUR STEEL PEOPLES CO-OPERATIVE BANK LTD","EMIRATES NBD BANK P J S C","ESAF SMALL FINANCE BANK LIMITED","FINO PAYMENTS BANK","FEDERAL BANK","FINCARE SMALL FINANCE BANK LTD","FIRST ABU DHABI BANK PJSC","FIRSTRAND BANK LIMITED","G P PARSIK BANK","GS MAHANAGAR CO-OPERATIVE BANK LIMITED, MUMBAI","HDFC BANK","HARYANA STATE COOPERATIVE BANK","HIMACHAL PRADESH STATE COOPERATIVE BANK LTD","IDBI BANK","INDIA POST PAYMENT BANK","INDUSIND BANK","IRINJALAKUDA TOWN CO-OPERATIVE BANK LTD","JALGAON JANATA SAHAKARI BANK LIMITED","JAMMU AND KASHMIR BANK LIMITED","JANA SMALL FINANCE BANK LTD","JIO PAYMENTS BANK LIMITED","KALYAN JANATA SAHAKARI BANK","KARNATAKA BANK LIMITED","KARUR VYSYA BANK","KOTAK MAHINDRA BANK LIMITED","KOZHIKODE DISTRICT COOPERATIAVE BANK LTD","KRUNG THAI BANK PCL","LAXMI VILAS BANK","MUFG BANK, LTD","MAHARASHTRA STATE COOPERATIVE BANK","MAHESH SAHAKARI BANK LTD PUNE","NSDL PAYMENTS BANK LIMITED","NAGPUR NAGARIK SAHAKARI BANK LIMITED","NATIONAL BANK FOR AGRICULTURE AND RURAL DEVELOPMENT","NORTH EAST SMALL FINANCE BANK LIMITED","PAYTM PAYMENTS BANK LTD","QATAR NATIONAL BANK SAQ","RESERVE BANK OF INDIA , PAD","RESERVE BANK OF INDIA, PAD","RBI PAD, AHMEDABAD","RBL BANK LIMITED","RAJARAMBAPU SAHAKARI BANK LIMITED","RESERVE BANK OF INDIA","SBM BANK INDIA LIMITED","SHIKSHAK SAHAKARI BANK LIMITED","SHIVALIK MERCANTILE CO OPERATIVE BANK LTD","SHRI VEERSHAIV CO OP BANK LTD","SIR M VISVESVARAYA CO OPERATIVE BANK LTD","SMALL INDUSTRIES DEVELOPMENT BANK OF INDIA","SOUTH INDIAN BANK","SURYODAY SMALL FINANCE BANK LIMITED","TJSB SAHAKARI BANK LIMITED","TJSB SAHAKARI BANK LTD","TELANGANA STATE COOP APEX BANK","TEXTILE TRADERS CO OPERATIVE BANK LTD","THE A.P. MAHESH COOPERATIVE URBAN BANK LIMITED","THE ANDHRA PRADESH STATE COOPERATIVE BANK LIMITED","THE HASTI COOP BANK LTD","THE KANGRA CENTRAL COOPERATIVE BANK LIMITED","THE KANGRA COOPERATIVE BANK LIMITED","THE KARAD URBAN COOPERATIVE BANK LIMITED","THE KARANATAKA STATE COOPERATIVE APEX BANK LIMITED","THE NAINITAL BANK LIMITED","THE PANDHARPUR URBAN CO OP. BANK LTD. PANDHARPUR","THE RAJASTHAN STATE COOPERATIVE BANK LIMITED","THE SINDHUDURG DISTRICT CENTRAL COOP BANK LTD","THE SURAT DISTRICT COOPERATIVE BANK LIMITED","THE TAMIL NADU STATE APEX COOPERATIVE BANK","THE THANE BHARAT SAHAKARI BANK LIMITED","THE VISHWESHWAR SAHAKARI BANK LIMITED","THE WEST BENGAL STATE COOPERATIVE BANK","THRISSUR DISTRICT CO-OPERATIVE BANK LTD","TUMKUR GRAIN MERCHANTS COOPERATIVE BANK LIMITED","UJJIVAN SMALL FINANCE BANK LIMITED","UTKARSH SMALL FINANCE BANK","VASAI JANATA SAHAKARI BANK LTD","VASAI VIKAS SAHAKARI BANK LIMITED","VASAI VIKAS SAHAKARI BANK LTD","WOORI BANK","YES BANK","SYNDICATE  BANK","BHARATIYA MAHILA BANK","KARNATAKA BANK LTD.","HASSAN DCC BANK","Muktsar CCB","Odisha State Cooperative Bank Ltd"];
		for (s in banks) {
			$("#bank_name").append(
					"<option value='"+banks[s].toUpperCase()+"'>"
							+ banks[s].toUpperCase()
							+ "</option>");
//				console.log(responseText.district[s]);
		}
// 		//////alert("Onload called");
		fetchStates(); 
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		//////alert(urlParams);
		const page_type = urlParams.get('status');
// 		//////alert("page type is "+page_type);
// 		console.log(page_type);
		if (page_type == "done") {
			swal({
				title : "User ID created successfully",
				icon : "success",
				timer : "200000",
				buttons: {
				    create: "Create New User",
				    viewdata:"View Data",
				}
			}).then((value) => {
				  switch (value) {
				  
				    case "create":
				    	window.location.href = "/WeatherApi/app/NewUser.jsp";
				      break;
				   
				    case "viewdata":
				    	window.location.href = "/WeatherApi/editController?id=readonly&mobile1="+urlParams.get('mobile');
				    	break;
				  }
			});

		}
		else if (page_type == "invalid") {
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
		else if (page_type == "duplicate") {
			swal({
				title : "User with same Mobile Number already exists . Kindly change the Number and try again!",
				icon : "error",
				timer : "200000",
				buttons: {
				    create: "Create New User",
				    home_page: "Go to Home Page",
				}
			}).then((value) => {
				  switch (value) {
				  
				    case "create":
				    	window.location.href = "/WeatherApi/UserDetailsController";
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


	<!-- 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" -->
	<!-- 		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" -->
	<!-- 		crossorigin="anonymous"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

<script>
function checkMobile()
{
// 	alert("checkMobile called");
// 	document.getElementById("alertmobile").innerHTML='<img src="images/loading.gif" height="50" width="50">';
	var mobile=document.getElementById("m1").value;
	console.log(mobile);
	if(mobile=="")
		{
		document.getElementById("m1").value="";
		}
	else if(mobile.length!=10)
	 ValidateNo();
	else{
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
				document.getElementById("alertmobile").innerHTML="<span style='color: red;font-size:12px'>**UserId Already Exists!.</span>";
				}
			else
				{
				document.getElementById("alertmobile").innerHTML="<span style='color: green;font-size:12px'>**UserId is Available.</span>";
				}
		}
	
});
	}}
	function fetchStates() {
// 		//////alert("fetchStates called");

		$.ajax({
			url : '/WeatherApi/StateJSONController',
			success : function(responseText) {
// 				//////alert("function returned success");
// 				console.log(responseText.States);

// 				//////alert(responseText.States);
				for (s in responseText.States) {
					$("#state").append(
							"<option value='"+responseText.States[s]+"'>"
									+ responseText.States[s] + "</option>");
// 					console.log(responseText.States[s]);
				}
			}
		});

	}
	$("#state").change(
			function() {
// 				//////alert("fetchStates called");
				var selectedState = $(this).children("option:selected").val();
// 				//////alert(selectedState);
				$.ajax({
					url : '/WeatherApi/fetchDistrict',
					data:{state:selectedState},
					success : function(responseText) {
// 						//////alert("function returned success");
// 						console.log(responseText.States);

// 						//////alert(responseText.district);
							$("#district").empty();
							$("#subdistrict").empty();
						for (s in responseText.district) {
							$("#district").append(
									"<option value='"+responseText.district[s]+"'>"
											+ responseText.district[s]
											+ "</option>");
// 							console.log(responseText.district[s]);
						}
					}
				});
			});
	
	$("#district").change(
			function() {
// 				//////alert("fetchDistricts called");
				var selectedState = $("#state").children("option:selected").val();
				var selectedDistrict = $(this).children("option:selected").val();
// 				//////alert(selectedState);
// 				//////alert(selectedDistrict);
				$("#subdistrict").empty();
				$.ajax({
						url : '/WeatherApi/fetchSubDistricts',
						data:{state:selectedState,district:selectedDistrict},
						success : function(responseText) {
// 							//////alert("function returned success");
// 							console.log(responseText.States);
// 							//////alert(responseText.district); 
							for (s in responseText.district) {
								$("#subdistrict").append(
										"<option value='"+responseText.district[s].toUpperCase()+"'>"
												+ responseText.district[s].toUpperCase()
												+ "</option>");
// 								console.log(responseText.district[s]);
							}
						}
					});
			});
	function getBanks()
	{
		//alert("called");
		console.log("hello");
		$.ajax({
			url : '/WeatherApi/BankListController',
			success : function(responseText)
			{
				//alert("ajax called");
				console.log(responseText);
				var json=responseText;
				var j=JSON.parse(json);
				console.log(j.banklist);//why this is undefined
				for (s in j.banklist) 
				{
					$("#bank_name").append("<option value='"+j.banklist[s]+"'>"+ j.banklist[s]+ "</option>");
				}
				/*for (s in responseText.banklist) 
				{
					$("#bank_name").append("<option value='"+responseText.banklist[s].toUpperCase()+"'>"+ responseText.banklist[s].toUpperCase()+ "</option>");
				}*/
			}
		});
	}
	function checkIFSC()
	{
		//alert("checkIFSC called");
		var ifsc=document.getElementById("ifscno").value;//$("#ifscno").value;
// 		console.log(ifsc);
		 $('#branchspan').html('<img src="images/loading.gif" height="50" width="50">' );
		$.ajax({
			url : '/WeatherApi/IFSCController',
			data: {
				bank_ifsc:ifsc//ifsc:bank_ifsc//
				},
				success : function(responseText)
				{
					
// 					alert("values fetched");
// 					alert(responseText.bank);
// 					alert("reposnse terxt is "+responseText.bank[0]);
					if(responseText.bank!=null )//|| responseText.bank[0]!="NULL"
					{
// 						alert("detals found");
						document.getElementById("branchspan").innerHTML="<span style='color: green;font-size:12px'>**IFSC details populated !</span>";
						document.getElementById("branch").disabled=true;
						document.getElementById("bankstate").disabled=true;
						document.getElementById("addr").disabled=true;
						document.getElementById("bank_name").disabled=true;
						document.getElementById("branch").value = responseText.bank[1];
						document.getElementById("bankstate").value = responseText.bank[2];
						document.getElementById("addr").value = responseText.bank[3];
						document.getElementById("bank_name").value = responseText.bank[0];
// 						console.log("ohh");
						
					
					
						
					}
					else
					{
// 						alert("in else")
						document.getElementById("branchspan").innerHTML="<span style='color: red;font-size:12px'>**IFSC not Found!</span>";
						// 						console.log("hell");
					
					}
				}
		});
	}
</script>
</html>