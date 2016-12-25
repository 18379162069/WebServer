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
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
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
                发布业务
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
                                <div class="col-md-12">
                                    <form action="<%=basePath%>companyuser/addService" onsubmit="return submitForm()"
                                          enctype="multipart/form-data" method="post">
                                        <h3><strong>选择分类：</strong></h3>
                                        <select name="type1" id="type1" onchange="getType2List(this.value)">
                                            <c:if test="${type1List!=null}">
                                                <c:forEach items="${type1List}" var="obj">
                                                    <option value="${obj}">${obj}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                        <select name="type2" id="type2">
                                            <c:if test="${type2List!=null}">
                                                <c:forEach items="${type2List}" var="obj">
                                                    <option value="${obj}">${obj}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                        <%--<select name="type3" id="type3">--%>
                                        <%--<c:if test="${type3List!=null}">--%>
                                        <%--<c:forEach items="${type3List}" var="obj">--%>
                                        <%--<option value="${obj}">${obj}</option>--%>
                                        <%--</c:forEach>--%>
                                        <%--</c:if>--%>
                                        <%--</select>--%>

                                        <a href="javascript:addServicePage()"><span style="margin-left: 20px;"
                                                                                    onmouseover="hoverRight()"
                                                                                    onmouseout="hoverLeft()">申请增加分类</span></a>
                                        <span class="glyphicon glyphicon-arrow-right addType"
                                              style="color: #333"></span>

                                        <div class="addServiceTypeDiv" style="display:none;height: 30px">

                                            <select name="type1Name" class="addType1Name" style="height: 100%;">
                                                <c:if test="${type1List!=null}">
                                                    <c:forEach items="${type1List}" var="obj">
                                                        <option value="${obj}">${obj}</option>
                                                    </c:forEach>
                                                </c:if>
                                            </select>
                                            <input type="text" class="addType2Name" style="height: 100%" >
                                            <input type="button" onclick="addService()" style="height: 100%" class="btn btn-primary"
                                                   value="提交审核">
                                            <input type="button" class="btn btn-danger" onclick="cancelAddService()" style="height: 100%"  value="取消">
                                        </div>
                                        <br>

                                        <h3><strong>业务名：</strong></h3>
                                        <input type="text" name="servicename" id="servicename" required>

                                        <h3><strong>业务图片：</strong></h3>
                                        <input type="file" name="pic" id="pic" required>

                                        <h3><strong>业务介绍：</strong></h3>

                                        <div style="margin-top: 1%">
                                            <script id="editor" name="servicedescription" type="text/plain"
                                                    style="width:100%;height:500px;">
                                            </script>
                                            <script>
                                                var ue = UE.getEditor('editor');
                                            </script>
                                        </div>
                                        <div style="margin-top: 1%">
                                            <input type="submit" class="btn btn-primary" style="width: 100%" value="提交">
                                        </div>
                                    </form>
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

<script>
    function cancelAddService(){
        $(".addServiceTypeDiv").hide();
    }
    function addServicePage() {
        $(".addServiceTypeDiv").css("display", "inline-block");
    }
    function addService() {
        var type1Name =$(".addType1Name").val();
        var type2Name =$(".addType2Name").val();
        if(type1Name==""||type1Name==null)return false;
        if(type2Name==""||type2Name==null)return false;
        $.ajax({
            type: "post",
            url: "<%=basePath%>companyuser/addServiceType",
            dataType: "json",
            data: {type1Name: type1Name, type2Name: type2Name},
            success: function (data) {
                if (data.flag == true) {
                    window.location.href = "<%=basePath%>companyuser/addServicePage"
                } else {
                    alert("抱歉，添加失败~");
                }
            }

        })
    }

    function hoverRight() {
        $(".addType").animate({
            "margin-left": "5px"
        })
    }
    function hoverLeft() {
        $(".addType").animate({
            "margin-left": "0px"
        })
    }
    function giveToSelect2(data) {

        $("#type2").children("option").remove();
        $("#type3").children("option").remove();

        for (var i = 0; i < data.typeList.length; i++) {
            $("#type2").append("<option value=" + data.typeList[i] + ">" + data.typeList[i] + "</option>");
        }
//        for (var i = 0; i < data.type2List.length; i++) {
//            $("#type3").append("<option value=" + data.type2List[i] + ">" + data.type2List[i] + "</option>");
//        }
    }
    //    function giveToSelect3(data) {
    //        $("#type3").children("option").remove();
    //        for (var i = 0; i < data.typeList.length; i++) {
    //            $("#type3").append("<option value=" + data.typeList[i] + ">" + data.typeList[i] + "</option>");
    //        }
    //    }
    function getType2List(dataType) {
        $.ajax({
            type: 'post',//可选get
            url: '<%=basePath%>companyuser/getNextTypeList',    //这里是接收数据的后台程序路径，比如servlet(不知道C#有没有这个)
            data: {dataType: dataType},//传给后台的数据，多个参数用&连接，也可以放在在url后面
            dataType: 'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
            success: function (data) {
                giveToSelect2(data);
            },
        })
    }
    <%--function getType3List(dataType2) {--%>
    <%--var type1 = $("#type1").val();--%>
    <%--$.ajax({--%>
    <%--type: 'post',//可选get--%>
    <%--url: '<%=basePath%>companyuser/getNextTypeList',    //这里是接收数据的后台程序路径，比如servlet(不知道C#有没有这个)--%>
    <%--data: {dataType: type1, dataType2: dataType2},//传给后台的数据，多个参数用&连接，也可以放在在url后面--%>
    <%--dataType: 'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等--%>
    <%--success: function (data) {--%>
    <%--giveToSelect3(data);--%>
    <%--}--%>
    <%--})--%>
    <%--}--%>

    function submitForm() {
        var type1Name = $("#type1").val();
        var type2Name = $("#type2").val();
        var serviceName = $("#servicename").val();
        var serviceDescription = ue.getContent();
        var servicepic = $("#pic").val();
        if ((type1Name == "" || type1Name == null) || (type2Name == "" || type2Name == null) || (serviceName == "" || serviceName == null) || (serviceName == "" || type1Name == null) || (serviceDescription == "" || serviceDescription == null) || (servicepic == "" || servicepic == null)) {
            return false;
        }
        return true;
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

<script>
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
