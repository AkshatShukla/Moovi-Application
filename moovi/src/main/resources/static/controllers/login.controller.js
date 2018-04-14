(function () {
    angular
        .module("MooviApp")
        .controller("LoginController", LoginController);

    function LoginController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "api/";
        vm.checkIfValidUser = checkIfValidUser;

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
        var redirectToURL = "../index.html";
        function checkIfValidUser(username, password, userType) {

            $http
                .get(localpath+url+userType+"?username="+username)
                .then(function (response) {
                    $scope.user = response.data;
                    if (response.data.length === 0){
                        alert ("Incorrect Login, Please register first!");
                        console.log(response);
                    }
                    else
                    {
                        localStorage.setItem('username',username);
                        alert("Successfully logged in as " + username);
                        console.log(response);
                        window.location.href = localpath+"#!/mypage";
                    }

                }, function(){
                    alert("Please register first!");
                });

            console.log(username);
            console.log(password);
            console.log(userType);
        }

    }
})();