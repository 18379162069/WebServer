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
                企业用户信息更新
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- MAILBOX BEGIN -->
            <div class="mailbox row">
                <div class="row">
                    <div class="col-md-1">
                    </div>
                    <div class="col-md-10" style="background-color:#fff;padding-top: 3%">
                        <div>
                            <form onsubmit="return checkForm()" action="<%=basePath%>companyuser/editCompanyUser" method="post">
                                <div class="row">
                                    <div class="col-md-2"><h3><strong>公司名</strong></h3></div>
                                    <div class="col-md-10" style="margin-top:2%;"><input type="text"
                                          id="companyusername" name="companyusername" value="${companyUser.companyusername}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2"><h3><strong>负责人</strong></h3></div>
                                    <div class="col-md-10" style="margin-top: 2%;"><input type="text"
                                         id="companyusermanager"  name="companyusermanager" value="${companyUser.companyusermanager}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2"><h3><strong>联系电话</strong></h3></div>
                                    <div class="col-md-10" style="margin-top: 2%;"><input type="text"
                                         id="companyusertel"   name="companyusertel" value="${companyUser.companyusertel}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2"><h3><strong>座机电话</strong></h3></div>
                                    <div class="col-md-10" style="margin-top: 2%;"><input type="text"
                                         id="companyuserlandtel"    name="companyuserlandtel" value="${companyUser.companyuserlandtel}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2"><h3><strong>负责人邮箱</strong></h3></div>
                                    <div class="col-md-10" style="margin-top: 2%;"><input type="text"
                                      id="companyuseremail"  name="companyuseremail" value="${companyUser.companyuseremail}">
                                    </div>
                                </div>
                                <div style="margin-top: 2%">
                                    <input type="submit" style="width: 100%;" value="提交" class="btn btn-primary ">
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-1">
                    </div>
                </div>
                <!-- /.col (MAIN) -->
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
    function checkForm(){
        var companyusername = $("#companyusername").val();
        var companyusermanager= $("#companyusermanager").val();
        var companyusertel= $("#companyusertel").val();
        var companyuserlandtel= $("#companyuserlandtel").val();
        var companyuseremail= $("#companyuseremail").val();
        if(companyusername="" || companyusername==null)return false;
        if(companyusermanager="" || companyusermanager==null)return false;
        if(companyusertel="" || companyusertel==null)return false;
        if(companyuserlandtel="" || companyuserlandtel==null)return false;
        if(companyuseremail="" || companyuseremail==null)return false;
        return true;
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




