<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>讲师后台</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="<%=basePath %>res/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="<%=basePath %>res/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons -->
    <link href="<%=basePath %>res/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- Morris chart -->
    <link href="<%=basePath %>res/css/morris/morris.css" rel="stylesheet" type="text/css"/>
    <!-- jvectormap -->
    <link href="<%=basePath %>res/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css"/>
    <!-- fullCalendar -->
    <link href="<%=basePath %>res/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
    <!-- Daterange picker -->
    <link href="<%=basePath %>res/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="<%=basePath %>res/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- Theme style -->
    <link href="<%=basePath %>res/css/AdminLTE.css" rel="stylesheet" type="text/css"/>
</head>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->
<jsp:include page="lecturerheader.jsp"/>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="lecturerbackgroundsidebar.jsp"/>

    <!-- Right side column. Contains the navbar and content of the page -->
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <%--<section class="content-header">--%>
        <%--<h1>--%>
        <%--<small></small>--%>
        <%--</h1>--%>
        <%--</section>--%>
        <section class="content-header no-margin">
            <h1 class="text-center">
                讲师信息
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <form role="form" action="<%=basePath %>lecturer/lecturerupdateinfopage" onsubmit="return checkForm()" method="post"
                  style="width: 70%;margin-left: 20%">
                <div class="form-group">
                    <div class="box box-info" style="height: 800px">
                        <div class="box-header">
                            <h2 style="margin-left: 40%">教师个人信息</h2>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>讲师账号</label>
                                    <input type="text" class="form-control" name="lectureraccount"
                                           value="${lecturer.lectureraccount}"
                                           disabled>
                                </div>
                                <div class="col-md-2" style="margin-left: 100px">
                                    <label>讲师性别</label>
                                    <select class="form-control" name="lecturersex">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <label>讲师年龄</label>
                                    <input type="text" class="form-control" name="lecturerage"
                                           value="${lecturer.lecturerage}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>讲师等级</label>
                                    <input type="text" class="form-control" name="lecturerrank"
                                           value="${lecturer.lecturerrank}"
                                           disabled>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>讲师姓名</label>
                                    <input type="text" class="form-control" name="lecturername"
                                           value="${lecturer.lecturername}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <%--<label>讲师申请理由</label>--%>
                                    <%--<input type="text" class="form-control" name="lecturerapplreason"--%>
                                           <%--value="${lecturer.lecturerapplreason}">--%>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>讲师所属单位</label>
                                    <input type="text" class="form-control" name="lecturercompany"
                                           value="${lecturer.lecturercompany}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>讲师email</label><span id="ithis1" style="margin-left: 50px"></span>

                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                        <input type="text" class="form-control" id="lectureremail" name="lectureremail"
                                               value="${lecturer.lectureremail}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>讲师联系电话</label>

                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-phone"></i>
                                        </span>
                                        <input type="text" class="form-control" name="lecturertel"
                                               value="${lecturer.lecturertel}"  disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>讲师介绍</label>
                                        <textarea class="form-control" row="6" name="lecturerdescription"
                                                >${lecturer.lecturerdescription}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>审核是否通过</label>
                                    <c:choose>
                                        <c:when test="${lecturer.lecturercheck==null}">
                                            <input type="text" class="form-control" value="unpass"
                                                   disabled>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${lecturer.lecturercheck=='1'}">
                                                    <input type="text" class="form-control" value="pass"
                                                           disabled>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" class="form-control" value="delete"
                                                           disabled>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="col-md-4" style="margin-left: 30%;margin-top: 15px">
                                    <button type="submit" class="btn btn-primary">确认修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>


        </section>
        <!-- /.content -->
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

<!-- add new calendar event modal -->
<!--More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>-->

<!-- jQuery 2.0.2 -->
<script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
<!-- jQuery UI 1.10.3 -->
<script src="<%=basePath %>res/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
<!-- Bootstrap -->
<script src="<%=basePath %>res/js/bootstrap.min.js" type="text/javascript"></script>
<!-- Morris.js charts -->
<script src="<%=basePath %>res/js/raphael-min.js"></script>
<script src="<%=basePath %>res/js/plugins/morris/morris.min.js" type="text/javascript"></script>
<!-- Sparkline -->
<script src="<%=basePath %>res/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- jvectormap -->
<script src="<%=basePath %>res/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>res/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"
        type="text/javascript"></script>
<!-- fullCalendar -->
<script src="<%=basePath %>res/js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<!-- jQuery Knob Chart -->
<script src="<%=basePath %>res/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
<!-- daterangepicker -->
<script src="<%=basePath %>res/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<%=basePath %>res/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"
        type="text/javascript"></script>
<!-- iCheck -->
<script src="<%=basePath %>res/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

<%--<!-- AdminLTE App -->--%>
<script src="<%=basePath %>res/js/AdminLTE/app.js" type="text/javascript"></script>
<%--<!-- AdminLTE dashboard demo (This is only for demo purposes) -->--%>
<script src="<%=basePath %>res/js/AdminLTE/dashboard.js" type="text/javascript"></script>
<script>
    function checkForm() {
        var lectureremail = $("#lectureremail").val();
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (!myreg.test(lectureremail)) {
            document.getElementById("ithis1").innerHTML = "<font color='red'>请输入有效邮箱</font>";
            return false;
        } else {
            if(lectureremail != "") {
                $.ajax({
                    type: 'POST',
                    url: "<%=basePath %>lecturer/updatelectureremailcheck",
                    data: {lectureremail:lectureremail },
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
</script>

</body>
</html>
