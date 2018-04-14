(function () {
    angular
        .module("MooviApp")
        .controller("LikeController", LikeController);

    function LikeController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var followUrl = "/like/api/";
        vm.searchUserByUsername = searchUserByUsername;
        //console.log("Hi"+userType);

        function searchUserByUsername(username) {
            //var url = "https://api.themoviedb.org/3/search/movie?api_key=878a88feb1d8acab0c9883e805657264&query="+title;
            var findByName = "?username="+username;
            $scope.myVal = true;
            $http
                .get(url+findByName)
                .then(function (response) {
                    console.log(response);
                    $scope.critics = response.data;
                });
            console.log(name);
        }

    }
})();