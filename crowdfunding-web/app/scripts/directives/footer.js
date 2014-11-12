'use strict';

angular.module('crowdfundingApp.directives').directive('footer',function($window, $log, $location) {
    return {
// Define directive properties
        restrict: 'E',

        template: '<p>ING Hackathon 2014</p>'

     };
});