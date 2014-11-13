'use strict';

angular.module('crowdfundingApp.directives').directive('footer',function($window, $log, $location) {
    return {
// Define directive properties

        restrict: 'E',

        template: ' <span>We adviseren u slechts een verantwoord deel van uw vermogen te investeren in crowdfundingprojecten.</span><br/>' +
        '<span>Tevens adviseren we u, uw inleg te spreiden over meerdere projecten.</span><br/><br/>' +
        '<span>CrowdfundingAPI.nl heeft een vergunning op grond van artikel 2.83 Wft en staat onder toezicht van de AFM.</span><br/>' +
        '<span>© Copyright 2014 - Alle rechten voorbehouden. CrownfundingAPI.nl is een geregistreerd handelsmerk.</span>' +
        '<h4><strong>© ING Hackathon 2014<strong/></h4> '
     };
});
