<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="X-UA-Compatible" content="IE=8"> -->
<title>Non AngularJS</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<!-- <script data-require="jquery.js@1.11.3" data-semver="1.11.3"
	src="//code.jquery.com/jquery-1.11.3.min.js"></script>
 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.4/holder.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
			$(document).ready(function(){

				console.log('Jquery loaded');
				$("#envelopeStatusBtn").click(function(){

					var envelopeId = '815fda8d-ed99-42de-9c53-ee32b5222f43';
					var recipientEmail = 'docusign.sso@gmail.com';
					
					$.ajax({
						type : 'GET',
						url : 'redirectToRecipientViewUrlIframe',
						dataType : 'json',
						data: ({envelopeId:envelopeId, recipientEmail: recipientEmail}),
						success : function(respData) {

							console.log('url in openRecipientViewAsIframe- ' + respData.embeddedUrl);
							$('#myIframe').attr('src', respData.embeddedUrl)
							
						},
						error : function(respData) {

							console.log('error in envelopeStatusBtn ');
						}
					});
					
				});

				$("#envelopeStatusPopupBtn").click(function(){

					var envelopeId = '815fda8d-ed99-42de-9c53-ee32b5222f43';
					var recipientEmail = 'docusign.sso@gmail.com';
					
					$.ajax({
						type : 'GET',
						url : 'redirectToRecipientViewUrlIframe',
						dataType : 'json',
						data: ({envelopeId:envelopeId, recipientEmail: recipientEmail}),
						success : function(respData) {

							console.log('url in openRecipientViewAsPopUpIframe- ' + respData.embeddedUrl);

							openInNewTab(respData.embeddedUrl);
							
						},
						error : function(respData) {

							console.log('error in envelopeStatusPopupBtn ');
						}
					});
					
				});

				function openInNewTab(url) {
				    $("<a>").attr("href", url).attr("target", "_blank")[0].click();
				}
				
			});
			
</head>
<body>

	<h1>IFrame Test</h1>
	<div>
		<div>
			<table id="projectTable" width="100%">
	
				<tbody>
					<tr>
						<td>815fda8d-ed99-42de-9c53-ee32b5222f43</td>
						<td>Test Subject</td>
						<td><input type="button" value="Sign" id="envelopeStatusBtn" name="envelopeStatusBtn"
							class="btn btn-primary" /></td>
						<td><input type="button" value="Sign" id="envelopeStatusPopupBtn" name="envelopeStatusPopupBtn"
							class="btn btn-primary" /></td>
					</tr>
				</tbody>
			</table>
	
		</div>
		
		<div style="height: 640px; width:640px">
			<br/><br/><br/>
			<iframe id="myIframe" src="" width="640" height="640"></iframe>
		</div>
	</div>
</body>
</html>