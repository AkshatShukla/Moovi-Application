(function () {
    angular
        .module("MooviApp", [])
        .controller("MovieSearchController", MovieSearchController);
    
    function MovieSearchController($http, $scope) {
        var vm = this;
        vm.searchMovieByTitle = searchMovieByTitle;
        
        function searchMovieByTitle(title) {
            //var url = "https://api.themoviedb.org/3/search/movie?api_key=878a88feb1d8acab0c9883e805657264&query="+title;
            var localpath = "http://localhost:8080/";
            var url = "/api/search/movie?movieName="+title;
            $http
                .get(url)
                .then(function (response) {
                    console.log(response);
                    $scope.movies = response.data;
                });
            console.log(title);

        }
    }
})();