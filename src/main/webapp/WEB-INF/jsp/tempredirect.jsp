<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temp Redirect</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script>
	/*function openRecipientView(envelopeId, recipientEmail){

		console.log('openRecipientView envelopeId- '
				+ envelopeId + ' recipientEmail- '
				+ recipientEmail);
		$.ajax({
			type : 'POST',
			crossOrigin : true,
			dataType : "json",
			url : 'createRecipientViewUrl',
			data : ({
				envelopeId : envelopeId,
				recipientEmail : recipientEmail
			}),
			success : function(data) {
				console.log('success login- ' + data);
				$('#envelopeId').html(data);
			}
		});
	}*/
</script>
</head>
<body onload="document.forms['redirectToDSURLForm'].submit()">

	<form:form method="POST" id="redirectToDSURLForm"
		name="redirectToDSURLForm" action="redirectToDSURL">
		
		<input id="envelopeId" name="envelopeId" type="hidden" value="${envelopeId}"/>

		<input id="recipientEmail" name="recipientEmail" type="hidden" value="${recipientEmail}"/>

		<input type="submit" value="Submit" id="loginBtn" name="loginBtn" />
	</form:form>

</body>
</html>