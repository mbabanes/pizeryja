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
    alert(" :"+id+con);
}