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
        <a href="<%=basePath %>user/usermainpage">
          <i class="fa fa-dashboard"></i> <span>用户首页</span>
        </a>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>个人信息管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>user/userinfoupdatepage"><i class="fa fa-angle-double-right"></i>修改个个人信息</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>课程管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>user/courseListpage"><i class="fa fa-angle-double-right"></i>已购买课程信息</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>业务管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>user/usercollectionservice"><i class="fa fa-angle-double-right"></i>已选择的业务</a></li>
          <li><a href="<%=basePath %>course/courseapplicationpage"><i class="fa fa-angle-double-right"></i>需要的业务</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i> <span>资讯管理</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <li><a href="<%=basePath %>user/newspage"><i class="fa fa-angle-double-right"></i>咨询信息</a></li>
        </ul>
      </li>


    </ul>
  </section>
  <!-- /.sidebar -->
</aside>

</body>
</html>
