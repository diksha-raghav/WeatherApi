const rmCheck = document.getElementById("rememberMe"),
userInput = document.getElementById("username");

if (localStorage.checkbox && localStorage.checkbox !== "") {
  rmCheck.setAttribute("checked", "checked");
  userInput.value = localStorage.username;
} else {
  rmCheck.removeAttribute("checked");
  userInput.value = "";
}

function isRememberMe() 
{
  if (rmCheck.checked && userInput.value !== "") {
    localStorage.username = userInput.value;
    localStorage.checkbox = rmCheck.value;
  } else {
    localStorage.username = "";
    localStorage.checkbox = "";
  }
}