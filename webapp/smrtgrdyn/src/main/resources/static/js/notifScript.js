// ======================== On Page Load Functions =============================//

$('document').ready(function(){

    setProfileName();

    loadGardens().then(response => getNotifs()).then(res => loadNotifs());

});


function setProfileName(){

    var profileName = document.getElementById("profileName");

    profileName.innerHTML = "\u00A0" + window.sessionStorage.getItem("username");
    document.title += " | " + window.sessionStorage.getItem("username");

}

$("#home-button").submit(function(e){
    e.preventDefault();
    home();
})

//==============================Garden Loading ==================================//
var selectedGarden = {};
var defaultGarden = {};
async function loadGardens(){

    await getDefaultGarden().then(getAllGardens());
    console.log(selectedGarden);
    return;
}


//asynchronous function executes while doing its own thing
async function getDefaultGarden() {

    //gets username
    var user = window.sessionStorage.getItem("username");

    response = await fetch("api/v1/user_session/default_garden?username=" + user)

    defaultGarden = await response.json();
    selectedGarden = defaultGarden;

    setSelectedGardenWithSessionSelectedGarden();

}

function setSelectedGardenWithSessionSelectedGarden(){

    if(window.sessionStorage.getItem("selectedId")){
        selectedGarden.gardenId = window.sessionStorage.getItem("selectedId")
        selectedGarden.gardenName = window.sessionStorage.getItem("selectedName")
    }
    else{
        window.sessionStorage.setItem("selectedId", selectedGarden.gardenId);
        window.sessionStorage.setItem("selectedName", selectedGarden.gardenName);
    }
}

async function getAllGardens(){

    var user = window.sessionStorage.getItem("username");

    fetch("api/v1/user_session/get_gardens?username=" + user)
        .then(getRes => getRes.json()).then(json => populateGardenList(json));
}


// Global Gardens Var
var gardens = [];
function populateGardenList(allGardens) {

    var list = document.getElementById("gardenId");

    if(allGardens.length >= 1){

        allGardens.forEach(garden => gardens.push(garden));

        //Add entry for Default Garden
        list.innerHTML = generateOption(defaultGarden.gardenId, defaultGarden.gardenName);

        //Add Rest of Gardens
        gardens.forEach(function (garden) {

            if (garden.gardenId !== defaultGarden.gardenId) {
                //makes sure default garden isnt in there twice by checking its id
                list.innerHTML += generateOption(garden.gardenId, garden.gardenName)
            }
        })
    }

}


//modularizing the previous
function generateOption(gardenId, gardenName) {
    //gardenId determines the gardenName for the dropdown menu in dashboard.html
    if(window.sessionStorage.getItem("selectedId") && window.sessionStorage.getItem("selectedId") == gardenId){
        return '<option value="' + gardenId + '" selected = "true">' + gardenName + '</option>';
    }
    return '<option value="' + gardenId + '">' + gardenName + '</option>';
}

//===============================Notif Loading =====================================================//


async function getNotifs(){

    console.log(selectedGarden);
    console.log(selectedGarden.gardenId);

    var response = await fetch("api/v1/notifications?gardenId=" + selectedGarden.gardenId);
    var resJson = await response.json();
    notifs = [];
    notifs = resJson.sort(notifSort);
    populateNotifsToDisplay();

}

function notifSort(first, second){
    return (new Date(first.timestamp)) < (new Date(second.timestamp));
}
function populateNotifsToDisplay(){

    notifsToDisplay = [];

    //get type filter
    var e = document.getElementById("notif-type");
    var filter = e.value;
    //apply filters to notifs
    if(filter !== "all"){
        notifs.forEach(function(n){
            if(n.type == filter){
                notifsToDisplay.push(n);
            }
        });

    }
    else{
        notifsToDisplay = notifs;
    }
    notifsToDisplay.sort(notifSort);

    e = document.getElementById("notif-sort");
    var sortVal = e.value;

    if(sortVal === "old-to-new"){
        notifsToDisplay.reverse();
    }


    return;
    //if sort filter is oldest first, sort list, then reverse list
}

function loadNotifs(){

    if(notifsToDisplay.length > 0){

        populateNotifList();

        addCustEventListeners();

    }
    else{
        document.getElementById("list-window").innerHTML = '<div class="no-list">No Notifications</div>'
    }

}

function populateNotifList(){

    var listWindow = document.getElementById("list-window");
    listWindow.innerHTML = "";
    while(listWindow.firstChild){
        listWindow.removeChild(listWindow.firstChild);
    }

    notifsToDisplay.forEach(function(n){
        var newChild = buildNotif(n)
        listWindow.innerHTML += newChild;
    })
}

function buildNotif(notif){

    var date = pitaDate(notif.timestamp)
    var type = pitaType(notif.type)
    var notifString = '<div class="list-el" value="' + notif.message + '">' +
                            '<p class="list-el-date" value="' + notif.timestamp + '">' +
                             date + '</p><h4 class="list-el-divider">|</h4>' +
                            '<p class="list-el-type" value="' + notif.type +'">' + type +
                            '</p></div>';
    return notifString;
}


function pitaDate(timestamp){
    var newDate = new Date(timestamp);
    var time = formatAMPM(newDate);
    return ''+ (newDate.getMonth() + 1) + '-' + newDate.getDate()
    + "-" + newDate.getFullYear() + "\t" + time;
}


function pitaType(type){
    return type.charAt(0).toUpperCase() + type.slice(1) + " detected!";
}

function formatAMPM(date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = (hours !== 0) ? hours : 12; // the hour '0' should be '12'
    hours = (hours < 10) ? "\u00A0 " + hours : hours;
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + '' + ampm;
    return strTime;
}

function addCustEventListeners(){

    list_els = document.querySelectorAll(".list-el");
    list_els.forEach(el => addCustEventListener(el));

}


function addCustEventListener(list_el){

    list_el.addEventListener("dblclick", function(list_el){
        loadModal(list_el.target);
    });

}
//=================================MODALS=====================================//

$("#close-modal-btn").submit(function(e){
    e.preventDefault();
    closeModal();
})

function loadModal(element){

    try{

        var timestamp = element.querySelector(".list-el-date").getAttribute('value');
        var date = pitaJustDate(timestamp);
        var time = pitaJustTime(timestamp);

        var message = pitaMessage(date, time, element.getAttribute('value'));

        var type = pitaType( element.querySelector(".list-el-type").getAttribute('value'));

        populateModal(type, timestamp, message);

        var modal = document.getElementById("modal");
        modal.style.display = "block";

    } catch(err){
        console.log(err);
    }

}

function closeModal(){
    clearModal();
    var modal = document.getElementById("modal");
    modal.style.display = "none";
}


function pitaJustDate(timestamp){
    var newDate = new Date(timestamp);
    return ''+ (newDate.getMonth() + 1) + '-' + newDate.getDate()
    + "-" + newDate.getFullYear();
}

function pitaJustTime(timestamp){
    var newDate = new Date(timestamp);
    var time = formatAMPM(newDate);
    return time;
}

function clearModal(){
    var modal_type = document.getElementById("modal-type");
    var modal_date = document.getElementById("modal-date");
    var modal_message = document.getElementById("modal-message");

    modal_type.innerHTML = "";
    modal_date.innerHTML = "";
    modal_message.innerHTML = "";
}

function populateModal(type, timestamp, message){

    clearModal();
     var modal_type = document.getElementById("modal-type");
     var modal_date = document.getElementById("modal-date");
     var modal_message = document.getElementById("modal-message");

     modal_type.innerHTML = type;
     modal_date.innerHTML = pitaDate(timestamp);
     modal_message.innerHTML = message;

}
function pitaMessage(date, time, message){

    return "On " + date + " at " + time + "\u00A0" + message;

}
//=======================================LOGOUT/HOME====================================//
async function logout() {
    window.sessionStorage.clear();
    var response = await fetch("api/v1/user_session/logout");
    document.location.href="/";
}

function home(){
    window.location.href = "/"
}

//================================CONST TEST VARS====================================//
const __baseURL = "http://172.22.158.171:8080/"

var notifs = [];
var notifsToDisplay = [];

//=================================ON CHANGE===========================================//

function changeGarden(sel){
     selectedGarden.gardenId = sel.options[sel.selectedIndex].value;
     selectedGarden.gardenName = sel.options[sel.selectedIndex].text;
     window.sessionStorage.setItem("selectedId", selectedGarden.gardenId)
     window.sessionStorage.setItem("selectedName", selectedGarden.gardenName)

     getNotifs().then(res => loadNotifs());

}

async function applyFilter(){

    await populateNotifsToDisplay();
    loadNotifs();
}