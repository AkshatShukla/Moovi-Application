(function () {
    angular
        .module("MooviApp")
        .controller("TheatresManagedController", TheatresManagedController);

    function TheatresManagedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/manager/";
        var url2 = "/theatremanaged";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem("username")+url2)
                .then(function (response) {
                    $scope.allTheatresHeading = "All Theatres You Manage";
                    $scope.theatres = response.data;
                    console.log(response);
                })

        });

    }
})();