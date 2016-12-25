<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/2/28
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<html>
<head>
    <title></title>
    <style>
        .projects-header {
            text-align: center;
            border-bottom: solid 1px rgb(200, 200, 200);
        }
    </style>
</head>
<body>
<script>
    $(document).ready(function(){
        if("<%=basePath%>web/gotoIndex"!=window.location){
            window.location.href="<%=basePath%>web/gotoIndex";
        }
    })
</script>
<jsp:include page="header.jsp"/>
<div id="myCarousel" class="carousel slide" style="margin-top: 3%">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="<%=basePath%>web/getPic/lunboImg/${lunboPicList.get(0)}">
        </div>
        <div class="item">
            <img src="<%=basePath%>web/getPic/lunboImg/${lunboPicList.get(1)}" alt="Second slide">
        </div>
        <div class="item">
            <img src="<%=basePath%>web/getPic/lunboImg/${lunboPicList.get(2)}" alt="Second slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
</div>
<div style="background-color: rgb(233,233,233);height: 50px;border-bottom: 1px solid rgb(200,200,200)">
</div>
<div class="container" style="margin-top: 3%">
    <div class="row">
        <div class="col-md-8" style="text-align: center">
            <h3>公司业务介绍</h3>

            <div style="text-align: left;">
                <p>${companyIntroduce}</p>
            </div>
        </div>
        <div class="col-md-4">
            <img src="<%=basePath%>web/getPic/lunboImg/qq.jpg" alt="" width="100%" height="auto"
                 style="border-radius: 50%"/>
        </div>
    </div>
</div>
<div class="container projects" style="margin-top:3%; ">
    <div class="projects-header">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-3"><h3>热门课程推荐</h3></div>
            <div class="col-md-3"></div>
            <div class="col-md-1">
            </div>
            <div class="col-md-1" style="padding-top: 2%">
                <button class="btn btn-xs" style="color: blue"><</button>
                <button class="btn btn-xs" style="color: blue">></button>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <c:if test="${courseList!=null}">
            <c:forEach items="${courseList}" var="obj">
                <div class="col-md-3">
                    <div class="thumbnail" style="height: 250px;">
                        <a href="#" title="Bootstrap 编码规范" target="_blank"><img
                                src="<%=basePath%>web/getPic/courseImg/${obj.coursepic}"
                                style="width:100%;height:50%!important;"
                                alt=""/></a>

                        <div class="caption">
                            <h3>${obj.coursename}<br/>
                                <small>课时：${obj.courseperiod}</small>
                            </h3>
                            <p>
                                    ${obj.coursedescription}
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <div class="projects-header">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-3"><h3>热门业务推荐</h3></div>
            <div class="col-md-3"></div>
            <div class="col-md-1">
            </div>
            <div class="col-md-1" style="padding-top: 2%">
                <button class="btn btn-xs" style="color: blue"><</button>
                <button class="btn btn-xs" style="color: blue">></button>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <c:if test="${serviceList!=null}">
            <c:forEach items="${serviceList}" var="obj">
                <div class="col-md-3">
                    <div class="thumbnail" style="height: 250px;word-wrap: break-word!important;">
                        <a href="#" title="" target="_blank"><img
                                src="<%=basePath%>web/getPic/serviceImg/${obj.servicepic}"
                                style="width:100%;height:50%!important;" alt=""/></a>

                        <div class="caption">
                            <h3>${obj.servicename}<br/>
                                <br>
                                <small>@by${obj.servicemanage}</small>
                            </h3>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <div class="projects-header">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-3"><h3>最新资讯订阅</h3></div>
            <div class="col-md-3"></div>
            <div class="col-md-1">
            </div>
            <div class="col-md-1" style="padding-top: 2%">
                <button class="btn btn-xs" style="color: blue"><</button>
                <button class="btn btn-xs" style="color: blue">></button>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <c:if test="${newsList!=null}">
            <c:forEach items="${newsList}" var="obj">
                <div class="col-md-3">
                    <div class="thumbnail" style="height: 240px;">
                        <a href="#" title="Bootstrap 编码规范" target="_blank"><img
                                src="<%=basePath%>web/getPic/newsImg/${obj.newspic}"
                                style="width:100%;height:50%!important;" alt=""/></a>

                        <div class="caption">
                            <h3>${obj.newsname}<br/>
                                <small>类型：${obj.newstype}</small>
                            </h3>
                            <p>
                                <input type="button" class="btn btn-primary" value="订阅" style="width: 100%">
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <div style="margin-top: 10px;border-bottom: solid 1px rgb(200,200,200)">
    </div>
    <footer class="footer ">
        <div class="container">
            <div class="row footer-top">
                <div class="col-sm-6 col-lg-6">
                    <h4>
                        <%--<img src="../../../Desktop/Bootstrap中文网_files/logo.png">--%>
                    </h4>

                    <p>--------------------------------------------------------------</p>
                </div>
                <div class="col-sm-6 col-lg-5 col-lg-offset-1">
                    <div class="row about">
                        <div class="col-xs-4">
                            <h4>关于</h4>
                            <ul class="list-unstyled">
                                <li><a href="http://www.bootcss.com/about/">关于我们</a></li>
                                <li><a href="http://www.bootcss.com/ad/">广告合作</a></li>
                                <li><a href="http://www.bootcss.com/links/">友情链接</a></li>
                                <li><a href="http://www.bootcss.com/hr/">招聘</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-4">
                            <h4>联系方式</h4>
                            <ul class="list-unstyled">
                                <li><a href="http://weibo.com/bootcss" title="Bootstrap中文网官方微博" target="_blank">新浪微博</a>
                                </li>
                                <li><a href="mailto:admin@bootcss.com">电子邮件</a></li>
                            </ul>
                        </div>

                        <div class="col-xs-4">
                            <h4>赞助商</h4>
                            <ul class="list-unstyled">
                                <li><a href="http://www.ucloud.cn/" target="_blank">UCloud</a></li>
                                <li><a href="https://www.upyun.com/" target="_blank">又拍云</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
            <hr>
            <div class="row footer-bottom">
                <ul class="list-inline text-center">
                    <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a></li>
                    <li>京公网安备11010802014853</li>
                </ul>
            </div>
        </div>
    </footer>
</div>

</body>
</html>
