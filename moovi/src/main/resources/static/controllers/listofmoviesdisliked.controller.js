(function () {
    angular
        .module("MooviApp")
        .controller("MovieDislikedController", MovieDislikedController);

    function MovieDislikedController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url1 = "api/dislike/fan/";
        var url2 = "/moviesdisliked";

        $scope.$on('$viewContentLoaded', function()
        {
            $http
                .get(localpath+url1+localStorage.getItem("username")+url2)
                .then(function (response) {
                    $scope.allMoviesDislikedHeading = "All Movies You Dislike";
                    $scope.movies = response.data;
                    console.log(response);
                })

        });

    }
})();