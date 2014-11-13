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

            return $http.post(' http://localhost:8080/rest/projecten ', postData);
        }

        return {
            addInvestering: addInvestering
        }


    });