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

<title>modif page client</title>
</head>
<body>

<div>
		<nav class="navbar navbar-inverse bg-inverse">
			<ul class="nav nav-pills">
				<li role="presentation" class="active"><a
					href="<c:url value="${pageContext.request.contextPath}/blabla" />">Se
						déconnecter</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/etudiant/afficheAjout">Acheter</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/etudiant/afficheModifClient">Modifier informations compte client</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/client/afficheSupClient">Supprimer compte</a></li>
				<li role="presentation"><a
					href="${pageContext.request.contextPath}/client/afficheRecherche">Panier</a></li>
			</ul>
		</nav>
	</div>

<br />
	<h1 style="color: blue; text-align: center">Formulaire de modifiaction</h1>
	<br />
	<f:form class="form-horizontal" method="POST"
		modelAttribute="clientModif" action="modifierClient">
		
		<div class="form-group">
			<f:label path="id_client" class="col-sm-2 control-label">Id</f:label>
			<div class="col-sm-10">
				<f:input path="id_client" />
				<f:errors path="id_client" class="col-sm-6" />
			</div>
		</div>
		<div class="form-group">
			<f:label path="nomClient" class="col-sm-2 control-label">Nom</f:label>
			<div class="col-sm-10">
				<f:input path="nomClient" />
				<f:errors path="nomClient" class="col-sm-6" />
			</div>

		</div>

		<div class="form-group">
			<f:label path="adresse" class="col-sm-2 control-label">Adresse</f:label>
			<div class="col-sm-10">
				<f:input path="adresse" />
				<f:errors path="adresse" class="col-sm-6" />

			</div>
		</div>

		<div class="form-group">
			<f:label path="email" class="col-sm-2 control-label">EMail</f:label>
			<div class="col-sm-10">
				<f:input path="email" />
				<f:errors path="email" class="col-sm-6" />
			</div>
		</div>
		<div class="form-group">
			<f:label path="tel" class="col-sm-2 control-label">Tel</f:label>
			<div class="col-sm-10">
				<f:input path="tel" />
				<f:errors path="tel" class="col-sm-6" />
			</div>

		</div>
		<div class="col-sm-5">
			<input type="submit" value="modifier compte client"
				class="btn btn-primary" />
		</div>
	</f:form>
	
	<p style="color:red; text-align:centre">${message}</p>

</body>
</html>