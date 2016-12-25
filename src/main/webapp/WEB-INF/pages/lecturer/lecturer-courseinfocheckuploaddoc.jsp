<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
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
                课程信息
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <form role="form" action="<%=basePath%>course/coursedocupload" method="post" enctype="multipart/form-data"
                  style="width: 70%;margin-left: 20%">
                <div class="form-group">
                    <div class="box box-info" style="height: 800px">
                        <div class="box-header">
                            <h2 style="margin-left: 40%">课程信息</h2>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程ID</label>
                                    <input type="text" class="form-control" name="courseid"
                                           value="${course.id}"
                                           disabled>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px;">
                                    <label>课程名称</label>
                                    <input type="text" class="form-control" name="coursename"
                                           value="${course.coursename}"
                                           disabled>

                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left: 10%;width: 80%">
                            <div class="row" style="margin-left: 3px">
                                <div class="col-md-10">
                                    <div class="row">
                                        <label>课程分类</label>
                                    </div>
                                    <div class="row">
                                        <ol class="breadcrumb">
                                            <li>Home</li>
                                            <li>Library</li>
                                            <li class="active">Data</li>
                                        </ol>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程模式</label>
                                    <input type="text" class="form-control" name="coursemode"
                                           value="${course.coursemode}"
                                           disabled>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程讲师</label>
                                    <input type="text" class="form-control" name="courselecturer"
                                           value="${course.courselecturer}" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程开始时间</label>
                                    <input type="text" class="form-control" name="coursetime"
                                           value="${course.coursetime}" disabled>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程课时</label>
                                    <input type="text" class="form-control" name="courseperiod"
                                           value="${course.courseperiod}" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程学生容量</label>

                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-th"></i>
                                        </span>
                                        <input type="text" class="form-control" name="coursemaxstu"
                                               value="${course.coursemaxstu}" disabled>
                                    </div>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程收费</label>

                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-yen"></i>
                                        </span>
                                        <input type="text" class="form-control" name="courseprice"
                                               value="${course.courseprice}" disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>课程介绍</label>
                                        <textarea class="form-control" row="6" name="lecturerdescription"
                                                  disabled>${course.coursedescription}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>审核是否通过</label>
                                    <c:choose>
                                        <c:when test="${course.coursecheck==null}">
                                            <input type="text" class="form-control" value="unpass"
                                                   disabled>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${course.coursecheck=='1'}">
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
                                        <input style="width:120px; border:1px solid #ccc; height:25px;" type="file" name="coursedoc"
                                               id="fcupload" onchange="readURL(this);" />
                                        <input type="hidden" name="courseid" value="${course.id}"/>
                                        <li><input type="submit" value="上传" id="upload" class="cinput"/></li>
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

</body>
</html>
