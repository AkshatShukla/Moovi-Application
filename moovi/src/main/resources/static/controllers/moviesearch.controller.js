(function () {
    angular
        .module("MooviApp")
        .controller("MovieSearchController", MovieSearchController);

    function MovieSearchController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/search/movie";
        vm.searchMovieByTitle = searchMovieByTitle;

        $scope.userT = localStorage.getItem("userType");

        $scope.loading = "Loading Movies...";

        $scope.$on('$viewContentLoaded', function()
        {
            var nowPlayingUrl = "?nowPlaying=true";
            $scope.myVal = false;
            $scope.myVal1 = false;
            $http
                .get(url+nowPlayingUrl)
                .then(function (value) {
                    $scope.myVal1 = true;
                    $scope.nowplayingheading = "Now Playing Movies";
                    $scope.movies = value.data;
                })

        });

        $scope.myKeyPress = function(keyEvent,title) {
            if (keyEvent.which === 13)
                searchMovieByTitle(title);
        };

        function searchMovieByTitle(title) {
            //var url = "https://api.themoviedb.org/3/search/movie?api_key=878a88feb1d8acab0c9883e805657264&query="+title;
            var findByTitle = "?movieName="+title;
            $scope.myVal = true;
            $scope.myVal1 = false;
            $http
                .get(url+findByTitle)
                .then(function (response) {
                    console.log(response);
                    $scope.movies = response.data;
                });
            console.log(title);
            console.log(localStorage.getItem("username"));
        }

        vm.likeThisMovie = likeThisMovie;

        function likeThisMovie(movieId) {
            var username = localStorage.getItem("username");
            var likeUrl = localpath+"api/like/fan/"+username+"/movie/"+movieId;

            $http
                .post(likeUrl)
                .then(function () {
                    alert("Movie Liked");
                })
        }

        vm.dislikeThisMovie = dislikeThisMovie;

        function dislikeThisMovie(movieId) {
            var username = localStorage.getItem("username");
            var dislikeUrl = localpath+"api/dislike/fan/"+username+"/movie/"+movieId;

            $http
                .post(dislikeUrl)
                .then(function () {
                    alert("Movie Disliked");
                });
        }

        vm.recommendThisMovie = recommendThisMovie;

        function recommendThisMovie(movieId) {
            var username = localStorage.getItem("username");
            var recommendMovieURL = localpath+"api/recommend/critic/"+username+"/movie/"+movieId;

            $http
                .post(recommendMovieURL)
                .then(function () {
                    alert(username +" recommended a movie");
                });
        }

        vm.changeToReviewView = changeToReviewView;

        function changeToReviewView(movieName,movieId) {
            localStorage.setItem("movieName",movieName);
            localStorage.setItem("movieId",movieId);
            window.location = "#!/review";
        }
    }
})();