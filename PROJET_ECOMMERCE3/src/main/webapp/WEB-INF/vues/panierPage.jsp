<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<link href='<c:url value="/resources/css/bootstrap.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/bootstrap-theme.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/styleFich.css"></c:url>'
	rel="stylesheet" />
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-3.2.1.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/scriptFich.js"></c:url>'></script>
<link href='<c:url value="/resources/css/style.css"></c:url>'
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Indie+Flower"
	rel="stylesheet">

<title>Panier</title>
</head>
<body>


	<!-- =====================Recapitulatif du panier============================= -->

	<form>
		<nav>
		<div>
			<div>
				<h5>
					<a
						href="<c:url value="${pageContext.request.contextPath}/blabla" />">Se
						d�connecter</a>
				</h5>
			</div>
			<div>
				<h5>
					<a
						href="<c:url value="/client/pageClient" />">
						Catalogue produit</a>
				</h5>
			</div>
		</div>
		</nav>
		<div>
			<h2 style="text-align: center" class="text-center">Panier</h2>
		</div>
		<div id="dvContainer">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<td class="text-center"><strong>Id Produit </strong></td>
								<td></td>
								<td class="text-center"><strong>Designation du
										produit </strong></td>
								<td></td>
								<td class="text-center"><strong>Description du
										produit </strong></td>
								<td></td>
								<td class="text-center"><strong>Prix </strong></td>
								<td></td>
								<td class="text-center"><strong>Quantit� du
										produit </strong></td>
								<td></td>
								<td class="text-center"><strong>Etat</strong></td>
								<td></td>
								<td class="text-center"><strong>Image</strong></td>
							</tr>
						</thead>
						<c:forEach var="prod" items="${listeProd}">
							<tbody>
								<tr>
									<td class="text-center">${prod.id_produit}</td>
									<td></td>
									<td class="text-center">${prod.designation}</td>
									<td></td>
									<td class="text-center">${prod.description}</td>
									<td></td>
									<td class="text-center">${prod.prix}</td>
									<td></td>
									<td class="text-center">${prod.quantite}</td>
									<td></td>
									<td class="text-center">${prod.valide}</td>
									<td></td>
									<td class="text-center"><img alt=""
										src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}" /></td>
									<td></td>

								</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>

	<f:form
		action="${pageContext.request.contextPath}/ligneCommande/ValideLigneCommandeViaLien"
		method="GET">
		<button class="btn btn-primary" type="submit">Valider le
			panier</button>
	valide la commande + redirection vers le recapitulatif panier

</f:form>
</body>
</html>