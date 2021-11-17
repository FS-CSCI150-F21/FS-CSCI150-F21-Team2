$('document').ready(

    getDefaultGardenId();

    if(checkForDefault()){
         // make call to server to get latest data
            getLatestData();
            // make call to get range of data for last 13 hours
            getLast13hours();
            // store result in a const


    }else {

        //display something saying no garden or no data
    }

)



function makeChart(type){

    switch(type) {

        case 'Temperature':
            //call makeTempGraph
            break;
        case 'Humidity' :
            // call makeHumidGraph
            break;

    }

}

function getLatest(){
    var gettingRange = $.ajax({
        type: 'GET',
        url: 'api/v1/farden_data_collection/range',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            //var current = jQuery.parseJSON(data);
            var values = data;
            console.log(obj);
        },
        error: function (xhr, status, error) {

        }
    });
    //get request to a api string
    // store data
    return gettingRange;
}

function getLast13hours(){

    // get request with a body
}

function translateTemp(timeData) {
    const time[];
    if (timeData == 12) {
        timeData = timeData + "pm";
    }
    else if (timeData > 12) {
        timeData = (timeData - 12) + "pm";
    }
    else () {
        timeData = timeData + "am";
    }
    return time.push(timeData);
}

function celToFaren(temperature) {
    var faren = (temperature * (9 / 5)) + 32
    return faren;
}