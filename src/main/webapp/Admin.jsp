<%--
  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/7/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/station.do" method="post">
  <input type="text" name="position">
  <input type="text" name="positionName">
  <input type="submit" value="提交">
</form>
</body>
</html>
