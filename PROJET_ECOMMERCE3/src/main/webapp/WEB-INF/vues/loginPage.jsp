<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>

</head>

<body>

	<div class="marque">Concept Store</div>

	<div class="slogan">Votre boutique conceptuelle</div>

	<div class="login">

		<h2>Connexion administrateur</h2>

		<form action="connexion" method="post">
			Identifiant : <input type="text" name="j_username"> <br />

			Mot de passe : <input type="password" name="j_password"> <br />

			<input type="submit" value="Se connecter">
		</form>

		<c:if test="${not empty erreur}">
			<h1>Login ou Mot de passe erroné</h1>
		</c:if>

	</div>

</body>
</html>