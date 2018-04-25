$(document).ready(function(){
   
   var cookie = (document.cookie);
   if (cookie.indexOf("length-login")!==-1){
            $("#length-login").css("display","inline-block");
            $("#symbol-login").css("display","none");
            deleteCookie("length-login");
        }  else if (cookie.indexOf("symbol-login")!==-1){
            $("#symbol-login").css("display","inline-block");
            $("#length-login").css("display","none");
            deleteCookie("symbol-login");
        } else  {
            $("#length-login").css("display","none");
            $("#symbol-login").css("display","none");
    }
        
    if (cookie.indexOf("length-password")!==-1){
            $("#length-password").css("display","inline-block");
            $("#symbol-password").css("display","none");
            deleteCookie("length-password");
        }  else if (cookie.indexOf("symbol-password")!==-1){
            $("#symbol-password").css("display","inline-block");
            $("#length-password").css("display","none");
            deleteCookie("symbol-password");
        } else  {
            $("#length-password").css("display","none");
            $("#symbol-password").css("display","none");
        }  
        
    if (cookie.indexOf("length-mail")!==-1){
            $("#length-mail").css("display","inline-block");
            $("#symbol-mail").css("display","none");
            deleteCookie("length-mail");
        }  else if (cookie.indexOf("symbol-mail")!==-1){
            $("#symbol-mail").css("display","inline-block");
            $("#length-mail").css("display","none");
            deleteCookie("symbol-mail");
        } else  {
            $("#length-mail").css("display","none");
            $("#symbol-mail").css("display","none");
        }   
        
    if (cookie.indexOf("length-position")!==-1){
            $("#length-position").css("display","inline-block");
            $("#symbol-position").css("display","none");
            deleteCookie("length-position");
        }  else if (cookie.indexOf("symbol-position")!==-1){
           $("#symbol-position").css("display","inline-block");
           $("#length-position").css("display","none");
           deleteCookie("symbol-position");
        } else  {
           $("#length-position").css("display","none");
           $("#symbol-position").css("display","none");
        }    
    
    if (cookie.indexOf("length-name")!==-1){
            $("#length-name").css("display","inline-block");
            $("#symbol-name").css("display","none");
             deleteCookie("length-name");
        }  else if (cookie.indexOf("symbol-name")!==-1){
            $("#symbol-name").css("display","inline-block");
            $("#length-name").css("display","none");
           deleteCookie("symbol-name");
        } else  {
            $("#length-name").css("display","none");
            $("#symbol-name").css("display","none");
        }
        
    if (cookie.indexOf("length-surname")!==-1){
           $("#length-surname").css("display","inline-block");
            $("#symbol-surname").css("display","none");
            deleteCookie("length-surname");
        }  else if (cookie.indexOf("symbol-surname")!==-1){
            $("#symbol-surname").css("display","inline-block");
            $("#length-surname").css("display","none");
            deleteCookie("symbol-surname");
        } else  {
           $("#length-surname").css("display","none");
            $("#symbol-surname").css("display","none");
        }
        
    if (cookie.indexOf("length-about")!==-1){
            $("#length-about").css("display","inline-block");
            $("#symbol-about").css("display","none");
            deleteCookie("length-about");
        }  else if (cookie.indexOf("symbol-about")!==-1){
            $("#symbol-about").css("display","inline-block");
            $("#length-about").css("display","none");
            deleteCookie("symbol-about");
        } else  {
            $("#length-about").css("display","none");
            $("#symbol-about").css("display","none");
        }  
   
    $('.createProfileBtn').on("click", function(){    
    var filterUsername  = /^([a-zA-Z0-9_\-])+$/;
    var filterPassword = /^[a-zA-Z0-9!%&#$\^*?_~+]+$/;
    var filterMail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var filter = /[a-zA-Z0-9!%@&#$\^*?_~+]/;
    
    var login = $("#createlogin").val();
    var password = $("#createpassword").val();
    var mail = $("#createmail").val();
    var position = $("#createposition").val();
    var name = $("#createname").val();
    var surname = $("#createsurname").val();
    var about = $("#createabout").val();
    
    
    if (login == '' || login.length>45){
            //$("#length-login").css("display","inline-block");
            //$("#symbol-login").css("display","none");
            setCookie("length-login", "1");
        }  else if (!filterUsername.test(login)){
            //$("#symbol-login").css("display","inline-block");
            //$("#length-login").css("display","none");
           setCookie("symbol-login", "1");
        } else  {
            //$("#length-login").css("display","none");
            //$("#symbol-login").css("display","none");
        } 
        
    if (password == '' || password.length>45){
            //$("#length-password").css("display","inline-block");
            //$("#symbol-password").css("display","none");
            setCookie("length-password", "1");
        }  else if (!filterPassword.test(password)){
            //$("#symbol-password").css("display","inline-block");
           // $("#length-password").css("display","none");
            setCookie("symbol-password", "1");
        } else  {
            //$("#length-password").css("display","none");
            //$("#symbol-password").css("display","none");
            //createCookie=false;
        }  
        
    if (mail == '' || mail.length>45){
            //$("#length-mail").css("display","inline-block");
            //$("#symbol-mail").css("display","none");
            setCookie("length-mail", "1");
        }  else if (!filterMail.test(mail)){
            //$("#symbol-mail").css("display","inline-block");
            //$("#length-mail").css("display","none");
            setCookie("symbol-mail", "1");
        } else  {
            //$("#length-mail").css("display","none");
            //$("#symbol-mail").css("display","none");
            //createCookie=false;
        }   
        
    if (position == '' || position.length>45){
            //$("#length-position").css("display","inline-block");
            //$("#symbol-position").css("display","none");
            setCookie("length-position", "1");
        }  else if (filter.test(position)){
            //$("#symbol-position").css("display","inline-block");
           // $("#length-position").css("display","none");
            setCookie("symbol-position", "1");
        } else  {
            //$("#length-position").css("display","none");
           // $("#symbol-position").css("display","none");
            //createCookie=false;
        }    
    
    if (name == '' || name.length>45){
            //$("#length-name").css("display","inline-block");
            //$("#symbol-name").css("display","none");
            setCookie("length-name", "1");
        }  else if (filter.test(name)){
            //$("#symbol-name").css("display","inline-block");
            //$("#length-name").css("display","none");
            setCookie("symbol-name", "1");
        } else  {
            //$("#length-name").css("display","none");
            //$("#symbol-name").css("display","none");
           // createCookie=false;
        }
        
    if (surname == '' || surname.length>45){
           // $("#length-surname").css("display","inline-block");
            //$("#symbol-surname").css("display","none");
            setCookie("length-surname", "1");
        }  else if (filter.test(surname)){
            //$("#symbol-surname").css("display","inline-block");
            //$("#length-surname").css("display","none");
           setCookie("symbol-surname", "1");
        } else  {
           // $("#length-surname").css("display","none");
            //$("#symbol-surname").css("display","none");
            //createCookie=false;
        }
        
    if (about === '' || about.length>255){
            //$("#length-about").css("display","inline-block");
            //$("#symbol-about").css("display","none");
            setCookie("length-about", "1");
        }  else if (filter.test(about)){
            //$("#symbol-about").css("display","inline-block");
            //$("#length-about").css("display","none");
           setCookie("symbol-about", "1");
        } else  {
            //$("#length-about").css("display","none");
            //$("#symbol-about").css("display","none");
            //createCookie=false;
        }     
    });
 });   
    
    
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
    






