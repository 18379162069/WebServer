<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/2/23 0023
  Time: 下午 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html>
<head>
    <meta charset="UTF-8">
    <script src="<%=basePath%>res/js/pace.min.js"></script>
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=basePath %>res/css/main.css">
    <link rel="stylesheet" href="<%=basePath %>res/css/pages/login-signup.css">
    <link rel="stylesheet" href="<%=basePath %>res/css/blue.css">
    <title>用户登录</title>
    <script>
        function usercheck(){
            var usertel=$("#login-user").val();
            var userpassword=$("#login-pass").val();
            $.ajax({
                type: 'GET',
                url: "<%=basePath %>user/userLogCheck",
                data: {usertel: usertel, userpassword: userpassword},
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        window.location.href = "<%=basePath %>user/usermainpage";

                    } else {
                        alert("用户名密码错误")
                        window.location.href = "<%=basePath %>user";

                    }

                }
            })
        }
    </script>
</head>
<body>
<div class="overlay"></div>
<div class="container">
    <div class="col-md-4">

    </div>

    <section class="user-window" >
        <div class="user-form mid col-lg-3 col-md-4 col-sm-6" style="box-shadow: 1px 1px 3px 3px rgb(220,220,220);padding: 20px;margin-top: 10%">
            <div class="logo">
                <h3 class="text-center">用户登陆</h3>
            </div>
            <div class="form">
                <label class="control-label" for="login-user">手机号码</label>

                <div class="input-group">
                    <input type="text" id="login-user" name="usertel" class="form-control input-sm" placeholder="手机号">
                    <span class="input-group-addon"><span class="fa fa-phone"></span></span>
                </div>
                <label class="control-label" for="login-pass">密码</label>

                <div class="input-group">
                    <input type="password" id="login-pass" name="userpassword" class="form-control input-sm" placeholder="密码">
                    <span class="input-group-addon"><span class="fa fa-key"></span></span>
                </div>

                <button class="btn btn-success btn-sm" style="margin-top: 20px" onclick="usercheck()">登录</button>
                <a href="<%=basePath%>user/userRegisterPage"><button class="btn btn-danger btn-sm" style="margin-top: 20px">注册</button></a>
            </div>
        </div>
    </section>

</div>
<!-- jQuery -->
<script src="<%=basePath%>res/js/jquery-2.1.1.min.js"></script>

<!-- Bootstrap -->
<script src="<%=basePath%>res/js/bootstrap.min.js"></script>

<!-- Universal JS for all pages js < Editable > -->
<script src="<%=basePath%>res/js/main.js"></script>

<!-- Style switcher for demo page only -->
<script src="<%=basePath%>res/js/style-switcher.js"></script>

</body>
</html>
