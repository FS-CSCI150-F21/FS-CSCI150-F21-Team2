function getChart(chartName){

    switch(chartName){
        case 'temp':
            return getTempChart();
            break;
        case "humid":
            return getHumidChart();
            break;
        case "waterflow":
            return getWaterFlowChart();
            break;
        case "moisture":
            return getMoistureChart();
            break;
        case "waterstatus":
            return getwaterStatusChart();
            break;
        default:
            break;
    }
}


function getTempChart(){

    var yVals = [30, 40, 80, 60, 70, 80, 60, 110, 80];

    return newChart("tempChart", "Temperature", yVals);
}

function getHumidChart(){


    var yVals = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,1,2,3,4,5,6,7,8,9,10,11,12,13,14];

    return newChart("humidChart", "Humidity", yVals);
}

function getWaterFlowChart(){


    var yVals = [1,2,3,4,5,6,7, 8, 8, 9, 9, 9, 10, 11, 14, 14, 15];

    return newChart("waterFlowChart", "Water Usage", yVals);
}

function getMoistureChart(){


    var yVals = [1,2,3,4,5,6,7, 8, 8, 9, 9, 9, 10, 11, 14, 14, 15];

    return newChart("moistureChart", "Soil Moisture", yVals)
}

function getwaterStatusChart(){


    var yVals = [0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0,1];

    return newChart("waterStatusChart", "Watering Status", yVals)
}

function newChart(ctx, dlabel, yVals){


    new Chart(ctx, {
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
    console.log(utc)
    var start = new Date();

    start.setHours(end.getHours() - 13);
    end = toUTC(end);
    start = toUTC(start);
    console.log(start)
    console.log(end)
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

         }
     });

    console.log(start);
    console.log(end);

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

    graphFields.forEach(field => getChart(field));
//    graphFields.forEach(buildAndFillGraphData(field));
}

var timeValues = [];
var timeLabels = [];

function setTimeValues(local, utc){

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
    if(hour > 12){
        return (hour - 12) + 'pm';
    }else if(hour == 12) {
        return hour + 'pm';
    }
    else{
        return hour + 'am';
    }

}

t = []; //temperature
h = []; // humidity
m = []; //moisture
w = []; //water flow
s = []; //watering status
function getAveragesPerHour(){


    var hourIndex = 0;
    var currentHour = timeValues[hourIndex];

    gardenDataLast13.forEach(data => function(){






    })


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
    field.innerHTML = "Latest Reading: "+ latest.temperature + "F";
}
function setHumidData(field) {
    field.innerHTML = "Latest Reading: " + latest.humidity;
}
function setwaterFlowData(field) {
    field.innerHTML = "Latest Reading: " + latest.waterFlow;

}
function setSoilData(field) {
    field.innerHTML = "Latest Reading: " + latest.soilMoisture;
}
function setwaterstatusData(field) {
    var msg = "Off";
    if (latest.waterActive) {
        msg = "On";
    }
    field.innerHTML = "Status: " + msg;
}

function setAllData(){
     dataFields.forEach(field => getInstanceData(field));
}




//=====================================================================chart data==========================================================================

var latest = {};
var defaultGarden = {};
//asynchronous function executes while doing its own thing
async function getDefaultGarden() {

    //gets username
    var user = window.sessionStorage.getItem("username");

    response = await fetch("api/v1/user_session/default_garden?username=" + user)
    defaultGarden = await response.json();
}

var gardens = [];

async function getAllGardens(){
    var user = window.sessionStorage.getItem("username");

    fetch("api/v1/user_session/get_gardens?username=" + user)
        .then(response => response.json())
        .then(data => console.log(data))
//        .then(data => data.forEach(garden => gardens.push(garden)));


}


function getLatest() {

    var body = { "gardenId": defaultGarden.gardenId };
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

        }
    });

}


function populateGardenList() {
    var list = document.getElementById("gardenId");
    //editing the options to dynamically add the name of the garden, based on ID of the garden
    list.innerHTML = generateOption(defaultGarden.gardenId, defaultGarden.gardenName);
    gardens.forEach(garden => function () {
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

$('document').ready(function () {
  //do this for async functions, basically to wait for them to finish execution since they make fetch calls
    getDefaultGarden()
        .then(response => getAllGardens())
        .then(response2 => populateGardenList())
        .then(res3 => getLatest())
        .then(res4 => getLast13Hours());

})

async function logout() {
    var response = await fetch("api/v1/user_session/logout");



    document.location.href="/";
    window.sessionStorage.clear();
}