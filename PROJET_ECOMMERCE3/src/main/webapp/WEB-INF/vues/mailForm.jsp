<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page mail</title>
</head>
<body>

	<f:form class="form-horizontal" method="POST" modelAttribute="mail"
		action="sendMail">
		<div class="form-group">
			<label class="control-label col-sm-2" for="to_id">To : </label>
			<div class="col-sm-10">
				<f:input path="to" class="form-control" id="to_id" />
				<f:errors path="to" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="sujet_id">Sujet</label>
			<div class="col-sm-10">
				<f:input path="subject" class="form-control" id="sujet_id" />
				<f:errors path="subject" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="corps">Corps</label>
			<div class="col-sm-10">
				<f:input path="text" class="form-control"
					id="corps" />
				<f:errors path="text" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-warning">ENVOYER</button>
			</div>
		</div>
	</f:form>

</body>
</html>