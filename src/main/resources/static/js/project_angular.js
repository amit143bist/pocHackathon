var app = angular.module('angularSPF', ['ngRoute','datatables','ui.bootstrap']);

app.controller('ModalCtrl', function($scope, $http, $timeout, DTOptionsBuilder) {

	var container = this;
	container.showBody = false;
	container.custEnvelopes = [];
	
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
					console.log('success redirect- ');
				}
			});
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