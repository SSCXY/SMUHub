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

        .login-ft {
            padding-top: 20px;
            min-width: 1200px
        }

        .login-ft .ft-inner {
            margin: 0 auto
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
            margin-bottom: 10px
        }

        .login-ft .ft-inner .other-info {
            text-align: center;
            color: #999;
            font-size: 12px;
            margin-bottom: 50px
        }




        .col-xs-1{
            border: 1px red solid;

        }
        .ab{
            background: red;
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
        header{
            width: 100%;
            height: 80px;
            background-color: cornflowerblue;
            background: rgba(0,0,0,0.7);

        }


        .headercont{
            width:1260px ;
            height:80px ;
            margin-left:auto;
            margin-right:auto;
            overflow: hidden;
            color: #6495ED;

        }
        /* 	.headercont:hover{
                overflow: visible;

            } */
        .headercont .logo img{
            height: 80px;
            float: left;
        }

        /* 块级元素水平居中：
        宽度固定
        左边距自动
        右边距自动
         */
        .headercont ul{
            float: left;
            height: 32px;
            margin-left: 100px;

            /* border: 1px solid chartreuse; */
        }
        .headercont ul li{
            float: left;
            line-height: 60px;
            text-align: center;
            height: 50px;
            width: 100px;
            font-size: 20px;

            /* border: 1px solid #000000; */
        }
        .headercont ul li a{
            color:  rgba(255,255,255,0.7);
            text-decoration: none;
        }

        .headercont ul li :hover a{
            text-decoration: underline;
            color: gold;
        }
        /* 	.headercont .english ul li{
                height: 40px;
            } */
        .headercont .english ul li a{
            font-size: 10px;
            /* line-height: 5px; */
        }

        .erji ul li a {
            /* font-size: 10px;
            height: 20px;
            width: 40px;
            height: 30px; */
            line-height: 30px;
            display: block;
            padding: 0;
            font-size: 14px;
            color: #c9c9dd;

        }
        .erji ul li :hover a {
            color: #FFD700;
            text-decoration: underline;
        }
        .erji ul{
            position: relative;
            left: -110px;
            float: left;
            height: 300px;
            width: 101.8%;
            background-color : #000000;
            background: rgba(0,0,0,0.5);
            /* 	margin-left: 100px; */
            /* overflow: hidden; */
        }
        .erji ul li{
            /* float: left; */
            position: relative;
            left: 300px;
            line-height: 40px;
            text-align: center;
            height: 250px;
            font-size: 15px;


        }


        /* top 部分 */

        main{
            min-height: 326px;
            /* background: #FFD700; */
            width: 1200px;
            margin: 0 auto;
            padding-top: 44px;
        }
        .top1{
            height: 343px;
            width: 1200px;
            /* background-color: aqua; */
            display: flex;
            justify-content: center;
        }
        .zuo{
            width: 604px;
            height: 100%;
            /* background-color: #C9C9DD; */
            overflow: hidden;
        }
        .zhong{
            width: 500px;
            height: 100%;
            background-color: rgba(31, 153, 185, 0.51);
            padding: 0 17px;
            box-sizing: border-box;

        }
        .zhong-nav{
            /* display: flex; */
            justify-content: center;
            border-bottom: 1px solid #000000;
            margin-bottom: 10px;
        }
        .zhong-nav ul li{
            width: 16.5%;
            height: 47px;
            line-height: 47px;
            text-align: center;
        }
        .zhong-nav ul li:hover{
            border-bottom: 2px solid #FFD700;
        }
        .news-title{
            background-color: #8dcbdb;
            margin-top: 50px;
            height: 38px;
            padding-top: 10px;
        }
        .news-title a{
            color: gold;
            font-size: 18px;
            display: inline-block;
            width:88% ;
            /* 设置单行文本超出省略 */
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .zhong a {
            color: #F0F8FF;
            text-decoration: none;
        }
        .zhong-cot ul li a{
            display: inline-block;
            width:100% ;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            font-size: 14px;
        }
        .zhong-cot a :hover{
            text-decoration: underline;
        }
        .zhong-cot ul li{
            margin: 5.5px 0px;
        }

        .top2{
            height: 176px;
            width: 1200px;
            /* background-color: blueviolet;	 */
            margin-top: 30px;
            display: flex;
            justify-content: space-between;
            background: azure;
            background-size: 100% 100%;
        }
        .slide{
            width: 800%;
            height: 298px;
            overflow: hidden;
            transition: all .8s;

            /* background-color: #FFD700; */
        }
        .slide li{
            float: left;
            list-style: none;
        }
        .slide-img{
            height: 450px;
            width: 905px;
        }
        .zuo label{
            display: inline-block;
            width: 20%;
            height: 45px;
            text-align: center;
            line-height: 45px;
            color: aliceblue;
            background-color: #000000;
            cursor: pointer;
            /* 鼠标放上去有手的形状 */
        }
        .zuo label:hover{
            color: #FFD700;
            background-color: rgba(61,61,61,0.95);
        }
        .you a{
            display: inline-block;
            width: 100%;
            height: 30px;

            /* background-size: cover; */
        }

        input[ name="tabs1"]{
            display: none;
        }
        #tab1:checked~.slide{
            margin-left: 0;
        }
        #tab2:checked~.slide{
            margin-left: -604px;
        }
        #tab3:checked~.slide{
            margin-left: -1208px;
        }
        #tab4:checked~.slide{
            margin-left: -1812px;
        }
        #tab5:checked~.slide{
            margin-left: -2416px;
        }



        .footer-cnt{
            width: 1200px;
            margin: 0 auto;
            background-color: cadetblue;
            height: 265px;
            padding-top: 100px;
        }
        .f-top{
            height: 78px;
            background-color: aquamarine;

        }
        .footer-main{
            height: 140px;
            background-color: blue;
        }
        .f-left,.f-right{
            height: 78px;
            width: 30%;

        }



    </style>
</head>

<body>
<header>

    <div class="headercont">

        <a href="" class="logo">
            <img src="static/images/1.png" />
        </a>

        <div class="erji">

        </div>
        <div class="kong"/>


    </div>
</header>

<main>
    <div class="top1">
        <div class="zuo">
            <input type="radio" name="tabs1" id="tab1"/>
            <input type="radio" name="tabs1" id="tab2" />
            <input type="radio" name="tabs1" id="tab3"/>
            <input type="radio" name="tabs1" id="tab4"/>
            <input type="radio" name="tabs1" id="tab5"/>
            <div class="slide">
                <li class="slide-img">
                    <img src="static/images/8.jpg" />
                </li>
                <li class="slide-img">
                    <img src="static/images/5-1.jpg" />
                </li>
                <li class="slide-img">
                    <img src="static/images/72.jpg" />
                </li>
                <li class="slide-img">
                    <img src="static/images/4%20(2).jpg" />
                </li>
                <li class="slide-img">
                    <img src="static/images/62.jpg" />
                </li>
            </div>
            <label for="tab1">民大看点</label><label for="tab2">精彩民大</label><label for="tab3">聚焦民大</label><label for="tab4">民大人文</label><label for="tab5">民大色彩</label>
        </div>
        <div class="zhong">
            <div class="zhong-nav">
                <ul>
                    <li><a href="">全部</a></li>
                    <li><a href="">今日</a></li>
                    <li><a href="">近期</a></li>
                    <li><a href="">往期</a></li>
                    <!-- <li><a href=""></a></li> -->
                    <li><a href="">...</a></li>
                </ul>

            </div>
            <div class="zhong-cot">
                <div class="news-title">
                    <a href="">【民大Github】关于民大Github使用说明</a>
                </div>
                <ul>

                    <c:forEach items="<%=allFiles%>" var="file">

                        <li>
                            <a href="">${file.addDate} 用户${file.creator}上传文件“${file.filename}”</a>
                        </li>
                    </c:forEach>




                </ul>

            </div>
        </div>

    </div>
    </div>
    <div class="top2">

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
</main>
<footer>


</footer>
</body>
</html>
