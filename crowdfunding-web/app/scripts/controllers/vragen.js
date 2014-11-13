/**
 * Created by Jirodica on 12-11-14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('VragenCtrl', function ($scope, state) {
        state.active('vragen');

        $scope.vragen = [
            {nr: '1', onderwerp: 'Lenen', vraag: 'Hoeveel kan ik lenen?', antwoord: 'U kunt maximaal 1 miljoen lenen.'},
            {nr: '2', onderwerp: 'Lenen', vraag: 'Wat is de maximale leenperiode?', antwoord: 'U kunt maximaal 60 maanden lenen.'},
            {nr: '3', onderwerp: 'Investeren', vraag: 'Is er een minimum bedrag om te investren?', antwoord: 'Het minimum bedrag is 1 euro.'},
            {nr: '4', onderwerp: 'Investeren', vraag: 'Wat is het risico als ik uitleen?', antwoord: 'Er bestaat altijd de kans dat de investering (gedeelteliijk) niet wordt terugbetaald.'},
            {nr: '5', onderwerp: 'Investeren', vraag: 'Geldt er een minimum leeftijd om te mogen investeren?', antwoord: 'De minimum leeftijd is 18 jaar.'},
            {nr: '6', onderwerp: 'Algemeen', vraag: 'Wat is crownfunding?', antwoord: 'Crowdfunding (ook wel crowdfinancing genoemd) is een alternatieve wijze om een project te financieren.'},
        ];
    })

    .value('state', {});

