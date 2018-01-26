setTimeout(
    function()
    {


        document.getElementById("order-txt").innerHTML = "You order is being prepared!";
        document.getElementById("order-txt2").innerHTML = "Delivery time: ~30min";
        document.getElementById("img-load").src="success.png";
    }, 5000);


$(document).ready(function() {
    $.ajax({
        url: "https://reqres.in/api/users/2"
    }).then(function(data) {
        $('.greeting-id').append(data.data.id);

        $('.greeting-content').append(data.data.last_name);

    });
});

