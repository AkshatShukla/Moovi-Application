(function () {
    angular
        .module("MooviApp")
        .controller("MyPageController", MyPageController);

    function MyPageController($scope) {
        var vm = this;

        $scope.uT = localStorage.getItem("userType");
    }
})();