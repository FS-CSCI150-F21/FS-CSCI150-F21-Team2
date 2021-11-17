function singup() {

    var emailReg = document.getElementById("rEmail");
    var passReg = document.getElementById("rPassword");
    var passwordConfirm = document.getElementById("rcPassword");

    if (passReg !== passwordConfirm) {
        showErrorMessage("Pleae Match Passwords");
        return;
    }

    $.post("api/v1/user_registration",
        {
            email: emailReg,
            passowrd: passReg
        }).fail(showErrorMessage("Not acceptable username or password"))
}

function showErrorMessage(msg) {
    document.getElementById("signup").classLst.add('errorMsg');
    document.getElementById("singup").innerHTML = msg;
    var emailReg = document.getElementById("email").value;
    var passReg = document.getElementById("password").value;
}