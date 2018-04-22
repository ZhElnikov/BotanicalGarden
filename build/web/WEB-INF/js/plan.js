$(document).ready(function () {
    $('.completeBtn').on('click', function (event) {
     var self =  $(this);
        disable(self,event);
    });
    
    $('.deleteBtn').on('click', function (event) {
     var self =  $(this);
        disable(self,event);
    });
});


function disable(self,event){
    self.attr("disabled", true);
    self.css('background-color', 'lightgrey');
    var id = (event.target.id).slice(8);
    
    $('#panelid'+id).css('background-color', 'silver');
    $('#textareaid'+id).css('background-color', 'whitesmoke');
    $('#textareaid'+id).css('color', 'gray');   
    
}