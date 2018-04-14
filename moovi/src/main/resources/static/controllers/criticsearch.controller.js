(function () {
    angular
        .module("MooviApp")
        .controller("CriticSearchController", CriticSearchController);

    function CriticSearchController($http, $scope) {

        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/critic";
        vm.searchCriticByUsername = searchCriticByUsername;

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
            var findByName = "?username="+username;
            $scope.myVal = true;
            $http
                .get(url+findByName)
                .then(function (response) {
                    console.log(response);
                    $scope.critics = response.data;
                });
        }

        vm.followThisCritic = followThisCritic;

        function followThisCritic(criticUsername) {
            var username = localStorage.getItem("username");
            var followCriticURL = localpath+"api/follow/fan/"+username+"/critic/"+criticUsername;

            $http
                .post(followCriticURL)
                .then(function () {
                    alert(username +" followed a critic: "+criticUsername);
                });
        }
    }
})();