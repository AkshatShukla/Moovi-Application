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
            var url1 = localpath + "/api/follow/fan/" + localStorage.getItem("username") + "/critic/" + criticUsername;
            var followCriticURL = localpath + "api/follow/fan/" + username + "/critic/" + criticUsername;
            var count = 0;

            $http
                .get(url1)
                .then(function (response) {
                    //alert(username +" followed a critic: "+criticUsername);
                    $scope.criticsfollowed = response.data;
                    if (response.data === 1){
                        count = 1;
                    }
                    else
                    {
                        count = response.data.length;
                    }
                });

            if (count === 1) {

            $http
                .post(followCriticURL)
                .then(function () {
                    alert(username + " followed a critic: " + criticUsername);
                });
            }
            else
            {
                alert("You already follow this critic!");
            }
        }
    }
})();