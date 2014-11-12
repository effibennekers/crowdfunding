/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldLenen_stap1_Ctrl', function ($scope, state) {
        state.active('geldlenen');
        $scope.fee = { calculate: 0};

        $scope.berekenFee = function() {
            console.log($scope.inputR);
            $scope.fee.berekend = ($scope.krediet * $scope.looptijd);
        };
    })

    .value('state', {});


