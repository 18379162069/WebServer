<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/3/7
  Time: 10:24
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
  <%--<link href="<%=basePath %>res/css/bootstrap.css" rel="stylesheet" type="text/css"/>--%>

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
  <script src="<%=basePath %>res/js/jquery-2.1.4.min.js"></script>
  <style>
    span{
      font-family: 微软雅黑;
    }
  </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container" style="margin-top: 6%;height: 40%">
  <div class="row">
    <div class="col-md-6">
      <img src="<%=basePath%>web/getPic/serviceImg/${service.servicepic}" style="width: 100%;height: 100%" alt="">
    </div>
    <div class="col-md-6">
      <div class="" style="height: 20%">
        <h3>${service.servicename}</h3>
      </div>
      <div class="" style="height: 30%">
        <h4>模式:线下交流</h4>
      </div>
      <div style="height: 20%">

      </div>
      <div style="height: 20%;padding-top: 5px">
        <input type="button" class="btn btn-primary" value="订购业务">
      </div>
    </div>
  </div>
</div>
<div style="margin-top: 2%;border-bottom: solid 1px rgb(220,220,220)">
</div>
<div class="container">
  <div class="row">
    <div class="col-md-8">
      <div class="courseDescription" style="background-color: rgb(220,220,220);padding-left: 10px;padding-top: 5px;padding-bottom: 5px">
        <span><h5>业务介绍</h5></span>
      </div>
      <div style="padding-left:5%;margin-top: 1%;margin-bottom: 1%;text-align: left">
        <span>${course.coursedescription}</span>
      </div>
      <%--<div class="lecturerDescrition" style="background-color: rgb(220,220,220);padding-left: 10px;padding-top: 5px;padding-bottom: 5px">--%>
        <%--<span><h5>讲师介绍</h5></span>--%>
      <%--</div>--%>
      <%--<div style="padding-left:5%;margin-top: 1%;margin-bottom: 1%;text-align: left">--%>
        <%--${lecturerDescription}--%>
      <%--</div>--%>
      <div class="courseContent" style="background-color: rgb(220,220,220);padding-left: 10px;padding-top: 5px;padding-bottom: 5px">
        <span><h5>业务内容</h5></span>
      </div>
      <div style="padding-left:5%;margin-top: 1%;margin-bottom: 1%;text-align: left">
        ${course.coursecontent}
      </div>

    </div>
    <div class="col-md-4">

    </div>
  </div>
</div>

</body>
</html>
