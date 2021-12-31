<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AIC Reports</title>
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

</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="br-space"></div>
<div class="main-body-section">
	<div class="subsection"  id="reporttype">	<div>
				<h3 >
					<b>REPORTS VIEWER<b></b>
				</h3>
			</div>
	  <div id="selectform">
					<label for="inputDefault"><b>SELECT REPORT TYPE</b></label> 
					 <select
						class="form-control col-md-12 col-sm-12 col-xs-12"
						aria-required="true" onChange="reportchoser(event,this.id)"
						id="reportname" name="reportname">
						<option value="select">--Select--</option>
						<option value="1"> Form-wise Details Report </option>
						<option value="2"> User-wise Forms Count </option>
						<option value="3"> User-wise Daily Forms Count(Attendance) </option>
					</select> 
				
	</div></div>
	
<div class="subsection" id="datareport">
		<form action="/WeatherApi/ReportController"
			id="reports" method="post" enctype="multipart/form-data" >
			<input type="hidden" name="reporttype" value="datareport" />
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">

               <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault"><b>State</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <select
						class="form-control col-md-12 col-sm-12 col-xs-12"
						aria-required="true" onChange="changeListener(event,this.id)"
						id="State1" name="State" required multiple>
						<option value="select">--Select--</option>
						<option value="all"> All </option>
					</select> <span id="state_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">FORM</label> <span 
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <select
						onChange="changeListener(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="formList"
						name="form" required aria-required="true"
						multiple>
						<option value="select" selected>--Select</option>
						

					</select> <span id="sheet_error"></span>

				</div>
				

				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>Start Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <input
						class="form-control" id="fdate" name="fdate"
						onChange="changeListener(event,this.id)" required color="white"
						placeholder="DD/MM/YYYY" type="date" /> <span id="fromDate_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>To Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <input
						class="form-control" id="tdate" name="tdate"
						onChange="changeListener(event,this.id)" required color="white"
						type="date" /> <span id="toDate_error"></span>
				</div>






			</div>
			<!-- <br /> <br /> <br />
			<button type="submit" disabled class="btn btn-primary"
				id="submit_btn">Submit</button> -->

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
		</form>
	
	</div>
	
	<div class="subsection" id="formcount">
		<form action="/WeatherApi/ReportController"
			id="reports1" method="post" enctype="multipart/form-data" >
			<input type="hidden" name="reporttype" value="countreport" />
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">

               <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault"><b>State</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <select
						class="form-control col-md-12 col-sm-12 col-xs-12"
						aria-required="true" onChange="changeListener1(event,this.id)"
						id="State2" name="State1" required >
						<option value="all"> All </option>
					</select> <span id="state_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">District</label>  <br> <select
						onChange="changeListener1(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="district" name="district1" >
						<option value="all" > All </option>
						

					</select> <span id="sheet_error"></span>

				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">User</label>  <br> <select
						onChange="changeListener1(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="user" name="user" required >
						<option value="all" > All </option>
						

					</select> <span id="sheet_error"></span>

				</div>

				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>Start Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <input
						class="form-control" id="fdate1" name="fdate"
						onChange="changeListener1(event,this.id)" required color="white"
						placeholder="DD/MM/YYYY" type="date" /> <span id="fromDate_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>To Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <input
						class="form-control" id="tdate1" name="tdate"
						onChange="DateValidation1()" required color="white"
						type="date" /> <span id="toDate_error"></span>
				</div>






			</div>
			<!-- <br /> <br /> <br />
			<button type="submit" disabled class="btn btn-primary"
				id="submit_btn">Submit</button> -->

			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="col-md-12">
				<div class="submitbuttondiv" >
					<span> <input type="submit" value="Submit"
						class="mainsubmit" id="submit_btn2" />
					</span>
				</div>
			</div>
		</form>
	</div>
	
	<!----------Daily Report------------------>
	<div class="subsection" id="dailyreport">
		<form action="/WeatherApi/ReportController"
			id="reports2" method="post" enctype="multipart/form-data" >
			<input type="hidden" name="reporttype" value="dailyreport" />
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">

               <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault"><b>State</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <select
						class="form-control col-md-12 col-sm-12 col-xs-12"
						aria-required="true" onChange="changeListener(event,this.id)"
						id="State3" name="State2" required>
						<option value="select">--Select--</option>
					</select> <span id="state_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>Start Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <input
						class="form-control" id="fdate2" name="fdate"
						onChange="changeListener(event,this.id)" required color="white"
						placeholder="DD/MM/YYYY" type="date" /> <span id="fromDate_error"></span>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<label for="inputDefault"><b>To Date</b></label> <span
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <input
						class="form-control" id="tdate2" name="tdate"
						onChange="DateValidation1()" required color="white"
						type="date" /> <span id="toDate_error"></span>
				</div>
			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="col-md-12">
				<div class="submitbuttondiv" >
					<span> <input type="submit" value="Submit"
						class="mainsubmit" id="submit_btn3" onClick="showAlert()"/>
					</span>
				</div>
			</div>
		</form>
	
	</div>
	</div>
	<div id="loader"> aisdjakljdlakasdkaklsdjkajsldjklasjdlkajsdljasldkj nksdlkhdhlqwuhgdqghdjkgbasjdbasd kajhsdkljahskdk jsd</div>
	<!--onclick="document.getElementById('loader').style.display = 'block';"-->
</body>


</html>