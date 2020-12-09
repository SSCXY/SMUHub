<%@ page import="java.util.List" %>
<%@ page import="com.jiao.model.Uploadfile" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Uploadfile> allFiles = (List<Uploadfile>) application.getAttribute("allFiles");
    request.setAttribute("list", allFiles);
    System.out.println("jsp:" + allFiles);
%>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>

    <style>
        *{margin: 0;padding: 0;}
        html,body{
            height: 100%;width: 100%;
        }
        body,ul{
            margin: 0;
            padding:0;
        }
        ul{
            list-style: none;
        }
        li{
            float: left;
        }
        .main{
            width: 100%;
            height: 100%;
            background-color: #fffefd;
        }
        div{height: 400px;
            width: 400px;
            /*background-color:cornflowerblue;*/
            /* margin-bottom: 10px; */
        }
        .r1{
            width: 100%;
            height: 13%;
            background-color: cornflowerblue;

        }
        .tu{
            height: 100%;
            width: 40%;
            float: left;
            background-image: url(static/images/index_1.png);
            background-size: 100% 100%;

        }
        .bt{
            height: 10%;
            width: 10%;
            float: right;
            margin-top: 2%;
        }

        .r2{
            width: 90%;
            height: 80%;
            margin-left: 5%;
            margin-top: 4%;

        }
        .zuo{
            width: 65%;
            height: 100%;
            background-color: coral;
            float: left;
        }
        .shang{
            width: 100%;
            height: 90%;
            background-color: darksalmon;
            background-image: url(static/images/index_main.jpg);
            background-size: 100% 100%;
        }
        .zuo label{
            display: inline-block;
            width: 19%;
            height: 10%;
            text-align: center;
            line-height: 45px;
            color: aliceblue;
            /*background-color: #000000;*/
            cursor: pointer;
            /* 鼠标放上去有手的形状 */
        }


        .you{
            width: 35%;
            height: 100%;
            background-color: #241a0b;
            float: left;

        }
        .you-nav {
            /* display: flex; */
            width: 100%;
            height: 10%;
            justify-content: center;
            /*border-bottom: 1px solid #000000;*/
            /*margin-bottom: 10px;*/
        }
        .you-nav ul li{
            width: 16.5%;
            height: 10%;
            line-height: 47px;
            text-align: center;
        }
        .you-nav ul li:hover{
            border-bottom: 2px solid #FFD700;
        }
        .news-title{
            background-color: rgba(96, 13, 7, 0.12);
            /*margin-top: 21%;*/
            height: 10%;
            padding-top: 10px;
            width: 100%;
        }
        .news-title a{
            font-size: 18px;
            display: inline-block;
            width:100% ;
            /* 设置单行文本超出省略 */
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .news-title ul li a{
            display: inline-block;
            width:100% ;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .you-cot{
            height: 90%;
            width: 100%;
            background-image: url(static/images/index_midr.jpg);
            background-size: 100% 100%;
        }
        .you a {
            color: #F0F8FF;
            text-decoration: none;
        }
        .you-cot ul li a{
            display: inline-block;
            width:100% ;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            font-size: 14px;
        }
        .you-cot a :hover{
            text-decoration: underline;
        }
        .you-cot ul li{
            margin: 5.5px 0px;
        }
        .r3{
            width: 100%;
            height: 20%;
        }
        .login-ft {
            padding-top: 20px;
            min-width: 1200px;
            height: 100%;

        }

        .login-ft .ft-inner {
            margin: 0 auto;
            height: 100%;

        }

        .login-ft .ft-inner .about-us {
            height: 20px;
            line-height: 20px;
            width: 295px;
            margin: 0 auto;
            margin-bottom: 10px
        }

        .login-ft .ft-inner .about-us a {
            color: #666;
            text-decoration: none;
            font-size: 14px;
            float: left;
            margin-left: 15px
        }

        .login-ft .ft-inner .about-us a:hover {
            text-decoration: underline
        }

        .login-ft .ft-inner .address {
            text-align: center;
            color: #999;
            font-size: 12px;
            margin-bottom: 10px;
            height: 15%;

        }

        .login-ft .ft-inner .other-info {
            text-align: center;
            color: #999;
            font-size: 12px;
            margin-bottom: 50px;
            height: 0
        ;
        }

    </style>
</head>

<body>
<header>


</header>

<div class="main">
    <div class="r1">
        <div class="tu"></div>
        <div class="bt" style="padding-right: 80px">
           <c:if test="${sessionScope['userInfo'] eq null}">
               <a href="${pageContext.request.contextPath}/login" style="color: white;font-size: 30px;text-decoration: none">登录</a>
           </c:if>
           <c:if test="${sessionScope['userInfo'] ne null }">
               <a href="${pageContext.request.contextPath}/loginout" style="color: white;font-size: 30px;text-decoration: none">你好,${sessionScope["userInfo"]}</a>
           </c:if>

        </div>
    </div>

    <div class="r2">
        <!--            左-->
        <div class="zuo">
            <div class="shang"></div>
            <label >民大看点</label>
            <label >精彩民大</label>
            <label >聚焦民大</label>
            <label >民大人文</label>
            <label >民大色彩</label>
        </div>
        <!--            右-->
        <div class="you">
            <div class="you-nav">
                <ul>
                    <li><a href="">全部</a></li>
                    <li><a href="">今日</a></li>
                    <li><a href="">近期</a></li>
                    <li><a href="">往期</a></li>
                    <!-- <li><a href=""></a></li> -->
                    <li><a href="">...</a></li>
                </ul>

            </div>
            <div class="you-cot">
                <div class="news-title">
                    <a href="">【民大Github】关于民大Github使用说明</a>
                </div>
                <ul>

                    <c:forEach items="<%=allFiles%>" var="file">

                        <li>
                            <a href="${pageContext.request.contextPath}/download?url=/${file.filename}${file.filetype}">${file.addDate} 用户${file.creator}上传文件“${file.filename}${file.filetype}”</a>
                        </li>
                    </c:forEach>

                </ul>

            </div>
        </div>

    </div>

</div>



<footer>


</footer>
</body>
</html>
