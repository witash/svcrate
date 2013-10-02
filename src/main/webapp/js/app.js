    angular.module('svcrate', []).
    config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/svcrate', {templateUrl: 'partials/profileSearch.html', controller: ProfileSearchCtrl}).
    when('/svcrate/:profileId', {templateUrl: 'partials/profile.html', controller: SvcRateProfileCtrl}).
    when('/svcrate/:profileId/addServices', {templateUrl: 'partials/addServices.html', controller: AddServicesCtrl}).
    otherwise({redirectTo: '/svcrate'});
    }]);