<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html >
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
	
	<script type="text/javascript"
	src='<c:url value="/resources/js/java.js"></c:url>'></script>
	
<link href='<c:url value="/resources/css/style.css"></c:url>'
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Indie+Flower"
	rel="stylesheet">
<title>AdminProdPage</title>
</head>
<body>

	<button type="button" data-toggle="modal" data-target="#AjoutAdminPro"
		style="position: absolute; width: 15%; right: 3%; top: 13%"
		class="btn btn-primary">AJOUTER UN PRODUIT</button>


	<div class="panel-heading">
		<h1 align="center" style="color: gold">LISTE DES PRODUITS</h1>
	</div>
	<f:form action="${pageContext.request.contextPath}/blabla" method="GET">
		<button type="submit" class="btn btn-danger"
			style="position: absolute; width: 10%; left: 3%; top: 3%">DECONNEXION</button>
	</f:form>
	<input class="form-control" id="searchProduitAdminPro" type="text"
		placeholder="Rechercher" style="width: 70%; margin-left: 10%">
	<div id="dvContainer">
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr class="header">
							<td class="text-center"><strong>Aperçu</strong></td>
							<td class="text-center"><strong>Id</strong></td>
							<td></td>
							<td class="text-center"><strong>Designation</strong></td>
							<td></td>
							<td class="text-center"><strong>Description</strong></td>
							<td></td>
							<td class="text-center"><strong>Prix </strong></td>
							<td></td>
							<td class="text-center"><strong>Stock</strong></td>
							<td></td>
							<td class="text-center"><strong>Catégorie</strong></td>
						</tr>
					</thead>

					<tbody id="produitAdminPro">
						<c:forEach var="prod" items="${listeProd}">
							<tr style="background: rgba(133, 136, 147, 0.7); font-size: 19px">
								<td class="text-center"><img alt=""
									src="${pageContext.request.contextPath}/admin/photoProd?id_produit=${prod.id_produit}" /></td>
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
								<td class="text-center">${prod.cat.nomCategorie}</td>
								<th><a style="color: gold"
									href="${pageContext.request.contextPath}/admin/produits/supprimProduitViaLien/${prod.id_produit}"><img
										height="20px" width="20px" alt="Supprimer"
										src='<c:url value="/resources/css/images/close.png"></c:url>'></a>
									<a style="color: gold"
									href="${pageContext.request.contextPath}/admin/produits/modifProduitViaLien?pName=${prod.designation}">
										<img height="20px" width="20px" alt="Supprimer"
										src='<c:url value="/resources/css/images/modif.png"></c:url>'>
								</a></th>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<input type="button" class="btn btn-danger"
		value="Enregistrer le catalogue" id="btnPrint"
		style="position: absolute; width: 20%; left: 40%; margin-top: -20px" />


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
						modelAttribute="proAddForm" action="insererProduit"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-sm-2" for="pro_name">Nom:</label>
							<div class="col-sm-10">
								<f:input path="designation" class="form-input" id="pro_name" />
								<f:errors path="designation" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="pro_description">Description:</label>
							<div class="col-sm-10">
								<f:input path="description" class="form-input"
									id="pro_description" />
								<f:errors path="description" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="pro_prix">Prix:</label>
							<div class="col-sm-10">
								<f:input path="prix" class="form-input" id="pro_prix" />
								<f:errors path="prix" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="pro_quantite">Quantité:</label>
							<div class="col-sm-10">
								<f:input path="quantite" class="form-input" id="pro_quantite" />
								<f:errors path="quantite" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<f:label path="cat" class="col-sm-2 control-label">Categorie</f:label>
							<div class="col-sm-10">
								<f:select path="cat.id_cat">
									<f:option value="0" label="Selectionnez une categorie" />
									<f:options items="${listeCat}" itemLabel="nomCategorie"
										itemValue="id_cat" />
								</f:select>
							</div>
						</div>

						<div class="form-group">
							<f:label path="imageBytes" class="col-sm-2 control-label">imageBytes</f:label>
							<div class="col-sm-10">
								<input type="file" name="file" />
								<f:errors path="imageBytes" class="col-sm-6"></f:errors>
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