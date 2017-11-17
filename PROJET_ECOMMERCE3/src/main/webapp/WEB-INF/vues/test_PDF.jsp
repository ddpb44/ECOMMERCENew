<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
	<form id="form1">
	<div id="dvContainer">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="text-center">
						<i class="fa fa-search-plus pull-left icon"></i>
						<h3 style="text-align: center">Numéro de la commande:</h3>
					</div>
					<hr />
					<div class="row">
						<div class="col-xs-12 col-md-3 col-lg-3 pull-left">
							<div class="panel panel-default height">
								<div class="panel-heading">
									<strong>Informations sur le client</strong>
								</div>
								<div class="panel-body">
									Nom : <br /> Adresse : <br /> Telephone : <br />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-3 col-lg-3">
							<div class="panel panel-default height">
								<div class="panel-heading">
									<strong>Informations de paiement</strong>
								</div>
								<div class="panel-body">
									Card Name: Visa<br /> Card Number: ***** 332<br /> Exp Date:
									09/2020<br />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-3 col-lg-3">
							<div class="panel panel-default height">
								<div class="panel-heading">
									<strong>Preferences</strong>
								</div>
								<div class="panel-body">
									Gift: No <br /> Express Delivery : Yes <br /> Insurance: No <br />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-3 col-lg-3 pull-right">
							<div class="panel panel-default height">
								<div class="panel-heading">
									<strong>Adresse de facturation</strong>
								</div>
								<div class="panel-body">
									Nom : <br /> Adresse : <br /> telephone : <br />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 style="text-align: center" class="text-center">
								<strong>Commande en cours</strong>
							</h3>
						</div>
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
											<td class="text-center"><strong>Quantité du
													produit </strong></td>
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
													src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}"/></td>
											</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$("#btnPrint").on("click",function() {
				var conceptStore = $("#dvContainer").html();
				var printWindow = window.open('', '','height=400,width=800');
					printWindow.document.write('<html><head><title>ConceptStore</title>');
					printWindow.document.write('</head><body >');
					printWindow.document.write(conceptStore);
					printWindow.document.write('</body></html>');
					printWindow.document.close();
					printWindow.print();
				});
			});
	</script>

	<input type="button" value="Enregistrer facture" id="btnPrint"
		style="position: absolute; width: 20%; left: 40%" />
</form>


</body>
</html>