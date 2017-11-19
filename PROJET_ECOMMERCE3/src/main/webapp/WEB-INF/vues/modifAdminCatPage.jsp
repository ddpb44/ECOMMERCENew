<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Categorie</title>
</head>
<body>

	<f:form class="form-horizontal" method="POST" modelAttribute="catUpdateForm" action="modifierCat">
		<div class="form-group">
			<label class="control-label col-sm-2" for="cat_id">Id:</label>
			<div class="col-sm-10">
				<f:input path="id_cat" class="form-control" id="cat_id"/>
				<f:errors path="id_cat" cssStyle="color:red"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="cat_name">Nom:</label>
			<div class="col-sm-10">
				<f:input path="nomCategorie" class="form-control" id="cat_name"/>
				<f:errors path="nomCategorie" cssStyle="color:red"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="cat_description">Description:</label>
			<div class="col-sm-10">
				<f:input path="description" class="form-control" id="cat_description"/>
				<f:errors path="description" cssStyle="color:red" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-warning">MODIFIER</button>
			</div>
		</div>
	</f:form>


</body>
</html>