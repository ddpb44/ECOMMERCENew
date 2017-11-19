<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/bootstrap.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/bootstrap-theme.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/style.css"></c:url>'
	rel="stylesheet" />
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-3.2.1.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/java.js"></c:url>'></script>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
</head>
<body>

	<h1 align="center">PAGE ADMINISTRATEUR PRINCIPAL</h1>
	<button type="button" class="btn btn-danger" data-dismiss="modal" style="position: absolute; width: 10%; left: 3%; top: 3%">DECONNEXION</button>

	<h2 align="left" style="position: absolute; left: 8%">LISTE DES
		CATEGORIES</h2>
	<button type="button" data-toggle="modal" data-target="#Ajout"
		style="position: absolute; width: 15%; left: 23%; top: 20%"
		class="btn btn-primary">AJOUTER UNE CATEGORIE</button>

	<input class="form-control" id="myInput" type="text"
		placeholder="Rechercher"
		style="position: absolute; width: 15%; left: 3%; top: 20%">
	<table class="table table-hover"
		style="position: absolute; width: 35%; left: 3%; top: 25%">
		<thead>
			<tr class="header">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Opérations</th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach var="cat" items="${listeCat}">
				<tr class="bodyTable">
					<th>${cat.id_cat}</th>
					<th>${cat.nomCategorie}</th>
					<th>${cat.description}</th>
					<th><a style="color: gold"
						href="${pageContext.request.contextPath}/client/principal/supprimViaLien/${cat.id_cat}">Supprimer</a>
						| <a style="color: gold"
						href="${pageContext.request.contextPath}/client/principal/modifViaLien?pName=${cat.nomCategorie}">
							Modifier </a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div id="Ajout" class="modal fade" role="dialog" >
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: black">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Ajout d'une catégorie</h4>
				</div>
				<div class="modal-body" style="background-color: black">
					<f:form class="form-horizontal" method="POST"
						modelAttribute="catAddForm" action="ajouterCat">

						<div class="form-group">
							<label class="control-label col-sm-2" for="cat_name">Nom:</label>
							<div class="col-sm-10">
								<f:input path="nomCategorie" class="form-input" id="cat_name" />
								<f:errors path="nomCategorie" cssStyle="color:red" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="cat_description">Description:</label>
							<div class="col-sm-10">
								<f:input path="description" class="form-input"
									id="cat_description"/>
								<f:errors path="description" cssStyle="color:red" />
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

	<h2 align="left" style="position: absolute; right: 21%">LISTE DES
		PRODUITS</h2>
	<input class="form-control" id="myInputPro" type="text"
		placeholder="Rechercher"
		style="position: absolute; width: 15%; right: 43%; top: 20%">
	<button type="button" data-toggle="modal" data-target="#AjoutPro"
		style="position: absolute; width: 15%; right: 3%; top: 20%"
		class="btn btn-primary">AJOUTER UN PRODUIT</button>


	<table class="table table-hover"
		style="position: absolute; width: 55%; right: 3%; top: 25%">
		<thead>
			<tr class="header">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Catégorie</th>
				<th>Image</th>
				<th>Opérations</th>
			</tr>
		</thead>
		<tbody id="myTableProd">
			<c:forEach var="pro" items="${listeProd}">
				<tr class="bodyTable">
					<th>${pro.id_produit}</th>
					<th>${pro.designation}</th>
					<th>${pro.description}</th>
					<th>${pro.prix}</th>
					<th>${pro.quantite}</th>
					<th>${pro.cat.nomCategorie}</th>
					<td><img alt=""
						src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${pro.id_produit}"></td>
					<th><a style="color: gold"
						href="${pageContext.request.contextPath}/admin/principal/supprimViaLien/${pro.id_produit}">Supprimer</a>
						| <a style="color: gold"
						href="${pageContext.request.contextPath}/admin/principal/modifViaLien?pName=${pro.designation}">
							Modifier </a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div id="AjoutPro" class="modal fade" role="dialog">
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
						action="${pageContext.request.contextPath}/produit/insererProduit"
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
								<f:select path="cat">
									<c:forEach items="${categoriesListe}" var="cat">
										<f:option value="${cat}">${cat.nomCategorie}</f:option>
										<f:errors path="cat" class="col-sm-6"></f:errors>
									</c:forEach>
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