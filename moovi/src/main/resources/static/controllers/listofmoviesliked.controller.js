(function () {
    angular
        .module("MooviApp")
        .controller("MovieLikedController", MovieLikedController);

    function MovieLikedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/like/fan/";
        var url2 = "/moviesliked";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem("username")+url2)
                .then(function (response) {
                    $scope.allMoviesLikedHeading = "All Movies You Like";
                    $scope.movies = response.data;
                    console.log(response);
                })

        });

    }
})();