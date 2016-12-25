<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/3/1
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html>
<head>
    <title></title>
    <style>

        a {
            text-decoration: none;
            color: #00c6ff;
        }

        h1 {
            font: 4em normal Arial, Helvetica, sans-serif;
            padding: 20px;
            margin: 0;
            text-align: center;
        }

        h1 small {
            font: 0.2em normal Arial, Helvetica, sans-serif;
            text-transform: uppercase;
            letter-spacing: 0.2em;
            line-height: 5em;
            display: block;
        }

        h2 {
            color: #bbb;
            font-size: 3em;
            text-align: center;
            text-shadow: 0 1px 3px #161616;
        }

        .btn-sign a {
            color: #fff;
            text-shadow: 0 1px 2px #161616;
        }

        #mask {
            display: none;
            background: #000;
            position: fixed;
            left: 0;
            top: 0;
            z-index: 10;
            width: 100%;
            height: 100%;
            opacity: 0.8;
            z-index: 999;
        }

        .login-popup {

        }

        img.btn_close {
            float: right;
            margin: -28px -28px 0 0;
        }

        fieldset {
            border: none;
        }

        form.signin .textbox label {
            display: block;
            padding-bottom: 7px;
        }

        form.signin .textbox span {
            display: block;
        }

        form.signin p, form.signin span {
            color: #999;
            font-size: 11px;
            line-height: 18px;
        }

        form.signin .textbox input {
            background: #666666;
            border-bottom: 1px solid #333;
            border-left: 1px solid #000;
            border-right: 1px solid #333;
            border-top: 1px solid #000;
            color: #fff;
            border-radius: 3px 3px 3px 3px;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            font: 13px Arial, Helvetica, sans-serif;
            padding: 6px 6px 4px;
            width: 200px;
        }

        form.signin input:-moz-placeholder {
            color: #bbb;
            text-shadow: 0 0 2px #000;
        }

        form.signin input::-webkit-input-placeholder {
            color: #bbb;
            text-shadow: 0 0 2px #000;
        }

        .button {
            /*background: -moz-linear-gradient(center top, #f3f3f3, #dddddd);*/
            background: -webkit-gradient(linear, left top, left bottom, from(#f3f3f3), to(#dddddd));
            background: -o-linear-gradient(top, #f3f3f3, #dddddd);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#f3f3f3', EndColorStr='#dddddd');
            border-color: #000;
            border-width: 1px;
            border-radius: 4px 4px 4px 4px;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            color: #333;
            cursor: pointer;
            display: inline-block;
            padding: 6px 6px 4px;
            margin-top: 10px;
            font-size: 12px;
            width: 214px;
        }

        .button:hover {
            background: #ddd;
        }

    </style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="navbar-collapse collapse" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=basePath%>web/gotoIndex"><img
                        src="<%=basePath%>web/getPic/lunboImg/ww.jpg" style="height: 100%;width: auto;" alt=""></a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<%=basePath%>web/gotoIndex" target="_blank">首页</a></li>
                <li><a href="<%=basePath%>web/coursePage" target="_blank">课程培训</a></li>
                <li><a href="<%=basePath%>web/servicePage" target="_blank">业务展示</a></li>
                <li><a href="<%=basePath%>web/contactUs" target="_blank">联系我们</a></li>
                <li><a href="javascript:void(0)" onclick="gotoUserPage()" target="_blank">个人中心</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <c:if test="${sessionScope.userAccount==null}">
                    <li><a class="log">登入</a></li>
                </c:if>
                <c:if test="${sessionScope.userAccount!=null}">
                    <li class="dropdown">
                        <a href="#" class="userac dropdown-toggle" data-toggle="dropdown">${sessionScope.userAccount}</a>
                        <ul class="dropdown-menu" style="color: white">
                            <li><a href="<%=basePath%>user/userLogOut">退出</a></li>
                        </ul>
                    </li>

                </c:if>
                <li><a href="<%=basePath%>user/page/userRegisterPage">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div id='cs_box'>
    <span class='cs_title'>在线咨询</span>
    <span class='cs_close'>x</span>

    <div class='cs_img'></div>
    <span class='cs_info'>有什么可以帮到你</span>

    <div class='cs_btn'>点击咨询</div>
</div>
<script type="text/javascript">
    myEvent(window, 'load', function () {
        cs_box.set({
            img_path: '../pic/xixi.jpg',	//设置图片路径
            qq: '510629251',	//设置QQ号码
        });
    });

    function gotoUserPage(){
        if($(".userac").text()!=null && $(".userac").text()!=""){
            window.location.href="<%=basePath%>user/usermainpage";
        }else {
            return false;
        }

    }

</script>


<%----------------------------------------------------%>


<div id="login-box" class="login-popup" style="display: none;
            background: #333;
            padding: 10px;
            border: 2px solid #ddd;
            float: left;
            font-size: 1.2em;
            position: fixed;
            top: 30%;
            left: 40%;
            z-index: 99999;
            box-shadow: 0px 0px 20px #999;
            -moz-box-shadow: 0px 0px 20px #999; /* Firefox */
            -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
            border-radius: 3px 3px 3px 3px;
            -moz-border-radius: 3px; /* Firefox */
            -webkit-border-radius: 3px; /* Safari, Chrome */">
    <a href="#" class="close"><img src="<%=basePath%>web/getPic/lunboImg/close_pop.jpg" class="btn_close"
                                   title="Close Window" alt="Close"/></a>

    <form class="signin">
        <fieldset class="textbox">
            <label class="login-user">
                <span>手机号或者邮箱</span>
                <input id="login-user" name="username" value="" type="text" autocomplete="on" placeholder="Username"
                       style="width: 100%">
            </label>

            <label class="login-pass">
                <span>密码</span>
                <input id="login-pass" name="password" value="" type="password" placeholder="Password"
                       style="width: 100%">
            </label>

            <button class="button submitbutton" type="button">登入</button>

        </fieldset>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var ac = $(".userac").text();
        $(".userac").text(ac.substring(0,2)+"***");
        $('a.log').click(function () {
            // Getting the variable's value from a link
            var loginBox = $(this).attr('href');
            //Fade in the Popup and add close button
            $(loginBox).fadeIn(300);
            $(".login-popup").css("display", "block");
            //Set the center alignment padding + border
            var popMargTop = ($(loginBox).height() + 24) / 2;
            var popMargLeft = ($(loginBox).width() + 24) / 2;

            $(loginBox).css({
                'margin-top': -popMargTop,
                'margin-left': -popMargLeft
            });

            // Add the mask to body
            $('body').append('<div id="mask"></div>');
            $('#mask').fadeIn(300);

            return false;
        });

        // When clicking on the button close or the mask layer the popup closed
        $('a.close, #mask').bind('click', function () {
            $('#mask , .login-popup').fadeOut(300, function () {
                $('#mask').remove();
            });
            return false;
        });

        $(".submitbutton").bind("click", function usercheck() {
            var usertel = $("#login-user").val();
            var userpassword = $("#login-pass").val();
            $.ajax({
                type: 'GET',
                url: "<%=basePath %>user/userLogCheck",
                data: {usertel: usertel, userpassword: userpassword},
                dataType: "json",
                success: function (data) {
                    if (data.flag == true) {
                        window.location.href = "<%=basePath %>web/gotoIndex";
                    } else {
                        alert("用户名密码错误");
                    }
                }
            })
        })
    });
</script>
</body>
</html>
