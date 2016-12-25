<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<% String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+':'+request.getServerPort()+path+'/';
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css"/>
    <title></title>
    <style>
        .panelHead>div:first-child{
            text-align: center;
        }
        body{
            background: url("<%=basePath %>res/pic/back.jpg");
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4 myLoginBox" style="margin-top: 8%">
            <div class="panel panel-default panelHead">
                <div class="panel-heading" style="color: rgb(60,148,188)"><strong>管理员登入</strong></div>
                <div class="panel-body">
                    <form action="<%=basePath %>superadmin/superadminLog" method="post">
                        <div class="form-group">
                            <label for="inputAccount">超级管理员名/Account</label>
                            <input type="text" class="form-control" id="inputAccount" name="superadminaccount" placeholder="Account">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">输入密码/Password</label>
                            <input type="password" class="form-control" id="inputPassword" name="superadminpassword" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-default" value="登入" onclick="checkAdmin()" style="width: 100%; color:rgb(60,148,188);font-weight: bold;">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-4">
        </div>
    </div>

</div>

</body>
</html>