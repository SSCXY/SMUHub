<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/11/14
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid">
<%--    <div class="row">--%>
<%--        <div class="search_title_bar">搜索</div>--%>
<%--    </div>--%>
    <div class="row">
        <form id="search_form" class="form-inline">
            <div class="form-group has-feedback">
                <label >加入时间:</label>
                <input type="text" class="form-control input-sm form_datatime" name="regStartTime" >
                <span class="iconfont icon-rili form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <label >至:</label>
                <input type="text" class="form-control input-sm form_datatime" name="regEndTime">
                <span class="iconfont icon-rili form-control-feedback"></span>

            </div>
            &nbsp

            <div class="form-group">
                <label >成员信息:</label>
                <input type="text" class="form-control input-sm" name="userInfo">
            </div>

            <div id="search_btn" class="row form-group pull-right">
                <button type="button" class="btn btn-default">查询</button>
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">添加</button>
                <button type="button" class="btn btn-default">删除</button>
                <button type="button" class="btn btn-default">导入</button>
                <button type="button" class="btn btn-default">导出</button>

            </div>
        </form>
    </div>

    <div id="content_table" class="row">
        <div class="table-responsive">
            <table class="table table-border table-hover">
                <tr>
                    <td style="width: 30px"><input type="checkbox" name="allcheck" class="checkall" onclick="checkall();"></td>
                    <td>用户名</td>
                    <td>手机号</td>
                    <td>邮箱地址</td>
                    <td>角色</td>
                    <td>用户状态</td>
                    <td style="width: 100px">操作</td>
                </tr>
                <c:forEach items="${userDatasByPager.list}" var="user">
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>${user.username}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>
                        <c:forEach items="${user.roles}" var="role">
                            ${role.rname}&nbsp;
                        </c:forEach>
                    </td>
                    <td>${user.enable}</td>
                    <td><a href="${pageContext.request.contextPath}/updateUser?id=${user.id}" data-toggle="modal" data-target="#updateUserModal">编辑</a>&nbsp;<a href="#">删除</a></td>
                </tr>

                </c:forEach>
            </table>
        </div>

        <div class="row" id="pager">
            <p class="pull-left">总共有<span>${userDatasByPager.total}</span>条记录，当前<span>${userDatasByPager.pageNum}/${userDatasByPager.pages}页</span></p>
            <div class="btngroup pull-right" >
                <a href="${pageContext.request.contextPath}/user?pageNum=1&pageSize=5" class="btn btn-default">首页</a>
                <a href="${pageContext.request.contextPath}/user?pageNum=${userDatasByPager.prePage}&pageSize=5" class="btn btn-default">上一页</a>
                <a href="${pageContext.request.contextPath}/user?pageNum=${userDatasByPager.nextPage}&pageSize=5" class="btn btn-default">下一页</a>
                <a href="${pageContext.request.contextPath}/user?pageNum=${userDatasByPager.pages}&pageSize=5" class="btn btn-default">尾页</a>
            </div>
        </div>
    </div>


    <div class="modal fade" id="addUserModal" tabindex="-1">
        <div class="modal-dialog modal-sm">
            <div class="modal-content" >

                <div class="modal-body">
                    <form method="post"  id="addUserForm" action="${pageContext.request.contextPath}/adduser" >
                        <div class="form-group">
                            <label >用户名：</label>
                            <input type="text" class="form-control" name="username" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            <label >密  码：</label>
                            <input type="password" class="form-control" name="password" placeholder="密码">
                        </div>
                        <div class="form-group">
                            <label >角  色：</label>
                            <select class="selectpicker form-control" name="roleIds" multiple>
                                <c:forEach items="${allRoles}" var="role">
                                    <option value="${role.id}">${role.rname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> 手机号：</label>
                            <input type="text" class="form-control" name="phone" placeholder="手机号码">
                        </div>
                        <div class="form-group">
                            <label >邮箱：</label>
                            <input type="text" class="form-control" name="email" placeholder="邮箱">
                        </div>

                        <div class="form-group">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="addUserBtn" type="submit" class="btn btn-primary">添加用户</button>
                            </div>
                        </div>
                    </form>
                </div>


            </div>
        </div>
    </div>


    <div class="modal fade" id="updateUserModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">

            </div>
        </div>
    </div>

</div>
</body>

<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/lib/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/lib/bootstrap-select/js/i18n/defaults-zh_CN.min.js" type="text/javascript"></script>

</html>
