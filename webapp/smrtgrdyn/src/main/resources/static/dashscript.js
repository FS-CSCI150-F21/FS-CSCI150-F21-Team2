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

    var xVals = ["8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm",];
    var yVals = [30, 40, 80, 60, 70, 80, 60, 110, 80];

    return newChart("tempChart", "temperature", xVals, yVals);
}

function getHumidChart(){

    var xVals = ["8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm",];
    var yVals = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14];

    return newChart("humidChart", "Humidity", xVals, yVals);
}

function getWaterFlowChart(){

    var xVals = ["8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm",];
    var yVals = [1,2,3,4,5,6,7, 8, 8, 9, 9, 9, 10, 11, 14, 14, 15];

    return newChart("waterFlowChart", "Water Usage", xVals, yVals);
}

function getMoistureChart(){

    var xVals = ["8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm",];
    var yVals = [1,2,3,4,5,6,7, 8, 8, 9, 9, 9, 10, 11, 14, 14, 15];

    return newChart("moistureChart", "Soil Moisture", xVals, yVals)
}

function getwaterStatusChart(){

    var xVals = ["8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm",];
    var yVals = [0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0,1];

    return newChart("waterStatusChart", "Watering Status", xVals, yVals)
}

function newChart(ctx, dlabel, xVals, yVals){


    new Chart(ctx, {
            type: "bar",
            data: {
                labels: xVals,
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

const latest = {};
var defaultGarden = {};
//asynchronous function executes while doing its own thing
async function getDefaultGarden() {

    //gets username
    var user = window.sessionStorage.getItem("username");

    response = await fetch("api/v1/user_session/default_garden?username=" + user)
    defaultGarden = await response.json();

    console.log(defaultGarden);

}

var gardens = [];

async function getAllGardens(){
    var user = window.sessionStorage.getItem("username");

        fetch("api/v1/user_session/get_gardens?username=" + user)
          .then(response => response.json())
          .then(data => data.forEach(garden => gardens.push(garden)))
        
}

function getLatest(){

    var gettingRange = $.ajax({
        type: 'post',
        url: 'api/v1/garden_data_collection/latest',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(body),
        success: function (response) {
            latest = response;
            var values = response;
            console.log(values);
        },
        error: function (xhr, status, error) {

        }
    });

}

function populateGardenList() {
    var list = document.getElementById("gardenId");
    //editing the otpions to dynamically add the name of the garden, based on ID of the garden
    list.innerHTML = generateOption(defaultGarden.gardenId, defaultGarden.gardenName);
    gardens.forEach(garden => function () {
        if (garden.gardenId !== defaultGarden.gardenId) {
            //makes sure default garden isnt in there twice by chekcing its id
            list.innerHTML += generateOption(garden.gardenId, garden.gardenName)
    }
    })
}
//modularizing the previouse 
function generateOption(gardenId, gardenName) {
    return '<option value="' + gardenId + '">' + gardenName + '</option>';
}

