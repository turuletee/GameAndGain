$("#slideshow > div:gt(0)").hide();

setInterval(function() { 
  $('#slideshow > div:first')
    .fadeOut(1000)
    .next()
    .fadeIn(1000)
    .end()
    .appendTo('#slideshow');
},  3000);

$("#slideshow-bene > div:gt(0)").hide();

setInterval(function() { 
  $('#slideshow-bene > div:first')
    .fadeOut(1000)
    .next()
    .fadeIn(1000)
    .end()
    .appendTo('#slideshow-bene');
},  3000);


function contentMenu(){
    document.getElementById("myDropdown").classList.toggle("show");
    
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.menu_bar-link')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('flex')) {
        openDropdown.classList.remove('flex');
      }
    }
  }
}