<!DOCTYPE html>
<meta charset="UTF-8">
<%@ page pageEncoding="UTF-8" %>
<html ng-app>
<head>
    <script src="/js/angular1.3.9.min.js"></script>
    <!--响应式CSS-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.css" rel="stylesheet">
    <title>login page</title>
</head>

<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2">...</div>
        <div class="span10">

            <p class="lead text-center"><strong>欢迎登录在线聊天系统</strong></p>

            <form action="" class="form-horizontal">
                <div class="control-group">
                    <label for="userName" class="control-label">用户名：</label>

                    <div class="controls"><input type="text" name="" id="userName"/></div>
                </div>

                <div class="control-group">
                    <label for="userPass" class="control-label">密码：</label>

                    <div class="controls"><input type="password" name="" id="userPass"/></div>
                </div>
                <div class="controls">
                    <button class="btn">提交</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>

</html>