$(document).ready(function() {
			$("#btnPrint").on("click",function() {
				var conceptStore = $("#dvContainer").html();
				var printWindow = window.open('','_blank','height=400,width=800');
				//ecrire le html dans la nouvelle fenêtre
				printWindow.document.write('<html><head><title>ConceptStore</title>');
			    printWindow.document.write('<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" absolute = true>');

				printWindow.document.write('</head><body>');
				
				 // Add the stylesheet link and inline styles to the new document:
			    printWindow.document.write('<link rel="stylesheet" href="resources/css/styleFich.css">');
			    
				printWindow.document.write(conceptStore);
				printWindow.document.write('</body></html>');
				printWindow.document.close();
				printWindow.print();
			});
});
