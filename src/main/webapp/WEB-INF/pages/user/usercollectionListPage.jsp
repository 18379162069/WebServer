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
    <title>用户后台</title>
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
<%--<jsp:include page="lecturerheader.jsp"/>--%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="userbackgroundsidebar.jsp"/>

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
                业务信息
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <label>已购买的业务</label>

            <div class="mailbox row">
                <div class="col-xs-12">
                    <div class="box box-solid">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <div class="table-responsive">
                                        <table class="table table-mailbox">
                                            <tr class="unread">
                                                <td class="name">业务号</td>
                                                <td class="name">业务名称</td>
                                                <td class="name">业务负责人</td>
                                                <td class="name">负责人电话</td>
                                                <td class="time">操作</td>
                                            </tr>
                                            <c:if test="${serviceList!=null}">
                                                <c:forEach begin="0" end="4" step="1"
                                                           items="${serviceList}"
                                                           varStatus="status" var="obj">
                                                    <tr class="unread">
                                                        <td class="name">${obj.id}</td>
                                                        <td class="name">
                                                            <a href="<%=basePath%>course/courseinfopage?courseid=${obj.id}">
                                                                    ${obj.servicename}
                                                            </a></td>
                                                        <td class="name">${obj.servicemanage}</td>
                                                        <td class="name">${obj.servicemanagetel}</td>
                                                        <td class="time">
                                                            <a href="<%=basePath%>course/courseinfopage?courseid=${obj.id}">
                                                                <button class="btn btn-primary btn-sm">查看</button>
                                                            </a>

                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                        </table

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
