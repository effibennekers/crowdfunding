/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldInvesterenCtrl', function ($scope, state, projectenStateService, $location) {

        $scope.investeringen;

        var investeringenPromise = projectenStateService.getProjecten();
        investeringenPromise.then(function succes(data) {
             $scope.investeringen = data.data;
        }, function () {
            console.log("http://localhost:8080/rest/projecten FAILED");
        });

        $scope.rentepercentage = 1;

        $scope.bedrag = 50000;

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

        $scope.getProgressBarWidth = function (index) {
            var withPercentage = ($scope.investeringen[index].bereiktbedrag / $scope.investeringen[index].doelbedrag * 100);
            return "width:" + withPercentage + "%";
        }

        $scope.openProjectDetail = function (index) {
            console.log("index = " + index);
            enhanceInvestering(index);
            $scope.investeringen[index].hideDetails = !$scope.investeringen[index].hideDetails;
        }

        $scope.openInvestering = function (index) {
            projectenStateService.setSelectedProject(index);
            $location.path("/investeren");
        }

        state.active('geldinvesteren');
    })
    .value('state', {})
    .filter('rentepercentagefilter', function () {
        return function (items, rentepercentage) {
            var filtered = [];
            angular.forEach(items, function (item) {
                if (item.rentepercentage >= rentepercentage || rentepercentage === undefined || isNaN(rentepercentage)) {
                    filtered.push(item);
                }
            });
            return filtered;
        };
    })
    .filter('maximaalbedragfilter', function () {
        return function (items, maximaalbedrag) {
            var filtered = [];
            angular.forEach(items, function (item) {
                var pushToFilterd = false;
                if (maximaalbedrag === undefined || isNaN(maximaalbedrag)) {
                    pushToFilterd = true
                } else {
                    var maximaalbedragint = parseInt(maximaalbedrag);
                    var doelbedrag = parseInt(item.doelbedrag);
                    if (doelbedrag <= maximaalbedragint) {
                        pushToFilterd = true
                    }
                }

                if (pushToFilterd) {
                    filtered.push(item);
                }
            });
            return filtered;
        };
    });