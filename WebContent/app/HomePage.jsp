<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/mainSheet.css" type="text/css"/>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />
<script type="text/javascript" src="js/state.js"></script>
<script src="js/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/header_menu.css" type="text/css">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>


.form-control {
	font-size: 15px !important;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="br-space"></div>

	<div class="main-body-section">

		<form action="http://sewadrdmsfts01p.aicofindia.com:8081/weather"
			id="weather" method="get" enctype="multipart/form-data">
			<div class="heading">
				<h3 align="center">
					<b>Weather Data</b>
				</h3>
			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div id="grid_container">


				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 spacing_margin ">
					<label for="inputDefault">Status</label> <span 
						class="mandatoryfield" style="color: Red; font-size: 17px !important;">*</span> <br> <select
						onChange="changeListener(event,this.id)"
						class="form-control col-md-12 col-sm-12 col-xs-12" id="Status"
						name="Status" required aria-required="true">
						<option value="select" selected>--Select</option>
						<option value="Actual District">Actual District</option>
						<option value="Block Grided">Block Gridded</option>
						<option value="Min Temperature">Min Temperature</option>
						<option value="Max Temperature">Max Temperature</option>

					</select> <span id="sheet_error"></span>

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





				<!-- <div>
					<label for="inputDefault"><b>Status</b></label><br /> <select
						onChange="changeListener(event,this.id)" required
						aria-required="true" id="Status" name="Status">
						<option value="select" selected>--Select</option>
						<option value="Actual District">Actual District</option>
						<option value="Block Grided">Block Gridded</option>
					</select>
				</div>
				<div>
					<label for="inputDefault"><b>State</b></label><br /> <select
						id="State" name="State" required aria-required="true"
						onChange="changeListener(event,this.id)"><option
							value="select" selected>--Select--</option></select>

				</div>
				<div>
					<label for="inputDefault"><b>Start Date</b></label><br /> <input
						type="date" id="fdate" name="fdate"
						onChange="changeListener(event,this.id)" required></input>
				</div>
				<div>
					<label for="inputDefault"><b>End Date</b></label><br /> <input
						type="date" id="tdate" name="tdate"
						onChange="changeListener(event,this.id)" required></input>
				</div> -->

			</div>
			<!-- <br /> <br /> <br />
			<button type="submit" disabled class="btn btn-primary"
				id="submit_btn">Submit</button> -->

			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			
				<div class="submitbuttondiv">
				 <input type="submit" value="Submit"
						 class="mainsubmit" id="submit_btn" />
				
				</div>
			
		</form>
	</div>
</body>
<script>
	function changeListener(e, id) {
		switch (id) {
		case 'Status':
			statusChangeListener(event);
			valueTracker.statusIndex = e.target.selectedIndex;
			break;
		case 'State':
			valueTracker.stateIndex = e.target.selectedIndex;
			break;
		case 'fdate':
			valueTracker.startDate = e.target.value;
			break;
		case 'tdate':
			DateValidation();
			valueTracker.endDate = e.target.value;
			break;
		}
		checkEnableBtn();
	}

	let valueTracker = {
		statusIndex : 0,
		stateIndex : 0,
		startDate : "",
		endDate : ""
	};

	function checkEnableBtn() {
		if (valueTracker.statusIndex !== 0 && valueTracker.stateIndex !== 0
				&& valueTracker.startDate !== "" && valueTracker.endDate !== "") {
			document.getElementById("submit_btn").disabled = false;
		} else {
			document.getElementById("submit_btn").disabled = true;
		}
	}
</script>
<script type="text/javascript" src="js/state.js"></script>
</html>
