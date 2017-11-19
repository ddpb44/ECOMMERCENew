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

<title>page client</title>
</head>
<body>

	<!-- =====================catalogue produits============================= -->
	<nav>
		<div>
			<div>
				<button type="button" value="#AjoutLigneCommandeViaLien"
					style="position: absolute; width: 15%; right: 3%; top: 20%"
					class="btn btn-primary">Acheter</button>

			</div>
			<br/>
			<div>
				<button type="button" value="#AjoutLigneCommandeViaLien"
					style="position: absolute; width: 15%; right: 3%; top: 20%"
					class="btn btn-primary">Panier</button>

			</div><br/>
			<div>
				<button type="button" value="#AjoutLigneCommandeViaLien"
					style="position: absolute; width: 15%; right: 3%; top: 20%"
					class="btn btn-primary">Modifier informations compte
					client</button>

			</div><br/>
			<div>
				<button type="button" value="#AjoutLigneCommandeViaLien"
					style="position: absolute; width: 15%; right: 3%; top: 20%"
					class="btn btn-primary">Supprimer compte</button>

			</div>
		</div>
	</nav>

	<form>
		<div class="panel-heading">
			<h2 style="text-align: center" class="text-center">Catalogue
				Produits</h2>
			<h5>
				<a
					href="<c:url value="$${pageContext.request.contextPath}/blabla" />">Se
					déconnecter</a>
			</h5>
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
										src="${pageContext.request.contextPath}/admin/photoProd?id_produit=${prod.id_produit}" /></td>
									<td></td>

								</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
	<!-- =============================ajouter un produit================================= -->

	<div id="AjoutAdminPro" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: black">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Ajout d'un produit</h4>
				</div>
				<div class="modal-body" style="background-color: black">
					<f:form class="form-horizontal" method="POST"
						modelAttribute="proAddForm"
						action="${pageContext.request.contextPath}/admin/produits/insererProduit"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-sm-2" for="pro_name">Id:</label>
							<div class="col-sm-10">
								<input path="id_produit" class="form-input" id="pro_name" />
								<errors path="id_produit" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-warning">AJOUTER</button>
							</div>
						</div>
					</f:form>
				</div>
				<div class="modal-footer" style="background-color: black">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>