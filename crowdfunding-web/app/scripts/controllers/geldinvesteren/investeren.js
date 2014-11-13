/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('InvesterenCtrl', function ($scope, state, projectenStateService, investeringStateService) {

        var investeringenPromise = projectenStateService.getProjecten();
        investeringenPromise.then(function succes(data) {
            $scope.investering = data.data[projectenStateService.getSelectedproject()];
        }, function () {
            console.log("http://localhost:8080/rest/projecten FAILED");
        });

        $scope.addInvestering = function (investeerder, bedrag, project, belongin, rentepercentage, status, betaalperiode) {
            var investeerder = "2";
            var bedrag = "200";
            var project = "1";
            var belongin = "raceauto";
            var rentepercentage = "6";
            var status = "betaald";
            var betaalperiode = "2";
            var addInversteringPromise = investeringStateService.addInvestering(investeerder, bedrag, project, belongin, rentepercentage, status, betaalperiode);
            addInversteringPromise.then(function succes(data) {
                    console.log("works " + JSON.stringify(data,null,3));
                }
                , function error(data) {
                    console.log("shit happens");
                });
        }

//        {
//            "investeerder": 15302,
//            "bedrag": 500,
//            "project": 1,
//            "beloning": "Maandelijks uitgekeerde rente",
//            "rentepercentage": 7,
//            "status": "toegezegd",
//            "afbetaalperiode": 20,
//            "afbetalingen": null
//        }

        state.active('geldinvesteren');
    })
    .value('state', {});
