
    const loginText = document.querySelector(".title-text .login");
    const loginForm = document.querySelector("form.login");
    const loginBtn = document.querySelector("label.login");
    const signupBtn = document.querySelector("label.signup");
    const signupLink = document.querySelector("form .signup-link a");
        signupBtn.onclick = (() => {
        loginForm.style.marginLeft = "-50%";
            loginText.style.marginLeft = "-50%";
        });
        loginBtn.onclick = (() => {
        loginForm.style.marginLeft = "0%";
            loginText.style.marginLeft = "0%";
        });
        signupLink.onclick = (() => {
        signupBtn.click();
            return false;
        });

$("#loginForm").submit(function (event) {

    // Stop form from submitting normally
    event.preventDefault();
    var divId = "login_error";
    // Get some values from elements on the page:
    var $form = $(this),
        uname = $form.find("input[name='username']").val(),
        pword = $form.find("input[name='password']").val();


    // Info to send
    var SendInfo = { "username": uname, "password": pword };
    //Build and Send an Ajax Post Request
    var posting = $.ajax({
        type: 'post',
        url: $form.attr("action"),
        data: JSON.stringify(SendInfo),
        contentType: "application/json; charset=utf-8",
        success: function () {
            window.sessionStorage.setItem("username", uname);
            //window.location.replace(window.location.href + "dashboard.html");
        },
        error: function (divId, xhr, status, error) {
            showErrorMessage(divId, xhr.responseJSON.message);
        }
    });
});


function showErrorMessage(divId, msg) {

    var errorDiv = document.getElementById(divId);
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = msg;

}

$("#signUpForm").submit(function (event) {

    // Stop form from submitting normally
    event.preventDefault();
    var divId = "signup_error";
    console.log("test")
    // Get some values from elements on the page:
    var $form = $(this),
        uname = $form.find("input[name='username']").val(),
        pword = $form.find("input[name='password']").val();
        pconf = $form.find("input[name='pConfirm']").val();

    if (pword !== pconf) {
        showErrorMessage(divId, "Passwords Do Not Match");
        return;
    }
    // Info to send
    var SendInfo = { "username": uname, "password": pword };
    //Build and Send an Ajax Post Request
    var posting = $.ajax({
        type: 'post',
        url: $form.attr("action"),
        data: JSON.stringify(SendInfo),
        contentType: "application/json; charset=utf-8",
        success: function () {
            window.sessionStorage.setItem("username", uname);
            //window.location.replace(window.location.href + "dashboard.html");
        },
        error: function (xhr, status, error) {
            showErrorMessage(divId, xhr.responseJSON.message);
        }
    });
});


function showErrorMessage(divId, msg) {

    var errorDiv = document.getElementById(divId);
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = msg;

}