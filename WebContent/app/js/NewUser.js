/**
 * 
 */
function ValidateNo() {
    var phoneNo = document.getElementsByClassName('txtPhoneNo');

if (phoneNo.value == "" || phoneNo.value == null) {
        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Please enter your mobile number</span>";
        return false;
    }
    if (phoneNo.value.length < 10 || phoneNo.value.length > 10) {
        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Enter valid mobile Number</span>";
        return false;
    }
	if ((phoneNo.value < 92  && phoneNo.value > 64) || (phoneNo.value < 123  && phoneNo.value > 96) ) {
        document.getElementById("alertmobile").innerHTML = "<span style='color: red;'>**Enter valid mobile Number</span>";
        return false;
    }


    return true;
    }

    function autofill() {
        
        document.getElementById("uname").value = "srinivas";
        document.getElementById("L5").value = "delhi";
        document.getElementById("desig").value = "Field Executive";
        document.getElementById("m1").value = 987654321;
        document.getElementById("m2").value = 9806712341;
        document.getElementById("mailid").value = "a@gmail.com";
        document.getElementById("location").value = "Delhi";
        document.getElementById("months").value = 41;
        document.getElementById("years").value = 4;
        
        
    }