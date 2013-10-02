function ProfileSearchCtrl($scope, $location){
	$scope.advancedSearch=false;
	
	$scope.goToId=function(){
		$location.path("svcrate/C10003");
	};
}

function AddServicesCtrl($scope){
	$scope.newserviceitems=[];
	
	$scope.showAddRates=function(){
		$scope.addingRates=true;
	}
}

function SvcRateProfileCtrl($scope, $location, $http){
	 $http.get('service/rest/profile').success(function(data) {
		$scope.profile = data;
	});
	
	
	
	$scope.profilenbl={
		businessKey:"Blerm's blermtown blerms",
		serviceitems:[
			{sellservice_name:"AF",
			rateitems:[
				{currency:"USD",amount:"1.00"},
				{currency:"EUR",amount:"2.00"}]},
			{sellservice_name:"BF",
			rateitems:[
				{currency:"USD",amount:"1.00"},
				{currency:"EUR",amount:"2.00"}]}
			]};
	
	$scope.mode='view';
	
	$scope.moreCompanyInfo = false;
	
	$scope.serviceFilter = function(value){
		if($scope.fltrSvcName && value.sellService.name != $scope.fltrSvcName){
			return false;
		}
		if($scope.fltrOrigin && value.origin != $scope.fltrOrigin){
			return false;
		}
		if($scope.fltrDestination && value.destination != $scope.fltrDestination){
			return false;
		}
		if($scope.mode == 'addRates' && !value.selected){
			return false;
		}
		if($scope.mode == 'addRates' && !value.selected){
			return false;
		}
		if($scope.mode == 'addServices' && !value.new){
			return false;
		}
		
		return true;
	};
	
	$scope.rateFilter = function(value){
		return $scope.mode != 'addRates' || value.new; 
	};
	
	$scope.showAddRates=function(){
		$scope.addingRates=true;
	};
	
	$scope.saveAll=function(){
		var i;
		for(i in $scope.profile.serviceItems){
			var svcItem = $scope.profile.serviceItems[i];
			if(svcItem.new){
				svcItem.new=false;
			}
			var j;
			for(j in svcItem.rateItems){
				if(svcItem.rateItems[j].new){
					svcItem.rateItems[j].new=false;
				}
			}
		}
		$scope.mode="view";
	}
	
	$scope.addRates=function(){
		var i;
		for(i in $scope.profile.serviceItems){
			if($scope.profile.serviceItems[i].selected){
				$scope.profile.serviceItems[i].rateItems.push(
					{effectiveDate:$scope.newEffective,
					 expirationDate:$scope.newExpiration,
					 rate:
						{amount:$scope.newAmount,
						currency:{name:$scope.newCurrency}}
					,new:true});
			}
		}
	};
	
	$scope.addServices=function(){
		$scope.profile.serviceItems.push(
			{origin:$scope.newOrigin,
			 destination:$scope.newDestination,
			 sellService:{name:$scope.newServiceName},
			 rateItems:[],
			new:true});
	};
	
	$scope.showAddServices=function(){
		$scope.addingServices=true;
	};
			
	$scope.backToSearch=function(){
		$location.path("/");
	};			
}
