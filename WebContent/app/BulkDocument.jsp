<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

  <head>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--  CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/mainSheet.css" type="text/css"/> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <!--   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> -->
    <!--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  -->
      
    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>  -->
    
   <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<!-- <link rel="stylesheet" href="css/homePage.css" type="text/css"> -->
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
   
<title>Bulk Document Upload</title>
<style>
    
</style>
</head>
  <body>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<div class="main-body-section" >
      
      <center><h2 style="margin-bottom: 80px; margin-top: 30px; "><b>Bulk Document Upload</b></h2></center>
      <center><h3>Document Format: mobile_pan/aadhar/passport.pdf</h3></center>
    
         
                <div class="col d-flex justify-content-center align-items-center" >
                
                  <div class=" col d-flex justify-content-left align-items-left" style="align-items: left; justify-content: left;">
                 <!--  <a href="#" style="image-orientation:center">-->
                <!--     <span id="msg" style='color: black;font-size:12px'>File Format<br /></span>-->
                        
                      <br><br>
                    <img src="images/img.jpg" style="height: 100px;width: 100px;margin-left:80px;">
                  
                     <br>
                    <!--  <IMG SRC="images\image.png" style="height: 100px;width: 100px;margin-left:100px;" >-->
                 
                    <br>
                 
                   <!--  <label class="h5 border border-dark rounded" style="font-size: 15px !important;"><div style="padding: 5px;">FILE TYPE FOR PAN/AADHAR/PASSPORT</div></label>
                 <!-- </a>-->
                  
                  
                </div>
                
                    <div class=" " style="align-items: center; justify-content: center;">
                       
                    <form method="post" action="/WeatherApi/DocumentUploadController" id="form2"  enctype = "multipart/form-data" ><!-- onclick="disp()" -->
                     
                          <center>  <br><input style="font-size: 15px !important;" type="file" id="docfileupload" name="fileUploader" accept="application/pdf,image/png,image/jpeg,image/jpg" multiple required /> </center>  <!-- onchange="javascript:updateList()" --> 
                        	
                       	
                       <br>
                     <center><input type="submit" name="Submit" onclick="show()" class="mainsubmit"/></center>
                     
                      
                     <!-- <span id="message"></span>-->
                        </form>
                    </div>
                   <div class=" col d-flex justify-content-right align-items-right" style="align-items: right; justify-content: right;">
             <!--      <span id="msg" style='color: black;font-size:12px;font-weight:bold'>Document Format: mobilenumber_pan/aadhar/passport.pdf<br />
                        <br /><span id="msg" style='color: black;font-size:12px;font-weight:bold'>Photo Format : mobilenumber_photo<br /><br />-->
                      
                  <br /><span id="msg" style='color: green;font-size:12px;font-weight:bold' class="q-span"><c:out value="${successful}"/><span id="msg" style='color: green;font-size:12px;font-weight:bold' class="q-span"> <c:out value="${inserted}" />
                <br /><br />
              
                    <span id="msg1" style='color: red;font-size:12px;font-weight:bold' class="q-span"><c:out value="${unsuccessful}"/><span id="msg" style='color: red;font-size:12px;font-weight:bold' class="q-span"><c:out value="${failed}" />
                        <br />
                       <br /> <!--  <span id="msg1" style='color: red;font-size:12px;font-weight:bold' class="q-span">
                        <c:out value="${errorfiles}"/><span style='color: black;font-size:12px' class="q-span"><c:out value="${files_failed}" />-->
                    </span>
                  
                  
                </div> 
                </div>
               <div align="center"> 
               <br><br>
                 <span id="msg" style='color: green;font-size:12px;font-weight:bold' class="q-span">
                
              
                    <span id="msg1" style='color: red;font-size:12px;font-weight:bold' class="q-span">
                        <c:out value="${errorfiles}"/><span style='color: black;font-size:12px' class="q-span"><c:out value="${files_failed}" /></span>
                       </div>
              </div>
            
              
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
             <script>
             function show()
             {
            	 document.getElementById("msg").disabled=false;
            	 document.getElementById("msg1").disabled=false;
            	 document.getElementById("msg2").disabled=false;
             }
             </script>
              

</body>
</html>