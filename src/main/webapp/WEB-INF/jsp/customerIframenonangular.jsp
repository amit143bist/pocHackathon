<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<title>Non AngularJS</title>

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- <script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js">
	
</script>
 -->

<script type="text/javascript" language="javascript">
	$(document)
			.ready(
					function() {

						console.log('Jquery loaded');
						$("#envelopeStatusBtn")
								.click(
										function() {

											var envelopeId = '815fda8d-ed99-42de-9c53-ee32b5222f43';
											var recipientEmail = 'docusign.sso@gmail.com';

											$
													.ajax({
														type : 'GET',
														url : 'redirectToRecipientViewUrlIframe',
														dataType : 'json',
														data : ({
															envelopeId : envelopeId,
															recipientEmail : recipientEmail
														}),
														success : function(
																respData) {

															console
																	.log('url in openRecipientViewAsIframe- '
																			+ respData.embeddedUrl);
															$('#myIframe')
																	.attr(
																			'src',
																			respData.embeddedUrl);

														},
														error : function(
																respData) {

															console
																	.log('error in envelopeStatusBtn ');
														}
													});

										});

						$("#envelopeStatusPopupBtn")
								.click(
										function() {

											var envelopeId = '815fda8d-ed99-42de-9c53-ee32b5222f43';
											var recipientEmail = 'docusign.sso@gmail.com';

											$
													.ajax({
														type : 'GET',
														url : 'redirectToRecipientViewUrlIframe',
														dataType : 'json',
														data : ({
															envelopeId : envelopeId,
															recipientEmail : recipientEmail
														}),
														success : function(
																respData) {

															console
																	.log('url in openRecipientViewAsPopUpIframe- '
																			+ respData.embeddedUrl);

															window
																	.open(
																			respData.embeddedUrl,
																			'_newtab');

														},
														error : function(
																respData) {

															console
																	.log('error in envelopeStatusPopupBtn ');
														}
													});

										});

						$("#envelopeStatusPopupBtnNewWindow")
								.click(
										function() {

											var envelopeId = '815fda8d-ed99-42de-9c53-ee32b5222f43';
											var recipientEmail = 'docusign.sso@gmail.com';

											$
													.ajax({
														type : 'GET',
														url : 'redirectToRecipientViewUrlIframe',
														dataType : 'json',
														data : ({
															envelopeId : envelopeId,
															recipientEmail : recipientEmail
														}),
														success : function(
																respData) {

															console
																	.log('url in openRecipientViewAsPopUpIframe- '
																			+ respData.embeddedUrl);

															var newwindow = window
																	.open(
																			respData.embeddedUrl,
																			'_newtab',
																			'height=500,width=400,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,status=yes');
															if (window.focus) {
																newwindow
																		.focus();
															}

														},
														error : function(
																respData) {

															console
																	.log('error in envelopeStatusPopupBtn ');
														}
													});

										});

					});
</script>

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
						<td><input type="button" value="IFrame Sign" id="envelopeStatusBtn"
							name="envelopeStatusBtn" class="btn btn-primary" /></td>
						<td><input type="button" value="New Tab Sign"
							id="envelopeStatusPopupBtn" name="envelopeStatusPopupBtn"
							class="btn btn-primary" /></td>
						<td><input type="button" value="Popup Window Sign"
							id="envelopeStatusPopupBtnNewWindow"
							name="envelopeStatusPopupBtnNewWindow" class="btn btn-primary" /></td>
					</tr>
				</tbody>
			</table>

		</div>

		<div style="height: 640px; width: 640px">
			<br /> <br /> <br />
			<iframe id="myIframe" src="" width="640" height="640"></iframe>
		</div>
	</div>
</body>
</html>