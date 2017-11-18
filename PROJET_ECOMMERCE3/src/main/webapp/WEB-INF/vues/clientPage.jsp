<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>page client</title>
</head>
<body>

	<!-- =====================catalogue produits============================= -->

	<form>
		<div class="panel-heading">
			<h2 style="text-align: center" class="text-center">Catalogue
				Produits</h2>
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
								<td class="text-center"><strong>Quantité du
										produit </strong></td>
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
									<td class="text-center"><img alt=""
										src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}" /></td>
										<td></td>
									<td class="text-center"><a style="color: gold"
							href="${pageContext.request.contextPath}/client/principal/ajoutViaLienPanier/${cat.id_cat}">ajouter au panier</a></td>
								</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>

</body>
</html>