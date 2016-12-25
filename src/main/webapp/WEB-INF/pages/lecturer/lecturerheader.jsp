<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+':'+request.getServerPort()+path+'/';
%>
<html>
<head>
    <title></title>
</head>
<body>
<header class="header">
  <a href="<%=basePath %>lecturer/lecturerBGPage" class="logo">
    <!-- Add the class icon to your logo image or logo icon to add the margining -->
    讲师后台
  </a>
  <!-- Header Navbar: style can be found in header.less -->
  <nav class="navbar navbar-static-top" role="navigation">
    <!-- Sidebar toggle button-->
    <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </a>
    <div class="navbar-right">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="glyphicon glyphicon-user"></i>
            <span>${sessionScope.lectureraccount}<i class="caret"></i></span>
          </a>
          <ul class="dropdown-menu" style="width: 1%">
            <!-- Menu Footer-->
            <li class="user-footer">
              <div class="pull-right">
                <a href="<%=basePath%>lecturer/lecturerLogOut" class="btn btn-default btn-flat">注销</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>
</body>
</html>
