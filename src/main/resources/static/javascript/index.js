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
var abc=[{
    "confirmPassword": "123",
    "email": "test@test.te",
    "firstName": "test",
    "lastName": "test",
    "password": "123",
    "phoneNumber": "123123123"
}];
function myFunction2() {

    $.ajax({
        type: "POST",
        url: '/user/register',
        dataType: 'json',
        data: JSON.stringify({
            "confirmPassword": document.getElementById("regCPsw").value,
            "email": document.getElementById("regMail").value,
            "firstName": document.getElementById("regName").value,
            "lastName": document.getElementById("regSurname").value,
            "password": document.getElementById("regPsw").value,
            "phoneNumber": document.getElementById("regAddress").value

        }),
        contentType: 'application/json'

    })
    alert("Rejestracja poprawna!");
    document.getElementById("id02").style.display="none";
};
function myFunction() {
    var url = "/user/register";
    var params = "confirmPassword=123&email=test@test.te&firstName=test&lastName=test&password=123&phoneNumber=123123123";
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);

//Send the proper header information along with the request
    xhr.setRequestHeader("Content-type", "application/json");

    xhr.send(params);
};
function loginFunction() {


        if(document.getElementById("loginEmail").value == "robcio@buziaczek.pl"){
            if(document.getElementById("loginPsw").value == "robcio"){
                alert("login as: "+document.getElementById("loginEmail").value);
                location.href = "http://localhost:8080/order.html";
            };
        };


};