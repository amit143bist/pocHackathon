var app = angular.module('angularSPF', ['ngRoute','datatables','ui.bootstrap']);

app.controller('ModalCtrl', function($scope, $http, $timeout, $location, $window, $sce, DTOptionsBuilder, $interval) {

	var container = this;
	container.showBody = false;
	container.custEnvelopes = [];
	
	// DataTables configurable options
    $scope.dtOptions = DTOptionsBuilder.newOptions()
        .withOption('lengthMenu', [5, 10, 50, 100]);

	$scope.fetchAllEnvelopesJSON = function(envelopeId) {

		console.log('envelopeId ' + envelopeId);
		container.custEnvelopes = [];
		
		$.ajax({
			type : 'GET',
			url : 'fetchSignedFormData',
			dataType : 'json',
			data: ({envelopeId: envelopeId}),
			success : function(respData) {
				
				console.log('success login- ' + respData);
				console.log('success login- ' + respData.envelopeDataAvailable);

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