<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+':'+request.getServerPort()+path+'/';
%>
<html>
<head>

</head>
<body>
<aside class="left-side sidebar-offcanvas">
  <!-- sidebar: style can be found in sidebar.less -->
  <section class="sidebar">
    <!-- Sidebar user panel -->
    <!-- search form -->

    <!-- /.search form -->
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
      <li class="active">
        <a href="<%=basePath %>lecturer/lecturerBGPage">
          <i class="fa fa-dashboard"></i> <span>讲师首页</span>
        </a>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>个人信息管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>lecturer/lecturerInfoPage"><i class="fa fa-angle-double-right"></i>修改个个人信息</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>课程管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>lecturer/lecturercourseinfopage"><i class="fa fa-angle-double-right"></i>课程信息</a></li>
          <li><a href="<%=basePath %>course/courseapplicationpage"><i class="fa fa-angle-double-right"></i>申请课程开班</a></li>
        </ul>
      </li>
      <%--<li>--%>
        <%--<a href="<%=basePath %>lecturer/lastednewspage">--%>
          <%--<i class="fa fa-bell"></i> <span>咨询管理</span> <small class="badge pull-right bg-green"></small>--%>
        <%--</a>--%>
      <%--</li>--%>

      <li>
        <a href="<%=basePath %>lecturer/coursestudentpage">
          <i class="fa fa-bell"></i> <span>学生管理</span> <small class="badge pull-right bg-green"></small>
        </a>
      </li>
    </ul>
  </section>
  <!-- /.sidebar -->
</aside>

</body>
</html>
