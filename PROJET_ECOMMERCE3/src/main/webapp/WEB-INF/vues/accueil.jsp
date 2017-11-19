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

	<div class="login">
		<h2 style="text-align: center">
			<a
				href="${pageContext.request.contextPath}/admin/principal/pageAdmin" style="color:gold">
				Aller vers la page ADMIN</a>
		</h2>
		<br />
		<h2 style="text-align: center">
			<a
				href="${pageContext.request.contextPath}/admin/produits/pageAdminProduits" style="color:gold">
				Aller vers la page ADMIN Produit</a>
		</h2>
		<br /> <br />
		<h2 style="text-align: center">
			<a href="${pageContext.request.contextPath}/client/pageClient" style="color:gold">
				Aller vers la page Client</a>
		</h2>
	</div>
</body>
</html>