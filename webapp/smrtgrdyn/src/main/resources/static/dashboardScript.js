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
            var tempArray[];
            tempArray.push(faren);
            break;
        case 'Humidity' :
            // call makeHumidGraph
            break;

    }

}

const latest = {};

function getLatest(){
<<<<<<< HEAD

    // get request to a api string
=======
    var gettingRange = $.ajax({
        type: 'GET',
        url: 'api/v1/farden_data_collection/latest',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            //var current = jQuery.parseJSON(data);
            latest = response.responseJSON;
            console.log(obj);
        },
        error: function (xhr, status, error) {

        }
    });
    //get request to a api string
>>>>>>> 6c5220229d25f9dc4fa8b3a6d88191f4efe05f88
    // store data
    return gettingRange;
}

function getLast13hours(){

    // get request with a body
}

function translateTime(timeStamp) {
    if (timeStamp == 12) {
        timeStamp = timeStamp + "pm";
    }
    else if (timeStamp > 12) {
        timeStamp = (timeStamp - 12) + "pm";
    }
    else () {
        timeStamp = timeStamp + "am";
    }
    return time.push(timeStamp);
}

function celToFaren(temperature) {
    var faren = (temperature * (9 / 5)) + 32
    return faren;
}