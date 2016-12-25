<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
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
                发布资讯
            </h1>
        </section>
        <!-- Main content -->
        <form action="<%=basePath%>companyuser/pubNews" onsubmit="return submitForm()" method="post"
              enctype="multipart/form-data">
            <section class="content">
                <input type="hidden" value="${lastedNews.id}" name="id">
                <div class="">
                    <h3 style="display: inline-block"><strong>资讯类型：</strong></h3>
                    <input type="text" value="${lastedNews.newstype}" disabled="disabled">

                    <br>
                    <h3 style="display: inline-block"><strong>资讯名：</strong>&nbsp;&nbsp;&nbsp; </h3>
                    <input type="text" value="${lastedNews.newsname}" disabled="disabled" >


                    <input type="hidden" name="newstype" value="${lastedNews.newstype}" >
                    <input type="hidden" name="newsname" value="${lastedNews.newsname}">
                    <input type="hidden" name="companyuserid" value="${lastedNews.companyuserid}" />
                    <input type="hidden" name="newscheck" value="${lastedNews.newscheck}">
                    <input type="hidden" name="companyname" value="${lastedNews.companyname}" />
                    <input type="hidden" name="companyusertel" value="${lastedNews.companyusertel}"/>
                    <input type="hidden" name="newsdescription" value="${lastedNews.newsdescription}"/>



                <%--<select name="newstype" id="typelist">--%>
                        <%--<c:if test="${newsTypeList!=null}" var="obj">--%>
                            <%--<c:forEach items="${newsTypeList}" var="obj">--%>
                                <%--<option value="${obj}">${obj}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</c:if>--%>
                        <%--<option value="">--无--</option>--%>
                    <%--</select>--%>

                    <%--<h4 style="display: inline-block"><strong>或者</strong></h4>--%>
                    <%--<span><input type="text" id="typediy" disabled="disabled" onblur="textVal()"--%>
                                 <%--placeholder="自定义类型"></span>(如：计算机类)--%>
                    <%--<br>--%>

                    <%--<h3 style="display: inline-block"><strong>资讯图片：</strong></h3>--%>
                    <%--<input type="file" value="" name="pic">--%>

                    <%--<h3 style="display: inline-block"><strong>资讯简介：</strong></h3>--%>

                    <%--<div style="margin-top: 1%">--%>
                        <%--<textarea name="newsdescription" id="newsdescription" cols="30" rows="5">--%>

                        <%--</textarea>--%>
                    <%--</div>--%>
                    <div style="margin-top: 1%">
                        <h3 style="display: inline-block"><strong>资讯内容：</strong></h3>
                        <script id="editor" name="newscontent" type="text/plain" style="width:100%;height:500px;">
                        </script>
                        <script>
                            var ue = UE.getEditor('editor');
                        </script>
                    </div>
                    <input type="submit" style="width: 100% !important; margin-top: 1%"
                           class="btn btn-primary" value="发布资讯"/>
                </div>

            </section>
        </form>
        <!-- /.content -->
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

<!-- COMPOSE MESSAGE MODAL -->

<!-- /.modal -->
<script>
//    $(document).ready(function () {
//        $("#typelist").bind("change", function () {
//            if (($("#typelist option:selected").text()).indexOf("无") > 0) {
//                $("#typediy").removeAttr("disabled");
//            } else {
//                $("#typelist").attr("name", "newstype");
//                $("#typediy").val("");
//                $("#typediy").attr("disabled", "disabled");
//            }
//        })
//    });
//    function textVal() {
//        var typeVal = $("#typediy").val();
//        if (typeVal == "" || typeVal == null) {
//            $("#typelist").attr("name", "newstype");
//            $("#typediy").attr("name", "");
//        } else {
//            $("#typediy").attr("name", "newstype");
//            $("#typelist").attr("name", "");
//        }
//    };
    function submitForm() {
//        var newstype1 = $("#typelist option:selected").text();
//        var newstype2 = $("input[type=text]").val();
//        if ((newstype1 == "" || newstype1 == null) && (newstype2 == "" || newstype2 == null)) {
//            return false;
//        } else {
//            if ($(".pic").val() == "" || $(".pic").val() == null) {
//                return false;
//            } else {
//                if ((ue.getContent() != "" && ue.getContent() != null)) {
//                    if(($("#newsdescription").text() != "")){
//                        return true;
//                    }
//                }
//                else {
//                    return false;
//                }
//            }
//        }

        if ((ue.getContent() != "" && ue.getContent() != null)) {
                return true;
        }else{
            return false;
        }

    }
</script>
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
