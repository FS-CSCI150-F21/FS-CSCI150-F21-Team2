const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");

//Move Form to Left off Screen
signupBtn.onclick = (() => {
    loginForm.style.marginLeft = "-50%";
    loginText.style.marginLeft = "-50%";
});

//Move Form Back
loginBtn.onclick = (() => {
    loginForm.style.marginLeft = "0%";
    loginText.style.marginLeft = "0%";
});

//Load Sign Up form
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
        url = $form.attr("action");

    // Info to send
    var sendInfo = { "username": uname, "password": pword };
    //Build and Send an Ajax Post Request
    sendPost(sendInfo, uname, url, divId);
});


$("#signUpForm").submit(function (event) {

    // Stop form from submitting normally
    event.preventDefault();
    var divId = "signup_error";

    // Get some values from elements on the page:
    var $form = $(this),
        uname = $form.find("input[name='username']").val(),
        pword = $form.find("input[name='password']").val();
        pconf = $form.find("input[name='pConfirm']").val();
        url = $form.attr("action");

    if (pword !== pconf) {
        showErrorMessage(divId, "Passwords Do Not Match");
        return;
    }
    // Info to send
    var sendInfo = { "username": uname, "password": pword };
    //Build and Send an Ajax Post Request
    sendPost(sendInfo, uname, url, divId);

});

function sendPost(body, username, url, divId){

    var posting = $.ajax({
        type: 'post',
        url: url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function () {
            window.sessionStorage.setItem("username", username);
            window.location.replace(window.location.href + "html/dashboard.html");
        },
        error: function (xhr, status, error) {
            showErrorMessage(divId, xhr.responseJSON.message);
        }
    });
}

function showErrorMessage(divId, msg) {

    var errorDiv = document.getElementById(divId);
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = msg;

}
async function logout() {
    window.sessionStorage.clear();
    var response = await fetch("api/v1/user_session/logout");
    document.location.href="/";
}