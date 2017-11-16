<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>${message}</h1>

	<h2>LISTE DES Produits</h2>

	<div align="center">
		<table class="table table-striped">
			<tr>
				<th>ID Produit</th>
				<th>Designation</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantite</th>

			</tr>
			<c:forEach var="prod" items="${listeProduits}">
				<tr>
					<th>${prod.id_produit}</th>
					<th>${prod.designation}</th>
					<th>${prod.description}</th>
					<th>${prod.prix}</th>
					<th>${prod.quantite}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>