<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="app/css/header_menu.css" type="text/css">
<!-- <link rel="stylesheet" href="css/bootstrap.css" type="text/css"> -->
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
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery-1.12.4.js"></script> -->
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>






</head>
<body>
	
	<div id="topnav" >
        <img src="images/aic-logo1.png" alt="AIC logo"
				title="Agriculture Insurance Company">
		<a class="menuitem" href="/WeatherApi/app/HomePage.jsp">Weather Data</a>
		<a class="menuitem" href="/WeatherApi/app/ActiveUsers.jsp">Live Users Count</a>
		<a class="menuitem" href="/WeatherApi/app/reportsViewer.jsp">Reports</a>
		<a class="menuitem" href="/WeatherApi/ViewController">Existing Users</a>
		<a class="menuitem" href="/WeatherApi/SOSController">SOS</a>
		
		<div class="dropdown ">
			<button class="dropbtn" id="dmButton">
				CREATE USER <i class="fa fa-caret-down" style="margin-left: 3px;"></i>
			</button>
			<div class="dropdown-content">
				<a href="/WeatherApi/app/BulkUpload.jsp">Bulk User Upload</a> <br/>
				<a href="/WeatherApi/app/BulkDocument.jsp">Bulk Document Upload</a><br/>
				<a href="/WeatherApi/UserDetailsController">Single Form Upload</a>
			</div>
		</div>
		
		<div class="dropdown ">
			<button class="dropbtn" id="dmButton">
				RESET <i class="fa fa-caret-down" style="margin-left: 3px;"></i>
			</button>
			<div class="dropdown-content">
				<a href="/WeatherApi/app/ResetDeviceId.jsp">Reset Device ID</a> <br/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
				<a href="/WeatherApi/app/ResetPassword.jsp">Reset Password</a>
			</div>
		</div>
		
		<div class="dropdown ">
			<button class="dropbtn" id="dmButton">
				BSB Report <i class="fa fa-caret-down" style="margin-left: 3px;"></i>
			</button>
			<div class="dropdown-content">
				<a href="/WeatherApi/app/bsb_enrollment.jsp">Enrollment</a> <br/>
				<a href="/WeatherApi/app/BulkDocument.jsp"></a><br/>
				<!-- <a href="/WeatherApi/UserDetailsController">Single Form Upload</a> -->
			</div>
		</div>
		
		<div class="logout" align="right">
			<a id="userName">Hello, <c:out value="${sessionScope.username}" /></a>
			<a href="/WeatherApi/Logout"> <img src="${pageContext.request.contextPath}/images/logout.png" alt="logout"
				title="logout"> </a>
		</div>
	</div>



	<div class="container">

		<form id="user_modal">
			<div class="modal" id="myModal" data-backdrop="false">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

						<!-- Modal Header -->
						<div>
							<div>
								<h4 class="modal-title"
									style="float: left !important; font-weight: bold !important; font-size: 20px !important;">
									Active Users</h4>
							</div>
							<div>

								<button type="button" onClick="closeModal()"
									data-dismiss="modal" class="close">&times;</button>
							</div>
						</div>
						<div class="modal-header"></div>

						<!-- Modal body -->
						<div>


							<div class="br-space"></div>

							<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 "
								style="margin-right: 20px;">
								<label for="inputDefault">State</label> <span
									class="mandatoryfield"
									style="color: Red; font-size: 17px !important;">*</span> <select
									class="form-control " id="CountState" required
									name="CountState"
									style="width: auto !important; overflow: overflow-y !important; padding-right: 20px !important;">
									<option value="select" disabled selected>--Select--</option>


								</select> <span id="cState"></span>
							</div>

							<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"
								style="margin-left: 100px;">
								<label for="inputDefault"><b>Date</b></label> <span
									class="mandatoryfield"
									style="color: Red; font-size: 17px !important;">*</span> <input
									class="form-control " id="date" name="date" required
									style="width: auto !important;" color="white"
									placeholder="DD/MM/YYYY" type="date" /> <span id="cDate"></span>
							</div>

							<br /> <br />

							<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="CountDiv">
								<label for="inputDefault"><b>Total Count</b></label> <input
									class="form-control col-md-12 col-sm-12 col-xs-12"
									id="TotalCount" color="white" type="text" readonly
									style="width: auto !important" /> <span id="fromDate_error"></span>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="UserDiv">
								<label for="inputDefault"><b>Name</b></label>

								<textarea id="activeUser" maxlength="1000" class="form-control"
									readonly style="width: 500px; height: auto;">
					
						</textarea>
							</div>
							<div class="br-space"></div>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<div class="col-md-12">
								<div style="width: 18%; margin: auto; padding-top: 20px;">
									<span> <input type="submit" value="Submit"
										class="btn btn-primary "
										style="width: 9vw !important; height: 7vh !important; font-weight: bold !important; font-size: 15px !important;"
										id="submit" onClick="count()" />
									</span>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>
	</div>

</body>



<script>
	$(document).ready(function() {

		if ("${sessionScope.role}" != "admin") {
			$('#count').hide();
		}
		$('#userName').removeClass('active');
		jQuery(function($) {
			var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
			$('a').each(function() {
				if (path.includes(this.href)) {
					$(this).addClass('active');
					$('#userName').removeClass('active');
				}

			});
		});
	});
</script>
<script>
	var state = [ "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
			"Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana",
			"Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka",
			"Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya",
			"Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
			"Tamil Nadu", "Telangana", "Tripura", "Uttarakhand",
			"Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands",
			"Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu",
			"Lakshadweep", "Puducherry" ];
	$(document).ready(

			function() {
				if ("${sessionScope.role}" != "admin") {
					$('#myBtn').hide();
				}

				const queryString = window.location.href;
				const urlParams = new URLSearchParams(window.location.search);
				const status = urlParams.get('status');
				$('#UserDiv').hide();
				$('#CountDiv').hide();
				if (status == "error")
					swal("Ooops..", "No record found", "error")
				if (status == "Internalerror")
					swal("Error", "Internal Server Error", "error")

				let statearray = Object.values(state);
				//console.log(typeof(statearray));
				for (var i = 0; i < state.length; i++) {
					$("#State").append(
							"<option value='"+state[i]+"'>" + state[i]
									+ "</option>");
					$("#CountState").append(
							"<option value='"+state[i]+"'>" + state[i]
									+ "</option>");
				}

			});

	function count() {

		$.validator.addMethod("valueNotEquals", function(value, element, arg) {
			return arg !== value;
		}, "Please select the fields.")
		$('#user_modal').validate({
			// Specify validation rules
			rules : {
				// The key name on the left side is the name attribute
				// of an input field. Validation rules are defined
				// on the right side

				Countstate : {
					valueNotEquals : 'select'
				},
				date : {
					required : true
				}

			},
			messages : {
				CountState : {
					required : "Please select state."
				},
				date : {
					required : "Please select date."
				}

			},
			errorPlacement : function(error, element) {

				if (element.attr("name") == "CountState")
					error.appendTo('#cState');
				if (element.attr("name") == "date")
					error.appendTo('#cDate');
			},
			submitHandler : function() {
				submitData();
			}
		});
	}
	function submitData() {

		var loadingButton = "<button class='buttonload' id='submit' disabled><i class='fa spinner-border text-light' ></i>Loading</button>";
		var submitButton = "<input type='submit' value='Submit' class='btn btn-primary ' style='font-weight:bold !important; font-size: 15px !important; width:9vw !important; height:7vh !important;' id='submit' onClick='count()'  />";
		$('#submit').replaceWith(loadingButton);
		var countState = document.getElementById("CountState").value;
		var countDate = document.getElementById("date").value;

		var textArea = "<textarea id='activeUser' maxlength='1000' class='form-control' readonly style='width:500px; height:200px;'></textarea> ";

		$.ajax({
			url : '/WeatherApi/ExcelReader',
			type : 'get',
			data : {
				CountState : countState,
				CountDate : countDate
			},
			cache : false,
			success : function(data) {
				$('#CountDiv').show();
				if (data.length == 2) {
					$('#TotalCount').val("0");
					$('#UserDiv').hide();
				} else {
					$('#UserDiv').show();
					var name = ((data.replace("[", "")).replace("]", ""))
							.split(",");
					$('#activeUser').replaceWith(textArea);
					$('#TotalCount').val(name.length);
					for (n in name) {

						$('#activeUser').append(name[n]);
						if (n != (name.length - 1))
							$('#activeUser').append(", ");

					}

					$('#activeUser').each(function() {
						$(this).val($(this).val().trimStart());
					}

					);
				}
				$('#submit').replaceWith(submitButton);

			},
			error : function() {
				swal("Error", "Internal Server Error", "error")
			}
		});
	}
</script>

<script>
	function closeModal(form) {
		document.getElementById('user_modal').reset();
		$('#UserDiv').hide();
		$('#CountDiv').hide();
	}
	
	$(window).scroll(function(){
		var scroll=$(window).scrollTop();
	
		if(scroll>0)
			{
		
			$("#topnav").addClass("active1");
			}
		else
		{
			$("#topnav").removeClass("active1");
			}
	});
	
</script>
<script type="text/javascript" src="js/open_popup.js"></script>
</html>
