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
                <div class="panel-heading" style="color: rgb(60,148,188)"><strong>企业会员登入</strong></div>
                <div class="panel-body">
                    <form method="post">
                        <div class="form-group">
                            <label for="inputAccount">账号/Account</label>
                            <input type="text" class="form-control" id="inputAccount" name="account" placeholder="Account">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">密码/Password</label>
                            <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <input type="button" class="btn btn-default" value="登入" onclick="submitForm()" style="width: 100%; color:rgb(60,148,188);font-weight: bold;">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-4">
        </div>
    </div>

</div>
<script>
    function submitForm() {
        var account = $("#inputAccount").val();
        var password = $("#inputPassword").val();
        if ((account == null || account == "") || (password == null || password == "")) {
            alert("不能为空");
        } else {
            $.ajax({
                type: 'POST',

                url: "<%=basePath%>companyuser/checkAccount",

                data: {account: account,password:password},

                dataType: "json",

                success: function () {
                    window.location.href="<%=basePath%>companyuser/companyIndex"
                },
                error: function () {
                    alert("登入失败");
                }
            });

        }
    }
</script>
</body>
</html>