<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/11/14
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <![endif]-->
</head>
<body>
<div id="admin_top" class="container-fluid">
    <div class="row">
        <div class="navbar navbar-inverse navbar-static-top">
            <div class="navbar-header col-md-8">
                <span class="navbar-brand"><i class="iconfont icon-minzuyixue"></i>民大github后台管理</span>
            </div>
            <div class="col-md-8 col-md-offset8" ></div>

            <div class="col-md-8 col-md-offset8">
                <i class="iconfont icon-character  login-info-1">admin</i>
                <i class="iconfont icon-rili  login-info-2">2020-11-14</i>
                <a href="#" class="pull-right"><i class="iconfont">&#xe7eb</i></a>
            </div>
        </div>
    </div>
</div>
<div id="slid_bar">
    <div class="slidbar_title">
        <p>
            <span>模块/</span>
            <span>Nav Module</span>
        </p>
    </div>
    <div class="slidebar_content navbar-fixed-bottom" >
        <a href="#collapse_system" data-toggle="collapse"><i  class="iconfont icon-758bianjiqi_fengexian"></i>系统设置</a>
        <ul id="collapse_system" class="collapse in collapse_all">
            <li><a href="" data-iframesrc="${pageContext.request.contextPath}/user"><i class="iconfont icon-vertical_line"></i>角色管理</a></li>
            <li><a href="" data-iframesrc="${pageContext.request.contextPath}/role"><i class="iconfont icon-vertical_line"></i>用户管理</a></li>
            <li><a href="" data-iframesrc="${pageContext.request.contextPath}/permission"><i class="iconfont icon-vertical_line"></i>权限管理</a></li>

        </ul>
    </div>
</div>
<div id="path_nav">
    <ol class="breadcrumb">
        <li><a href="#">后台首页</a></li>
        <li><a href="#">系统管理</a></li>
        <li class="active">信息</li>
    </ol>

</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/admin.js" type="text/javascript"></script>
</body>
</html>

<iframe id="iframe-contant" class="navbar-fixed-bottom"
        scrolling="0" width="100%" height="100%" allowtransparency="true"
        src="${pageContext.request.contextPath}/html/admin_wel.html" frameborder="0"></iframe>