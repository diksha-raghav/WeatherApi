<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BSB Report - Enrollment</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/mainSheet.css" type="text/css"/>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />
 
<script src="js/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/header_menu.css" type="text/css">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/reportstyle.css" type="text/css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script	
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/forms.js"></script>
<script type="text/javascript" src="js/state_district.js"></script>
</head>

<style>
	#bsbreport
{
text-align: center;
padding-bottom:30px;
}
</style>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="br-space"></div>
<div class="main-body-section">
	<div>
				<h3 align="center" style="font: 25px Calibri !important;">
					<b>BSB Report Enrollment</b>
				</h3>
			</div>

			<hr>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">

				<br>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">Season</label> <span 
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <select
						onChange="changeListener(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="Status"
						name="season" required aria-required="true">
						<option value="select" selected>--Select</option>
						<option value="Rabi">Rabi</option>
						<option value="Kharif">Kharif</option>
						
					</select> <span id="season_error"></span>

				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault"><b>State</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <select
						class="form-control col-md-12 col-sm-12 col-xs-12"
						aria-required="true" onChange="changeListener(event,this.id)"
						id="State" name="State" required>
						<option value="select">--Select--</option>
					</select> <span id="state_error"></span>
				</div>

				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">District</label>  <br> <select
						onChange="changeListener1(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="district" name="district" >
						<option value="all" > All </option>
						

					</select> <span id="sheet_error"></span>
					</div>
					</div>
					
					<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="col-md-12">
				<div class="submitbuttondiv" >
					<span> <input type="submit" value="Submit"
						class="mainsubmit" id="submit_btn1" onClick="showAlert()"/>
					</span>
				</div>
			</div>
		
	


				<!-- <div id="loader"></div> -->
				
</body>
</html>