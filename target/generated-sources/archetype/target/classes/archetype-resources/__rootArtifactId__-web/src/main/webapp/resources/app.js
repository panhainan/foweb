/**
 * Created by phn on 2016/2/2.
 */

var app = angular.module("webApp", ["tm.pagination", "ngRoute", "ngSanitize",'ui.bootstrap', "ui.router", "ngFileUpload"]);
app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('HttpInterceptor');
});
app.config(function ($routeProvider) {
    $routeProvider.when("/index", {
        templateUrl: "resources/modules/index/main.view.html",
        controller: 'IndexController'
    }).when("/test-case",{
        templateUrl: "resources/modules/test/test.view.html",
        controller: 'TestCaseController'
    }).when("/test-case/:id",{
        templateUrl: "resources/modules/test/test.detail.view.html",
        controller: 'TestCaseDetailController'
    });

    $routeProvider.otherwise({
        templateUrl: "resources/modules/index/main.view.html"
    });
});
app.run(function ($rootScope, $location, $window) {
    //$rootScope.$on("$routeChangeStart", function (event, nextRoute, currentRoute) {
    //    if (nextRoute != null && nextRoute.access != null && nextRoute.access.requiredLogin
    //        && !AuthenticationService.isLogged && !$window.sessionStorage["stuUserSession"]) {
    //        $location.path("/login");
    //    }
    //});
});
app.controller("webAppCtrl", function ($scope, $rootScope, $window) {

    console.log("老子进来了，现在是9-11 3:25 我睡不着！")
});

