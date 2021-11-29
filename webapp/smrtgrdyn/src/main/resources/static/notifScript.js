const __baseURL = "http://172.22.158.171:8080/"

const notifs = [{
                    gardenId:"e945cbba-f6e5-4b84-b76b-f38e5313b21f",
                    timestamp:"2021-10-28T22:58:59.347",
                    type: "animal",
                    message: "chonky boy spotted"},
                {
                    gardenId:"e945cbba-f6e5-4b84-b76b-f38e5313b21f",
                    timestamp:"2021-10-28T21:58:59.347",
                    type: "animal",
                    message: "Super chonky boy spotted"},
                {
                    gardenId:"e945cbba-f6e5-4b84-b76b-f38e5313b21f",
                    timestamp:"2021-10-28T21:58:59.347",
                    type: "animal",
                    message: "Super chonky boy spotted"},
                {
                    gardenId:"e945cbba-f6e5-4b84-b76b-f38e5313b21f",
                    timestamp:"2021-10-28T20:58:59.347",
                    type: "leak",
                    message: "Cidney, The Tv Leaking"},

                ];

$('document').ready(function(){

    //Get all gardens
    // populate drop down
    // grab data for default/selected garden
    // grab data for onChange data

    if(notifs){
        var listWindow = document.getElementById("list-window");
        listWindow.innerHTML = "";
        notifs.forEach(function(n){
            var newChild = buildNotif(n)
            listWindow.innerHTML += newChild;
        })

        list_els = document.querySelectorAll(".list-el");
        list_els.forEach(el => addCustEventListener(el));
        // addCustEventListeners(list_els)
    }

});

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

function addCustEventListener(list_el){

    list_el.addEventListener("dblclick", function(list_el){
        test(list_el.target);
        // list_el.target.style.background = "lightgrey";
        // Change to addClass("selected"), selected will have background: lightgrey
    });

}

function test(element){

    var message = element.getAttribute('value');
    var timestamp = element.querySelector(".list-el-date").getAttribute('value');
    // var message = element.value;
    var type = element.querySelector(".list-el-type").getAttribute('value');

    console.log(timestamp + "\n" + type + "\n" + message);
}

function pitaDate(timestamp){
    var newDate = new Date(timestamp);
    var time = formatAMPM(newDate);
    return ''+ newDate.getMonth() + '-' + newDate.getDate()
    + "-" + newDate.getFullYear() + "\t" + time;
}

function formatAMPM(date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = (hours < 10) ? "\u00A0 " + hours : hours;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + '' + ampm;
    return strTime;
}

function pitaType(type){
    return type.charAt(0).toUpperCase() + type.slice(1) + " detected!";
}


var selectedGarden = {};
var defaultGarden = {};
//asynchronous function executes while doing its own thing
async function getDefaultGarden() {

    //gets username
    var user = window.sessionStorage.getItem("username");

    response = await fetch("api/v1/user_session/default_garden?username=" + user)

    defaultGarden = await response.json();
    console.log(defaultGarden);
    selectedGarden = defaultGarden;
    if(window.sessionStorage.getItem("selectedId")){
        selectedGarden.gardenId = window.sessionStorage.getItem("selectedId")
        selectedGarden.gardenName = window.sessionStorage.getItem("selectedName")
    }


}

var gardens = [];

async function getAllGardens(){

    var user = window.sessionStorage.getItem("username");

    fetch("api/v1/user_session/get_gardens?username=" + user)
        .then(getRes => getRes.json()).then(json => populateGardenList(json));


}



function populateGardenList(allGardens) {
    var list = document.getElementById("gardenId");
    console.log(allGardens);
    if(allGardens.length >= 1){
        allGardens.forEach(garden => gardens.push(garden));
            //editing the options to dynamically add the name of the garden, based on ID of the garden
            list.innerHTML = generateOption(defaultGarden.gardenId, defaultGarden.gardenName);
            gardens.forEach(function (garden) {
                console.log(garden.gardenName);
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


$('document').ready(function () {
  //do this for async functions, basically to wait for them to finish execution since they make fetch calls

  var profileName = document.getElementById("profileName");

  profileName.innerHTML = "| " + window.sessionStorage.getItem("username");
  document.title += " | " + window.sessionStorage.getItem("username");

  if(window.sessionStorage.getItem("selectedId")){
    onReload();
  }else{
         getDefaultGarden()
            .then(response => getAllGardens())

  }

})

async function logout() {
    var response = await fetch("api/v1/user_session/logout");

    document.location.href="/";
    window.sessionStorage.clear();
}
function home(){
    document.location.href="/";
}

async function onReload(){
        await getDefaultGarden();
        await getAllGardens();

        selectedGarden.gardenId = window.sessionStorage.getItem("selectedId");
        selectedGarden.gardenName = window.sessionStorage.getItem("selectedName");

}