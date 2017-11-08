$('#range').on("change", function() {
    $('.output').val(this.value +" puntos!" );
    }).trigger("change");


function showCreateForm() {
    var x = document.getElementById("creatBadge-form");
    if (x.style.display === "none") {
        x.style.display = "flex";
    } else {
        x.style.display = "none";
    }
}

function showBadgesTable() {
    var x = document.getElementById("badgesTable");
    if (x.style.display === "none") {
        x.style.display = "show";
    } else {
        x.style.display = "none";
    }
}

