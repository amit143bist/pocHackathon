<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<title>Non AngularJS</title>

<script data-require="jquery.js@1.11.3" data-semver="1.11.3"
	src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script data-require="datatable.js@1.10.7" data-semver="1.10.7"
	src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.4/holder.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
			$(document).ready(function(){

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

	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/Foremost-logo.jpg">
		</div>
		</header>
		<section>
		<div id="container_demo">
			<div>
				<div class="site-content">
					<div class="site-container loading" ui-view="">
						<div class="site-main">
							<div>
								<div class="text-center">
									<br> <br> <br>
									<div class="spinner-circle spinner-sm"></div>
								</div>
								<div class="overview-section" style="height:400px;">

									<div class="table-responsive">
										<table id="projectTable" datatable="ng"
											class="table table-condensed table-hover table-bordered"
											width="100%">

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

								</div>
								<div class="overview-section" style="height: 640px; width:640px">
									<br/><br/><br/>
									<iframe id="myIframe" src="" width="640" height="640"></iframe>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="text-center">
					<br/> <br/> <br/>
					<div class="spinner-circle spinner-sm"></div>
				</div>
			</div>
		</div>
		</section>
	</div>

</body>
</html>