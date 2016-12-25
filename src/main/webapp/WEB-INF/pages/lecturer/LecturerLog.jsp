<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css"/>
    <title></title>
    <style>
        .panelHead > div:first-child {
            text-align: center;
        }

        body {
            background: url("<%=basePath %>res/pic/back.jpg");
        }
    </style>
    <script>
        function checkLecturer() {
            var lectureraccount = $("#inputAccount").val();
            var lecturerpassword = $("#inputPassword").val();
            $.ajax({
                type: 'GET',
                url: "<%=basePath %>lecturer/lecturerLog",
                data: {lectureraccount: lectureraccount, lecturerpassword: lecturerpassword},
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        window.location.href = "<%=basePath %>lecturer/lecturerBGPage";
                    } else {
                        window.location.href = "<%=basePath %>lecturer/lecturerlogpage";
                        alert("用户名密码错误或者账号正在审核")
                    }

                }
            })
        }
    </script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4 myLoginBox" style="margin-top: 8%">
            <div class="panel panel-default panelHead">
                <div class="panel-heading" style="color: rgb(60,148,188)"><strong>讲师登入</strong></div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="inputAccount">讲师账号/Account</label>
                        <input type="text" class="form-control" id="inputAccount" name="lectureraccount"
                               placeholder="Account">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">输入密码/Password</label>
                        <input type="password" class="form-control" id="inputPassword" name="lecturerpassword"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default" value="登入" onclick="checkLecturer()"
                               style="width: 100%; color:rgb(60,148,188);font-weight: bold;">
                    </div>
                    <div class="form-group">
                        <a href="<%=basePath %>lecturer/lecturerregisterpage"><button class="btn btn-default" style="width: 100%; color:rgb(60,148,188);font-weight: bold;" >注册</button></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
        </div>
    </div>

</div>

</body>
</html>