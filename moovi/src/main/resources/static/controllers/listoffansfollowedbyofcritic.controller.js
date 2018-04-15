(function () {
    angular
        .module("MooviApp")
        .controller("FansFollowedController", FansFollowedController);

    function FansFollowedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/follow/critic/";
        var url2 = "/fanfollowing";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem('username')+url2)
                .then(function (response) {
                    $scope.allFansHeading = "All Fans Who Follow You";
                    $scope.fans = response.data;
                    console.log(response);
                })

        });

    }
})();