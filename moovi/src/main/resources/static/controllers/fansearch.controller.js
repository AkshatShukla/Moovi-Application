(function () {
    angular
        .module("MooviApp")
        .controller("FanSearchController", FanSearchController);

    function FanSearchController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/follow/fan/";
        var url2 = "/fansfollowing";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem('username')+url2)
                .then(function (response) {
                    $scope.allFansHeading = "All Fans You Follow";
                    $scope.fans = response.data;
                    console.log(response);
                })

        });

    }
})();