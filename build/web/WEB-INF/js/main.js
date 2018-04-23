$(window).load(function(){

    var winHeight = $(document).height();
    var step = 4;
    var timeToScroll = winHeight/step;

    $('.scrolltop').on('click', function(){

        $('html, body').animate({
            scrollTop: 0
        }, timeToScroll);
    });
    var pictToSet;
    var response = document.cookie;
    if(response.indexOf("tree")!==-1){
    pictToSet = (response.slice(23,32));
    deleteCookie("src");
    } 
    else {
     pictToSet="tree0.png";
    }
    $(".hint").attr("src",pictToSet);
    
    
    $('.linktree').on('click', function(event){     
    var name = "tree"+(event.target.id).slice(9)+".png";
    $(".hint").attr("src",name);    
    setCookie("src", name);
    //console.log(document.cookie);
    }); 
    
    $('.rect').on('mouseover', function(event){     
    var name = "tree"+(event.target.id).slice(9)+".png";
    $(".hint").attr("src",name);    
    });

    $('.rect').on('mouseleave', function(event){ 
    $(".hint").attr("src",pictToSet);
    });
});
function deleteCookie(name) {
  setCookie(name, "", {
    expires: -1
  })
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

