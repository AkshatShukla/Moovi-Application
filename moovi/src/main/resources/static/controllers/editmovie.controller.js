(function () {
    angular
        .module("MooviApp")
        .controller("EditMovieController", EditMovieController);

    function EditMovieController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        alert("hi from EditMovieController");
    }
})();