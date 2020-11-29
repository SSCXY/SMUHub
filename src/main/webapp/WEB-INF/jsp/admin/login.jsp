<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SMURespository</title>
    <link href="${pageContext.request.contextPath}/static/css/base.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>

</head>
<body class="white">
<div class="login-hd">
    <div class="left-bg"></div>
    <div class="right-bg"></div>
    <div class="hd-inner">
        <span class="logo"></span>
        <span class="split"></span>
        <span class="sys-name">SMURespository</span>
    </div>
</div>
<div class="login-bd">
    <div class="bd-inner">
        <div class="inner-wrap">
            <div class="lg-zone">
                <div class="lg-box">
                    <div class="lg-label"><h4>用户登录</h4></div>

                    <form id="myform" method="post" action="${pageContext.request.contextPath}/login">
                        <div class="lg-username input-item clearfix">
                            <i class="iconfont"></i>
                            <input type="text"  name="userInfo" placeholder="请输入用户名">
                        </div>
                        <div class="lg-password input-item clearfix">
                            <i class="iconfont"></i>
                            <input type="password"  name="password"  placeholder="请输入密码">
                        </div>

                        <div class="enter" style="float:left;">
                            <a href="javascript:void(0)" class="purchaser" id="loginBtn" style="display: block"  onclick="document.getElementById('myform').submit();">点击登录</a>

                        </div>
                        <div class="enter2" style="float:left;">
                            <a href="${pageContext.request.contextPath}/register" class="purchaser2" target="_blank" style="display: block" id="registBtn">注册</a>

                        </div>


                    </form>
                    <div class="line line-y"></div>
                    <div class="line line-g"></div>
                </div>
            </div>
            <div class="lg-poster"></div>
        </div>
    </div>
</div>
<div class="login-ft">
    <div class="ft-inner">
        <div class="about-us">
            <a href="javascript:;">关于我们</a>
            <a href="http://www.itlike.com/">计科学院</a>
            <a href="javascript:;">服务条款</a>
            <a href="javascript:;">联系方式</a>
        </div>
        <div class="address">  西南民族大学版权所有&nbsp;&nbsp;&nbsp; &nbsp;武侯校区地址：四川省成都市一环路南四段16号(610041)</div>
        <div class="other-info">建议使用IE8及以上版本浏览器&nbsp;蜀ICP备15030592号-1&nbsp;11019012号&nbsp;航空港校区地址：双流区航空港开发区大件路文星段168号(610225)</div>
    </div>
</div>


<script type="text/javascript">

</script>
</body>
</html>
