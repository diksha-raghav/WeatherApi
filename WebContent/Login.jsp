<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" >
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap-multiselect.css"	type="text/css" >
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/captcha.js"></script>
<script type="text/javascript" src="js/validation_password.js"></script>
<script type="text/javascript" src="js/rememberme.js"></script>
<script src="js/sweetalert.min.js"></script>
</head>
<body>

<div id="mainbody">
<div id="maincard">
<div id="innerbody1" >

		<div class="aiclogo" align="center">
			<a href="#"><img src="images/AIClogo.png" alt="AIC Logo"
				title="Agriculture Insurance Company"></a>
			
			<h3>Welcome</h3>
			
			<p>To request an account kindly contact Admin-HO</p>
			
			<div class="contact"> <i class="fa fa-envelope icon" style="margin-left: 0px;" aria-hidden="true"></i> HO-R&Dgroup@aicofindia.com</div>
		
		<div class="contact"> <i class="fa fa-phone icon" style="margin-top: 0px;" aria-hidden="true"></i> 011 - 24600580</div>
		</div>
	
</div>
<div id="innerbody2" >

	
		<br>
		<div class="container1">
	<div class="container2">
	<h1>Login</h1>
	<p>Please sign in to continue</p>  
		
					<div class="loginformcontainer">
						<form name="LoginForm" id="LoginForm" class="loginform"
							method="post" action="Login">

							<div class="inputs">
								
							
							      <i class="fa fa-user icon" style="margin-left: 3px;" aria-hidden="true"></i>
									<input type="text" name="username"
										placeholder="Enter Username" required value="">
								
							</div>
							<br>
							<!--Add <br> for spacing  -->
							<div class="inputs">
								    <i class="fa fa-key icon" style="margin-left: 3px;" aria-hidden="true"></i>
									<input type="password"  maxlength="20" value=""
										placeholder="Enter password" id="password" name="password" value="Aicnet@570" required>
								</div>	<div id="show"><div class="squaredOne"><input type="checkbox" onclick="myFunction()" id="squaredOne" ><label for="squaredOne"></label> </div><p>Show
									Password </p></div>
								
							
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="br-space"></div>
							<div class="col-md-3"></div>
							<input type="submit" id="login" value="Login">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
<script>
	$(document).ready(function() {

		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		const page_type = urlParams.get('status');
		console.log(page_type);
		if (page_type == "invalid") {
			swal({
				title : "Oops...",
				text : "Invalid username or password",
				icon : "error",
				timer : "200000",
				Button : "Close",
				closeModal : "true",
			}).then(function() {
				window.location.href = "/WeatherApi/Login.jsp";
			});

		}
	})
</script>
</html>