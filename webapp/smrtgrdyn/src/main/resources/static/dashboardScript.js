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

    //get request to a api string
    // store data
}

function getLast13hours(){

    // get request with a body
}

