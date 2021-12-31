<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--  CSS -->
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <!--   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> -->
    <!--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  -->
      
    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>  -->
    
   <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/mainSheet.css" type="text/css"/>
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
   
    <title>BulkUpload</title>
    <style>
      



  /*  #current-progress{
	height: 10px;
	color: green;
}
 
    .modal {
  
  position: absolute;
  float: left;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.inset {
border-style: ridge;
border-width: 5px 20px;
border-radius: 8px;

}
    
    .progress {
                margin: 10px;
                width: 440px;
                color: yellowgreen;
              } */
    </style>
  </head>
  <body >
	<jsp:include page="Header.jsp"></jsp:include>
    
    
<div class="main-body-section"  >
      <center>
        <h1 style="margin-bottom: 80px; margin-top: 30px; font: 25px Calibri !important;"><b>User Bulk Upload</b></h1>
      </center>
    
          <div class="row">
                <div class=" col d-flex justify-content-center align-items-center" style="align-items: center; justify-content: center;">
                  <a href="Template/Template.xlsx" style="image-orientation:center" download>
                    <img src="images/xlimage.jpg" alt="file" style="height: 100px;width: 100px;">
                    <br>
                    <br>
                    <label class="h5 border border-dark rounded" style="font-size: 15px !important;"><div style="padding: 5px;">Click here to download the template</div></label>
                  </a>
                  
                  
                </div>
                <div class="col d-flex justify-content-center align-items-center">
                  
                    <div class=" " style="align-items: center; justify-content: center;">
                        <!--<label class="mt-7" for="inputDefault" id="upload_r">BulkUpload Files</label>-->
                        
                        
                        
                        <form method="post" action="/WeatherApi/BulkUploadController" id="form1"  enctype = "multipart/form-data">
                        
                            <p style="font-size:20px !important; font-weight: light;">Upload File</p>
                        <br>
                         <div id="fileuploaddiv" >
                            <input style="font-size: 15px !important;" type="file" id="fileupload" name="fileUploader" required/>    
                        </div>
                        <br>
                        
                        
                    </div>
                
                </div>
              </div>
            
              <br>
              <br>
              <br>
             <div class="col-md-12"> <div class="submitbuttondiv">
              	<span>	<input type="submit" class="mainsubmit"  onclick="SubmitFunc();" Value="Submit" />
                     </span> 
              </div></div></form> 
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              
              </div>
              
                
             <!--
                <center>  
                <div class="container">
      
                
              </div>
            </center>
             --> 
            <!-- Progress Bar Starting 
            
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="">
                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title in" id="myModalLabel">Please Wait</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body center-block">
                    
                    <div class="progress">
                      <div id="dynamic" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                        <span id="current-progress"></span>
                      </div>
                    </div>
                  </div>
                  
                  <div class="modal-footer">
                    <span id="complete"></span>
                    <button type="button" class="btn btn-default hide" data-dismiss="modal" id="btnClose">Close</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
          
                        
     
        
        
   

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
      
    
    <script >
    
    function SubmitFunc() {
		$('#submitbutton').prop('disabled', true);
		document.getElementById("form1").submit();
		// 				$('#submitbutton').prop('disabled', true);
	}
    
    $(document).ready(function() {
//     	console.log("entered");
    	 // initializeModal();
    	});

    	function initializeModal() {
    	  $('#myModal').modal({
    	backdrop: 'static',
    	keyboard: false,
    	show: false
    	});



    	$('#myModal').on('shown.bs.modal', function () {
			
    		console.log("modalfunction");
    		
    		function fetchpercentage(){
    			$.ajax({
        		    url: '/WeatherApi/BulkQuotationController',
        		    type: "GET",
        		    dataType: "json",
        		    success: function (data) {
        		    	console.log("hi");
        		        console.log(data.progress);
        		        
        		        
		        		        	$("#dynamic")
		          		    	  .css("width", data.progress + "%")
		          		    	  .attr("aria-valuenow", data.progress)
		          		    	  .text(data.progress + "% Complete");
		  	        		       
		          		    	  if (data.progress >= 100)
		          		    	  {
		          		    	      clearInterval(interval);
		          		    	      document.getElementById('complete').innerHTML = "Uploaded";
		          		    	      
		          		    	  }
        		        	
        		       
        		    }
        		    
        		});
    		
    		}
    		
    		
    	var interval = setInterval(fetchpercentage, 5000);

    	});

    	$('#myModal').on('hidden.bs.modal', function () {
    	// reset modal
    	if ($('#myModal').data('reenable')) {
    	   $(this).removeData();
    	   $('#myModal').modal({
    	      show: true
    	   });
    	}
    	});
    }

    
    </script>
  </body>
</html>