<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="angularSPF" xmlns="http://www.w3.org/1999/xhtml"
	xml:lang="en">
<head>
	<title>Customer Envelopes</title>
	<link rel="stylesheet" href="/css/site.css">
	<link rel="stylesheet" href="/css/normalize.css">
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" type="text/css" href="/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/css/styledemo.css" />
	<link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />
	
	<link rel="stylesheet" type="text/css"
		href="https://docucdn-a.akamaihd.net/olive/17.11.0/css/olive.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://docucdn-a.akamaihd.net/olive/17.11.0/css/martini.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://docucdn-a.akamaihd.net/olive/17.11.0/css/tagger.min.css">
	
	<link href="//fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900"
		rel="stylesheet prefetch" type="text/css">
	
	<link href="/css/main.css" rel="stylesheet" />
	<link href="/css/spf.css" rel="stylesheet" />
	<link href="/css/dashboard.css" rel="stylesheet" />
	
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
			
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<link data-require="bootstrap-css@2.3.2" data-semver="2.3.2"
		rel="stylesheet"
		href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" />
	
	<link data-require="datatable-css@1.10.7" data-semver="1.10.7"
		rel="stylesheet"
		href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css" />
	
	<script>

	    function openRecipientView(envelopeId, recipientEmail){

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
		}
		
		$(document).ready(function() {
	
					$('input[type=button]').click(function() {
	
								var envelopeId = $(this).data('envelopeId');
							    var recipientEmail = $(this).data('recipientEmail');
	
								console.log('jquery login initiate envelopeId- '
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
							});
				});
	</script>
</head>
<body ng-app="angularSPF" ng-controller="ModalCtrl as spfController"
	ng-init="fetchAllEnvelopesJSON('${recipientEmail}')">

	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/Foremost-logo.jpg">
		</div>
		</header>
		<section>
		<div id="container_demo">
			<div>
				<div class="site-content" ng-show="spfController.showBody">
					<div class="site-container loading" ui-view="">
						<div class="site-main ng-isolate-scope">
							<div class="ng-scope">
								<div class="text-center ng-hide">
									<br> <br> <br>
									<div class="spinner-circle spinner-sm"></div>
								</div>
								<div class="overview-section" style="height: 640px;">

									<div class="table-responsive">
										<table id="projectTable" datatable="ng" dt-options="dtOptions"
											class="table table-condensed table-hover table-bordered"
											width="100%">
											<thead>
												<tr>
													<th>EnvelopeId</th>
													<th>Envelope Subject</th>
													<th>Sign Link</th>

												</tr>
											</thead>

											<tfoot>
												<tr>
													<th>EnvelopeId</th>
													<th>Envelope Subject</th>
													<th>Sign Link</th>
												</tr>
											</tfoot>

											<tbody>
												<tr
													ng-repeat="envelopeData in spfController.custEnvelopes track by $index">
													<td>{{envelopeData.envelopeId}}</td>
													<td>{{envelopeData.envelopeSubject}}</td>
													<td><input type="button" value="Sign" id="loginBtn"
														name="loginBtn"
														data-envelopeId="{{envelopeData.envelopeId}}"
														data-recipientEmail="{{envelopeData.recipientEmail}}" onclick="openRecipientView('{{envelopeData.envelopeId}}', '{{envelopeData.recipientEmail}}')"/></td>
												</tr>
											</tbody>
										</table>

									</div>

								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="text-center ng-hide" ng-hide="spfController.showBody">
					<br> <br> <br>
					<div class="spinner-circle spinner-sm"></div>
				</div>
			</div>
		</div>
		</section>
	</div>

	<script data-require="jquery.js@1.11.3" data-semver="1.11.3"
		src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script data-require="datatable.js@1.10.7" data-semver="1.10.7"
		src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

	<script data-require="angular.js@1.1.5" data-semver="1.4.5"
		src="https://code.angularjs.org/1.4.5/angular.min.js"></script>
	<script data-require="angular.js@1.1.5" data-semver="1.4.5"
		src="https://code.angularjs.org/1.4.5/angular-route.js"></script>
	<script data-require="angular.js@1.1.5" data-semver="1.4.5"
		src="https://code.angularjs.org/1.4.5/angular-resource.js"></script>


	<script data-require="angular-datatable.js@1.1.5" data-semver="1.1.5"
		src="js/angular-datatables.min.js"></script>

	<script
		src="https://docucdn-a.akamaihd.net/olive/17.11.0/js/olive-angular.min.js"></script>
	<script
		src="https://docucdn-a.akamaihd.net/olive/17.11.0/js/olive-migrate.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.4/holder.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script
		src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.7.0.js"></script>

	<script src="js/project_angular.js"></script>
</body>
</html>