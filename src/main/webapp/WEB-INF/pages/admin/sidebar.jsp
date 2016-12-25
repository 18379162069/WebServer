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
                <a href="<%=basePath %>admin/adminIndex">
                    <i class="fa fa-dashboard"></i> <span>首页</span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-chain"></i> <span>企业/个人申请</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>admin/companyUserApplCheckList"><i
                            class="fa fa-angle-double-right"></i>企业会员申请</a></li>
                    <li><a href="<%=basePath %>admin/lecturerApplCheckList"><i
                            class="fa fa-angle-double-right"></i>个人讲师申请</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-bell"></i> <span>内容审核</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>admin/courseCheckList"><i class="fa fa-angle-double-right"></i>课程信息审核</a></li>
                    <li><a href="<%=basePath %>admin/serviceCheckList"><i class="fa fa-angle-double-right"></i>业务信息审核</a></li>
                    <li><a href="<%=basePath %>admin/courseDocCheckList"><i class="fa fa-angle-double-right"></i>开班文档审核</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>资讯审核</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>admin/newsCheckList"><i class="fa fa-angle-double-right"></i>资讯项审核</a></li>
                    <li><a href="<%=basePath %>admin/newsContentCheckList"><i class="fa fa-angle-double-right"></i>资讯内容审核</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>类型添加审核</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>admin/courseTypeCheckList"><i class="fa fa-angle-double-right"></i>课程类型审核</a></li>
                    <li><a href="<%=basePath %>admin/serviceTypeCheckList"><i class="fa fa-angle-double-right"></i>业务类型审核</a></li>
                </ul>
            </li>
            <li>
                <a href="<%=basePath %>admin/newsList">
                    <i class="fa fa-angle-double-right"></i> <span>发布最新资讯</span>
                    <small class="badge pull-right bg-green"></small>
                </a>
            </li>
            <li>
                <a href="<%=basePath %>admin/page/add-companyuser">
                    <i class="fa fa-angle-double-right"></i> <span>添加企业用户</span>
                    <small class="badge pull-right bg-green"></small>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>查看身份信息</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>companyUser/test"><i class="fa fa-angle-double-right"></i>企业会员</a></li>
                    <li><a href="application-check.html"><i class="fa fa-angle-double-right"></i>个人讲师</a></li>
                    <li><a href="application-check.html"><i class="fa fa-angle-double-right"></i>用户</a></li>
                </ul>
            </li>
            <%--<li>--%>
                <%--<a href="pages/mailbox.html">--%>
                    <%--<i class="fa fa-envelope"></i> <span>删除过期信息</span>--%>
                    <%--<small class="badge pull-right bg-yellow">12</small>--%>
                <%--</a>--%>
            <%--</li>--%>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

</body>
</html>
