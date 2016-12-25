<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/12
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
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
                <a href="<%=basePath %>companyuser/companyIndex">
                    <i class="fa fa-dashboard"></i> <span>首页</span>
                </a>
            </li>
            <li>
                <a href="<%=basePath %>companyuser/companyIndex">
                    <i class="fa fa-bell"></i> <span>业务列表</span>
                    <small class="badge pull-right bg-green"></small>
                </a>
            </li>
            <li>
                <a href="<%=basePath %>companyuser/addServicePage">
                    <i class="fa fa-bell"></i> <span>增加业务</span>
                    <small class="badge pull-right bg-green"></small>
                </a>
            </li>
            <li>
                <a href="<%=basePath %>companyuser/newsList">
                    <i class="fa fa-chain"></i> <span>发布资讯</span>
                    <small class="badge pull-right bg-green"></small>
                </a>
            </li>
            <li>
                <a href="<%=basePath %>companyuser/editCompanyUserPage">
                    <i class="fa fa-envelope"></i> <span>更新企业信息</span>
                </a>
            </li>
            <%--<li>--%>
                <%--<a href="pages/mailbox.html">--%>
                    <%--<i class="fa fa-envelope"></i> <span>查看消息</span>--%>
                    <%--<small class="badge pull-right bg-yellow">12</small>--%>
                <%--</a>--%>
            <%--</li>--%>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

</body>
</html>
