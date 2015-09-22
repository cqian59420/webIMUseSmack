<html ng-app="myApp">
<meta charset="UTF-8">
<%@ page pageEncoding="utf-8" contentType="text/html; UTF-8" %>
<head>
    <title>>聊天</title>
    <script src="/js/angular1.3.9.min.js"></script>
</head>
<body>
<h1>我的聊天页面</h1>

<div ng-controller="myController">
    <p>在输入框中尝试输入：</p>

    <p>姓名：<input type="text" ng-model="name"></p>

    <p ng-bind="name"></p>

    <h3>{{skillName}} i love you</h3>
</div>


<div ng-controller="RosterController">
    <ul>
        <li ng-repeat="tmpRoster in roster">
            {{ 'name: ' + tmpRoster.name +' ,组别 : ' + tmpRoster.groups[0].name}}
        </li>
    </ul>

</div>



<script>
    var app = angular.module('myApp', []);
    app.controller("myController", function ($scope) {
        $scope.skillName = 'angularJs'
    });

    app.controller("RosterController",function($scope,$http){
        var url ="/chat/getRoster";
        $http.get(url).success(function(response){
            $scope.roster = response;
        });
    })


</script>

</body>
</html>