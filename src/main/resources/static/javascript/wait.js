setTimeout(
    function()
    {

        var x = Math.floor((Math.random() * 30) + 30)
        document.getElementById("order-txt").innerHTML = "You order is being prepared!";
        document.getElementById("order-txt2").innerHTML = "Delivery time: ~"+ x +"min";
        document.getElementById("img-load").src="../images/success.png";
    }, 5000);



