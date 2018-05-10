var app = angular.module('angularSPF', ['ngRoute','datatables','ui.bootstrap']);

app.controller('ModalCtrl', function($scope, $http, $timeout, $location, $window, DTOptionsBuilder) {

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
					
			var url = '/redirectToRecipientViewUrl?envelopeId' + envelopeId + '&recipientEmail=' + recipientEmail;
			
			console.log('url-' + url);
			$window.location.href = url;
			/*$.ajax({
				type : 'POST',
				crossOrigin : true,
				url : 'createRecipientViewUrl',
				data : ({
					envelopeId : envelopeId,
					recipientEmail : recipientEmail
				}),
				success : function(data) {
					console.log('success redirect- ' + data);
					console.log('success redirect- ' + data.redirect);
				},
				complete : function(data) {
					console.log('complete redirect- ' + data);
					console.log('complete redirect- ' + data.redirect);
				},
				error: function(xhr, textStatus, errorThrown) { 
		            console.log('Error!  Status = ' + xhr.status); 
		         }
			});*/
			
			/*var dataObj = {
				envelopeId : 'b84ef791-6d05-40fb-b645-5b4a4edcbd05',
				recipientEmail : 'docusign.sso@gmail.com'
			};
			
			var res = $http.post('/createRecipientViewUrl', dataObj);
			res.success(function(data, status, headers, config) {
				console.log('success ' + data + ' status- ' + status + ' headers- ' + headers + ' config ' + config );
				
				$location.path('/redirectToRecipientViewUrl');
			});
			res.error(function(data, status, headers, config) {
				console.log( "failure message: " + data + ' status- ' + status + ' headers- ' + headers + ' config ' + config);
			});*/
			
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