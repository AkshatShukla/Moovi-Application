(function () {
    angular
        .module("MooviApp")
        .controller("NavbarController", NavbarController);
    
    function NavbarController($scope) {

        $scope.typeRole = localStorage.getItem("userType");
    }

})();