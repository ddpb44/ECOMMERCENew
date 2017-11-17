jQuery(document).ready(function($) {
	$("#btnPrint").on("click", function() {
		var conceptStore = $("#dvContainer").html();
		var printWindow = window.open('', '', 'height=400,width=800');
		printWindow.document.write('<html><head><title>ConceptStore</title>');
		printWindow.document.write('</head><body >');
		printWindow.document.write(conceptStore);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		printWindow.print();
	});
});