<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image Test</title>

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-default" style="background-color: orange;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">HNB</a>
			</div>
			<ul class="nav navbar-nav">
				<li role="presentation" class="active"><a
					href="${pageContext.request.contextPath}/admin/produit/afficheAjoutProd"
					style="color: white">Ajouter produit</a></li>
				
			</ul>
		</div>
	</nav>

</body>
</html>