(function () {
    angular
        .module("MooviApp")
        .controller("FansFollowedOfFanController", FansFollowedOfFanController);

    function FansFollowedOfFanController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/follow/fan/";
        var url2 = "/followedby";

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