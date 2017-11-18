<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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

<title>Insert title here</title>
</head>
<body>

<!-- ===================Contenu de ma facture=============================-->

<form id="form1">
    <div id="dvContainer">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="text-center">
                        <i class="fa fa-search-plus pull-left icon"></i>
                        <h3 style="text-align: center">Numéro de la commande: </h3>
                    </div>
                    <hr/>
                    <div class="row">
                        <div class="col-xs-12 col-md-3 col-lg-3 pull-left">
                            <div class="panel panel-default height">
                                <div class="panel-heading"><strong>Informations sur le client</strong></div>
                                    <div class="panel-body">
                                        Nom : <br/>
                                        Adresse : <br/>
                                        Telephone : <br/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-md-3 col-lg-3">
                            <div class="panel panel-default height">
                                <div class="panel-heading"><strong>Informations de paiement</strong></div>
                                <div class="panel-body">
                                    Card Name: Visa<br/>
                                    Card Number: ***** 332<br/>
                                    Exp Date: 09/2020<br/>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-3 col-lg-3">
                            <div class="panel panel-default height">
                                <div class="panel-heading"><strong>Preferences</strong></div>
                                <div class="panel-body">
                                    Gift: No <br/>
                                    Express Delivery : Yes <br/>
                                    Insurance: No <br/>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-3 col-lg-3 pull-right">
                            <div class="panel panel-default height">
                                <div class="panel-heading"><strong>Adresse de facturation</strong></div>
                                <div class="panel-body">
                                    Nom : <br/>
                                    Adresse : <br/>
                                    telephone : <br/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 style="text-align: center" class="text-center"><strong>Commande en cours</strong></h3>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-condensed">
                                    <thead>
                                    <tr>
                                        <td><strong>Designation du produit : </strong></td>
                                        <td class="text-center"><strong>Prix :</strong></td>
                                        <td class="text-center"><strong>Quantité du produit : </strong></td>
                                        <td class="text-center"><strong>Image : </strong></td>
                                        <br/><br/>
                                        <td class="text-right"><strong>Total</strong></td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${prod.designation} </td>
                                        <td class="text-center">${prod.prix}</td>
                                        <td class="text-center">${prod.quantite} </td>
                                        <td class="text-center"><img alt=""
										src="${pageContext.request.contextPath}/produit/photoProd?id_produit=${prod.id_produit}" /></td>
                                        <td class="text-right">Mettre le lien du total : </td>
                                    </tr>
                                    <tr>
                                        <td class="highrow"></td>
                                        <td class="highrow"></td>
                                        <br/><br/>
                                        <td class="highrow text-center"><strong>Prix total de la commande</strong></td>
                                        <td class="highrow text-right">Mettre le lien du prix total de la commande :</td>
                                    </tr>
                                    <tr>
                                        <td class="emptyrow"></td>
                                        <td class="emptyrow"></td>
                                        <td class="emptyrow text-center"><strong>Prix de la livraison</strong></td>
                                        <td class="emptyrow text-right">20 EmotionCoin</td>
                                    </tr>
                                    <tr>
                                        <td class="emptyrow"><i class="fa fa-barcode iconbig"></i></td>
                                        <td class="emptyrow"></td>
                                        <td class="emptyrow text-center"><strong>Total</strong></td>
                                        <td class="emptyrow text-right">Mettre le lien du total</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ===================Bouton pour imprimer le pdf=============================-->

    <input type="button" value="Enregistrer facture" id="btnPrint" style="position:absolute; width: 20%; left: 40%"/>
</form>



</body>
</html>