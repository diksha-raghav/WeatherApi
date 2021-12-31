<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DM App</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>

<script type="text/javascript" src="js/popper.min.js"></script>
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
<body style="background-color: #ebebeb !important;">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="br-space"></div>
	<div class="main-body-section">
		<form action="" method="post" name="dmApp" id="dmApp">
			<div class="br-space"></div>
			<div class="br-space"></div>
			<h3 align="center" style="font: 25px Calibri !important;">
				<b>DMApp Report Generation</b>
			</h3>

			<div class="br-space"></div>
			<!-- <button type="button" id="myBtn" class="btn btn-primary attach prent"
				data-toggle="modal" data-target="#myModal"
				style="margin-left: 10px;">Live User</button> -->
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">Form</label> <span class="mandatoryfield"
						style="color: Red; font-size: 17px !important;">*</span> <br>
					<select class="form-control col-md-12 col-sm-12 col-xs-12"
						id="sheet" name="sheet" required>
						<option value="select" selected>--Select--</option>
						<option value="All">All</option>
						<c:forEach items="${SheetList }" var="list">
							<option value="${list}">${list}</option>
						</c:forEach>
					</select> <span id="sheet_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault"><b>State</b></label> <span
						class="mandatoryfield"
						style="color: Red; font-size: 17px !important;">*</span> <select
						class="form-control col-md-12 col-sm-12 col-xs-12" id="inputState" onChange="renderDistrict()"
						name="State" required>
						<option value="select">--Select--</option>
						

					</select> <span id="state_error"></span>
				</div>
				
				  <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
				    <label for="inputDistrict">District</label>
				     <span class="mandatoryfield"
						style="color: Red; font-size: 17px !important;">*</span>
				    <select class="form-control col-md-12 col-sm-12 col-xs-12" name="District" id="inputDistrict">
				        <option value="select">--Select--</option>
				    </select>
				    <span id="district_error"></span>
  				</div>
  				<br><br><br>
  				<div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>From Date</b></label> <span
						class="mandatoryfield"
						style="color: Red; font-size: 17px !important;">*</span> <input
						class="form-control" id="fdate" name="from_date" color="white"
						placeholder="DD/MM/YYYY" type="date" /> 
						<span id="fromDate_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>To Date</b></label> <span
						class="mandatoryfield"
						style="color: Red; font-size: 17px !important;">*</span> <br>
					<input class="form-control" id="tdate" name="to_date"
						onChange="DateValidation()" onfocus="(this.type='date')"
						color="white" type="date" /> <span id="toDate_error"></span>
				</div>
				</div>
			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="col-md-12">
				<div style="width: 18%; margin: auto; padding-top: 20px;">
					<span> <input type="submit" value="Submit"
						class="btn btn-primary " id="submit_btn" />
					</span>
				</div>
			</div>

		</form>

	</div>


</body>

<script>
	$(document).ready(function() {

		$.validator.addMethod("valueNotEquals", function(value, element, arg) {
			return arg !== value;
		}, "Please select the fields.")
		$('#dmApp').validate({
			// Specify validation rules
			rules : {
				// The key name on the left side is the name attribute
				// of an input field. Validation rules are defined
				// on the right side

				sheet : {
					valueNotEquals : "select"
				},
				State : {
					valueNotEquals : "select"
				},
				District : {
					valueNotEquals : "select"
				},
				from_date : {
					required : true
				},
				to_date : {
					required : true
				}

			},
			messages : {

				sheet : {
				// required: "Please select atleast one form."
				},
				State : {
				//  required: "Please select atleast one state."
				},
				from_date : {
					required : "Please select from date."
				},
				to_date : {
					required : "Please select to date."
				}

			},
			errorPlacement : function(error, element) {

				if (element.attr("name") == "sheet")
					error.appendTo('#sheet_error');
				if (element.attr("name") == "State")
					error.appendTo('#state_error');
				if (element.attr("name") == "District")
					error.appendTo('#district_error');
				if (element.attr("name") == "from_date")
					error.appendTo('#fromDate_error');
				if (element.attr("name") == "to_date")
					error.appendTo('#toDate_error');

			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
<script>
	var state = [ "Andhra Pradesh", "Arunachal Pradesh", "Assam",
			"Bihar", "Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana",
			"Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka",
			"Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya",
			"Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
			"Tamil Nadu", "Telangana", "Tripura", "Uttarakhand",
			"Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands",
			"Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu",
			"Lakshadweep", "Puducherry" ];

		
	$(document).ready(
		
			function() {
				   
			   	var states=new Array();
				<c:forEach var="stateDistrict" items="${StateDistrictList}">
					s="${stateDistrict}".split("=");
					states.push(s[0]);
				</c:forEach>
				states=states.sort();
				
				const queryString = window.location.href;
				const urlParams = new URLSearchParams(window.location.search);
				const status = urlParams.get('status');
				if (status == "error")
					swal("Ooops..", "No record found", "error");
				if (status == "Internalerror")
					swal("Error", "Internal Server Error", "error");

				if ("${sessionScope.role}"=="admin") {
					
					$("#inputState").append("<option value='All'>All</option>");
					for(s in states)
						{
							$("#inputState").append(
								"<option value='"+states[s]+"'>"+states[s]+"</option>");	
								
						}
				}
				else
				{
					var flag=0;
					
						for (var i = 0; i < states.length; i++) {
							if("${StateList}".includes(states[i].toUpperCase()))
							{
								flag=1;
								$("#inputState").append(
										"<option value='"+states[i]+"'>" + states[i]
												+ "</option>");
							}
						}
						if(flag===0)
							{
								$("#inputState").append("<option value=''selected>No data available</option>");
								$("#inputDistrict").append("<option value=''selected>No data available</option>");
								$('#inputState').prop("disabled",true);
								$('#inputDistrict').prop("disabled",true);
							}
				}

			});
</script>
<script>
function renderDistrict()
{
	var index=document.getElementById("inputState");
	var state=index.options[index.selectedIndex].value;
	document.getElementById("inputDistrict").innerHTML="";
	 if(state=="All"){
		  	$('#inputDistrict').prop("disabled", true);
		  	$("#inputDistrict").append("<option value=''selected>All</option>");
		  }
	 else
		 {
			$('#inputDistrict').prop("disabled", false);
			if(state!=="select"&&"${StateDistrictList}".includes(state.toUpperCase()))
			{
				
				<c:forEach var="stateDistrict" items="${StateDistrictList}">
					s="${stateDistrict}".split("=");
					if(s[0]===state.toUpperCase())
						{
							district=s[1];
							districtArray=((district.replace("[","")).replace("]","")).split(", ");
						}
						
				</c:forEach>
				
				districtArray=districtArray.sort();
				$("#inputDistrict").append("<option value='All'>All</option>");
				for(d in districtArray)
				{
					$("#inputDistrict").append(
						"<option value='"+districtArray[d]+"'>"+districtArray[d]+"</option>");	
						
				}
			}
		else
			{
				$("#inputDistrict").append(
					"<option value='select' selected>--Select--</option>");	
			}
		 
		 
		 }

		
	
}

</script>


 <!-- <script type="text/javascript" src="js/state_district.js"></script>  -->
<script type="text/javascript" src="js/open_popup.js"></script>

</html>