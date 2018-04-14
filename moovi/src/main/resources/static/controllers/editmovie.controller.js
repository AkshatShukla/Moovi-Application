(function () {
    angular
        .module("MooviApp")
        .controller("EditMovieController", EditMovieController);

    function EditMovieController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        alert("hi from EditMovieController");

        vm.addMovie = addMovie;

        $scope.$on('$viewContentLoaded', function()
        {
            var allMovieUrl = "api/movie";
            $http
                .get(localpath+allMovieUrl)
                .then(function (value) {
                    $scope.movies = value.data;
                })

        });

        function addMovie(movieName, overview, posterSrc, releaseDate, imdbRating, revenue, runtime, releaseStatus, imdbId) {

        }
    }
})();