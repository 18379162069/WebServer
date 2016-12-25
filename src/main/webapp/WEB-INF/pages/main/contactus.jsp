<%--
  Created by IntelliJ IDEA.
  User: louie
  Date: 2016/3/9
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ':' + request.getServerPort() + path + '/';
%>
<html>
<head>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <script src="<%=basePath %>res/js/jquery-2.1.1.min.js"></script>
    <link href="<%=basePath %>res/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath %>res/js/bootstrap.min.js"></script>

    <title></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="row" style="margin-top: 5%">
    <div class="col-md-3">
    </div>
    <div class="col-md-6" style="border: solid 1px rgb(220,220,220)">
        <form role="form" action="<%=basePath%>web/userAddService" onsubmit="return checkSession()" method="post">
            <div style="text-align: center">
                <h3><span>填写内容</span></h3>
            </div>
            <div class="form-group">
                <label for="subject">主题</label>
                <input type="text" class="form-control" name="subject" id="subject" placeholder="" required>
            </div>
            <label for="content">内容</label>
            <div class="form-group">
                <textarea name="content" id="content" class="form-control"  cols="30" rows="10" required></textarea>
            </div>
            <button type="submit" style="width: 100%" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <input type="hidden" id="userId" value="${sessionScope.userId}">


</div>
<script>
    function checkSession(){

        if(gotoUserPage()==false){
            alert("请先登入!");
            return false;
        }else{
            return true;
        }
    }
    $(document).ready(function () {
        if ($("#userId").val() == null) {
            $("a.log").trigger("click");
        }
    })
</script>
</body>
</html>
