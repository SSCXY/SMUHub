<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/11/14
  Time: 22:59
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
    <div class="row">
        <div class="search_title_bar">搜索</div>
    </div>
    <div class="row">
        <form id="search_form" class="form-inline">


            <div class="form-group">
                <label>角色信息:</label>
                <input type="text" class="form-control input-sm" name="userInfo">
            </div>

            <div id="search_btn" class="row form-group pull-right">
                <button type="button" class="btn btn-default">查询</button>
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">添加</button>
                <button type="button" class="btn btn-default">删除</button>


            </div>
        </form>
    </div>

    <div id="content_table" class="row">
        <div class="table-responsive">
            <table class="table table-border table-hover">
                <tr>
                    <td style="width: 30px"><input type="checkbox" name="allcheck" class="checkall" onclick="checkall();"></td>
                    <td>角色名称</td>
                    <td>角色代码</td>

                    <td style="width: 100px">操作</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#" data-toggle="modal" data-target="#updateUserModal">编辑</a>&nbsp;<a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="allcheck" class="checkone" onclick="checkone();" ></td>
                    <td>用户名</td>
                    <td>手机号</td>


                    <td><a href="#">编辑</a><a href="#">删除</a></td>
                </tr>

            </table>
        </div>

        <div class="row" id="pager">
            <p class="pull-left">总共有<span>90</span>条记录，当前<span>1/9页</span></p>
            <div class="btngroup pull-right" >
                <button class="btn btn-default">首页</button>
                <button class="btn btn-default">上一页</button>
                <button class="btn btn-default">下一页</button>
                <button class="btn btn-default">胃页</button>
            </div>
        </div>
    </div>


    <div class="modal fade" id="addUserModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true"></span></button>
                    <h4 class="modal-title" id="addModalLabel">添加角色</h4>
                </div>
                <div class="modal-body">
                    <form action="#" >
                        <div class="form-group">
                            <label>角色名称：</label>
                            <input type="text" class="form-control" name="username" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            <label>角色代码：</label>
                            <input type="text" class="form-control" name="password" placeholder="密码">
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">添加角色</button>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="updateUserModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true"></span></button>
                    <h4 class="modal-title" id="updateModalLabel">修改角色</h4>
                </div>
                <div class="modal-body">
                    <form action="#" >
                        <div class="form-group">
                            <label>角色名称：</label>
                            <input type="text" class="form-control" name="username">
                        </div>
                        <div class="form-group">
                            <label>角色代码：</label>
                            <input type="text" class="form-control" name="password">
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">编辑角色</button>
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
