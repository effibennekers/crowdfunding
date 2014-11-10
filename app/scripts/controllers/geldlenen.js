/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldLenenCtrl', function ($scope, state) {
        state.active('geldlenen');

        $scope.currentTime = new Date();
    })
    .value('state', {});


