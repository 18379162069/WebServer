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
    <title>用户注册</title>

</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div class="row" style="margin-top: 5%">
    <form action="<%=basePath%>user/insertUser" onsubmit="return checkForm()" method="post">
        <div class="col-md-4">
        </div>
        <section class="user-window">
            <div class="user-form col-md-4"
                 style="box-shadow: 0.5px 0.5px 3px 3px rgb(233,233,233);padding-bottom: 30px">
                <div class="logo">
                    <h3 class="text-center">注册</h3>
                </div>
                <div class="form">
                    <label class="control-label" for="username">用户名</label><span id="signature"
                                                                                 style="margin-left: 50px" ></span>

                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-user"></span></span>
                        <input type="text" id="username" name="username" class="form-control input-sm" placeholder="用户名"
                               onblur="accountcheck()" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" required>
                    </div>

                    <label class="control-label" for="password">密码</label>

                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-key"></span></span>
                        <input type="password" id="password" name="userpassword" class="form-control input-sm"
                               placeholder="确认密码" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" required>
                    </div>

                    <label class="control-label" for="password2">确认密码</label>

                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-key"></span></span>
                        <input type="password" id="password2" class="form-control input-sm" placeholder="确认密码" required>
                    </div>

                    <label class="control-label" for="email">邮箱</label><span id="emailSign"
                                                                             style="margin-left: 50px"></span>

                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-envelope"></span></span>
                        <input type="email" id="email" name="useremail" class="form-control input-sm" placeholder="邮箱"
                               onblur="userEmailCheck()" required>
                    </div>

                    <label class="control-label" for="userTel">手机号码</label><span id="telSign"
                                                                                 style="margin-left: 50px" ></span>

                    <div class="input-group">
                        <span class="input-group-addon"><span class="fa fa-phone"></span></span>
                        <input type="text" id="userTel" name="usertel" class="form-control input-sm"
                               style="width: 73%!important;" placeholder="手机号码" required>
                        <input type="button" id="getSMS" class="btn-small btn-primary" onclick="checkTime()"
                               style="height: 120% !important;" value="获取验证码"/>
                    </div>

                    <br>
                    <h5 style="display: inline-block"><strong>填写验证码：</strong></h5><input type="text" id="verify">

                    <div class="row" style="margin-top: 1%">
                        <div class="col-md-6" style="text-align: center">
                            <input type="submit" class="btn btn-success btn-sm" style="width: 50%" required>
                        </div>
                        <div class="col-md-6" style="text-align: center">
                            <button class="btn btn-danger btn-sm" style="width: 50%">重置</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
</div>

<script>

    function checkForm() {
        var psd = $("#password").val();
        var psd2 = $("#password2").val();
        var  name = $("#username").val();
        var email = $("#email").val();
        if (!userEmailCheck()) return false;
        if ( name== "" || name == null)return false;
        if (psd == "" || psd == null)return false;
        if (psd2 == "" || psd2== null)return false;
        if (psd != psd2)return false;
        if (email == "" || email == null)return false;
        if (!checkVerify())return false;
        if (!userTelCheck())return false;
        return true;
    }
    function checkVerify(){
        var flag = false;
        var verify= $("#verify").val();
        var userTel= $("#userTel").val();
        $.ajax({
            type: 'POST',
            url: "<%=basePath %>user/checkVerify",
            data: {verify: verify,userTel: userTel},
            dataType: "json",
            async: false,
            success: function (data) {
                if(data.flag) flag = true;
            }
        });
        return flag;
    }

    function checkTime() {
        var tel = $("#userTel").val();
        if (userTelCheck()) {
            alert("验证码将发送到手机  60s后再尝试！");
            $("#getSMS").attr("disabled", true);
            //倒数100秒后执行
            $('body').oneTime('1hs', function () {
                //do something...
                $("#getSMS").removeAttr("disabled");
            });
//            alert("验证码1111");
            getSMS(tel);
        }
    }

    //获取验证码
    function getSMS(tel) {
        $.ajax({
            type: 'POST',
            url: "<%=basePath %>user/getSMS",
            data: {tel: tel},
            async: false
        });
    }

    //查看密码是否一致
    function checkPsd() {
        if ($("#password").val() != $("#password2").val()) {
            $("#password2").val(null);
            $("#password").val(null);
        }
    }

    //查看电话是否存在
    function userTelCheck() {
        var flag = false;
        var userTel = $("#userTel").val();
        var mobile = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (!mobile.test(userTel) || userTel == null || userTel == "") {
            alert("手机号有误！")
            return false;
        }
        $.ajax({
            type: 'GET',
            url: "<%=basePath %>user/userTelCheck",
            data: {userTel: userTel},
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.flag == false) {
                    document.getElementById("telSign").innerHTML = "<font color='red'>手机号已经存在</font>";
                    $("#tel").val(null);
                    flag = false;
                } else {
                    document.getElementById("telSign").innerHTML = "<font color='green'></font>";
                    flag = true;
                }

            }
        });
        return flag;
    }

    //查看email是否存在 存在true
    function userEmailCheck() {
        var flag = false;
        var email = $("#email").val();
        $.ajax({
            type: 'GET',
            url: "<%=basePath %>user/userEmailCheck",
            data: {email: email},
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.flag == false) {
                    flag = false;
                    document.getElementById("emailSign").innerHTML = "<font color='red'>邮箱已经存在</font>";
                    $("#email").val(null);
                } else {
                    flag = true;
                    document.getElementById("emailSign").innerHTML = "<font color='green'></font>";
                }
            }
        });
        return flag;
    }

</script>
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
