<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<link href="https://fonts.googleapis.com/css?family=Indie+Flower"
	rel="stylesheet">

</head>
<body>

	<h1 style="color: red; text-align: center">Formulaire de
		modification</h1>
<div class="formulaire">
	<form:form class="form-horizontal" method="POST"
		modelAttribute="proUpdateForm" action="modifProd"
		enctype="multipart/form-data">

		<div class="form-group">
			<label class="col-sm-2 control-label" for="id_produit">Id</label>
			<div class="col-sm-10">
				<form:input path="id_produit" />
				<form:errors path="id_produit" class="col-sm-6"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<form:label path="designation" class="col-sm-2 control-label">Designation</form:label>
			<div class="col-sm-10">
				<form:input path="designation" />
				<form:errors path="designation" class="col-sm-6"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<form:label path="description" class="col-sm-2 control-label">Description</form:label>
			<div class="col-sm-10">
				<form:textarea path="description" cssStyle="height:100px; width:800px" />
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
			<label class="col-sm-2 control-label">Categorie</label>
			<div class="col-sm-10">
				<form:select path="cat.id_cat">
						<form:options items="${listeCat}" itemLabel="nomCategorie"
							itemValue="id_cat" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label path="imageBytes" class="col-sm-2 control-label">imageBytes</form:label>
			<div class="col-sm-10">
				<input type="file" name="file"style="width:1000px;" />
				<form:errors path="imageBytes" class="col-sm-6" ></form:errors>
			</div>

		</div>
		<input type="submit" value="Modifier un produit"
			class="btn btn-primary" style="margin-left:17%; font-size: 20px" />
	</form:form>
</div>
</body>
</html>