<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Active Users</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/mainSheet.css" type="text/css"/>
<link rel="stylesheet" href="css/header_menu.css" type="text/css">
<!--  <link rel="stylesheet" href="css/view_user.css" type="text/css">-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
  integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
  crossorigin="anonymous"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
  crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>



<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/main-style.css" type="text/css" />

<link rel="stylesheet" href="css/header_menu.css" type="text/css">
<!--   <link rel="stylesheet" href="css/view_user.css" type="text/css">-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
<script>
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
<script type="text/javascript" src="js/odometer.js"></script>
<link rel="stylesheet" href="css/odometer.css" type="text/css"/>
</head>
<style>
.tableFixHead {
	width: 200px;
	table-layout: fixed;
	border-collapse: collapse;
}

.tableFixHead tbody {
	display: block;
	width: 100%;
	overflow: auto;
	height: 350px;
}

.tableFixHead thead tr {
	display: block;
}

.tableFixHead th, .tableFixHead  td {
	padding: 5px 10px;
	width: 200px;
}

th {
	background: #ABDD93;
}

/*.row {
  margin-left:-5px;
  margin-right:-5px;
}
  
.column {
margin-top:20px;
  float: left;
  width: 50%;
  padding: 5px;
}*/

/* Clearfix (clear floats) */
/*.row::after {
  content: "";
  clear: both;
  display: table;
}*/
</style>
<body >
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="br-space"></div>
	<div class="main-body-section">

		<div class="container mt-7 rounded"
			style="background-color: white; max-width: 1200px;">
			

			<h1 align="center">Active User Count</h1>

			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="row">
				<div class="col-6">
					<h4 align="center" style="font: 20px Calibri !important;">
						<b>Total Active Users : <span id="count" class="odometer"></span></b>
					</h4>
				</div>
				<div class="col-6">
					<h4 align="center" style="font: 20px Calibri !important;">
						<b>Total Forms : <span id="formcount" class="odometer"></span></b>
					</h4>
				</div>
			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="row">

				<div
					class="col-6 tableFixHead d-flex align-items-center jusify-content-center">

					<table id="mytableID"
						style="width: 70%; margin-left: 100px; font-size: 15px; padding: 10px;"
						class="table table-striped">
						<thead>
							<tr>
								<th style="font-size: 15px;">State</th>
								<th style="font-size: 15px;">Active Users</th>
							</tr>
						</thead>
						<tbody id="viewTable">
						</tbody>
					</table>
				</div>
				<div class="col-6 ">

					<table id="mytableID"
						style="width: 70%; margin-left: 100px; font-size: 15px"
						class="table table-striped">
						<thead>
							<tr
								style="background-color: rgba(180, 148, 84, 0.459); font-family: Arial, Helvetica, sans-serif; color: black;">
								<th style="font-size: 15px;">FormName</th>
								<th style="font-size: 15px;">Count</th>
							</tr>
						</thead>
						<tbody id="viewTable2">
						</tbody>
					</table>
				</div>
			</div>
			<div class="br-space"></div>
			<div class="br-space"></div>
			<div class="br-space"></div>

		</div>



	</div>


	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>

	<script src="jquery.counterup.min.js"></script>
	<script type="text/javascript">
$(document).ready(function() {
function countuser()
			{
			$.ajax({
			    url: '/WeatherApi/LiveUsersController',
			    success: function (responseText) {
			    	console.log(responseText.count);
			    	$("#count").html(responseText.count);
			    	(function(e){"use strict";e.fn.counterUp=function(t){var n=e.extend({time:10000,delay:100},t);return this.each(function(){var t=e(this),r=n,i=function(){var e=[],n=r.time/r.delay,i=t.text(),s=/[0-9]+,[0-9]+/.test(i);i=i.replace(/,/g,"");var o=/^[0-9]+$/.test(i),u=/^[0-9]+\.[0-9]+$/.test(i),a=u?(i.split(".")[1]||[]).length:0;for(var f=n;f>=1;f--){var l=parseInt(i/n*f);u&&(l=parseFloat(i/n*f).toFixed(a));if(s)while(/(\d+)(\d{3})/.test(l.toString()))l=l.toString().replace(/(\d+)(\d{3})/,"$1,$2");e.unshift(l)}t.data("counterup-nums",e);t.text("0");var c=function(){t.text(t.data("counterup-nums").shift());if(t.data("counterup-nums").length)setTimeout(t.data("counterup-func"),r.delay);else{delete t.data("counterup-nums");t.data("counterup-nums",null);t.data("counterup-func",null)}};t.data("counterup-func",c);setTimeout(t.data("counterup-func"),r.delay)};t.waypoint(i,{offset:"100%",triggerOnce:!0})})}})(jQuery);
			    	 
			          jQuery(responseText.count).ready(function()
			                 {//'.counter'
			                     $("#count").counterUp({
			                     delay: 200,
			                     time: 6000
			                 });
			                 });    	             },
		      		
			   });
			};
			setTimeout(countuser, 0);
			setInterval(countuser, 10000);
			
			
			function countuserbystate()
			{
			$.ajax({
				url : '/WeatherApi/LiveUsersStateController',
				success : function(responseText) {
					    console.log("countusersState() called");
					    $("#viewTable").children().remove();
						

					for (s in responseText.State) {
						$("#viewTable").append("<tr><td>" +responseText.State[s]+ "</td> <td>" +responseText.Count[s]+ "</td></tr>");
								
					}
				}
			});
			};
			setTimeout(countuserbystate, 0);
			setInterval(countuserbystate, 10000);
			
			
			function formcountuser()
			{
			$.ajax({
			    url: '/WeatherApi/LiveTotalFormCountController',
			    success: function (responseText) {
			    	console.log(responseText.formcount);
			    	$("#formcount").html(responseText.formcount);
			    	(function(e){"use strict";e.fn.counterUp=function(t){var n=e.extend({time:10000,delay:100},t);return this.each(function(){var t=e(this),r=n,i=function(){var e=[],n=r.time/r.delay,i=t.text(),s=/[0-9]+,[0-9]+/.test(i);i=i.replace(/,/g,"");var o=/^[0-9]+$/.test(i),u=/^[0-9]+\.[0-9]+$/.test(i),a=u?(i.split(".")[1]||[]).length:0;for(var f=n;f>=1;f--){var l=parseInt(i/n*f);u&&(l=parseFloat(i/n*f).toFixed(a));if(s)while(/(\d+)(\d{3})/.test(l.toString()))l=l.toString().replace(/(\d+)(\d{3})/,"$1,$2");e.unshift(l)}t.data("counterup-nums",e);t.text("0");var c=function(){t.text(t.data("counterup-nums").shift());if(t.data("counterup-nums").length)setTimeout(t.data("counterup-func"),r.delay);else{delete t.data("counterup-nums");t.data("counterup-nums",null);t.data("counterup-func",null)}};t.data("counterup-func",c);setTimeout(t.data("counterup-func"),r.delay)};t.waypoint(i,{offset:"100%",triggerOnce:!0})})}})(jQuery);
			    	 
			          jQuery(responseText.count).ready(function()
			                 {//'.counter'
			                     $("#formcount").counterUp({
			                     delay: 200,
			                     time: 6000
			                 });
			                 });   	     
			          },
		      		
			   });
			};
			setTimeout(formcountuser, 0);
			setInterval(formcountuser, 10000);
			
			
			function countuserbyform()
			{
			$.ajax({
				url : '/WeatherApi/LiveUsersFormController',
				success : function(responseText) {
					    console.log(responseText.Form);
					    console.log(responseText.Count);
					    $("#viewTable2").children().remove();
						

					for (s in responseText.Form) {
						$("#viewTable2").append("<tr><td>" +responseText.Form[s]+ "</td> <td>" +responseText.Count[s]+ "</td></tr>");
								
					}
				}
			});
			};
			setTimeout(countuserbyform, 0);
			setInterval(countuserbyform, 10000);
			
});

	

</script>
</body>
</html>