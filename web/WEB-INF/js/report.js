$(window).load(function () {

    $('.reportBtn').on('click', function () {
        
        $("#canvas").css("display","inline-block");
        var rawText = $("#sectorDescription").val();

        var data = getValues(getInfo(rawText));

        var canvas = document.getElementById('canvas');
        var ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.lineWidth = 1;
        ctx.fillStyle = "black";
        //оси
        ctx.moveTo(25, 325);
        ctx.lineTo(540, 325);
        ctx.lineTo(535, 320);
        ctx.moveTo(540, 325);
        ctx.lineTo(535, 330);
        ctx.stroke();

        ctx.moveTo(25, 325);
        ctx.lineTo(25, 10);
        ctx.lineTo(20, 15);
        ctx.moveTo(25, 10);
        ctx.lineTo(30, 15);
        ctx.stroke();
        // оси конец

        for (var i = 325, num = 0; i >= 15; i -= 30, num += 10) {
            ctx.fillText(num, 5, i);
        }

        ctx.fillStyle = "lightgreen";
        ctx.fillRect(51, 325, 40, -data[0] * 3);
        ctx.fillRect(167, 325, 40, -data[2] * 3);
        ctx.fillRect(283, 325, 40, -data[4] * 3);
        ctx.fillRect(399, 325, 40, -data[6] * 3);
        ctx.fillRect(30, 355, 10, 10);

        ctx.fillStyle = "black";
        ctx.fillText(data[0] + "%", 51 + 10, 355 - 30 - data[0] * 3 - 5);
        ctx.fillText(data[1] + "%", 51 + 40 + 10, 355 - 30 - data[1] * 3 - 5);
        ctx.fillText(data[2] + "%", 167 + 10, 355 - 30 - data[2] * 3 - 5);
        ctx.fillText(data[3] + "%", 167 + 40 + 10, 355 - 30 - data[3] * 3 - 5);
        ctx.fillText(data[4] + "%", 283 + 10, 355 - 30 - data[4] * 3 - 5);
        ctx.fillText(data[5] + "%", 323 + 10, 355 - 30 - data[5] * 3 - 5);
        ctx.fillText(data[6] + "%", 399 + 10, 355 - 30 - data[6] * 3 - 5);
        ctx.fillText(data[7] + "%", 439 + 10, 355 - 30 - data[7] * 3 - 5);
        ctx.fillText("optimal %", 50, 363);
        ctx.fillText("real %", 170, 363);

        ctx.fillText("Humus", 75, 345);
        ctx.fillText("Acid", 198, 345);
        ctx.fillText("N", 315, 345);
        ctx.fillText("P", 440, 345);

        ctx.fillStyle = "dodgerblue";
        ctx.fillRect(91, 325, 40, -data[1] * 3);
        ctx.fillRect(207, 325, 40, -data[3] * 3);
        ctx.fillRect(323, 325, 40, -data[5] * 3);
        ctx.fillRect(439, 325, 40, -data[7] * 3);
        ctx.fillRect(150, 355, 10, 10);
        
canvas.toBlob(function(blob) {
    saveAs(blob, "pretty image.png");
});
    });

});

function getInfo(text) {
    return text.slice(text.indexOf(":") + 3, text.length);
}

function getValues(text) {
    var array = text.split("\n"); //5 строк, надо взять 4
    var humus = array[0].split(" ");
    var acidity = array[1].split(" ");
    var nitro = array[2].split(" ");
    var phosp = array[3].split(" ");

    var values = [];
    values[0] = humus[3].slice(0, -1);
    values[1] = humus[5].slice(0, -1);
    values[2] = acidity[3].slice(0, -1);
    values[3] = acidity[5].slice(0, -1);
    values[4] = nitro[3].slice(0, -1);
    values[5] = nitro[5].slice(0, -1);
    values[6] = phosp[3].slice(0, -1);
    values[7] = phosp[5].slice(0, -1);

    return values;
}
