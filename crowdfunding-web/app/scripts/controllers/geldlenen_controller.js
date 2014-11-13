/**
 * Created by rob_000 on 04/11/14.
 */
'use strict';

angular.module('CrowdFundingApp')
    .controller('GeldLenenCtrl', function ($scope, state, $location, $http) {
        state.active('geldlenen');
        $scope.fee = { calculate: 0};
        $scope.fee = { rente: 0 };
        $scope.stap1 = true;
        $scope.stap2 = false;
        $scope.stap3 = false;
        $scope.stap4 = false;
        $scope.naam_klant = "Pietje Puk";
        $scope.iban_klant = "NL18INGB00766087889";

        $scope.berekenFee = function () {
            $scope.fee.berekend = (($scope.fee.krediet * $scope.fee.looptijd) * 0.0075);
            $scope.fee.berekend = roundNumber($scope.fee.berekend, 2);
        };

        function roundNumber(number, precision) {
            precision = Math.abs(parseInt(precision)) || 0;
            var multiplier = Math.pow(10, precision);
            return (Math.round(number * multiplier) / multiplier);
        }

        $scope.subscribe = {};

        $scope.subscribe.account = 'option1';

        $scope.submitForm = function () {

            var email = $scope.subscribe.email;
            var password = $scope.subscribe.password;
            var voornaam = $scope.subscribe.voornaam;
            var achternaam = $scope.subscribe.achternaam;
            var straatnaam = $scope.subscribe.straatnaam;
            var nr = $scope.subscribe.nr || null;
            var postcode = $scope.subscribe.postcode;
            var plaats = $scope.subscribe.plaats;
            var ingrek = $scope.subscribe.ingrekening || null;
            var debrek = $scope.subscribe.debtorrekeningnummer || null;
            var tel = $scope.subscribe.telefoon || null;
            var geb = $scope.subscribe.geb || null;

            if (email != undefined && password != undefined && voornaam != undefined && achternaam != undefined && straatnaam != undefined && postcode != undefined && plaats != undefined) {


                $http.put('http://localhost:8080/rest/klanten', {'email': email, 'password': password, 'voornaam': voornaam, 'achternaam': achternaam, 'straatnaam': straatnaam, 'huisnummer': nr, 'plaats': plaats, 'debtoriban': debrek, 'creditoriban': ingrek, 'telefoonnummer': tel, 'postcode': postcode, 'geboortedag': geb, 'ingklant': 'nee', 'contract': null, 'authtoken': null});

                $scope.subscribe(true);

            }


        }


        $scope.login = {};

        $scope.login = function () {
            var email = $scope.login.email;
            var password = $scope.login.password;


            $http.get('http://localhost:8080/rest/klanten/login?email=' + email + '&password=' + password).success(function (data) {

                if(data.email == email && data.password == password) {
                    $scope.geldlenen_stap2();
                }


            }).error(function () {

                });

        }


        $scope.ingAccount = function (value) {

            var ingAccount = false;

            if (value === 'option1') {
                ingAccount = true;

            }

            return ingAccount;

        }

        $scope.existingUser = true;

        $scope.subscribe = function (value) {

            $scope.existingUser = value;

        }


        $scope.geldlenen_stap1 = function () {
            $scope.stap1 = true;
            $scope.stap2 = false;
        };

        $scope.geldlenen_stap2 = function () {
            $scope.stap1 = false;
            $scope.stap2 = true;
            $scope.stap3 = false;
        };

        $scope.geldlenen_stap3 = function () {
            $scope.stap1 = false;
            $scope.stap2 = false;
            $scope.stap3 = true;
        };

        $scope.geldlenen_stap4 = function () {
            $scope.stap1 = false;
            $scope.stap2 = false;
            $scope.stap3 = false;
            $scope.stap4 = true;
        };
    })

    .value('state', {});


