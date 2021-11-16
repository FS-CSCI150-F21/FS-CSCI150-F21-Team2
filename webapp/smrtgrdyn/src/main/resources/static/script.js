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

  // Get some values from elements on the page:
  var $form = $( this ),
    uname = $form.find( "input[name='uname']" ).val(),
    pword = $form.find( "input[name='pWord']" ).val();
    pconf = $form.find( "input[name='confPword']" ).val();
    murl = window.location.href + $form.attr( "action" );

  if(pword !== pconf){
      showErrorMessage("Passwords Do Not Match");
      return;
  }
  // Send the data using post

  var SendInfo =  { "username": uname, "password": pword};

  var posting = $.ajax({
                        type: 'post',
                        url: murl,
                        data: JSON.stringify(SendInfo),
                        dataType: 'json',
                        contentType: "application/json; charset=utf-8",
                        traditional: true,
                    }).done(function(response){
                        console.log("Done")
                        window.location.replace(window.location.href + "dashboard.html");
                    }).fail(function(response){
                        if(response.responseJSON){
                            showErrorMessage(response.responseJSON.message);
                            return;
                        }
                        else{
                            console.log("error");
                        }
                    });
    const user = uname;
    window.sessionStorage.setItem("user", uname);
  window.location.replace(window.location.href + "dashboard.html");

});


function showErrorMessage(msg){

    var errorDiv = document.getElementById("errorDiv");
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = msg;

}