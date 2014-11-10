'use strict';

/**
 * @ngdoc overview
 * @name crowdfundingoApp
 * @description
 * # angularDemoApp
 *
 * Main module of the application.
 */
angular
  .module('CrowdFundingApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'crowdfundingApp.filters',
    'crowdfundingApp.directives'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/projecten.html',
        controller: 'ProjectenCtrl'
      })
      .when('/geldlenen', {
            templateUrl: 'views/geldlenen.html',
            controller: 'GeldLenenCtrl'
      })
      .when('/geldinvesteren', {
        templateUrl: 'views/geldinvesteren.html',
        controller: 'GeldInvesterenCtrl'
      })
      .when('/profiel', {
        templateUrl: 'views/profiel.html',
        controller: 'ProfielCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
angular.module('crowdfundingApp.filters', []);
angular.module('crowdfundingApp.directives', []);
