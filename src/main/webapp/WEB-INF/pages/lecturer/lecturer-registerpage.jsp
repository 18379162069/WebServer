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

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4 myLoginBox" style="margin-top: 8%">
            <div class="panel panel-default panelHead">
                <div class="panel-heading" style="color: rgb(60,148,188)"><strong>讲师注册</strong></div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="inputAccount">讲师账号/Account</label><span id="ithis0"
                                                                            style="margin-left: 50px"></span>
                        <input type="text" class="form-control" id="inputAccount" name="lectureraccount"
                               onblur="accountcheck()" placeholder="Account">
                    </div>
                    <div class="form-group">
                        <label>讲师姓名/name</label>
                        <input type="text" class="form-control" id="lecturername" name="lecturername"
                               placeholder="name">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">输入密码/Password</label>
                        <input type="password" class="form-control" id="inputPassword" name="lecturerpassword"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">再次输入密码/Password</label> <span id="ithis"
                                                                                 style="margin-left: 50px"></span>
                        <input type="password" class="form-control" id="inputPassword2" name="lecturerpassword2"
                               onblur="checkpassword()" placeholder="Password">

                    </div>
                    <div>
                        <label for="inputPassword">邮箱</label><span id="ithis1" style="margin-left: 50px"></span>

                        <div class="input-group">
                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-envelope"></i>
                                        </span>
                            <input type="text" class="form-control" id="lectureremail" name="lectureremail"
                                   placeholder="Email" onblur="emailcheck()">
                        </div>
                    </div>
                    <div style="margin-top: 20px">
                        <label for="inputPassword">手机号码</label><span id="ithis2" style="margin-left: 50px"></span>

                        <div class="input-group">
                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-phone"></i>
                                        </span>
                            <input type="text" class="form-control" id="lecturertel" name="lectureretel"
                                   placeholder="Tel" onblur="telcheck()">
                        </div>
                    </div>
                    <div style="margin-top: 40px">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default" onclick="checkLecturer()"
                                    style="width: 100%; color:rgb(60,148,188);font-weight: bold;">注册
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <a href="<%=basePath %>lecturer/lecturerlogpage">
                            <button class="btn btn-default"
                                    style="width: 100%; color:rgb(60,148,188);font-weight: bold;">登陆
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
        </div>
    </div>

</div>
<script>
    function accountcheck() {
        var lectureraccount = $("#inputAccount").val();
        var flg;
        if (lectureraccount != "") {
            $.ajax({
                type: 'GET',
                async: false,
                url: "<%=basePath %>lecturer/lectureraccountcheck",
                data: {lectureraccount: lectureraccount},
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        document.getElementById("ithis0").innerHTML = "<font color='red'>账号已存在</font>";
                        flg=false;
                    } else {
                        document.getElementById("ithis0").innerHTML = "<font color='green'>账号可以注册</font>";
                        flg=true;
                    }

                }
            })
        } else {
            document.getElementById("ithis0").innerHTML = "<font color='red'>账号不能为空</font>";
            flg= false;
        }
        return flg;

    }
    function telcheck() {
        var flg=false;
        var lecturertel = $("#lecturertel").val();
        var mobile = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (!mobile.test(lecturertel)) {
            document.getElementById("ithis2").innerHTML = "<font color='red'>请输入正确手机号</font>";
            return false;
        } else if (lecturertel != "") {
            $.ajax({
                type: 'POST',
                url: "<%=basePath %>lecturer/lecturertelcheck",
                data: {lecturertel: lecturertel},
                async: false,
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        document.getElementById("ithis2").innerHTML = "<font color='red'>手机号码已存在</font>";
                        flg = false;
                    } else {
                        document.getElementById("ithis2").innerHTML = "<font color='green'>手机号码可用</font>";
                        flg = true;
                    }

                }
            })
        }
        return flg;
    }
    function emailcheck() {
        var lectureremail = $("#lectureremail").val();
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (!myreg.test(lectureremail)) {
            document.getElementById("ithis1").innerHTML = "<font color='red'>请输入有效邮箱</font>";
            return false;
        } else {
            if(lectureremail != "") {
                $.ajax({
                    type: 'POST',
                    url: "<%=basePath %>lecturer/lectureremailcheck",
                    data: {lectureremail :lectureremail },
                    async: false,
                    dataType: "json",
                    success: function (data) {
                        if (data.flag == true) {
                            document.getElementById("ithis1").innerHTML = "<font color='red'>邮箱已存在</font>";
                            flg = false;
                        } else {
                            document.getElementById("ithis1").innerHTML = "<font color='green'>邮箱可用</font>";
                            flg = true;
                        }

                    }
                })}
            return flg;
        }
    }
    function checkpassword() {
        var lecturerpassword = $("#inputPassword").val();
        var lecturerpassword2 = $("#inputPassword2").val();
        if( lecturerpassword2==""|| lecturerpassword2==null){
            document.getElementById("ithis").innerHTML = "<font color='red'>密码不能为空</font>";
            return false;
        }else if (lecturerpassword == lecturerpassword2) {
            document.getElementById("ithis").innerHTML = "<font color='green'>两次密码相同</font>";
            return true;
        } else {

            document.getElementById("ithis").innerHTML = "<font color='red'>两次密码不相同</font>";
            return false;
        }
    }
    function checkLecturer() {
        var lectureraccount = $("#inputAccount").val();
        var lecturerpassword = $("#inputPassword").val();
        var lecturerpassword2 = $("#inputPassword2").val();
        var lectureremail = $("#lectureremail").val();
        var lecturertel = $("#lecturertel").val();
        var lecturername = $("#lecturername").val();
        if (telcheck() && accountcheck() && lecturername != ""&&emailcheck()&&checkpassword()&&lecturerpassword!=""&&lecturerpassword!=null&&lecturerpassword==lecturerpassword2) {
            $.ajax({
                type: 'POST',
                url: "<%=basePath %>lecturer/lecturerregister",
                data: {
                    lectureraccount: lectureraccount,
                    lecturerpassword: lecturerpassword,
                    lectureremail: lectureremail,
                    lectureretel: lecturertel,
                    lecturername: lecturername
                },
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        alert("注册成功!等待审核")
                        window.location.href = "<%=basePath %>lecturer/lecturerlogpage";
                    } else {
                        window.location.href = "<%=basePath %>lecturer/lecturerregisterpage";
                        alert("注册失败!")
                    }

                }
            })
        }else if(lecturerpassword==""||lecturerpassword==null||lecturerpassword!=lecturerpassword2){
            if(lecturerpassword!=lecturerpassword2){
                document.getElementById("ithis").innerHTML = "<font color='red'>两次密码不相同</font>";
            }else
                document.getElementById("ithis").innerHTML = "<font color='red'>密码不能为空</font>";
        }else
            alert("注册失败")
    }
    //        function checkForm(){
    //            var lectureraccount = $("#inputAccount").val();
    //            var lecturerpassword = $("#inputPassword").val();
    //            var lecturerpassword2 = $("#inputPassword2").val();
    //            var lectureremail = $("#lectureremail").val();
    //            var lecturertel = $("#lecturertel").val();
    //            var lecturername = $("#lecturername").val();
    //            if(lecturername="" || lecturername==null) return false;
    //            if(lecturerpassword="" ||lecturerpassword==null) return false;
    //            if(lecturerpassword2=""||lecturerpassword2==null) return false;
    //            if(lectureremail="" ||lectureremail==null) return false;
    //            if(lecturertel="" ||lecturertel==null) return false;
    //
    //
    //        }
</script>
</body>
</html>