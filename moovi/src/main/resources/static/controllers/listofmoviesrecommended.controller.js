(function () {
    angular
        .module("MooviApp")
        .controller("MovieRecommendedController", MovieRecommendedController);

    function MovieRecommendedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/recommend/critic/";
        var url2 = "/recommendedmovies";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem('username')+url2)
                .then(function (response) {
                    $scope.allMoviesRecommendedHeading = "All Movies You Recommended";
                    $scope.movies = response.data;
                    console.log(response);
                })
        });
    }
})();