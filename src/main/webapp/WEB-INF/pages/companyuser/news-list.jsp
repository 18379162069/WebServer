<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 20:30
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
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
</head>
<script>
    $(document).ready(function(){
        if(window.location.href != "<%=basePath%>companyuser/newsList") {
            window.location.href = "<%=basePath%>companyuser/newsList";
        }
    })
</script>
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
                已发布资讯列表
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- MAILBOX BEGIN -->
            <div class="mailbox row">
                <div class="col-xs-12">
                    <div class="box box-solid">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <div class="row pad">
                                        <div class="col-sm-6">

                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="table-responsive">
                                        <!-- THE MESSAGES -->
                                        <table class="table table-mailbox">
                                            <tr class="unread">
                                                <td class="small-col"><input type="hidden"/></td>
                                                <td class="name">资讯名</td>
                                                <td class="subject">资讯简介</td>
                                                <td class="subject">资讯分类</td>
                                                <td class="time">增加内容</td>
                                            </tr>
                                            <c:if test="${newsList!=null}">
                                                <c:forEach items="${newsList}" varStatus="state" var="obj">
                                                    <tr class="unread">
                                                        <td class="small-col"></td>
                                                        <td class="name">${obj.newsname}</td>
                                                        <td class="subject">${obj.newsdescription}</td>
                                                        <td class="subject">${obj.newstype}</td>
                                                        <td class="time"><input type="button" class="btn-xs btn-primary" value="增加" onclick="window.location.href='<%=basePath%> companyuser/pubNewsPage?id=${obj.id}'"></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col (RIGHT) -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <div class="pull-right">
                                <small></small>
                                <%--<button class="btn btn-xs btn-primary" onclick="goToPrevious()"><i class="fa fa-caret-left"></i></button>--%>
                                <%--<button class="btn btn-xs btn-primary" onclick="goToNext()"><i class="fa fa-caret-right"></i></button>--%>
                            </div>
                        </div>
                        <!-- box-footer -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col (MAIN) -->
            </div>
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4 myLoginBox" style="margin-top: 8%">
                    <div class="panel panel-default panelHead">
                        <div class="panel-heading" style="color: rgb(183,57,158);text-align: center"><strong>添加新资讯</strong></div>
                        <div class="panel-body">
                            <form onsubmit="return checkForm()" action="<%=basePath %>companyuser/addNews" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="newsname">资讯名</label>
                                    <input type="text" class="form-control" id="newsname" name="newsname"  placeholder="资讯名"/>
                                </div>
                                <div class="form-group">
                                    <label for="newstype">资讯分类</label>
                                    <input type="text" class="form-control" id="newstype" name="newstype" placeholder="资讯分类"/>
                                </div>
                                <div class="input-append" style="padding-right: 0 !important;">
                                    <label for="photoCover">资讯图片</label><br>
                                    <input id="searchFile" type="file" name="pic" style="display: none;">
                                    <input id="photoCover" class="form-control"  type="text"
                                           placeholder="资讯图片" style="width:70% !important;display: inline-block;"/>
                                    <input type="button" id="myBtn" class="btn btn-primary"
                                           onclick="$('input[id=searchFile]').click();" value="浏览图片">
                                </div>
                                <div class="form-group">
                                    <label for="newsdescription">资讯简介</label>
                                    <input type="text" class="form-control" id="newsdescription" name="newsdescription"/>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-default" value="确定添加"  style="width: 100%; color:rgb(183,57,158);font-weight: bold;">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                </div>
            </div>
            <!-- MAILBOX END -->

        </section>
        <!-- /.content -->
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

<!-- COMPOSE MESSAGE MODAL -->

<!-- /.modal -->

<!-- jQuery 2.0.2 -->

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
<script type="text/javascript">
    $(document).ready(function () {
        $("#searchFile").change(function () {
            $("#photoCover").val($(this).val());
        });

        $(document).ready(function () {
            $("#searchFile").change(function () {
                $("#photoCover").val($(this).val());
                var pic = $(this).val();
                if (!/\.(jpg|jpeg|png|JPG|PNG)$/.test(pic)) {
                    alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
                    $(this).val();
                    $("#photoCover").val("");
                }
            });
        });

    });

    function checkForm(){
        var newsname = $("#newsname").val();
        var newstype  = $("#newstype").val();
        var newspic = $("#photoCover").val();
        var newsdescription = $("#newsdescription").val();
        if ((newsname == null || newsname == "") || (newstype == null || newstype == "") || (newspic == null || newspic == "")|| (newsdescription == null || newsdescription == "")) {
            return false;
        }
        return true;
    }
    var pageNo = $("#pageNo").val();
    if(pageNo==NaN ){
        pageNo=0;
    }else if(pageNo==""){
        pageNo=0;
    }
    var nextPageNo = parseInt(pageNo) + 1;
    if (pageNo >= 1) {
        var prePageNo = pageNo - 1;
    } else {
        var prePageNo = pageNo;
    }

    function goToNext() {
        window.location.href = "<%=basePath%>admin/serviceCheck?pageNo=" + nextPageNo;
    }

    function goToPrevious() {
        window.location.href = "<%=basePath%>admin/serviceCheck?pageNo=" + prePageNo;
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

</body>
</html>
