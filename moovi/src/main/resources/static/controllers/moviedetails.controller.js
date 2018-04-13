(function () {
    angular
        .module("MooviApp")
        .controller("MovieDetailsController", MovieDetailsController);
    
    function MovieDetailsController($routeParams) {
        var movieName = $routeParams.movieName;
        alert("hello from details" + movieName);
    }
})();