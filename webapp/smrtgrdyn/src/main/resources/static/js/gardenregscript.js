const piIdForm = document.getElementById("piIdForm");
const piIdLabel = document.querySelector(".title-text .piId");
const errorDiv = document.getElementById("error");
var gardenRegId = "";

$( "#piIdForm" ).submit(function( event ) {

    // Stop form from submitting normally
    event.preventDefault();

    var $form = $(this),
        piId = $form.find("input[name='piId']").val(),
        url = $form.attr("action");

    if(piId) {
        piId = piId.toString();
        piId = piId.toUpperCase();
        console.log(piId);
    }
    if(piId.length != 6){
        console.log("Not Sufficient Length")
        addErrorToCard("Invalid Passcode");
        return;
    }
    removeErrorFromCard()

    var username = window.sessionStorage.getItem("username");
    if(username){
        var body = { username: username, "piId": piId};

        sendPost(body, url, function(result){
            gardenRegId = result;
             confirmToName();
        })

    }
    else{
        // logout();
    }

});

function confirmToName(){
    removeErrorFromCard()
    piIdForm.style.marginLeft = "-50%";
    piIdLabel.style.marginLeft = "-50%";
}


$("#gardenNameForm").submit( function(event) {
    event.preventDefault();

    if(!gardenRegId){
        return;
    }
     //get gardenName and url
    var $form = $(this),
            gardenName = $form.find("input[name='gardenName']").val(),
            url = $form.attr("action");

    var username = window.sessionStorage.getItem("username");
    if(username || gardenRegId != ""){
        var body = { username: username, "gardenId": gardenRegId, "gardenName": gardenName};

        sendPost(body, url, function(result){
                showConfirmationCard();
                return;
        })

    }
    else{
        // logout();
    }

    //build body of request: {username: username, gardenId: window.sessionStorage.getItem("regGardenId")}
})

function showConfirmationCard(){

    var cardDiv = document.getElementById("card")
    var innerHtml = '<div class="title-text"><div class="title confirmation">Congratulations</div></div>' +
    '<div class="form-container"><form id="confirmation"><div class="field">' +
    '<p> Congratulations on registering your new garden! We hope you enjoy!</p></div>' +
    '<div class="field btn"><div class="btn-layer"></div><input type="submit" value="Home">' +
    '</div></form></div>';
    cardDiv.innerHTML = innerHtml;


    $("#confirmation").submit( function(event) {
            event.preventDefault();
             document.location.href="/dashboard.html";
    })



}


function sendPost(body, url, callback){

    $.ajax({
        type: 'post',
        url: url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: callback,
        error: function (xhr, status, error) {
            addErrorToCard(xhr.responseJSON.message);
        }
    });
}


function addErrorToCard(message){
    var errorDiv = document.getElementById("error")
    errorDiv.classList.add("errorMsg");
    errorDiv.innerHTML = message;
}

function removeErrorFromCard(){

    errorDiv.innerHTML = ""
    errorDiv.classList.remove("errorMsg");

}

async function logout() {
    window.sessionStorage.clear();
    var response = await fetch("api/v1/user_session/logout");
    document.location.href="/";
}


function home(){
    document.location.href="/";
}

$('document').ready(function(){
    var profileName = document.getElementById("profileName");
    profileName.innerHTML = "\u00A0" + window.sessionStorage.getItem("username");

})