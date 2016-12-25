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
                业务展示列表
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
                                            <!-- Action button -->
                                            <div class="btn-group">
                                                <button type="button"
                                                        class="btn btn-default btn-sm btn-flat dropdown-toggle"
                                                        data-toggle="dropdown">
                                                    选择业务类型<span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <c:if test="${type1List!=null}">
                                                        <c:forEach items="${type1List}" var="obj">
                                                            <li><a href="<%=basePath%>companyuser/companyIndex?type=${obj}">${obj}</a></li>
                                                        </c:forEach>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="table-responsive">
                                        <!-- THE MESSAGES -->
                                        <table class="table table-mailbox">
                                            <tr class="unread">
                                                <td class="small-col"><input type="hidden"/></td>
                                                <td class="name">业务名</td>
                                                <td class="subject">负责人</td>
                                                <td class="time">审核状态</td>
                                                <td class="time">操作</td>
                                            </tr>
                                            <%--<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}"/>--%>
                                            <c:if test="${serviceList!=null}">
                                                <c:forEach items="${serviceList}" varStatus="state" var="obj">
                                                    <tr class="unread">
                                                        <input type="hidden" value="${obj.id}"/>
                                                        <td class="small-col"><input type="hidden"></td>
                                                        <td class="name"><a href="<%=basePath%>companyuser/showService?id=${obj.id}">${obj.servicename}</a>
                                                        </td>
                                                        <td class="subject">${obj.servicemanage}</td>

                                                        <c:if test="${obj.servicecheck=='1'}">
                                                            <td class="time" style="color: green">通过</td>
                                                        </c:if>
                                                        <c:if test="${obj.servicecheck=='-1'}">
                                                            <td class="time" >删/待审核</td>
                                                        </c:if>
                                                        <c:if test="${obj.servicecheck=='0'}">
                                                            <td class="time" style="color: red">不通过</td>
                                                        </c:if>
                                                        <c:if test="${obj.servicecheck==null}">
                                                            <td class="time">增/待审核</td>
                                                        </c:if>
                                                        <td class="time"><a href="<%=basePath%>companyuser/delService?id=${obj.id}"><input type="button" class="btn-xs btn-danger" value="删除"></a></td>
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

                        <!-- box-footer -->
                    </div>
                    <!-- /.box -->
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
<div class="modal fade" id="compose-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><i class="fa fa-envelope-o"></i> Compose New Message</h4>
            </div>
            <form action="#" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">TO:</span>
                            <input name="email_to" type="email" class="form-control" placeholder="Email TO">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">CC:</span>
                            <input name="email_to" type="email" class="form-control" placeholder="Email CC">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">BCC:</span>
                            <input name="email_to" type="email" class="form-control" placeholder="Email BCC">
                        </div>
                    </div>
                    <div class="form-group">
                        <textarea name="message" id="email_message" class="form-control" placeholder="Message"
                                  style="height: 120px;"></textarea>
                    </div>
                    <div class="form-group">
                        <div class="btn btn-success btn-file">
                            <i class="fa fa-paperclip"></i> Attachment
                            <input type="file" name="attachment"/>
                        </div>
                        <p class="help-block">Max. 32MB</p>
                    </div>

                </div>
                <div class="modal-footer clearfix">

                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i>
                        Discard
                    </button>

                    <button type="submit" class="btn btn-primary pull-left"><i class="fa fa-envelope"></i> Send Message
                    </button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

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
<script type="text/javascript">
    var pageNo = $("#pageNo").val();
    if (pageNo == NaN) {
        pageNo = 0;
    } else if (pageNo == "") {
        pageNo = 0;
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
