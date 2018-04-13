var app = angular.module("MooviApp", ['ngRoute']);

app.config(function ($routeProvider) {
	$routeProvider
		.when('/searchMovie', {
			template: 'partials/searchMovie.html',
			controller: 'MovieSearchController'
		})
		.when('/login', {
			template: 'partials/login.html',
			controller: 'LoginController'
		})
		.when('/register', {
			template: 'partials/register.html',
			controller: 'RegisterController',
			redirectTo: 'partials/login.html'
		})
		.when('/', {
			template: 'index.html',
			controller: 'initiator'
		})
});

app.controller('MovieSearchController' , function MovieSearchController($http, $scope, $window) {
    var vm = this;
    var localpath = "http://localhost:8080/";
    var url = "/api/search/movie";
    vm.searchMovieByTitle = searchMovieByTitle;

    $window.onload = function () {
        var nowPlayingUrl = "?nowPlaying=true";
        $scope.myVal = false;
        $http
            .get(url+nowPlayingUrl)
            .then(function (value) {
                $scope.nowplayingheading = "Now Playing Movies";
                $scope.movies = value.data;
            })
    };
    $scope.myKeyPress = function(keyEvent,title) {
        if (keyEvent.which === 13)
            searchMovieByTitle(title);
    };
    
    function searchMovieByTitle(title) {
        //var url = "https://api.themoviedb.org/3/search/movie?api_key=878a88feb1d8acab0c9883e805657264&query="+title;
        var findByTitle = "?movieName="+title;
        $scope.myVal = true;
        $http
            .get(url+findByTitle)
            .then(function (response) {
                console.log(response);
                $scope.movies = response.data;
            });
        console.log(title);
    }
});

app.controller('RegisterController', function LoginController($http, $scope) {
	var localpath = "http://localhost:8080/";
	
	function checkIfValidUser(username, password, userType) {
		var url = "/api/";
        $http
            .get(url+userType.toLowerCase())
            .then(function (response) {
                console.log(response);
                $scope.user = response.data;
            });
    }
});

app.controller('initiator' , function($scope, $http) {
	angular.element(document).ready(function () {
	});
});
