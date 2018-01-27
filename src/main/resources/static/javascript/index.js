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

function myFunction() {

    $.ajax({
        type: "POST",
        url: 'localhost:8080/user/register',
        data: {

            "email": "test@test.test",
            "firstName": "Test",
            "lastName": "Test",
            "password": "123",
            "phoneNumber": "123123123"
        }
    }).then(function() {
        alert(" :"+id+con);

    });

};
function loginFunction() {


        if(document.getElementById("loginEmail").value == "robcio@buziaczek.pl"){
            if(document.getElementById("loginPsw").value == "robcio"){
                alert("login as: "+document.getElementById("loginEmail").value);
                location.href = "http://localhost:8080/order.html";
            };
        };


};