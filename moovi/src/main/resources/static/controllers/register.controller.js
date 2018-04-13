(function () {
    angular
        .module("MooviApp")
        .controller("RegisterController", RegisterController);

    function RegisterController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "api/";
        vm.registerUserInDb = registerUserInDb;

        /*$scope.$on('$viewContentLoaded', function()
        {
            var nowPlayingUrl = "?nowPlaying=true";
            $scope.myVal = false;
            $http
                .get(url+nowPlayingUrl)
                .then(function (value) {
                    $scope.nowplayingheading = "Now Playing Movies";
                    $scope.movies = value.data;
                })

        });

        $scope.myKeyPress = function(keyEvent,title) {
            if (keyEvent.which === 13)
                searchMovieByTitle(title);
        };*/

        function registerUserInDb(firstName, lastName, username, password, userType, email, dob, userDescription) {
            var newUser;

            if (userType === "fan")
            {
                newUser = {
                    "firstName":firstName,
                    "lastName":lastName,
                    "username":username,
                    "password":password,
                    "email": email,
                    "dob": dob,
                    "fanDescription": userDescription
                };
            }
            else if (userType === "critic")
            {
                newUser = {
                    "firstName":firstName,
                    "lastName":lastName,
                    "username":username,
                    "password":password,
                    "email": email,
                    "dob": dob,
                    "criticDescription": userDescription
                };
            }
            else if (userType === "adrecruiter")
            {
                newUser = {
                    "firstName":firstName,
                    "lastName":lastName,
                    "username":username,
                    "password":password,
                    "email": email,
                    "dob": dob,
                    "adrecruiterDescription": userDescription
                };
            }
            else if (userType === "theatremanager")
            {
                newUser = {
                    "firstName":firstName,
                    "lastName":lastName,
                    "username":username,
                    "password":password,
                    "email": email,
                    "dob": dob,
                    "theatremanagerDescription": userDescription
                };
            }

            $http
                .post(localpath+url+userType, newUser)
                .then(function (response) {
                    $scope.user = response.data;
                    alert("Successfully registered!");
                    window.location = "../views/login.html";
                });

            console.log(username);
            console.log(password);
            console.log(userType);
        }
    }
})();