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
                    controllerAs: "register"
            })
            .when("/manageThisTheatre", {
                templateUrl: "views/manageThisTheatre.html",
                controller: "ManageTheatreController",
                controllerAs: "theatre"
            })
            .when("/review", {
                templateUrl: "views/review.html",
                controller: "ReviewController",
                controllerAs: "rev"
            })
            .when("/mypage", {
                templateUrl: "views/mypage.html",
                controller: "MyPageController",
                controllerAs: "mp"
            })
            .when("/admin", {
                templateUrl: "views/admin.html",
                controller: "AdminController",
                controllerAs: "ad"
            })
            .when("/listOfFansYouFollow", {
                templateUrl: "views/listOfFansYouFollow.html",
                controller: "FanFollowingController",
                controllerAs: "ff"
            })
            .when("/listOfCriticsYouFollow", {
                templateUrl: "views/listOfCriticsYouFollow.html",
                controller: "CriticFollowingController",
                controllerAs: "cf"
            })
            .when("/movieForAdmin", {
                templateUrl:"views/movieForAdmin.html",
                controller:"EditMovieController",
                controllerAs:"em"
            })
            .otherwise({
                templateUrl : "views/landingpage.html"
            });
    }
})();