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

        function checkIfValidUser(username, password, userType) {

            $http
                .get(localpath+url+userType+"?username="+username)
                .then(function (response) {
                    alert("Hello " + username);
                    console.log(response);
                    $scope.user = response.data;
                }, function(){
                    alert("Please register first!");
                });

            console.log(username);
            console.log(password);
            console.log(userType);
        }

    }
})();