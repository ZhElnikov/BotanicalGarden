$(document).ready(function () {
    $('.aproveBtn').on('click', function (event) {
        disable(event);
    });
    
    $('.declineBtn').on('click', function (event) {
        disable(event);
    });
});


function disable(event){  
    var id = (event.target.id).slice(10);    
    $('#panelid'+id).css('background-color', 'silver');
    $('#approvebtn'+id).css('background-color', 'darkseagreen');
    $('#declinebtn'+id).css('background-color', 'lightgrey');
    $('#approvebtn'+id).attr("disabled", true);
    $('#declinebtn'+id).attr("disabled", true);
    $('#textareaid'+id).css('background-color', 'whitesmoke');
    $('#textareaid'+id).css('color', 'gray');   
    $('#purposeid'+id).css('background-color', 'whitesmoke');
    $('#purposeid'+id).css('color', 'gray');
    $('#amountid'+id).css('background-color', 'whitesmoke');
    $('#amountid'+id).css('color', 'gray');
}

