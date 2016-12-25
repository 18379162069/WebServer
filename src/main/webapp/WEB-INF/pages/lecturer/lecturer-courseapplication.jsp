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
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>res/css/jquery.datetimepicker.css"/>
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
            <form role="form" onsubmit="checkForm()" action="<%=basePath %>course/courseapplication" method="post"
                  style="width: 70%;margin-left: 20%" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="box box-info" style="height: 800px">
                        <div class="box-header">
                            <h2 style="margin-left: 40%">课程信息</h2>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程名称</label>
                                    <input type="text" class="form-control" name="coursename"
                                           value="${course.coursename}"/>

                                </div>
                                <div class="col-md-2">

                                </div>
                                <div class="col-md-4">
                                    <label for="course-icon">课程图标</label>
                                    <input type="file" class="" id="course-icon" name="pic" required>
                                    建议使用：300*110 <br>大小不超过2M
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left: 10%;width: 80%">
                            <div class="row" style="margin-left: 3px">
                                <div class="col-md-10 ">
                                    <div class="row">
                                        <label>课程类型</label>
                                    </div>
                                    <div class="row courseType">
                                        <select class="courseType1" name="type1Name">
                                            <c:if test="${type1List!=null}">
                                                <c:forEach items="${type1List}" var="obj">
                                                    <option value="${obj}">${obj}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                        <select class="courseType2" name="type2Name">
                                        </select>
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
                                            <input type="button" class="btn btn-primary" style="height: 100%"  onclick="cancelAddCourseType()" value="取消">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4 ">
                                    <div class="row" style="margin-left: 5px">
                                        <label>课程分类</label>
                                    </div>
                                    <div class="row" style="margin-left: 5px">
                                        <select name="coursemode">
                                            <option value="线上">线上</option>
                                            <option value="线下">线下</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程讲师</label>
                                    <input type="text" class="form-control" name="courselecturer"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4">
                                    <label>课程开始时间</label>
                                    <input type="text" class="form-control" name="coursetime" id="datetimepicker"
                                           value="">
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程课时</label>
                                    <input type="text" class="form-control" name="courseperiod"
                                           >
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
                                               >
                                    </div>
                                </div>
                                <div class="col-md-4" style="margin-left: 100px">
                                    <label>课程收费</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-yen"></i>
                                        </span>
                                        <input type="text" class="form-control" name="courseprice"
                                               >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-10">
                                    <label>课程介绍</label>
                                        <textarea class="form-control" row="6" name="coursedescription"
                                                ></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-left:10%;width: 80%">
                            <div class="row">
                                <div class="col-md-4" style="margin-left: 30%;margin-top: 15px">
                                    <input type="submit" class="btn btn-primary">
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
<script>
    function checkForm(){
        $(".addType1Name").attr("name","no");
    }
    function cancelAddCourseType(){
        $(".addServiceTypeDiv").hide();
        $(".courseType1,.courseType2").css("display","inline-block")
    }
    function addServicePage() {
        $(".courseType1,.courseType2").hide();
        $(".addServiceTypeDiv").css("display", "inline-block");
    }
    function addService() {
        var type1Name =$(".addType1Name").val();
        var type2Name =$(".addType2Name").val();
        if(type1Name==""||type1Name==null)return false;
        if(type2Name==""||type2Name==null)return false;
        $.ajax({
            type: "post",
            url: "<%=basePath%>lecturer/addCourseType",
            dataType: "json",
            data: {type1Name: type1Name, type2Name: type2Name},
            success: function (data) {
                if (data.flag == true) {
                    window.location.href = "<%=basePath%>course/courseapplicationpage"
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
    function showType2List(data){
        $(".courseType2").html("");
        $.each(data,function(index){
            $(".courseType2").append("<option value='"+data[index]+"'>"+data[index]+"</option>");
        })
    }
    $(document).ready(function(){
        $.ajax({
            type:"GET",
            url:"<%=basePath%>course/getCourseType2List",
            dataType: "json",
            success:function(data){
                showType2List(data);
            }
        })

        $(".courseType1").change(function(){
            var type1 = $(this).val();
            $.ajax({
                type:"GET",
                url:"<%=basePath%>course/getCourseType2List",
                dataType: "json",
                data:{type1:type1},
                success:function(data){
                    showType2List(data);
                }
            })
        })
    })

</script>
<!-- jQuery 2.0.2 -->
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
<script src="<%=basePath %>res/js/jquery.datetimepicker.js"></script>
<script>
    $('#datetimepicker').datetimepicker();
    $('#datetimepicker').datetimepicker({value: "${course.coursetime}",step:10});
</script>
</body>
</html>
