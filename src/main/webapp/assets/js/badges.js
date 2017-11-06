$('#range').on("change", function() {
    $('.output').val(this.value +" puntos!" );
    }).trigger("change");

function showTable(id){
	document.getElementById(id).style.display = "block"; 
}