<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body onload="fetchStates();">
	<label class="field" for="sel1">State <span
		style="color: red; font-size: large;">*</span></label>
	<select name="State" class="form-control" id="state" required>
		<option>State</option>

	</select>
	<select name="District" class="form-control" id="district" required>
		<option>District</option>

	</select>
	<select name="SubDistrict" class="form-control" id="subdistrict" required>
		<option>District</option>

	</select>
</body>
<script>
	function fetchStates() {
// 		alert("fetchStates called");

		$.ajax({
			url : '/WeatherApi/StateJSONController',
			success : function(responseText) {
// 				alert("function returned success");
// 				console.log(responseText.States);

// 				alert(responseText.States);
				for (s in responseText.States) {
					$("#state").append(
							"<option value='"+responseText.States[s]+"'>"
									+ responseText.States[s] + "</option>");
					console.log(responseText.States[s]);
				}
			}
		});

	}
	$("#state").change(
			function() {
// 				alert("fetchStates called");
				var selectedState = $(this).children("option:selected").val();
// 				alert(selectedState);
				$.ajax({
					url : '/WeatherApi/fetchDistrict',
					data:{state:selectedState},
					success : function(responseText) {
// 						alert("function returned success");
// 						console.log(responseText.States);

// 						alert(responseText.district);
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
// 				alert("fetchDistricts called");
				var selectedState = $("#state").children("option:selected").val();
				var selectedDistrict = $(this).children("option:selected").val();
// 				alert(selectedState);
// 				alert(selectedDistrict);
				$("#subdistrict").empty();
				$.ajax({
						url : '/WeatherApi/fetchSubDistricts',
						data:{state:selectedState,district:selectedDistrict},
						success : function(responseText) {
// 							alert("function returned success");
// 							console.log(responseText.States);
// 							alert(responseText.district); 
							for (s in responseText.district) {
								$("#subdistrict").append(
										"<option value='"+responseText.district[s]+"'>"
												+ responseText.district[s]
												+ "</option>");
// 								console.log(responseText.district[s]);
							}
						}
					});
			});
</script>
</html>