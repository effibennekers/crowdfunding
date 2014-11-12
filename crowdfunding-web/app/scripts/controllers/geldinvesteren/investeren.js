/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('InvesterenCtrl', function ($scope, state, investerenStateService) {
        $scope.investering = investerenStateService.getSelectedInvestering();
        state.active('geldinvesteren');
    })
    .value('state', {});
