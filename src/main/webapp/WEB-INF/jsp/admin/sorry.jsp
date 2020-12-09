<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/12/7
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    *{margin: 0;padding: 0;}
    html,body{
        height: 100%;width: 100%;
    }
    .top_tu1{
        width: 100%;
        height: 150px;
        background-color: cornflowerblue;
        position: absolute;
    }
    .top_tu2{

        height: 150px;
        background-image:url(${pageContext.request.contextPath}/static/images/logo.png);
        background-size: 100% 100%;
    }

    .ok{

        width: 500px;
        /*background-color: #8A6DE9;*/
        position: absolute;
        /* 改变定位后，可以用top left  */
        top: 60%;
        left: 50%;
        margin-left: -100px;
        margin-top: -100px;
    }
    .bingo{
        height: 100px;
        width: 100px;
        position: absolute;
        top: 55%;
        left: 39%;
        margin-left: -100px;
        margin-top: -100px;
        background-image: url(${pageContext.request.contextPath}/static/images/warning.png);
        background-size: 100% 100%;
    }

</style>
<body>
<div class="top_tu1">
    <div class="top_tu2"></div>
</div>

<div class="ok"><h1>对不起，您暂无权限！</h1></div>
<div class="bingo"> </div>
</body>
</html>