<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/14
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html>
<head>
    <title></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="<%=basePath %>res/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="<%=basePath %>res/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons -->
    <link href="<%=basePath %>res/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="<%=basePath %>res/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="<%=basePath %>res/css/iCheck/minimal/blue.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <link href="<%=basePath %>res/css/AdminLTE.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->
<jsp:include page="header.jsp"/>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"/>

    <!-- Right side column. Contains the navbar and content of the page -->
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header no-margin">
            <h1 class="text-center">
                更新业务详情
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="">
                <input type="hidden" id="tmpId" value="${service.id}">
                <textarea  style="display:none" id="content" >${service.servicedescription}</textarea>
                <script id="editor" type="text/plain" style="width:100%;height:500px;">
                </script>
                <script>
                    var ue = UE.getEditor('editor');
                    ue.ready(function() {
                        var content = $("#content").text();
                        ue.setContent(content);
                    });
                </script>
                <input type="button" onclick="submitForm()" style="width: 100% !important; margin-top: 1%" class="btn btn-primary" value="更新并保存"/>
            </div>

        </section>
        <!-- /.content -->
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

<!-- COMPOSE MESSAGE MODAL -->

<!-- /.modal -->
<script type="text/javascript">
    function submitForm(){
        var id = $("#tmpId").val();
        var content = ue.getContent();

        $.ajax({
            type: 'POST',
            url: "<%=basePath %>companyuser/editService",
            data: {"id": id,"content":content},
            dataType: "json",
            async: false,
            success: function () {
                window.location.href="<%=basePath%>companyuser/companyIndex"
            }
        });

    }
    $(function () {

        "use strict";

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        //When unchecking the checkbox
        $("#check-all").on('ifUnchecked', function (event) {
            //Uncheck all checkboxes
            $("input[type='checkbox']", ".table-mailbox").iCheck("uncheck");
        });
        //When checking the checkbox
        $("#check-all").on('ifChecked', function (event) {
            //Check all checkboxes
            $("input[type='checkbox']", ".table-mailbox").iCheck("check");
        });
        //Handle starring for glyphicon and font awesome
        $(".fa-star, .fa-star-o, .glyphicon-star, .glyphicon-star-empty").click(function (e) {
            e.preventDefault();
            //detect type
            var glyph = $(this).hasClass("glyphicon");
            var fa = $(this).hasClass("fa");

            //Switch states
            if (glyph) {
                $(this).toggleClass("glyphicon-star");
                $(this).toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $(this).toggleClass("fa-star");
                $(this).toggleClass("fa-star-o");
            }
        });

        //Initialize WYSIHTML5 - text editor
        $("#email_message").wysihtml5();
    });
</script>
<!-- jQuery 2.0.2 -->
<script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
<!-- Bootstrap -->
<script src="<%=basePath %>res/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="<%=basePath %>res/js/AdminLTE/app.js" type="text/javascript"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<%=basePath %>res/js/plugins//bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"
        type="text/javascript"></script>
<!-- iCheck -->
<script src="<%=basePath %>res/js/plugins//iCheck/icheck.min.js" type="text/javascript"></script>
<!-- Page script -->


</body>
</html>
