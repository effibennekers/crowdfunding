/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldLenenCtrl', function ($scope, state, $location) {
        state.active('geldlenen');
        $scope.fee = { calculate: 0};
        $scope.fee = { rente: 0 };
        $scope.stap1 = true;
        $scope.stap2 = false;
        $scope.stap3 = false;
        $scope.stap4 = false;
        $scope.naam_klant = "Pietje Puk";
        $scope.iban_klant = "NL18INGB00766087889";

        $scope.berekenFee = function() {
            $scope.fee.berekend = (($scope.fee.krediet * $scope.fee.looptijd) * 0.0075);
            $scope.fee.berekend = roundNumber($scope.fee.berekend, 2);
        };

        function roundNumber(number, precision){
            precision = Math.abs(parseInt(precision)) || 0;
            var multiplier = Math.pow(10, precision);
            return (Math.round(number * multiplier) / multiplier);
        }
        $scope.geldlenen_stap1 = function(){
            $scope.stap1 = true;
            $scope.stap2 = false;
        };

        $scope.geldlenen_stap2 = function(){
            $scope.stap1 = false;
            $scope.stap2 = true;
            $scope.stap3 = false;
        };

        $scope.geldlenen_stap3 = function(){
            $scope.stap1 = false;
            $scope.stap2 = false;
            $scope.stap3 = true;
        };

        $scope.geldlenen_stap4 = function(){
            $scope.stap1 = false;
            $scope.stap2 = false;
            $scope.stap3 = false;
            $scope.stap4 = true;
        };
    })

    .value('state', {});


