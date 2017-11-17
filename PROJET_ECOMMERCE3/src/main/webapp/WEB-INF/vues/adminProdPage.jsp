<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='<c:url value="/resources/css/bootstrap.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/bootstrap-theme.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/style.css"></c:url>'
	rel="stylesheet" />
	<link href='<c:url value="/resources/css/styleFich.css"></c:url>'
	rel="stylesheet" />
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-3.2.1.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/java.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/scriptFich.js"></c:url>'></script>
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


	<form>

		<div class="panel-heading">
			<h2 style="text-align: center" class="text-center">Liste Des
				Produits</h2>
		</div>

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
								<td class="text-center"><strong>Quantité du
										produit </strong></td>
								<td class="text-center"><strong>Image</strong></td>
							</tr>
						</thead>
						<c:forEach var="prod" items="${listeProd}">
							<tbody>
								<tr>
									<td class="text-center">${prod.id_produit}</td>
									<td class="text-center">${prod.designation}</td>
									<td class="text-center">${prod.description}</td>
									<td class="text-center">${prod.prix}</td>
									<td class="text-center">${prod.quantite}</td>
									<td class="text-center"><img alt=""
										src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}" /></td>
								</tr>
						</c:forEach>
					</table>
				</div>
			</div>

		
		</div>
		<input type="button" value="Enregistrer facture" id="btnPrint"
			style="position: absolute; width: 20%; left: 40%" />
	</form>


</body>
</html>