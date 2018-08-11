<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PDAT Callback</title>
<link rel="stylesheet" href="/css/site.css">
<link rel="stylesheet" href="/css/normalize.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/css/styledemo.css" />
<link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

</head>
<body>
	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/uhc-logo.png">
		</div>
		</header>
		<section>
		<div class="container">
			<div class="row-fluid">
				<div class="form-horizontal">
					<fieldset>
						<div id="legend">
							<legend class="">The response is ${callResponse}</legend>
						</div>

						<div id="envelopeId">EnvelopeId signed is ${envelopeId}</div>
						<div id="recipientName">RecipientName who signed the
							envelope is ${recipientName}</div>
						<div id="recipientEmail">RecipientEmail who signed the
							envelope is ${recipientEmail}</div>

					</fieldset>
					
					<form:form method="POST" id="unitedConnectPost"
						name="unitedConnectPost" action="unitedConnectPost">
						
						<input id="envelopeId" name="envelopeId" type="hidden" value="${envelopeId}"/>
				
						<input type="submit" value="Fetch Connect Data" id="loginBtn" name="loginBtn" class="btn btn-success" />
					</form:form>
				</div>
			</div>
		</div>
		<div>
			<br/>
		</div>
		</section>
	</div>

</body>
</html>