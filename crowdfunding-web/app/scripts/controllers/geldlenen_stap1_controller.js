/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldLenen_stap1_Ctrl', function ($scope, state) {
        state.active('geldlenen');
    })

    .value('state', {});


