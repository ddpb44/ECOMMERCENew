$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
  
  $("#myInputPro").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTableProd tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
  
  $("#searchProduitAdminPro").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#produitAdminPro tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
});