$(document).ready(function(){
   
   var cookie = (document.cookie);
       
    if(cookie.indexOf("start-empty")!==-1)  {
      $("#start-empty").css("display","inline-block");
      deleteCookie("start-empty");
    } else {
      $("#start-empty").css("display","none");  
    }
    
    
    if (cookie.indexOf("length-price")!==-1){
        $("#length-price").css("display","inline-block");
      deleteCookie("length-price");
    } else if(cookie.indexOf("symbol-price")!==-1){
       $("#symbol-price").css("display","inline-block");
       deleteCookie("symbol-price");
    }else{
       $("#length-price").css("display","none");
       $("#symbol-price").css("display","none");
    }
    
    
    if(cookie.indexOf("end-empty")!==-1)  {
      $("#end-empty").css("display","inline-block");
      deleteCookie("end-empty");
    } else if(cookie.indexOf("end-today")!==-1){
      $("#end-today").css("display","inline-block");
      deleteCookie("end-today");  
    } else if(cookie.indexOf("wrong-interval")!==-1){
      $("#wrong-interval").css("display","inline-block");
      deleteCookie("wrong-interval");  
    } else {
      $("#end-empty").css("display","none"); 
      $("#end-today").css("display","none");
      $("#wrong-interval").css("display","none");
    }
    
    if (cookie.indexOf("length-area")!==-1){
           $("#length-area").css("display","inline-block");;
            deleteCookie("length-area");  
        }  else if (cookie.indexOf("symbol-area")!==-1){
          $("#symbol-area").css("display","inline-block");;
            deleteCookie("symbol-area"); 
        } else  {
           $("#length-area").css("display","none"); 
            $("#symbol-area").css("display","none");
        }
    
    deleteCookie("valid");   
   
    $('.createBtn').on("click", function(){    
    var filter = /[a-zA-Z0-9!%@&#$\^*?_~+]/;
    
    var startValid;
    var endValid;
    var areaValid;
    var priceValid;
    
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var price = $(".price-check").val();  
   
    if (startDate===''){
        startValid=false;
        setCookie("start-empty", "1");
    } else {
        startValid=true;
    }  
    
    if (price==='' || price.length>45){
        priceValid=false;
        setCookie("length-price", "1");
    } else if (!isNumber(price)){
        priceValid=false;
        setCookie("symbol-price", "1");
    } else{
        priceValid=true;
    }
    
    var today = (new Date);
    var difference = (Date.parse(today)-Date.parse(endDate))/3600/1000;          
    
    var start = Date.parse(startDate);
    var end = Date.parse(endDate);
    
    var diff = (end - start)/3600/1000;   
               
    if (endDate===''){
        endValid=false;
        setCookie("end-empty", "1");
    } else if (difference>24){
        endValid=false;
        setCookie("end-today", "1");
    } else if (diff<=0){
        endValid=false;
      setCookie("wrong-interval", "1");         
    } else {
        endValid=true;
    }
    
    var area=$("#body").val();
     
    if (area == '' || area.length>255){
            areaValid=false;
            setCookie("length-area", "1");
        }  else if (filter.test(area)){
            areaValid=false;
           setCookie("symbol-area", "1");
        } else  {
           areaValid=true;
        }      
       
    if( areaValid && endValid && startValid&& priceValid)
        setCookie("valid", "true");
        else 
        setCookie("valid", "false");
    console.log(document.cookie);
        
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
    
    
function isNumber(s){
    if (!isNaN(s) && Number(s)>0){
            return true;
    } else return false;    

    //return !isNaN(s) ? true: false;
}
    








