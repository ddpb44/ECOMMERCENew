<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<link href='<c:url value="/resources/css/bootstrap.css"></c:url>'
	rel="stylesheet" />
<link href='<c:url value="/resources/css/bootstrap-theme.css"></c:url>'
	rel="stylesheet" />
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>

</head>

<body>

	<h2>
		<a href="${pageContext.request.contextPath}/admin/principal/pageAdmin">
			Aller vers la page ADMIN</a>
	</h2>
	<br />
	<h2>
		<a
			href="${pageContext.request.contextPath}/admin/produits/pageAdminProduits">
			Aller vers la page ADMIN PROD</a>
	</h2>

</body>
</html>