(function () {
    angular
        .module("MooviApp")
        .controller("CriticFollowingController", CriticFollowingController);

    function CriticFollowingController($http, $scope) {

        var vm = this;
        alert("Hello Critic Following!");
        var localpath = "http://localhost:8080/";
        var url1 = "api/follow/fan/";
        var url2 = "/criticfollowed";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem('username')+url2)
                .then(function (response) {
                    $scope.allCriticsHeading = "All Critics You Follow";
                    $scope.critics = response.data;
                    console.log(response);
                })

        });

    }
})();