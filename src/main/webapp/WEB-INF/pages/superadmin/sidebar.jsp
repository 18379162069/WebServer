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
                <a href="<%=basePath %>superadmin/superadmin_stage">
                    <i class="fa fa-dashboard"></i> <span>首页</span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>首页管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>superadmin/updatewebpage"><i class="fa fa-angle-double-right"></i>公司信息修改</a>
                    </li>
                    <li><a href="<%=basePath %>superadmin/updatelunbopage"><i class="fa fa-angle-double-right"></i>轮播图片修改</a>
                    </li>
                    <li><a href="<%=basePath %>superadmin/cooperation_page"><i class="fa fa-angle-double-right"></i>合作伙伴更新</a>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>二级管理员</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=basePath %>superadmin/insertadmin_page"><i class="fa fa-angle-double-right"></i>增加二级管理员</a>
                    </li>
                    <li><a href="<%=basePath %>superadmin/adminlistpage"><i class="fa fa-angle-double-right"></i>二级管理员列表</a>
                    </li>
                    <%--<li><a href="<%=basePath %>admin/applicationCheck?type=个人讲师"><i class="fa fa-angle-double-right"></i>个人讲师申请</a></li>--%>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

</body>
</html>
