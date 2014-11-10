/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('ProjectenCtrl', function ($scope, state) {
        state.active('home');
        $scope.test = "test";

        $scope.projects = [
            {nr: '1', naam: 'Snackbar', looptijd: '48 maanden', rente: '8,0 %'},
            {nr: '2', naam: 'Onroeren goed', looptijd: '60 maanden', rente: '7,0 %'},
            {nr: '3', naam: 'Autoverhuur', looptijd: '12 maanden', rente: '10,0 %'},
            {nr: '4', naam: 'Muziekband', looptijd: '48 maanden', rente: '8,0 %'}
        ];
    })

    .value('state', {});


