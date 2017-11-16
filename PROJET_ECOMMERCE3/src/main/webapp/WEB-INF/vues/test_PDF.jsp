<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<script type="text/javascript" src="/main/webapp/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="src/main/webapp/resources/js/test_PDF.js"></script>

</head>
<body>

	<div class="row">
		<div class="col-sm-offset-4 col-sm-4">
			<h3>Courriers</h3>
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Date</th>
						<th>A ouvrir</th>
						<th>Lut</th>
						<th>Traité</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>15/12/2014</td>
						<td class="text-right">0</td>
						<td class="text-right">9</td>
						<td class="text-right">7</td>
						<td class="text-right">16</td>
					</tr>
					<tr>
						<td>17/12/2014</td>
						<td class="text-right">0</td>
						<td class="text-right">2</td>
						<td class="text-right">1</td>
						<td class="text-right">3</td>
					</tr>
					<tr>
						<td>31/12/2014</td>
						<td class="text-right">0</td>
						<td class="text-right">3</td>
						<td class="text-right">1</td>
						<td class="text-right">4</td>
					</tr>
					<tr>
						<td>20/01/2015</td>
						<td class="text-right">375</td>
						<td class="text-right">53</td>
						<td class="text-right">13</td>
						<td class="text-right">441</td>
					</tr>
					<tr>
						<td>26/01/2015</td>
						<td class="text-right">69</td>
						<td class="text-right">21</td>
						<td class="text-right">0</td>
						<td class="text-right">90</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th>&nbsp;</th>
						<th class="text-right">445</th>
						<th class="text-right">91</th>
						<th class="text-right">32</th>
						<th class="text-right">568</th>
					</tr>
				</tfoot>
			</table>
			<a href="#" class="btn btn-success pull-right"><i
				class="glyphicon glyphicon-export"></i>&nbsp;Exporter</a>
		</div>
	</div>
	<div>
		<a href="#" class="btn btn-success pull-right"
			download="export-sample.pdf"> <i
			class="glyphicon glyphicon-export"></i>&nbsp;Exporter dddd
		</a>
	</div>
</body>
</html>