var modal = document.getElementById('id01');
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
var id;
var con;
$(document).ready(function() {


    $.ajax({
        url: "http://localhost:8080/pizza/all"
    }).then(function(data) {
        console.log(data[0].name);

    });
});
var markers=[{
    "confirmPassword": "123",
    "email": "test@test.te",
    "firstName": "test",
    "lastName": "test",
    "password": "123",
    "phoneNumber": "123123123"
}];
function myFunction() {
    $.ajax({
        type: "POST",
        url: "localhost:8080/user/register",

        data: {

            "confirmPassword": "abc",
            "email": "abc@ac.abc",
            "firstName": "abc",
            "lastName": "abc",
            "password": "abc",
            "phoneNumber": "123333123"

        },
        contentType: "application/json"
    });

};
function myFunction2() {
    $.ajax
    ({
        type: "POST",
        url: 'localhost:8080/user/register',
        dataType: 'json',
        data: JSON.stringify({

                "confirmPassword": "abc",
                "email": "abc@ac.abc",
                "firstName": "abc",
                "lastName": "abc",
                "password": "abc",
                "phoneNumber": "123333123"

            }),
        contentType: 'application/json',
        success: function () {

            alert("Thanks!");
        }
    })
};
function loginFunction() {


        if(document.getElementById("loginEmail").value == "robcio@buziaczek.pl"){
            if(document.getElementById("loginPsw").value == "robcio"){
                alert("login as: "+document.getElementById("loginEmail").value);
                location.href = "http://localhost:8080/order.html";
            };
        };


};