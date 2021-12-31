
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOS viewers</title>
<link rel="stylesheet" href="css/main-style.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="app/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/mainSheet.css"
	type="text/css" />
<script type="text/javascript"
	src="http://ajax.cdnjs.com/ajax/libs/json2/20110223/json2.js"></script>
<script type="text/javascript" src="app/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">

<script
	src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="app/js/sweetalert.min.js"></script>
<style>
.cellRed {
	color: red;
	font-weight: 500;
}

.cellGreen {
	color: green;
	font-weight: 500;
}

.custom-navbar {
	display: inline;
	width: 100%;
	background-color: #f8f9fa;
}

.custom-navbar-right, .custom-navbar-left li {
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
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="br-space"></div>


	<div class="main-body-section">

		<div>
			<h3 align="center" style="font: 25px Calibri !important;">
				<b>SOS</b>
			</h3>
		</div>
		<div class="br-space"></div>
		<div class="br-space"></div>
		<div class="br-space"></div>

		<div class="custom-navbar">
			<ul class="custom-navbar-left">
				<li><button id="all" class="btn btn-light">ALL</button></li>
				<li><button id="resolved" class="btn btn-light">RESOLVED</button></li>
			</ul>
			<ul class="custom-navbar-right">
				<li><button type="button" class="btn btn-success"
						id="resolve-button">RESOLVE</button></li>
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
						<th>ID</th>
						<th>Name</th>
						<th>Date & Time</th>
						<th>Location</th>
						<th>REF ID</th>
						<th>Phone No.</th>
						<th>Remarks</th>
						<th>Is crop healthy?</th><!-- flag1 -->
						<th>Is area sown normal?</th><!-- flag2 -->
						<th>Any pressure to change the yield?</th><!-- flag3 -->
						<th>State</th>
						<th>User Name</th>
						<th>RO Remark</th>
						
					</tr>
				</thead>
				<tbody id="sosTable" style="font-size: 16px; height: 50px;">
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="sos" items="${sos_details}">
					 	<tr class="rowview" onclick="rowclick(event,this)">
							<!--  <tr class="rowview">-->
							<td class="chkbx"></td>
							<td><c:out value="${sos.empID}" /></td>
							<td><c:out value="${sos.ename}" /></td>
							<td><c:out value="${sos.date}" /></td>
							<td><c:out value="${sos.loclatlong}" /></td>
							<td id="refid"><c:out value="${sos.refid}" /></td>
							<td><c:out value="${sos.contact}" /></td>
							<td><c:out value="${sos.remark}" /></td>
							<td><c:out value="${sos.flag1}" /></td>
							<td><c:out value="${sos.flag2}" /></td>
							<td><c:out value="${sos.flag3}" /></td>
							<td><c:out value="${sos.state}" /></td>
							<td><c:out value="${sos.username}" /></td>
							<td><input type="text" name="remark" id="remark"></td>
							<%-- <td><c:out value="${sos.RO_remark}" /></td> --%>
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
		$(function() {
			$(document)
				.ready(
					function() {
						var table = $('#mytableID')
							.DataTable(
								{													
									"dom" : '<"dt-buttons"Bf><"clear">lirtp',
									"paging" : true,
									"autoWidth" : true,
									"ordering" : false,
									"lengthMenu" : [[ 10, 25, 50, 100, -1 ], [ 10, 25, 50, 100, 'All' ] ],
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
								table.on('order.dt search.dt', function() {
									table.column(1, {
										search : 'applied',
										order : 'applied'
									}).nodes().each(function(cell, i) {
										cell.innerHTML = i + 1;
									});
								}).draw();
								$(".selectAll").on("click", function(e) {
									if ($(this).is(":checked")) {
										table.rows({
											page : 'current'
										}).select();
									} else {
										table.rows({
											page : 'current'
										}).deselect();
									}
								});
								$('#all').on('click', function() {
									table.columns(10).search("").draw();
								});

								$('#resolved').on(
									'click',
									function() {
									console.log("clicked");
									table.columns(10).search('^resolved$', true, false)
									.draw();
								});
								
								$('#resolve-button')
									.on(
										'click',
										function(e) {
											console.log("clicked resolve button");
										 	/* let rows = table.rows({
												selected : true
											}); 
											 */ 
											//var table = document.getElementById("sosTable");
											//console.log(table.querySelectorAll("tbody tr").length);
											
											//var refid = table.cells(rows.nodes(), 5).data().toArray();
											//var rows = $('tr.immediate');
											//var refid = table.rows('#refid')).data().toArray();
										 	var refid = table.column(5).data().toArray();
											alert(refid);
											alert(refid.length);
											//var remark = table.cells(rows.nodes(), 13).data().toArray();
											var remark = $('input[name^=remark]').map(function(idx,ele){
												return $(ele).val();
											}).get();
											
							                 //var remark[] = document.getElementsByName('remark');
											//console.log(refid);
											alert(remark.length);
											console.log(remark);
											e.preventDefault();
											//var map = {'refid' : refid, 'remark' : remark};
											
											//alert(refid);
											if (refid.length != 0) {
												//var status = "0";
												$.ajax({
													type : "POST",
													//contentType: "application/json; charset=utf-8",
													url : "/WeatherApi/SOSController",
													data : {
														'refid' : refid,
														'remark' : remark
														//result : JSON.stringify(map)
													},
													//dataType: 'json',
													success : function(r) {
														swal(
															"User's Status Successfully Resolved","","success");
															timer : "200000",
															location.reload(true);
													}
												});
											} else {
												swal(
													"No rows selected", "", "warning");
												}
										})
							});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$(".status").each(function() {
				var colText = $(this).text();
				if (colText == 'resolved') {
					$(this).addClass("cellGreen");
				} else {
					$(this).addClass("cellRed");
				}
			});
		});
		
/* 		function GetCellValues() {
			  var table = document.getElementById('refid');
			  for (var r = 0, n = table.rows.length; r < n; r++) {
			    for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
			      alert(table.rows[r].cells[c].innerHTML);
			    }
			  }
			}
		
		function rowclick(e, p) {
			if (e.target.cellIndex === 0) {
				return;
			} else {
			$(p).find(".refid")[0].click();
			}
		}; */
	</script>
	
</body>
</html>