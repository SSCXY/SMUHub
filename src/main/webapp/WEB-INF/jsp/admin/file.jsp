<%--
  Created by IntelliJ IDEA.
  User: Jiao
  Date: 2020/12/5
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/upload"
      method="post" enctype="multipart/form-data">

    <input type="file" name="file"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
