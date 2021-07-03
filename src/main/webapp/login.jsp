<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/6/30
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
  <title>欢迎访问班车管理系统</title>
  <link rel="stylesheet" type="text/css" href="${path}/css/login.css">
  <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div class="header">
    <img src="${path}/image/corner.jfif" id="logo">
    <span id="span">智慧班车 | 致力于优化校园/社区/公司班车管理</span>
    <a href="" class="Link">加入我们</a>
    <a href="">投诉</a>
    <a href="">帮助</a>
</div>
<div class="main" >
    <div class="form">
        <div class="main-header">
            账号登录
        </div>
        <div class="input-form">
            <div class="border-form">
                <input type="text" name="username" id="username" placeholder="username" class="border-item" required="required">
            </div>
            <div class="border-form">
                <input type="password" name="password" id="password" placeholder="password" class="border-item" required="required">
            </div>
        </div>
      <div class="action">
        <div class="btn" id="login" onclick="login()">login</div>
        <div class="btn" id="regist" onclick="regist()">regist</div>
      </div>
    </div>
</div>
<div class="footer">
    <footer>
        <a href="">关于我们&nbsp;</a>
        <a href="">免费邮</a>
        <a href="">官方博客</a>
        <a href="">客户服务</a>
        <a href="">隐私政策|</a>
        <a href="">啥也不会公司版权所有&copy;2020-2021</a>
    </footer>
</div>
</body>
<script>
  window.onload=function (){
    var str="${info}";
    if (str==="error"){
      alert("密码错误");
    }
  }
  function login(){
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    var xhr=new XMLHttpRequest();
    var url="/sessions/post?"+"username="+username+"&password="+password;
    window.location.href=url;
  };
  function regist(){
    window.location.href="/regist.jsp";
  };

</script>
</html>
