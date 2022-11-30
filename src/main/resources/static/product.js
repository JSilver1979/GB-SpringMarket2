angular.module('app',[]).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app'

    $scope.loadProducts = function() {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.changePrice = function (productId, price) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                price: price
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/products/delete_product',
            method: 'GET',
            params: {
                productId: productId
            }
        }).then (function (response) {
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();
});