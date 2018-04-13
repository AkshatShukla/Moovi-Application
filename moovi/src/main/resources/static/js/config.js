(function () {
    angular
        .module("MooviApp",["ngRoute"])
        .config(Config);

    function Config($routeProvider) {
        $routeProvider
            .when("/searchMovie", {
                templateUrl: "views/searchmovie.html",
                controller: "MovieSearchController",
                controllerAs: "model"

            })
            .when("/searchActor", {
                templateUrl: "views/searchactor.html",
                controller: "ActorSearchController",
                controllerAs: "ac"
            })
            .when("/searchCritic", {
                templateUrl: "views/searchcritic.html",
                controller: "CriticSearchController",
                controllerAs: "cr"
            })
            .when("/movieDetails/:movieName", {
                templateUrl: "views/moviedetails.html",
                controller: "MovieDetailsController",
                controllerAs: "md"
            })
            .when("/login", {
                    templateUrl: "views/login.html",
                    controller: "LoginController",
                    controllerAs: "login"
            })
            .when("/register", {
                    templateUrl: "views/register.html",
                    controller: "RegisterController",
                    controllerAs: "register",
            })
    }
})();