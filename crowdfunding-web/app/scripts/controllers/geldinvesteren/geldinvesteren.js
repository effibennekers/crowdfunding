/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldInvesterenCtrl', function ($scope, state, investerenStateService,  $location) {

        $scope.investeringen = investerenStateService.getInvesteringen();

            function enhanceInvestering(i) {
            var withPercentage = ($scope.investeringen[i].bereiktbedrag / $scope.investeringen[i].doelbedrag * 100);
            $scope.investeringen[i].withPercentage = withPercentage;
            if (withPercentage < 33) {
                $scope.investeringen[i].progressbar = "progress-bar-danger"
            } else if (withPercentage < 66) {
                $scope.investeringen[i].progressbar = "progress-bar-warning"
            } else {
                $scope.investeringen[i].progressbar = "progress-bar-success"
            }
        }

        $scope.getProgressBarWidth = function(index) {
            var withPercentage = ($scope.investeringen[index].bereiktbedrag / $scope.investeringen[index].doelbedrag * 100);
            return "width:"+withPercentage+"%";
        }

        $scope.openProjectDetail = function(index) {
            enhanceInvestering(index);
            $scope.investeringen[index].hideDetails = !$scope.investeringen[index].hideDetails;
        }

        $scope.openInvestering = function(index) {
            investerenStateService.setSelectedInvestering(index);
            $location.path("/investeren");
        }

        state.active('geldinvesteren');
    })
    .value('state', {});
