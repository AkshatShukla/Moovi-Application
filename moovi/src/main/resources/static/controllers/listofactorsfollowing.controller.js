(function () {
    angular
        .module("MooviApp")
        .controller("ActorFollowingController", ActorFollowingController);

    function ActorFollowingController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/follow/fan/";
        var url2 = "/actorfollowed";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem("username")+url2)
                .then(function (response) {
                    $scope.allActorsHeading = "All Actors You Follow";
                    $scope.actors = response.data;
                    console.log(response);
                })

        });

    }
})();