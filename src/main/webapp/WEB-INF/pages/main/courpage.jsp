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
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <link href="<%=basePath %>res/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>
    <link href="<%=basePath %>res/css/AdminLTE.css" rel="stylesheet" type="text/css"/>

    <style>
        p, span {
            font-family: Verdana, "Lantinghei SC", "Hiragino Sans GB", "Microsoft Yahei", Helvetica, arial, \5b8b\4f53, sans-serif;
            color: #333;
        }

        .type2Each >p a{
            color: #333;
        }
        .type2Each >p a:hover{
            color: rgb(200,200,200);
        }
        .type2Each >p{
            padding-top:10px;
        }
    </style>
</head>
<body>
<!-- header logo: style can be found in header.less -->
<jsp:include page="header.jsp"/>
<div class="container" style="margin-top: 5%">
    <div class="row">
        <div class="col-md-3" style="padding-right: 0;">
            <div class="side"
                 style="border-left: solid 1px rgb(222,222,222);border-right: solid 1px rgb(222,222,222);border-top: solid 1px rgb(51,51,51);">
                <div class="side_header" style="border-bottom: solid 1px rgb(222,222,222);text-align: center">
                    <p style="display: inline-block;margin-top: 4%">全部分类</p>
                </div>
                <div class="type2List" style="width: 200px;margin-top: -7px;
                        background-color:rgb(249,249,249);margin-left: 95%;
                        display: none;z-index: 1000!important;position: absolute">
                    <%--循环开始--%>
                    <div style="border-bottom: solid 1px rgb(220,220,220);
                                border-right: solid 1px rgb(220,220,220);
                    text-align: center">
                        <div class="type2Each" style="margin-top: 3%;">
                        </div>
                        <div class="">
                            <img src="" alt="">
                        </div>
                    </div>
                    <%--循环结束--%>
                </div>
                <c:if test="${type1List!=null}">
                    <c:forEach items="${type1List}" var="obj" varStatus="status">
                        <div class="row type1"
                             style="border-bottom: solid 1px rgb(222,222,222);text-align: left;margin: 0 auto">
                            <div class="col-md-10" onmouseover="get2List(${status.count})">
                                <p style="display: inline-block;margin-top: 4%">${obj}</p>
                            </div>
                            <div class="col-md-2">
                                <p style="display: inline-block;margin-top: 50%"> > </p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div class="col-md-1">
        </div>
        <div class="col-md-8 courseList">
            <div class="row">
                <div class="" style="border: solid 1px rgb(220,220,220);height: 40px;margin-right:9%">
                </div>
            </div>

            <div class="row row_tran_class" style="margin-top: 30px">
                <c:if test="${courseList!=null}">
                    <c:forEach items="${courseList}" var="obj" varStatus="status">
                        <div class="col-md-3"
                             style="border: solid 1px rgb(220,220,220);border-radius: 2px;text-align: left;padding: 0;margin-bottom: 10px;">
                            <a href="<%=basePath%>web/getCourseInfo?courseId=${obj.id}"><img
                                    src="<%=basePath%>web/getPic/courseImg/${obj.coursepic}" alt=""
                                    style="width: 100%;height: auto!important;"></a>
                            <h4 style="display: inline-block;margin-left: 10px"
                                cid="${status.step}">${obj.coursename}</h4>

                            <p style="margin-left: 10px">课时:${obj.courseperiod}</p>
                        </div>
                        <div style="width:8%;height:10px;float: left">
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <div style="text-align: center">
                <ul class="pagination">
                    <c:if test="${pageNum>1}">
                        <li>
                            <a href="<%=basePath%>web/getTyp2V?type2=${sessionScope.type2}&pageNum=${pageNum-1}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageCount<=10}">
                        <c:forEach begin="1" end="${page.pageCount}" step="1" var="i">
                            <li><a href="<%=basePath%>web/getTyp2V?type2=${sessionScope.type2}&pageNum=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${page.pageCount>10}">
                        <c:forEach begin="${page.preStart}" end="${page.preEnd}" step="1" var="i">
                            <li><a href="<%=basePath%>web/getTyp2V?type2=${sessionScope.type2}&pageNum=${i}">${i}</a>
                            </li>
                        </c:forEach>
                        <li><a href="">...</a></li>
                        <c:forEach begin="${page.nextStart}" end="${page.nextEnd}" step="1" var="i">
                            <li><a href="<%=basePath%>web/getTyp2V?type2=${sessionScope.type2}&pageNum=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </c:if>

                    <c:if test="${pageNum<page.pageCount}">
                        <li>
                            <a href="<%=basePath%>web/getTyp2V?type2=${sessionScope.type2}&pageNum=${pageNum+1}">&raquo;</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- ./wrapper -->

<!-- COMPOSE MESSAGE MODAL -->

<!-- /.modal -->

<!-- jQuery 2.0.2 -->
<!-- Bootstrap -->
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

        $(".no-print").hide();
        $(".courseList").mouseover(function () {
            $(".type2List").css("display", "none")
        });
        $(".type2List").mouseover(function () {
            $(".type2List").css("display", "block");
        });
    })

    function show2List(data) {
        $(".type2Each").empty();
        $.each(data, function (idx, obj) {
            $(".type2Each").append("<p style='border-top: solid 1px rgb(233,233,233);'>"
                    + "<a href='<%=basePath%>web/getTyp2V?type2=" + obj + "'>" + obj + "</a></p>");
            $(".type2List").css("display", "block");
        });
    }
    function get2List(index) {
        $.ajax({
            type: "GET",
            url: "<%=basePath%>web/getType2For1",
            data: {"index": index},
            dataType: "json",
            async: false,
            success: function (data) {
                show2List(data);
            }
        })
    }
</script>

</body>
</html>
