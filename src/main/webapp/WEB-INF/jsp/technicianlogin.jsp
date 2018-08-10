<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PDAT Portal</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<script>
	$(document).ready(function(){

		$("#SenderViewBtn").click(function(){
	    	
			  var medicineName = $('#medicineName').val();

			  console.log('SenderView initiate medicineName- ' + medicineName);
		      $.ajax({
		    	  type: 'POST',
				  dataType: "json",
				  url: 'createEnvelopeAsSenderView?medicineName=' + medicineName ,
				  contentType: "application/json; charset=utf-8",
				  success: function(data) {
		            console.log('success login- ' + data.envelopeId);

		            $('#envelopeId').html(data.envelopeId);


			            $.ajax({
					    	  type: 'GET',
							  dataType: "json",
							  url: 'generateSenderView?envelopeId=' + data.envelopeId,
							  contentType: "application/json; charset=utf-8",
							  success: function(data) {
					            console.log('success in generateSenderView');
					          }
						});
		          }
			});
		  });

		$("#RecipientViewBtn").click(function(){
	    	
			  var medicineName = $('#medicineName').val();

			  console.log('login initiate medicineName- ' + medicineName);
		      $.ajax({
		    	  type: 'POST',
				  dataType: "json",
				  url: 'createEnvelopeAsRecipientView?medicineName=' + medicineName,
				  contentType: "application/json; charset=utf-8",
		          success: function(data) {
		            console.log('success login- ' + data.envelopeId);

		            $('#envelopeId').html(data.envelopeId);

			            $.ajax({
					    	  type: 'GET',
							  dataType: "json",
							  url: 'generateRecipientView?envelopeId=' + data.envelopeId,
							  contentType: "application/json; charset=utf-8",
							  success: function(data) {
								  console.log('success in generateRecipientView');  
					          }
						});
		          }
			});
		  });

		$("#SystemViewBtn").click(function(){
	    	
			  var medicineName = $('#medicineName').val();

			  console.log('login initiate medicineName- ' + medicineName);
		      $.ajax({
		    	  type: 'POST',
				  dataType: "json",
				  url: 'createEnvelopeAsSystem?medicineName=' + medicineName,
				  contentType: "application/json; charset=utf-8",
		          success: function(data) {
		            console.log('success login- ' + data.envelopeId);

		            $('#envelopeId').html(data.envelopeId);
		          }
			});
		  });

		$("#FillableFormViewBtn").click(function(){
	    	
			  var medicineName = $('#medicineName').val();

			  console.log('login initiate medicineName- ' + medicineName);
		      $.ajax({
		    	  type: 'POST',
				  dataType: "json",
				  url: 'createWorkspaceRemoteEnvelope?medicineName=' + medicineName,
				  contentType: "application/json; charset=utf-8",
		          success: function(data) {
		            console.log('success login- ' + data);
		            console.log('success login- ' + data.envelopeId);

		            $('#envelopeId').html(data.envelopeId);
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
			<img id="Image1" src="img/uhc-logo.png">
		</div>
		</header>
		<section>
		<div class="container">
			<div class="row-fluid">
				<div class="form-horizontal">
					<fieldset>
						<div id="legend">
							<legend class="">Envelope Generation</legend>
						</div>

						<div class="control-group">
							<label class="control-label" for="password">Medicine Name</label>
							<div class="controls">
								<select class="span3" name="medicineName" id="medicineName">
									<option></option>
									<option value="Entresto">Entresto</option>
									<option value="Metaxalone">Metaxalone</option>
								</select>
							</div>
						</div>

						<!-- Submit -->
						<div class="control-group">
							<div class="controls">
							
								<input type="button" value="Send with DocuSign As Sender View" id="SenderViewBtn"
														name="SenderViewBtn"
														class="btn btn-success" />
														
								<input type="button" value="Send with DocuSign As RecipientView" id="RecipientViewBtn"
								name="RecipientViewBtn"
								class="btn btn-success" />
								
								<input type="button" value="Send with DocuSign As System" id="SystemViewBtn"
								name="SystemViewBtn"
								class="btn btn-success" />
								
								<!-- <input type="button" value="Send with DocuSign As Fillable Form" id="FillableFormViewBtn"
								name="FillableFormViewBtn"
								class="btn btn-success" /> -->
														
							</div>
						</div>

					</fieldset>
				</div>
			</div>
		</div>
		<div id="envelopeId"></div>
		</section>
	</div>

</body>
</html>