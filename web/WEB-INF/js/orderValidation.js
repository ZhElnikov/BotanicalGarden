$(document).ready(function () {
    var cookie = (document.cookie);

    if (cookie.indexOf("length-amount") !== -1) {
        $("#length-amount").css("display", "inline-block");
        deleteCookie("length-amount");
    } else if (cookie.indexOf("symbol-amount") !== -1) {
        $("#symbol-amount").css("display", "inline-block");
        deleteCookie("symbol-amount");
    } else {
        $("#length-amount").css("display", "none");
        $("#symbol-amount").css("display", "none");
    }

    if (cookie.indexOf("length-area") !== -1) {
        $("#length-area").css("display", "inline-block");
        ;
        deleteCookie("length-area");
    } else if (cookie.indexOf("symbol-area") !== -1) {
        $("#symbol-area").css("display", "inline-block");
        ;
        deleteCookie("symbol-area");
    } else {
        $("#length-area").css("display", "none");
        $("#symbol-area").css("display", "none");
    }


    if (cookie.indexOf("length-name") !== -1) {
        $("#length-name").css("display", "inline-block");
        deleteCookie("length-name");
    } else if (cookie.indexOf("symbol-name") !== -1) {
        $("#symbol-name").css("display", "inline-block");
        deleteCookie("symbol-name");
    } else {

        $("#length-name").css("display", "none");
        $("#symbol-name").css("display", "none");
    }

    deleteCookie("valid");

    $('input[type=radio][name=type]').change(function () {

        var value = $('input[name=type]:checked', '#orderAddForm').val();
        if (value == "tree") {
            $(".inputName").css("display", "none");
            $(".dropName").css("display", "block");
        } else {
            $(".inputName").css("display", "inline-block");
            $(".dropName").css("display", "none");
        }
    });



    $('.bigButton').on("click", function () {
        var filter = /[a-zA-Z%@&#$\^?_~]/;

        var nameValid;
        var amountValid;
        var bodyValid;


        var amount = $("#q").val();

        if (amount === '' || amount.length > 45) {
            amountValid = false;
            setCookie("length-amount", "1");
        } else if (!isNumber(amount)) {
            amountValid = false;
            setCookie("symbol-amount", "1");
        } else {
            amountValid = true;
        }

        var body = $("#body").val();

        if (body == '' || body.length > 255) {
            bodyValid = false;
            setCookie("length-area", "1");
        } else if (filter.test(body)) {
            bodyValid = false;
            setCookie("symbol-area", "1");
        } else {
            bodyValid = true;
        }

        var value = $('input[name=type]:checked', '#orderAddForm').val();
        if (value !== "tree") {
            var name = $("#name").val();
            if (name == '' || name.length > 45) {
                nameValid = false;
                setCookie("length-name", "1");
            } else if (filter.test(name)) {
                nameValid = false;
                setCookie("symbol-name", "1");
            } else {
                nameValid = true;
            }
        }
        if (nameValid && amountValid && bodyValid)
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


function isNumber(s) {
    if (!isNaN(s) && Number(s) > 0) {
        return true;
    } else
        return false;
}
