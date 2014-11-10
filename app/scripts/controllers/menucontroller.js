/**
 * Created by rob_000 on 05/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
.controller('menuController', function($scope, state){
    state.active = function(viewName){
        $scope.activeNav = viewName;
    };
});
