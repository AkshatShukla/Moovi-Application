(function () {
    angular
        .module("MooviApp")
        .controller("ActorsRecruitedController", ActorsRecruitedController);

    function ActorsRecruitedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/recruit/adrecruiter/";
        var url2 = "/actorsrecruited";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem("username")+url2)
                .then(function (response) {
                    $scope.allActorsHeading = "All Actors You Recruited";
                    $scope.actors = response.data;
                    console.log(response);
                })

        });

    }
})();