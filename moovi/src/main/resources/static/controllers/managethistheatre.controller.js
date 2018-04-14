(function () {
    angular
        .module("MooviApp")
        .controller("ManageTheatreController", ManageTheatreController);

    function ManageTheatreController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "api/theatre";
        vm.registerTheatreForTheatreManager = registerTheatreForTheatreManager;

        /*$scope.myKeyPress = function(keyEvent,name) {
            if (keyEvent.which === 13)
                searchActorByName(name);
        };*/

        function registerTheatreForTheatreManager(theatreName, location, noOfScreens) {

            var newTheatre = {
                "theatreName":theatreName,
                "location":location,
                "totalScreens":noOfScreens
            };

            var username = localStorage.getItem("username");
            var createTheatreURL = localpath+url;
            $http
                .post(createTheatreURL, newTheatre)
                .then(function(response) {
                    $scope.theatre = response;
                    alert("Theatre created!");

                    vm.linkManagerToTheatreURL = linkManagerToTheatreURL;

                    function linkManagerToTheatreURL() {

                        $scope.theatreResponse = angular.fromJson(response.data);

                        var linkingURL = localpath+"/api/manage/theatre/"+$scope.theatreResponse.theatreId+"/manager/"+username;

                        $http
                            .post(linkingURL)
                            .then(function(response) {
                                //$scope.theatre = response;
                                alert("TheatreManager assigned to this Theatre!");
                            });

                    }

                    linkManagerToTheatreURL();
            });




            /*var createScreensURL = localpath+"/api/screen"
            $http
                .post(linkManagerToTheatreURL)
                .then(function(response) {
                    //$scope.theatre = response;
                    alert("TheatreManager assigned to this Theatre!");
                });*/
        }

    }
})();