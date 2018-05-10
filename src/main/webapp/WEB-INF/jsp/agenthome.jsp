<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>Send Envelope</title>
	<link rel="stylesheet" href="/css/site.css">
	<link rel="stylesheet" href="/css/normalize.css">
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" type="text/css" href="/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/css/styledemo.css" />
	<link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<script>
	$(document).ready(function(){

		$("#loginBtn").click(function(){
	    	
			  var recipientName = $('#recipientName').val();
			  var recipientEmail = $('#recipientEmail').val();

			  console.log('login initiate recipientName- ' + recipientName + ' recipientEmail- ' + recipientEmail);
		      $.ajax({
		    	  type: 'POST',
				  dataType: "json",
				  url: 'createWorkspaceRemoteEnvelope',
				  contentType: "application/json; charset=utf-8",
				  data: JSON.stringify(
			            {recipientName: recipientName, recipientEmail: recipientEmail}
			        ),
		          success: function(data) {
		            console.log('success login- ' + data);

		            var respData = JSON.stringify(data);

		            console.log('respData in success login- ' + respData);
		            
		            $('#envelopeId').html(data);
		          }
			});
		  });
	});
	</script>
</head>
<body>
	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/Foremost-logo.jpg">
		</div>
		</header>
		<section>
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form:form method="POST" autocomplete="on" id="customerLoginForm"
						name="customerLoginForm" action="createWorkspaceRemoteEnvelope">
						<h1>PNI Details</h1>
						<p>
							<label for="recipientName" class="uname" data-icon="u">
								PNI Full Name </label> <input id="recipientName" name="recipientName"
								required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						<p>
							<label for="recipientEmail" class="uname" data-icon="u">
								PNI Email </label> <input id="recipientEmail" name="recipientEmail"
								required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						
						<p class="login button">
							<input type="button" value="Send Envelopes" id="loginBtn"
								name="loginBtn" />
						</p>
						
						<p class="change_link">
							Home Page ? <a href="/portalLanding" class="to_register">Home Page</a>
						</p>
						
					</form:form>
				</div>
				<div id="envelopeId">
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>