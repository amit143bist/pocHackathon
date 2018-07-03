var app = angular.module('angularSPF', ['ngRoute','datatables','ui.bootstrap']);

app.controller('ModalCtrl', function($scope, $http, $timeout, $location, $window, $sce, DTOptionsBuilder) {

	var container = this;
	container.showBody = false;
	container.showIframe = false;
	container.custEnvelopes = [];
	
	$scope.url = $sce.trustAsResourceUrl('https://www.google.com');
	
	// DataTables configurable options
    $scope.dtOptions = DTOptionsBuilder.newOptions()
        /*.withDisplayLength(5)*/
        /*.withOption('bLengthChange', false)*/
        .withOption('lengthMenu', [5, 10, 50, 100]);

	$scope.roomId = 0;
	
	$scope.openRecipientView = function(envelopeId, recipientEmail){

    	console.log('openRecipientView envelopeId- '
				+ envelopeId + ' recipientEmail- '
				+ recipientEmail);
				
		var url = '/redirectToRecipientViewUrl?envelopeId=' + envelopeId + '&recipientEmail=' + recipientEmail;
		
		console.log('url-' + url);
		$window.location.href = url;
			
	}
		
	$scope.openRecipientViewAsIframe = function(envelopeId, recipientEmail){

    	console.log('openRecipientViewAsIframe envelopeId- '
				+ envelopeId + ' recipientEmail- '
				+ recipientEmail);
				
		var url = '/redirectToRecipientViewUrlIframe?envelopeId=' + envelopeId + '&recipientEmail=' + encodeURIComponent(recipientEmail);
		
		console.log('url in openRecipientViewAsIframe-' + url);
		container.showIframe = true;
		$scope.url = $sce.trustAsResourceUrl(url);
		$scope.$apply();
		
	}
		
	$scope.openRecipientViewAsPopUpIframe = function(envelopeId, recipientEmail){

    	console.log('openRecipientViewAsIframe envelopeId- '
				+ envelopeId + ' recipientEmail- '
				+ recipientEmail);
				
		container.showIframe = false;
		var url = '/redirectToRecipientViewUrlIframe?envelopeId=' + envelopeId + '&recipientEmail=' + encodeURIComponent(recipientEmail);
		
		console.log('url in openRecipientViewAsPopUpIframe-' + url);
		$window.open(url, 'width=500,height=400');
		
	}

	$scope.fetchAllEnvelopesJSON = function(recipientEmail) {

		console.log('recipientEmail ' + recipientEmail);
		container.custEnvelopes = [];
		
		$.ajax({
			type : 'GET',
			url : 'fetchRecipientEnvelopes',
			dataType : 'json',
			data: ({recipientEmail: recipientEmail}),
			success : function(respData) {

				$.each(respData, function(index, element) {

							console.log('dashBoardData- ' + index + ' elementName- '
							+ JSON.stringify(element));

						container.custEnvelopes.push(element);
				});
				
				$scope.$broadcast('dataloaded');
				container.showBody = true;
				$scope.$apply();
			},
			error : function(respData) {
				$scope.$apply();
			}
		});

	};
});