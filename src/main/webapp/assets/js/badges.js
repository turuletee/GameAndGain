$('#range').on("change", function() {
    $('.output').val(this.value +" puntos!" );
    }).trigger("change");