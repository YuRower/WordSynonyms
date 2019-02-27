var part = ""
var elemA =""
$(document).ready(function(){
    	  $("form").submit(function(){
    	    var e = document.getElementById("myselect");

    	    part=e.options[e.selectedIndex].value;

    		 elemA = document.getElementById("myField").value; 
    		 alert (elemA);
    	  });
  });
	
var app = angular.module("springDemo", []);

app.controller("AppCtrl", function ($scope, $http ) {
    $scope.websites = [
    ];
    $scope.names = [ "verb", "noun"];
    $scope.manualSubmit  = function(info) { 
    	
    	$scope.data = [
            { word : info.myField},
            { part : info.selectedName},
        ];


   
    $http.get("http://localhost:8081/api/wordsynonym/"+ info.selectedName+ "?word="+info.myField).then(function (response) {
    	$scope.websites=response.data; 
    	});  
    };
});