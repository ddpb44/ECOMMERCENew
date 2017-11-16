<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>

	<h1>${message}</h1>

	<h2>LISTE DES CATEGORIES</h2>

	<div class="tableCat" align="center">
		<table class="table table-striped">
			<tr style="background-color: black">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Opérations</th>
			</tr>
			<c:forEach var="cat" items="${listeCat}">
				<tr>
					<th>${cat.id_cat}</th>
					<th>${cat.nomCategorie}</th>
					<th>${cat.description}</th>
					<th><a href="${pageContext.request.contextPath}/admin/supprimViaLien/${categorie.id_cat}">Supprimer</a> | <a href="${pageContext.request.contextPath}/admin/modifViaLien?pId=${categorie.id_cat}"> Modifier </a></th>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>