<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/testPdf.js"></script>
<script type="text/javascipt" src="js/bootstrap.js"> </script>

<link href='<c:url value="/resources/css/PDF.css"></c:url>'
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script type="text/javascipt" src="js/bootstrap.js"> </script>

<title>AdminProdPage</title>
</head>
<body>

	<nav class="navbar navbar-default" style="background-color: orange;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">HNB</a>
			</div>
			<ul class="nav navbar-nav">
				<li role="presentation" class="active"><a
					href="${pageContext.request.contextPath}/produit/afficheAjoutProd"
					style="color: white">Ajouter produit</a></li>

			</ul>
		</div>
	</nav>

	<h1>${message}</h1>

	<div class="panel-heading">
		<h2 style="text-align: center" class="text-center">Liste Des
			Produits</h2>
	</div>
	<form> 
	<div id="dvContainer">
	<div class="panel-body">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<td class="text-center"><strong>Id Produit </strong></td>
						<td class="text-center"><strong>Designation du
								produit </strong></td>
						<td class="text-center"><strong>Description du
								produit </strong></td>
						<td class="text-center"><strong>Prix </strong></td>
						<td class="text-center"><strong>Quantité du produit
						</strong></td>
						<td class="text-center"><strong>Image</strong></td>
					</tr>
				</thead>
				<c:forEach var="prod" items="${listeProd}">
					<tbody>
						<tr>
							<td>${prod.id_produit}</td>
							<td>{prod.designation}</td>
							<td>${prod.description}</td>
							<td>${prod.prix}</td>
							<td>${prod.quantite}</td>
							<td><img alt=""
								src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}"></td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script>
	$(document).ready(function() {
		$("#btnPrint").on(
				"click",
				function() {
					var conceptStore = $("#dvContainer").html();
					var printWindow = window.open('', '',
							'height=400,width=800');
					printWindow.document
							.write('<html><head><title>ConceptStore</title>');
					
					printWindow.document.write('</head><body >');
					printWindow.document.write(conceptStore);
					printWindow.document.write('</body></html>');
					printWindow.document.close();
					printWindow.print();
				});
			});
	</script>
</div>
	<input type="button" value="Enregistrer facture" id="btnPrint"
		style="position: absolute; width: 20%; left: 40%" />
</form>


</body>
</html>