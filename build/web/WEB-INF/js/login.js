$(document).ready(function(){
console.log(document.cookie);


var response1 = document.cookie;
if((response1).indexOf("error")!==-1 && (response1).indexOf("-1")!==-1){
   showError("invalid data! ",50);
   //showError("0 |_|_| |/| 6 K A",50);
   deleteCookie("errorCookie");
 }
    $('.bigButton').on("click", function(){
    var response = document.cookie;
    if(response.indexOf("-1")!==-1){
    setCookie("errorCookie", "error");   
    //console.log(document.cookie);
}
});
 });   
    
    //console.log(document.cookie);

function deleteCookie(name) {
  setCookie(name, "", {
    expires: -1
  });
}
function setCookie(name, value, options) {
  options = options || {};

  var expires = options.expires;

  if (typeof expires == "number" && expires) {
    var d = new Date();
    d.setTime(d.getTime() + expires * 1000);
    expires = options.expires = d;
  }
  if (expires && expires.toUTCString) {
    options.expires = expires.toUTCString();
  }

  value = encodeURIComponent(value);

  var updatedCookie = name + "=" + value;

  for (var propName in options) {
    updatedCookie += "; " + propName;
    var propValue = options[propName];
    if (propValue !== true) {
      updatedCookie += "=" + propValue;
    }
  }
  document.cookie = updatedCookie;
}
var timer = null;

function hideError(){


    if (timer !== null){
        window.clearTimeout(timer);
    }

    timer = window.setTimeout(function(){
        $('.error-holder').fadeOut();
    }, 5000);
}

function showPopup(text, top, success) {

    if (success) {
        $('.error-holder').addClass('error-holder-success');
    } else {
        $('.error-holder').removeClass('error-holder-success');
    }
    $('.error-holder').css({"top":"" + top + "px", "z-index":"999999"});
    $('.error-holder span').text(text);

    $('.error-holder').fadeIn(function(){
        hideError();
    });
}

function showError(text, top){

    showPopup(text, top, false);
}

function showSuccess(text, top){

    showPopup(text, top, true);
}

$(document).ready(function(){

    $('.error-holder').on("click", function(){
        $(this).fadeOut();
    });

});