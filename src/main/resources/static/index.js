angular.module('app',[]).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app'

    $scope.loadProducts = function() {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.changeScore = function (studentId, delta) {
        $http({
            url: contextPath + '/students/change_score',
            method: 'GET',
            params: {
                studentId: studentId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();
});