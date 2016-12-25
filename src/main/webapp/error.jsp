<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/3/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>

<html>
<head>
    <script src="<%=basePath %>res/js/jquery-2.1.4.min.js"></script>
    <script src="<%=basePath%>res/js/test.js"></script>
    <title></title>

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            list-style-type: none;
        }

        a, img {
            border: 0;
            text-decoration: none;
        }

        body {
            font: 14px/180% Arial, Helvetica, sans-serif, "新宋体";
        }

        .demo {
            width: 300px;
            margin: 60px auto 10px auto
        }

        @media only screen and (min-width: 420px) {
            .demo {
                width: 500px;
                margin: 60px auto 10px auto
            }
        }

        .btn {
            text-transform: uppercase;
            background: rgb(0, 100, 0);
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px auto;
            width: 100px;
            text-align: center;
        }

        .btn:hover {
            background: rgb(0, 75, 0);
            text-decoration: none
        }

        #demo {
            margin: 20px auto;
            width: 120px;
            height: 120px
        }

        .demo p {
            text-align: center
        }
    </style>

</head>
<body>

<div class="demo">

    <p id="demo"></p>

</div>
<img src="<%=basePath%>web/getPic/lunboImg/error.jpg" style="width: 100%;height: 100%" alt="">
<script>
    $(document).ready(function(){
        $('#demo').pietimer('start');
    });
    $(function () {
        $('#demo').pietimer({
            seconds: 3,
            color: 'rgba(220, 220, 220, 0.8)',
            height: 100,
            width: 100
        }, function () {
            window.location.href="<%=basePath%>web/gotoIndex";
        });
    });
</script>
</body>
</html>
