angular.module('app',[]).controller('indexController', function ($scope, $http) {

    $scope.loadProducts = function() {
        $http.get('http://localhost:5555/products/api/v1/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.changePrice = function (productId, price) {
        $http({
            url: 'http://localhost:5555/products/api/v1/products/change_price',
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
        $http.delete('http://localhost:5555/products/api/v1/products/delete/' + productId)
        .then (function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addProduct = function (product) {
        $http.post('http://localhost:5555/products/api/v1/products', $scope.newProduct)
            .then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:5555/cart/api/v1/cart/add/' + productId)
            .then (function (response) {
                $scope.loadCart();
            });
    };

    $scope.clearCart = function (responce) {
        $http.get('http://localhost:5555/cart/api/v1/cart/clear')
            .then (function (response) {
                $scope.loadCart();
            });
    };

    $scope.loadCart = function() {
        $http.get('http://localhost:5555/cart/api/v1/cart')
            .then(function (response) {
                $scope.cart = response.data;
            });
    };

    $scope.createOrder = function () {
        $http.post('http://localhost:5555/products/api/v1/orders')
            .then(function (response){
                alert('Заказ оформлен');
                $scope.loadCart();
            });
    };

    $scope.loadProducts();
    $scope.loadCart();
});