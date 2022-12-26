angular.module('app',['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    $scope.authenticate = function () {
        $http.post('http://localhost:5555/auth/auth', $scope.auth)
            .then(function successAuthorization(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    let payload = JSON.parse(atob(response.data.token.split('.')[1]));
                    $localStorage.springMarketUser = {username: $scope.auth.username, token: response.data.token, role: payload.roles[0]};

                    $scope.auth.username = null;
                    $scope.auth.password = null;
                }
            }, function errorAuthorization(response){});
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.springMarketUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.isUserAdmin = function () {
        if ($localStorage.springMarketUser) {
            let userRole = $localStorage.springMarketUser.role;
            if (userRole.includes('ADMIN')) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.springMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.checkRoles = function (username) {
        $http.get('http://localhost:5555/auth/check_roles/' + username)
            .then(function (response) {
               alert (response.data.value);
            });
    };

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
        $http.post('http://localhost:5555/orders/api/v1/orders')
            .then(function (response){
                alert('Заказ оформлен');
                $scope.loadCart();
            });
    };

    $scope.loadProducts();
    $scope.loadCart();
});