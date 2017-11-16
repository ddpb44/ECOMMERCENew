<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body>

	<h2 align="left" style="position: absolute; left: 5%">LISTE DES CATEGORIES</h2>
	<button type="button" data-toggle="modal" data-target="#Ajout"
		style="position: absolute; width: 15%; left: 15%; top: 10%" class="btn btn-primary">AJOUTER
		UNE CATEGORIE</button>

	<input class="form-control" id="myInput" type="text"
		placeholder="Rechercher">
	<div class="tableCat" align="center"
		style="position: absolute; top: 15%">
		<table  class="table table-hover ">
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
							href="${pageContext.request.contextPath}/admin/principal/supprimViaLien/${cat.id_cat}">Supprimer</a>
							| <a style="color: gold"
							href="${pageContext.request.contextPath}/admin/principal/modifViaLien?pName=${cat.nomCategorie}">
								Modifier </a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="Ajout" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Ajout d'une catégorie</h4>
				</div>
				<div class="modal-body">
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
									id="cat_description" />
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
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
</body>
</html>