var tempChart = "";
var humidChart = "";
var waterFlowChart = "";
var moistureChart = "";
var waterStatusChart = "";

function getChart(chartName){


    switch(chartName){
        case 'temp':
            if(tempChart) tempChart.destroy();
            tempChart = getTempChart();
            break;
        case "humid":
            if(humidChart) humidChart.destroy();
            humidChart = getHumidChart();
            break;
        case "waterflow":
            if(waterFlowChart) waterFlowChart.destroy();
            waterFlowChart = getWaterFlowChart();
            break;
        case "moisture":
            if(moistureChart) moistureChart.destroy();
            moistureChart = getMoistureChart();
            break;
        case "waterstatus":
            if(waterStatusChart) waterStatusChart.destroy();
            waterStatusChart = getwaterStatusChart();
            break;
        default:
            break;
    }
}



var waterstatusYVals = []



function getTempChart(){

    return newChart("tempChart", "Temperature", tempYVals);
}

function getHumidChart(){

    return newChart("humidChart", "Humidity", humidYVals);
}

function getWaterFlowChart(){

    return newChart("waterFlowChart", "Water Usage", waterflowYVals);
}

function getMoistureChart(){

    return newChart("moistureChart", "Soil Moisture", moistureYVals)
}

function getwaterStatusChart(){

    return newChart("waterStatusChart", "Watering Status", waterstatusYVals)
}

function newChart(ctx, dlabel, yVals){


    return new Chart(ctx, {
            type: "bar",
            data: {
                labels: timeLabels,
                datasets: [{
                    label:dlabel,
                    fill: false,
                    lineTension: 0,
                    backgroundColor: "rgba(0,0,255,1.0)",
                    borderColor: "rgba(0,0,255,0.1)",
                    data: yVals
                }]
            },
            options: {
                legend: { display: true },
                scales: {
                    yAxes: { ticks: { min: 6, max: 16 } }
                }
            }
        });

}


var gardenDataLast13 = [];

function getLast13Hours(){

    var end = new Date();
    var local = end;
    var utc = toUTC(end);

    var start = new Date();

    start.setHours(end.getHours() - 13);
    end = toUTC(end);
    start = toUTC(start);

    start = pITAFormatting(start);
    end = pITAFormatting(end);

     var body = { "gardenId": defaultGarden.gardenId, start: start, end: end };
     var gettingRange = $.ajax({
         type: 'post',
         url: 'api/v1/garden_data_collection/range',
         dataType: 'json',
         contentType: "application/json; charset=utf-8",
         data: JSON.stringify(body),
         success: function (response) {
             gardenDataLast13 = response;
             setGraphData(local, utc);
         },
         error: function (xhr, status, error) {
            gardenDataLast13 = []
            setGraphData(local, utc);
         }
     });



}

function toUTC(date){
    return new Date(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
                            date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds(),
                            date.getUTCMilliseconds());
}

function pITAFormatting(date){

    var year = prependZero(date.getFullYear());
    var month = prependZero(date.getMonth());
    var day = prependZero(date.getDate());

    var hour = prependZero(date.getHours());
    var minutes = prependZero(date.getMinutes());
    var seconds = prependZero(date.getSeconds());
    var milli = date.getMilliseconds();


    var dateString = year + '-'+ month + '-' + day + 'T' + hour + ':' + minutes + ':' + seconds + '.' + milli ;

    return dateString;
}

function prependZero(time){

    if(time < 10){
        time = '0' + time;
    }
    return time;
}

var graphFields = ["temp", "humid", "waterflow", "moisture", "waterstatus"];

function setGraphData(local, utc){

    setTimeValues(local, utc);
    getAveragesPerHour();
    graphFields.forEach(field => getChart(field));

}

var timeValues = [];
var timeLabels = [];

function clearTimeValues(){
    timeValues = [];
    timeLabels = [];

}
function setTimeValues(local, utc){

    clearTimeValues();


    var localHour = local.getHours();
    var utcHour = utc.getHours();

    for( var i = 0; i < 13; i++){
        timeLabels.push(appendMeriem(localHour - i));
        if(utcHour - i < 0){
            timeValues.push((utcHour - i) + 24);
        }else {
            timeValues.push(utcHour - i);
        }

    }
    timeValues = timeValues.reverse();
    timeLabels = timeLabels.reverse();


}

function appendMeriem(hour){
    var meriem = 'am';
    if(hour > 12){
        hour -= 12;
        meriem = 'pm'
    }else if(hour < 0){
        hour += 12
        if(hour == 0){
            hour = 12
        }
         meriem = 'pm'
    }else if(hour == 0){
        hour = 12
        meriem = 'am'
    }

    return hour + meriem;

}

var tempYVals = []
var humidYVals = []
var moistureYVals = []
var waterflowYVals = []
var waterstatusYVals = []

function clearAverages(){

   tempYVals = [];
   humidYVals = [];
   moistureYVals = [];
   waterflowYVals = [];
   waterstatusYVals = [];

}

function getAveragesPerHour(){

    clearAverages();


    var hourIndex = 0;
    var currentHour = timeValues[hourIndex];

        t = [0]; //temperature
        h = [0]; // humidity
        m = [0]; //moisture
        w = [0]; //water flow
        s = [0]; //watering status

    for(var index = 0; index < timeValues.length; index++){

        gardenDataLast13.forEach(function(data) {

            var dataHour = new Date(Date.parse(data.timestamp)).getHours();
            if(dataHour == timeValues[index]){
                // Push data into temp arrays
                t.push(data.temperature);
                h.push(data.humidity);
                m.push(data.soilMoisture);
                w.push(data.waterFlow);
                s.push(+data.waterActive);

            }
        })

        //Push averages into YVal arrays
        tempYVals.push(getAverageOfArrayLengthMinus1(t));
        humidYVals.push(getAverageOfArrayLengthMinus1(h));
        moistureYVals.push(getAverageOfArrayLengthMinus1(m));
        waterflowYVals.push(getAverageOfArrayLengthMinus1(w));
        waterstatusYVals.push(getAverageOfArrayLengthMinus1(s));

        //Reset temp arrays
        t = [0]; //temperature
        h = [0]; // humidity
        m = [0]; //moisture
        w = [0]; //water flow
        s = [0]; //watering status

    }

}

function getAverageOfArrayLengthMinus1(array){

   var ret = array.reduce(function(acc, x){return acc + x}) / (array.length - 1)

   if(isNaN(ret)){
        return 0;
   }else {
        return ret;
   }

}
//===============================================================================chart data==============================================================

var dataFields = ["temp-data", "humid-data", "waterflow-data", "soil-data", "waterstatus-data"];

function getInstanceData(fieldName) {
    var field = document.getElementById(fieldName);
    switch (fieldName) {
        case 'temp-data':
            setTempData(field);
            break;
        case "humid-data":
            setHumidData(field);
            break;
        case "waterflow-data":
            setwaterFlowData(field);
            break;
        case "soil-data":
            setSoilData(field);
            break;
        case "waterstatus-data":
            setwaterstatusData(field);
            break;
        default:
            break;
    }
}

//setting data for graphs
function setTempData(field) {
    if(latest){
         //var temp convert to Celcius
         field.innerHTML = "Latest Reading: "+ latest.temperature + " \u00B0F";
    }else {
         field.innerHTML = "No Reading Available";
    }

}
function setHumidData(field) {

    if(latest){
         field.innerHTML = "Latest Reading: " + latest.humidity;
    }else {
         field.innerHTML = "No Reading Available";
    }

}
function setwaterFlowData(field) {
    if(latest){

         field.innerHTML = "Latest Reading: " + latest.waterFlow;
    }else {
         field.innerHTML = "No Reading Available";
    }


}
function setSoilData(field) {

    if(latest){
        field.innerHTML = "Latest Reading: " + latest.soilMoisture;
    }
    else{
         field.innerHTML = "No Reading Available";
    }

}
function setwaterstatusData(field) {

   deactivateSwitches();
    if(latest){

        var msg = "Off";
        if (latest.waterActive) {
            msg = "On";
            activateSwitches()

        }
        field.innerHTML = "Status: " + msg;
        showSwitches();
    }
    else{
         field.innerHTML = "No Reading Available";
         hideSwitches();
    }

}

function activateSwitches(){
    var switches = document.querySelectorAll('input[type=checkbox]')
    switches.forEach(s => s.checked = true);
}
function deactivateSwitches(){
    var switches = document.querySelectorAll('input[type=checkbox]')
    switches.forEach(s => s.checked = false);
}
function hideSwitches(){
    var switches = Array.from(document.getElementsByClassName("waterSwitch"));
        switches.forEach(s => s.style.display = "none");
}

function showSwitches(){
    var switches = Array.from(document.getElementsByClassName("waterSwitch"));
    switches.forEach(s => s.style.display = "inline-block")
}
function setAllData(){
     dataFields.forEach(field => getInstanceData(field));
}

//=====================================================================chart data==========================================================================

var latest = "";
var selectedGarden = {};
var defaultGarden = {};
//asynchronous function executes while doing its own thing
async function getDefaultGarden() {

    //gets username
    var user = window.sessionStorage.getItem("username");

    response = await fetch("api/v1/user_session/default_garden?username=" + user)

    selectedGarden = await response.json();
    defaultGarden = selectedGarden;
}

var gardens = [];

async function getAllGardens(){

    var user = window.sessionStorage.getItem("username");

    fetch("api/v1/user_session/get_gardens?username=" + user)
        .then(getRes => getRes.json()).then(json => populateGardenList(json));


}


function getLatest() {

    var body = { "gardenId": selectedGarden.gardenId };
    var gettingRange = $.ajax({
        type: 'post',
        url: 'api/v1/garden_data_collection/latest',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(body),
        success: function (response) {
            latest = response;
            setAllData();
        },
        error: function (xhr, status, error) {
            latest = "";
            setAllData();
        }
    });

}


function populateGardenList(allGardens) {
    var list = document.getElementById("gardenId");
    console.log(allGardens);
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

//modularizing the previous
function generateOption(gardenId, gardenName) {
    //gardenId determines the gardenName for the dropdown menu in dashboard.html
    return '<option value="' + gardenId + '">' + gardenName + '</option>';
}

function changeVals(sel){

        selectedGarden.gardenId = sel.options[sel.selectedIndex].value;
        selectedGarden.gardenName = sel.options[sel.selectedIndex].text;

        getLatest();
        getLast13Hours();
}

$('document').ready(function () {
  //do this for async functions, basically to wait for them to finish execution since they make fetch calls
    getDefaultGarden()
    .then(response => getAllGardens())
    .then(res3 => getLatest())
    .then(res4 => getLast13Hours());

})

async function logout() {
    var response = await fetch("api/v1/user_session/logout");

    document.location.href="/";
    window.sessionStorage.clear();
}