<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Categorie</title>

<link href='<c:url value="/resources/css/bootstrap.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/bootstrap-theme.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/style.css"></c:url>'
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Indie+Flower"
	rel="stylesheet">
</head>

<body>

	<h1 style="color: red; text-align: center">Formulaire de
		modification</h1>
	<div class="formulaire">
		<f:form class="form-horizontal" method="POST"
			modelAttribute="catUpdateForm" action="modifierCat">
			<div class="form-group">
				<label class="control-label col-sm-2" for="cat_id">Id:</label>
				<div class="col-sm-10">
					<f:input path="id_cat" class="form-control" id="cat_id" />
					<f:errors path="id_cat" cssStyle="color:red" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cat_name">Nom:</label>
				<div class="col-sm-10">
					<f:input path="nomCategorie" class="form-control" id="cat_name" />
					<f:errors path="nomCategorie" cssStyle="color:red" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cat_description">Description:</label>
				<div class="col-sm-10">
					<f:input path="description" class="form-control"
						id="cat_description" />
					<f:errors path="description" cssStyle="color:red" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-warning">MODIFIER</button>
				</div>
			</div>
		</f:form>
	</div>
</body>
</html>