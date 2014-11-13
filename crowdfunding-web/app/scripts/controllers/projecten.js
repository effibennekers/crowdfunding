/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('ProjectenCtrl', function ($scope, state) {
        state.active('home');

        $scope.test = "test";

        $scope.projects = [
            {nr: '326', naam: 'Snackbar', looptijd: '48 maanden', rente: '7,0 %', totaalbedrag: '35.000', categorie: 'laag risico'},
            {nr: '547', naam: 'Onroeren goed', looptijd: '60 maanden', rente: '5,0 %', totaalbedrag: '235.000', categorie: 'hoog risico'},
            {nr: '660', naam: 'Autoverhuur', looptijd: '12 maanden', rente: '8,0 %', totaalbedrag: '7.500', categorie: 'gemiddeld risico'},
            {nr: '788', naam: 'Muziekband', looptijd: '48 maanden', rente: '4,0 %', totaalbedrag: '2.500', categorie: 'laag risico'}
        ];
    })

    .value('state', {});


