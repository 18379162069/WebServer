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
    <title>用户主页</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="<%=basePath %>res/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="<%=basePath %>res/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>res/js/jquery.js"></script>
    <script src="<%=basePath%>res/js/jquery.backstretch.min.js"></script>
    <script src="<%=basePath%>res/js/custom.js"></script>
    <link rel="stylesheet" href="<%=basePath%>res/css/templatemo-blue.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>res/css/liuqianCSS.css"/>


</head>

<body background="<%=basePath%>res/css/images/tm-bg-slide-1.jpg">
<div class="preloader">
    <div class="sk-spinner sk-spinner-wordpress">
        <span class="sk-inner-circle"></span>
    </div>
</div>

<!-- header section -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <c:choose>
                    <c:when test="${user.userimage!=null}">
                        <img src="${user.userimage}"
                             class="img-responsive img-circle tm-border"
                             alt="templatemo easy profile"></c:when>
                    <c:otherwise>
                        <img src="<%=basePath%>res/css/images/tm-easy-profile.jpg"
                             class="img-responsive img-circle tm-border"
                             alt="templatemo easy profile">
                    </c:otherwise>
                </c:choose>
                <hr>
                <h1 class="tm-title bold shadow">Hi, I am Julia</h1>

                <h1 class="white bold shadow">Creative Director</h1>
            </div>
        </div>
    </div>
</header>

<!-- about and skills section -->
<section class="container">
    <div class="row">
        <div class="col-md-6 col-sm-12 box1">
            <div class="about">
                <h3 class="accent">个人信息模块</h3>
                <div class="row">
                    <div class="col-md-4">
                        <label>姓名</label>
                       <div class="input-group">
                           <input class="form-control" type="text" name="username" value="${user.username}" >
                       </div>
                    </div>
                    <div class="col-md-4">
                        <label>邮箱</label>
                        <div class="input-group">
                            <input class="form-control" type="text" name="useremail" value="${user.useremail}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label>职业</label>
                        <div class="input-group">
                            <input class="form-control" type="text" name="userjob" value="${user.userjob}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label>手机号</label>
                        <div class="input-group">
                            <input class="form-control" type="text" name="usertel" value="${user.usertel}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label>公司</label>
                        <div class="input-group">
                            <input class="form-control" type="text" name="usercompany" value="${user.usercompany}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label>座机号码</label>
                        <div class="input-group">
                            <input class="form-control" type="text" name="userlandtel" value="${user.userlandtel}" >
                        </div>
                    </div>
                </div>

                <form id="myForm" name="myForm" action="<%=basePath%>user/updateavatar" method="post"
                      enctype="multipart/form-data">
                    <input style="width:85px; border:1px solid #ccc; height:25px;" type="file" name="useravatar"
                           id="fcupload" onchange="readURL(this);" />
                    <li><input type="submit" value="上传" id="upload" class="cinput"/></li>
                </form>

            </div>
        </div>
        <div class="col-md-6 col-sm-12 box2">
            <div class="skills">
                <h2 class="white">Skills</h2>
                <strong>PHP MySQL</strong>
                <span class="pull-right">70%</span>

                <div class="progress">
                    <div class="progress-bar progress-bar-primary" role="progressbar"
                         aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;"></div>
                </div>
                <strong>UI/UX Design</strong>
                <span class="pull-right">85%</span>

                <div class="progress">
                    <div class="progress-bar progress-bar-primary" role="progressbar"
                         aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%;"></div>
                </div>
                <strong>Bootstrap</strong>
                <span class="pull-right">95%</span>

                <div class="progress">
                    <div class="progress-bar progress-bar-primary" role="progressbar"
                         aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;"></div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- education and languages -->
<section class="container">
    <div class="row">
        <div class="col-md-8 col-sm-12 box4">
            <div class="education">
                <h2 class="white">所提交需求的状态</h2>

                <div class="education-content">
                    <!--<h4 class="education-title accent">New Web Design</h4>-->
                    <!--<div class="education-school">
                        <h5>School of Media</h5><span></span>
                        <h5>2030 January - 2034 December</h5>
                    </div>
                <p class="education-description">In lacinia leo sed quam feugiat, ac efficitur dui tristique. Ut venenatis, odio quis cursus egestas, nulla sem volutpat diam, ac dapibus nisl ipsum ut ipsum. Nunc tincidunt libero non magna placerat elementum.</p>-->
                </div>
            </div>
        </div>
        <!--<div class="col-md-4 col-sm-12">
            <div class="languages">
                <h2>Languages</h2>
                    <ul>
                        <li>Myanmar / Thai</li>
                        <li>English / Spanish</li>
                        <li>Chinese / Japanese</li>
                        <li>Arabic / Hebrew</li>
                    </ul>
            </div>
        </div>-->
    </div>
</section>

<!-- contact and experience -->
<section class="container">
    <div class="row">
        <div class="col-md-4 col-sm-12">
            <div class="contact">
                <h2>收藏课程列表</h2>

                <p><i class="fa fa-map-marker"></i> 123 Rama IX Road, Bangkok</p>

                <p><i class="fa fa-phone"></i> 010-020-0890</p>

                <p><i class="fa fa-envelope"></i> easy@company.com</p>

                <p><i class="fa fa-globe"></i> www.company.com</p>
            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="contact">
                <h2>链接</h2>

                <p><i class="fa fa-map-marker"></i> 123 Rama IX Road, Bangkok</p>

                <p><i class="fa fa-phone"></i> 010-020-0890</p>

                <p><i class="fa fa-envelope"></i> easy@company.com</p>

                <p><i class="fa fa-globe"></i> www.company.com</p>
            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="contact">
                <h2>订阅课程列表</h2>

                <p><i class="fa fa-map-marker"></i> 123 Rama IX Road, Bangkok</p>

                <p><i class="fa fa-phone"></i> 010-020-0890</p>

                <p><i class="fa fa-envelope"></i> easy@company.com</p>

                <p><i class="fa fa-globe"></i> www.company.com</p>
            </div>
        </div>
        <!--<div class="col-md-8 col-sm-12">
            <div class="experience">
                <h2 class="white">Experiences</h2>
                    <div class="experience-content">
                        <h4 class="experience-title accent">Website Development</h4>
                        <h5>New Media Company</h5><span></span>
                        <h5>2035 January - 2036 April</h5>
                        <p class="education-description">Cras porta tincidunt sem, in sollicitudin lorem efficitur ut. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.</p>
                    </div>
            </div>
        </div>-->
    </div>
</section>

<!-- footer section -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <ul class="social-icons">
                    <li><a href="#" class="fa fa-facebook"></a></li>
                    <li><a href="#" class="fa fa-google-plus"></a></li>
                    <li><a href="#" class="fa fa-twitter"></a></li>
                    <li><a href="#" class="fa fa-dribbble"></a></li>
                    <li><a href="#" class="fa fa-github"></a></li>
                    <li><a href="#" class="fa fa-behance"></a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- jQuery 2.0.2 -->
<script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
<!-- Bootstrap -->
<script src="<%=basePath %>res/js/bootstrap.min.js" type="text/javascript"></script>


</body>
</html>
