/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldInvesterenCtrl', function ($scope, state) {
        state.active('geldinvesteren');
    })
    .value('state', {});
