<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>
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

	<div align="center" style="font-size: 90px">GoodLifeSTORE</div>

	<div align="center" style="font-size: 40px; color: lime">Votre
		boutique bien-être</div>
	<c:if test="${not empty erreur}">
		<h1 align="center" style="color: red">Login ou Mot de passe erroné</h1>
	</c:if>
	
	<div class="login">

		<br /> <br />

		<h2 align="center" style="margin-top: -30px">Connexion
			administrateur</h2>

		<form action="connexion" method="post">
			Identifiant : <input class="form-control" type="text"
				name="j_username" style="width: 85%; margin-left: 7.5%"> <br />

			Mot de passe : <input class="form-control" type="password"
				name="j_password" style="width: 85%; margin-left: 7.5%"> <br />

			<input type="submit" value="Se connecter" class="btn btn-warning"
				style="width: 30%">
		</form>
		<br />


	</div>

</body>
</html>