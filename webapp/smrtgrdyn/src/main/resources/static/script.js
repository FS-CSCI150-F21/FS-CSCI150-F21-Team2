const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
const signUpSubBtn = document.getElementById("signUpSubmit");

const user = "";

signupBtn.onclick = (()=>{
      loginForm.style.marginLeft = "-50%";
      loginText.style.marginLeft = "-50%";
});

loginBtn.onclick = (()=>{
      loginForm.style.marginLeft = "0%";
      loginText.style.marginLeft = "0%";
});



$( "#signUpForm" ).submit(function( event ) {

  // Stop form from submitting normally
  event.preventDefault();

    var divId = "registration_error";
  // Get some values from elements on the page:
  var $form = $( this ),
    uname = $form.find( "input[name='uname']" ).val(),
    pword = $form.find( "input[name='pWord']" ).val();
    pconf = $form.find( "input[name='confPword']" ).val();

  if(pword !== pconf){
      showErrorMessage("Passwords Do Not Match");
      return;
  }
  // Info to send
  var SendInfo =  { "username": uname, "password": pword};
//Build and Send an Ajax Post Request
  var posting = $.ajax({
                        type: 'post',
                        url: $form.attr( "action" ),
                        data: JSON.stringify(SendInfo),
                        contentType: "application/json; charset=utf-8",
                        success: function(){
                            window.sessionStorage.setItem("user", uname);
                            //window.location.replace(window.location.href + "dashboard.html");
                        },
                        error : function(xhr, status, error) {
                            showErrorMessage(divId, xhr.responseJSON.message);
                       }
                  });
});

$( "#loginForm" ).submit(function( event ) {

  // Stop form from submitting normally
  event.preventDefault();
  var divId = "login_error";
  // Get some values from elements on the page:
  var $form = $( this ),
    uname = $form.find( "input[name='uname']" ).val(),
    pword = $form.find( "input[name='pWord']" ).val();


  // Info to send
  var SendInfo =  { "username": uname, "password": pword};
//Build and Send an Ajax Post Request
  var posting = $.ajax({
                        type: 'post',
                        url: $form.attr( "action" ),
                        data: JSON.stringify(SendInfo),
                        contentType: "application/json; charset=utf-8",
                        success: function(){
                            window.sessionStorage.setItem("user", uname);
                            //window.location.replace(window.location.href + "dashboard.html");
                        },
                        error : function(xhr, status, error) {
                            showErrorMessage(divId, xhr.responseJSON.message);
                       }
                  });
});


function showErrorMessage(divId, msg){

    var errorDiv = document.getElementById(divId);
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = msg;

}