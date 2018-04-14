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
                                $scope.theatre = response;
                                alert("TheatreManager assigned to this Theatre!");


                            });

                    }

                    linkManagerToTheatreURL();

                    vm.createScreen = createScreen;

                    function createScreen() {

                        var createScreenURL = localpath + "api/screen";

                        var newScreen = {};

                        $http
                            .post(createScreenURL, newScreen)
                            .then(function (response2) {
                                $scope.screen = response2;
                                alert(noOfScreens + " screens created!");

                                vm.linkScreenToTheatreURL = linkScreenToTheatreURL;

                                function linkScreenToTheatreURL() {

                                    $scope.screenResponse = angular.fromJson(response2.data);
                                    //$scope.theatreResponse = angular.fromJson(response.data);

                                    var linkingScreenToTheatreURL = localpath + "api/screen/" + $scope.screenResponse.screenId + "/theatre/" + $scope.theatreResponse.theatreId;

                                    $http
                                        .post(linkingScreenToTheatreURL)
                                        .then(function (response) {
                                            //$scope.theatre = response;
                                            alert("screen assigned to this Theatre!");
                                        });
                                }

                                linkScreenToTheatreURL();
                        });
                    }

                    var i;

                    for (i = 0; i < noOfScreens; i++) {
                        createScreen();
                    }


            });
        }

    }
})();