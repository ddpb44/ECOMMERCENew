<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" />

</head>
<body>

	<h1 style="color: red; text-align: center">Formulaire d'ajout</h1>

	<form:form class="form-horizontal" method="POST"
		modelAttribute="prodAjout" action="insererProduit" enctype="multipart/form-data">
		<div class="form-group">
			<form:label path="designation" class="col-sm-2 control-label">Designation</form:label>
			<div class="col-sm-10">
				<form:input path="designation" />
				<form:errors path="designation" class="col-sm-6"></form:errors>
			</div>

		</div>

		<div class="form-group">
			<form:label path="description" class="col-sm-2 control-label">description</form:label>
			<div class="col-sm-10">
				<form:input path="description" />
				<form:errors path="description" class="col-sm-6"></form:errors>
			</div>

		</div>

		<div class="form-group">
			<form:label path="prix" class="col-sm-2 control-label">prix</form:label>
			<div class="col-sm-10">
				<form:input path="prix" />
				<form:errors path="prix" class="col-sm-6"></form:errors>
			</div>

		</div>
		
		<div class="form-group">
			<form:label path="quantite" class="col-sm-2 control-label">quantite</form:label>
			<div class="col-sm-10">
				<form:input path="quantite" />
				<form:errors path="quantite" class="col-sm-6"></form:errors>
			</div>

		</div>
		
		<div class="form-group">
			<form:label path="selectionne" class="col-sm-2 control-label">selectionne</form:label>
			<div class="col-sm-10">
				<form:input path="selectionne" />
				<form:errors path="selectionne" class="col-sm-6"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="imageBytes" class="col-sm-2 control-label">imageBytes</form:label>
			<div class="col-sm-10">
				<input type="file" name="file" />
				<form:errors path="imageBytes" class="col-sm-6"></form:errors>
			</div>

		</div>
		<input type="submit" value="Ajouter un produit"
			class="btn btn-primary" />
	</form:form>

</body>
</html>