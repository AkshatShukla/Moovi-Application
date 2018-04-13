(function () {
    angular
        .module("MooviApp")
        .controller("CriticSearchController", CriticSearchController);

    function CriticSearchController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/critic";
        vm.searchCriticByUsername = searchCriticByUsername;
        console.log("Hi Critic");
        $scope.$on('$viewContentLoaded', function()
        {
            $scope.myVal = false;
            $http
                .get(url)
                .then(function (value) {
                    $scope.allCriticsHeading = "All Critics";
                    $scope.critics = value.data;
                    console.log(value);
                })

        });

        $scope.myKeyPress = function(keyEvent,username) {
            if (keyEvent.which === 13)
                searchCriticByUsername(username);
        };

        function searchCriticByUsername(username) {
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