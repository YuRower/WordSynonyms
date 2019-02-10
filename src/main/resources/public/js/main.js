var app = angular.module("springDemo", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.websites = [
    ];
    $(document).ready(function(){
    	  $("form").submit(function(){
    	    var e = document.getElementById("myselect");

    		var part = e.options[e.selectedIndex].value;

    		var elemA = document.getElementById("myField").value; 

    $http.get("http://localhost:8081/api/stackoverflow/"+ part+ "?word="+elemA).then(function (response) {
    	$scope.websites=response.data; }); 
    		
    	  });
	});

   
});