angular.module('CrowdFundingApp')
    .service('investeringStateService', function ($http) {


        function addInvestering(investeerder, bedrag,project,beloning,rentepercentage,status,betaalperiode) {

            var postData = {
                "investeerder": investeerder,
                "bedrag": bedrag,
                "project": project,
                "beloning": beloning,
                "rentepercentage": rentepercentage,
                "status": status,
                "afbetaalperiode": betaalperiode
            };

            return $http.put('http://localhost:8080/rest/investeringen', postData);
        }

        return {
            addInvestering: addInvestering
        }


    });