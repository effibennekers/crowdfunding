'use strict';

angular.module('CrowdFundingApp').controller('LoginCtrl', function ($scope, $modal, $log) {

    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
        console.log(size);
        var modalInstance = $modal.open({
            templateUrl: 'login.html',
            controller: 'LoginInstanceCtrl',
            size: size,
            resolve: {
                items: function () {
                    return $scope.items;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $scope.selected = selectedItem;
        }, function () {
            $log.info('Login dismissed at: ' + new Date());
        });
    };
});

angular.module('CrowdFundingApp').controller('LoginInstanceCtrl', function ($scope, $modalInstance, items, loginService) {

    $scope.items = items;
    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };


    $scope.signUp = function() {

        var signUp = setSignUpParams();

        signUp.save();

    }

    $scope.input = {};


    function setSignUpParams() {

        var signUp = loginService.signUp();

        signUp.email = $scope.input.email;
        signUp.first = $scope.input.first;
        signUp.last = $scope.input.last;
        signUp.passwd = $scope.input.passwd;

        return signUp;


    }




});

