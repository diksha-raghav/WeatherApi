<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Data</title>
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="app/css/jquery.dataTables.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/mainSheet.css" type="text/css"/> 
    <script type="text/javascript" src="http://ajax.cdnjs.com/ajax/libs/json2/20110223/json2.js"></script>
<script type="text/javascript" src="app/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">

<script
	src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="app/js/sweetalert.min.js"></script>
<style>
.cellRed{
	color: red;
	font-weight: 500;
	
}
.cellGreen{
	color:green;
	font-weight: 500;
}

.custom-navbar{
	display: inline;
	width: 100%;
	background-color: #f8f9fa;
}
.custom-navbar-right,.custom-navbar-left li{
  list-style-type: none;
  margin: 0;
  padding: 10px 0px;
  overflow: hidden;
  background-color: #f8f9fa;
}

.custom-navbar-left li {
  display: inline;
  float: left;
}
.custom-navbar-right li {
  float: right;
}

.custom-navbar button {
 	text-align: center;
	text-decoration: none;
	color: black;
	text-transform: capitalize;
	font-size: 18px;
	font-weight: 500;
	padding: 10px 0px;
	width: 100px;
	border-radius: 6px;
	overflow: hidden;
	cursor: pointer;
	outline: none;
	transition: 0.2s all;
	margin-right: 5px;
	
	
/* 	box-shadow: 7px 6px 28px 1px rgba(0, 0, 0, 0.24); */
}

/* .custom-navbar-left button{ */
/* 	background-color: #808080; */
/* } */

.custom-menu li button:hover {
  background-color: #111;
}
</style>
</head>
<body >
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="br-space"></div>
	<div class="main-body-section">

		<div>
			<h3 align="center" style="font: 25px Calibri !important;">
				<b>View Users</b>
			</h3>
		</div>
		<div class="br-space"></div>
		<div class="br-space"></div>
		<div class="br-space"></div>
		
		<div class="custom-navbar">
			<ul class="custom-navbar-left">
				<li><button id="all" class="btn btn-light">ALL</button></li>
  				<li><button id="activated" class="btn btn-light">ACTIVE USERS</button></li>
  				<li><button id="deactivated" class="btn btn-light">INACTIVE USERS</button></li>
  				
  			</ul>
  			<ul class="custom-navbar-right">
  				<li><button type="button" class="btn btn-danger" id="deactivate-button">DEACTIVATE</button></li>
				<li><button type="button" class="btn btn-success" id="activate-button">ACTIVATE</button></li>
			</ul>
		</div>
		<div class="br-space"></div>
		<div class="br-space"></div>
		
		<div class="table-responsive">
			<table id="mytableID" style="width:"
				class="table table-hover table-striped table-bordered display">
				<thead
					style="background-color: #16a085; color: white; font-size: 18px; font-weight: 500;">
					<tr id="header">
						<th><input type="checkbox" class="selectAll" name="selectAll" value="all"></th>
						<th>SNo.</th>
						<th>Mobile No</th>
						<th>Username</th>
						<th>Designation</th>
						<th>Email</th>
<!-- 						<th>Gender</th> -->
						<th>State</th>
						<th>District</th>
						<th>Document</th>
						<th>Action</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody id="viewTable" style="font-size: 16px; height: 50px;">
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="user" items="${listUser }">
						<c:set var="count" value="${count+1}" scope="page" />
						<tr class="rowview" onclick="rowclick(event,this)">
							<td class="chkbx"></td>
							<td><c:out value="${count}" /></td>
							<a title="View Data" class="mobile"
								href="/WeatherApi/editController?id=readonly&mobile1=<c:out value='${user.mobile1}'/>"><td><c:out
										value="${user.mobile1}" /></td></a>
							<td><c:out value="${user.user}" /></td>
							<td><c:out value="${user.designation}" /></td>
							<td><c:out value="${user.email}" /></td>
<%-- 							<td><c:out value="${user.gender}" /></td> --%>
							<td><c:out value="${user.state}" /></td>
							<td><c:out value="${user.district}" /></td>
							<td><a href="/WeatherApi/FileDownload?mobile1=<c:out value='${user.mobile1}'/>">Download</a></td>
							<%-- 						<c:out value='${user.photo_card}'/></a></td> --%>
							<td><a href="/WeatherApi/editController?mobile1=<c:out value='${user.mobile1}' />" class="edituser">Edit</a></td>
							<td class="status"><c:out value="${user.status}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="br-space"></div>
	<div class="br-space"></div>
	<div class="br-space"></div>
	<div class="br-space"></div>
	<div class="br-space"></div>
	<div class="br-space"></div>
	<script>
		/*$(document).ready(function() {
			console.log("entered");
			var stat = document.getElementsByClassName("status");
			//	var stat2 = document.getElementsByClassName("statusbutton2");
			//	var x = document.getElementById("myTableID").rows.length;
			var n = ${totaluser}
			console.log(n);
			for (var i = 0; i <= n; i++) {
				console.log(stat[i].innerText);
				if (stat[i].innerText == "1") {
					stat[i].innerText = 'Active';
					//stat2[i].textContent = 'Activate';
				} else {
					stat[i].innerText = 'Inactive';
					//stat2[i].textContent = 'Deactivate';
				}

			}

		});*/
	</script>
	
	<script>
		$(function() {
			$(document).ready(function() {
						var table = $('#mytableID').DataTable({
									"dom" : '<"dt-buttons"Bf><"clear">lirtp',
									"paging" : true,
									"autoWidth" : true,
									"ordering" : false,
									"lengthMenu" : [ [ 10, 25, 50, 100, -1 ],
											[ 10, 25, 50, 100, 'All' ] ],
									columnDefs : [ {
										orderable : false,
										className : 'select-checkbox',
										targets : 0
									} ],
									select : {
										style : 'multi',
										selector : 'td:first-child'
									},
									order : [ [ 1, 'asc' ] ]
								});
						table.on( 'order.dt search.dt', function () {
					        table.column(1, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
					            cell.innerHTML = i+1;
					        } );
					    } ).draw();
						$(".selectAll").on( "click", function(e) {
						    if ($(this).is( ":checked" )) {
						        table.rows({ page: 'current' }).select();        
						    } else {
						        table.rows({ page: 'current' }).deselect(); 
						    }
						});
						$('#all').on('click', function () {
						    table.columns(10).search("").draw();
						});

						$('#activated').on('click', function () {
							console.log("clicked");
						    table.columns(10).search('^Active$',true,false).draw();
						});
						$('#deactivated').on('click', function () {
							console.log("clicked");
						    table.columns(10).search("Inactive").draw();
						});
						$('#activate-button').on('click', function(e) {
							let rows = table.rows({
								selected : true
							});
							var result = table.cells(rows.nodes(), 2).data().toArray();
							console.log(result);
							//alert(result);
								if(result.length!=0){
									var status = "0";
									  $.ajax({
							                type: "POST",
							                url: "/WeatherApi/statusChangeController",
							                data: {'result':result,status:status},
							                success: function (r) {
							                	swal("User Successfully Activated", "", "success");
							                    location.reload(true);
							                }
							            });
								}else{
									swal("No rows selected", "", "warning");
								}
						})
						$('#deactivate-button').on('click', function(e) {
							let rows = table.rows({
								selected : true
							});
							var result = table.cells(rows.nodes(), 2).data().toArray();
							//alert(result);
							console.log(result);
							if(result.length!=0){
								var status = "1";
								  $.ajax({
						                type: "POST",
						                url: "/WeatherApi/statusChangeController",
						                data: {'result':result,status:status},
						                success: function (r) {
						                	swal("User Successfully Deactivated", "", "success");
						                    location.reload(true);
						                }
						            });
							}else{
								swal("No rows selected", "", "warning");
							}
							
						})
					});
		});
	</script>
	<script type="text/javascript">
	$(function() {
		$(".status").each(function() {
			var colText = $(this).text();
			if (colText == 'Active') {
				$(this).addClass("cellGreen");
			}
			else {
				$(this).addClass("cellRed");
			}
		});
	});
	function rowclick(e,p) {
		if(e.target.cellIndex===0)
			{
			return;
			}
		else
			{
			$(p).find(".mobile")[0].click();
			}
		
	};
</script>
	
</body>
</html>