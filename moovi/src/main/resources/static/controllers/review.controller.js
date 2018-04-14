(function () {
    angular
        .module("MooviApp")
        .controller("ReviewController", ReviewController);

    function ReviewController($http,$scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/review";
        var name = localStorage.getItem("movieName");
        var username = localStorage.getItem("username");
        $scope.mName = name;
        vm.writeReview = writeReview;

        function writeReview(field,reviewVal) {
            var reviewForMovie = {
                "rating":field,
                "review":reviewVal
            };
            $http
                .post(localpath+url,reviewForMovie)
                .then(function () {
                    window.location.href = localpath+"#!/searchMovie";

                    alert("Review Posted");
                });
        }

    }
})();