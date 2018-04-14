(function () {
    angular
        .module("MooviApp")
        .controller("EditMovieController", EditMovieController);

    function EditMovieController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";

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

        function addMovie(movieId, movieName, overview, posterSrc, releaseDate, imdbRating, revenue, runtime, releaseStatus, imdbId) {
            var newMovie;

            newMovie = {
                "movieId":movieId,
                "movieName":movieName,
                "imdbId":imdbId,
                "posterSRC":posterSrc,
                "runtime":runtime,
                "imdbRating":imdbRating,
                "releaseDate":releaseDate,
                "revenue":revenue,
                "releaseStatus":releaseStatus,
                "overview":overview
            };

            var insertMovieUrl = "api/movie";
            $http
                .post(localpath+insertMovieUrl, newMovie)
                .then(function (response) {
                    $scope.movie = response.data;
                    alert("movie added");
                    location.reload(true);
                });
        }

        vm.deleteMovie = deleteMovie;

        function deleteMovie(movieId) {
            var deleteMovieUrl = "api/delete/movie/"+movieId;
            $http
                .delete(localpath+deleteMovieUrl)
                .then(function () {
                    location.reload(true);
                })
        }
    }
})();