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
            .when("/searchFan", {
                templateUrl: "views/searchfan.html",
                controller: "FanSearchController",
                controllerAs: "fs"
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
            .when("/listOfActorsYouFollow", {
                templateUrl: "views/listOfActorsYouFollow.html",
                controller: "ActorFollowingController",
                controllerAs: "af"
            })
            .when("/listOfMoviesYouLiked", {
                templateUrl: "views/listOfMoviesYouLiked.html",
                controller: "MovieLikedController",
                controllerAs: "ml"
            })
            .when("/listOfMoviesYouDisliked", {
                templateUrl: "views/listOfMoviesYouDisliked.html",
                controller: "MovieDislikedController",
                controllerAs: "mdl"
            })
            .when("/listOfFansWhoFollowYou", {
                templateUrl: "views/listOfFansWhoFollowYou.html",
                controller: "FansFollowedController",
                controllerAs: "ffb"
            })
            .when("/listOfMoviesYouRecommended", {
                templateUrl: "views/listOfMoviesYouRecommended.html",
                controller: "MovieRecommendedController",
                controllerAs: "mrc"
            })
            .when("/listOfMoviesYouReviewed", {
                templateUrl: "views/listOfMoviesYouReviewed.html",
                controller: "MovieReviewedController",
                controllerAs: "mrv"
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