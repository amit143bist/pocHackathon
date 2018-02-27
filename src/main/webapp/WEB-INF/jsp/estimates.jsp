<!DOCTYPE html>
<html ng-app="angularSPF">
<head>
<title>Estimates Demo</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/spf.css">
<link rel="stylesheet" href="css/tabFlow.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script src="/js/tabFlow.js"></script>
<script src="/js/rowAdd.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-sanitize.js"></script>
<script src="js/spf_angular.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

</head>
<body ng-app="angularSPF" ng-controller="SPFController as spfController">
	<div>
		<div class="grid-25 hidden"></div>

	</div>

	<div class="row headerSPF">
		<div class="col-sm-1" style="text-align: center"></div>
		<div class="col-sm-1" style="text-align: center">
			<img src="css/logo.png" height="60px" />
		</div>
		<div class="col-sm-8 collapsed">
			<h3>
				<i>Estimates Demo</i>
			</h3>
		</div>
		<div class="col-sm-2" style="text-align: center"></div>
	</div>

	<div class="row">
		<div class="col-md-6">&nbsp;</div>
		<div class="col-md-6">&nbsp;</div>
		<div class="col-md-6">&nbsp;</div>
		<div class="col-md-6">&nbsp;</div>
	</div>

	<div class="container">
		<div class="row">
			<section>
				<div class="wizard">
					<div class="wizard-inner">
						<div class="connecting-line"></div>
						<ul class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#step1"
								data-toggle="tab" aria-controls="step1" role="tab"
								title="Load Document"> <span class="round-tab"> <i
										class="glyphicon glyphicon-folder-open"></i>
								</span>
							</a></li>

							<li role="presentation" class="disabled"><a href="#complete"
								data-toggle="tab" aria-controls="step3" role="tab"
								title="Success"> <span class="round-tab"> <i
										class="glyphicon glyphicon-thumbs-up"></i>
								</span>
							</a></li>

						</ul>
					</div>

					<form role="form" enctype="multipart/form-data">
						<div class="tab-content">
							<div class="tab-pane active" role="tabpanel" id="step1">
								<div class="step1">

									<span class="h4">Select a valid Estimates Document</span>
									<hr>
									<div class="row mar_ned"></div>
									<div class="row">
										<div class="col-md-6">
											<input name="media[]" type="file" id="xmlTemplate" multiple>
										</div>
									</div>
									
									
									<div class="row clearfix">
										<div class="col-md-12">
											<input type="text" name='emailSubject'
															placeholder='Email Subject' required="required" class="form-control" />
											<input type="text" name='emailBlurb'
															placeholder='Email Body' class="form-control" />
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-md-12 table-responsive">
											<table
												class="table table-bordered table-hover table-sortable"
												id="tab_logic">
												<thead>
													<tr>
														<th class="text-center">Name</th>
														<th class="text-center">Email</th>
														<th class="text-center"
															style="border-top: 1px solid #ffffff; border-right: 1px solid #ffffff;">
														</th>
													</tr>
												</thead>
												<tbody>
													<tr id='addr0' data-id="0" class="hidden">
														<td data-name="name"><input type="text" name='name0'
															placeholder='Partner Name' required="required" class="form-control" /></td>
														<td data-name="mail"><input type="text" name='mail0'
															placeholder='Partner Email' required="required" class="form-control" /></td>
														<td data-name="del">
															<button
																nam"del0" class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div>
											<a id="add_row" class="btn btn-default pull-right">Add Row</a>
										</div>
									</div>
									
									<div>
									
										<ul class="list-inline pull-right">
											<li><button type="button" class="btn btn-primary next-step" ng-click="sendEnvelopes()">Send Envelopes</button></li>
										</ul>
								
									</div>
								</div>
							</div>


							<div class="tab-pane" role="tabpanel" id="complete">
								<div class="complete"
									ng-show="spfController.showComplete">
									<h4 style="text-align: center">All records successfully
												Submitted, envelopeId is</h4>
									<ul class="mappingFieldsInside">
											<li ng-repeat="value in spfController.validValue" class="list-group-item">
												{{value}}
											</li>
									</ul>
								</div>
								
							</div>

							<div class="clearfix"></div>
						</div>
					</form>
				</div>
			</section>
		</div>
	</div>
</body>
</html>