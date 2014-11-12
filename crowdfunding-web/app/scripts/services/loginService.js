angular.module('CrowdFundingApp')
    .service('loginService', function($resource) {

       function signUp() {

            return $resource("http://localhost:8080/rest/api/login", {}, {
                save: { method: "POST", isArray: true }

            });
        }


       return { signUp: signUp
           }


    });