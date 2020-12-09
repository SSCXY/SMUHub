<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/12/5
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jiao.model.Uploadfile" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Uploadfile> allFiles = (List<Uploadfile>) application.getAttribute("allFiles");
    request.setAttribute("list", allFiles);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/user.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/lib/bootstrap-select/css/bootstrap-select.min.css">


    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <![endif]-->
</head>
<body>

<div id="content_table" class="row">
    <div class="table-responsive">
        <table class="table table-border table-hover">
            <tr>

                <td>&nbsp;&nbsp;创建者</td>
                <td>文件名</td>
                <td>文件类型</td>
                <td>上传日期</td>


            </tr>
            <c:forEach items="<%=allFiles%>" var="file">
                <tr>
                    <td>&nbsp;&nbsp;${file.creator}</td>
                    <td>${file.filename}</td>
                    <td>${file.filetype}</td>
                    <td>${file.addDate}</td>
                </tr>

            </c:forEach>
        </table>
    </div>


</div>


<form action="${pageContext.request.contextPath}/upload"
      method="post" enctype="multipart/form-data">

    <input type="file" class="file-container btn btn-success fileinput-button" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle" name="file"/>
    <input type="submit" class="btn btn-success fileinput-button" value="上传"/>
</form>


</body>
</html>
