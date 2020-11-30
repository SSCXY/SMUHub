<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/11/30
  Time: 10:46
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

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/role.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.css">
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <![endif]-->
</head>
<body>
<div class="container-fluid">


    <div id="content_table" class="row">
        <div class="table-responsive">
            <table class="table table-border table-hover">
                <tr>
                    <td>权限路径</td>
                    <td style="width: 100px">操作</td>
                </tr>

                <c:forEach items="${permissions}" var="resource">
                    <tr>
                        <td>${resource.path}</td>
                        <td><a href="#" data-toggle="modal" data-target="#updatePermissionModal">编辑</a>&nbsp</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="row" id="pager">
            <p class="pull-left">总共有<span>9</span>条记录，当前<span>1/1页</span></p>
            <div class="btngroup pull-right" >
                <button class="btn btn-default">首页</button>
                <button class="btn btn-default">上一页</button>
                <button class="btn btn-default">下一页</button>
                <button class="btn btn-default">尾页</button>
            </div>
        </div>
    </div>




    <div class="modal fade" id="updatePermissionModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true"></span></button>
                    <h4 class="modal-title" id="updateModalLabel">修改路径</h4>
                </div>
                <div class="modal-body">
                    <form action="#" >
                        <div class="form-group">
                            <label>权限路径：</label>
                            <input type="text" class="form-control" name="permission_name">
                        </div>


                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>



</div>

<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/role.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>

</body>
</html>
