(function () {
    angular
        .module("MooviApp")
        .controller("MovieDetailsController", MovieDetailsController);
    
    function MovieDetailsController($routeParams) {
        var movieName = $routeParams.movieName;
        console.log("hello from details" + movieName);
    }
})();