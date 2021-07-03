<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/7/1
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>欢迎注册</title>
  <link rel="stylesheet" type="text/css" href="${path}/css/regist.css">
  <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
  <script type="text/javascript" src="${path}/js/regist.js"></script>
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
      账号注册
    </div>
    <div class="input-form">
      <div class="border-form">
        <input type="text" name="username" id="username" placeholder="username" class="border-item" required="required">
      </div>
      <div class="border-form">
        <input type="text" name="password" id="password" placeholder="password" class="border-item" required="required">
      </div>
      <div class="border-form">
        <input type="text" name="identity" id="identity" placeholder="identity" class="border-item" required="required">
      </div>
      <div class="border-form">
        <input type="text" name="telephone" id="telephone" placeholder="telephone" class="border-item" required="required">
      </div>
    </div>
    <div class="action">
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
      alert("用户名已存在");
    }
  }
  function regist(){
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    var identity=document.getElementById("identity").value;
    var telephone=document.getElementById("telephone").value;
    var xhr_2=new XMLHttpRequest();
    var url="/users/post?"+"username="+username+"&password="+password+"&identity="+identity+"&telephone="+telephone;
    window.location.href=url;

  };
</script>
</html>
