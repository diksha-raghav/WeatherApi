var text = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");


//When the user starts to type something inside the password field
function validating() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(text.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(text.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(text.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(text.value >= 8) 
  {
    length.classList.remove("invalid");
    length.classList.add("valid");
  }  
    else 
    {
      length.classList.remove("valid");
      length.classList.add("invalid");
  }
}

function validate()
{
    if(   document.getElementById("username").value == "")
    // && document.getElementById("password").value == "" )
    {
        alert( "validation succeeded" );
        location.href="run.html";
    }
    else
    {
        alert( "validation failed" );
        location.href="fail.html";
    }
}