<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/7/2
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <!--    引入ECharts文件-->
  <script src="https://cdn.staticfile.org/echarts/5.0.2/echarts.min.js"></script>
  <!-- 引入Jquery -->
  <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
  <!-- 引入art-template.js -->
  <script src="../js/art-template.js" type="text/javascript" charset="utf-8"></script>
  <meta name="description" content="">
  <meta name="author" content="">
  <title>班车后台管理</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">班车后台管理</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">欢迎您,</a></li>
        <li><a href="#">${sessionScope.userDO.username}</a></li>
        <li><a href="/sessions/delete" >注销</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <!--侧边栏-->
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="#">用户信息汇总</a></li>
        <li><a href="/adminHome/busManage.jsp">车辆信息汇总</a></li>
        <li><a href="/adminHome/rosterManage.jsp">排班信息汇总</a></li>
        <li><a href="/adminHome/driverManage.jsp">驾驶员信息汇总</a></li>
        <li><a href="/adminHome/addStation.jsp">添加地图</a></li>


      </ul>
    </div>

    <div id="my_bgc" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div id="mysub-header">
        <h1 class="sub-header">用户汇总</h1>
      </div>
      <div class="table-responsive">
        <div class="table table-striped">
            <div id="data5" style="float:left;margin-left: 20px;">
              <div style="font-size:18px;margin-left:155px;">用户信息</div>
              <table>
                <tr>
                  <th>序号&nbsp;&nbsp;</th>
                  <th>姓名&nbsp;&nbsp;</th>
                  <th>密码&nbsp;&nbsp;</th>
                  <th>组别&nbsp;&nbsp;</th>
                  <th>电话&nbsp;&nbsp;</th>
                </tr>
<c:forEach items="${applicationScope.userDOList}" var="UserDO">
                <tr>
                  <td>${UserDO.id}&nbsp;&nbsp;</td>
                  <td>${UserDO.username}&nbsp;&nbsp;</td>
                  <td>${UserDO.password}&nbsp;&nbsp;</td>
                  <td>${UserDO.identity}&nbsp;&nbsp;</td>
                  <td>${UserDO.telephone}&nbsp;&nbsp;</td>
                  <td><a href="${pageContext.request.contextPath}/users/delete?id=${UserDO.id}">删除&nbsp;&nbsp;</a></td>
                  <td>
                    <a name="update" id="update" onclick="$(this).next().toggle()">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <form action="${pageContext.request.contextPath}/users/put" id="update-form" style="display: none">
                          <input type="text" name="id" value="${UserDO.id}" style="display: none">
                      姓名:<input type="text" value="${UserDO.username}" name="username" size="1">&nbsp;
                      密码:<input type="text" value="${UserDO.password}" name="password" size="1">&nbsp;
                      组别:<input type="text" value="${UserDO.identity}" name="identity" size="1">&nbsp;
                      电话:<input type="text" value="${UserDO.telephone}" name="telephone" size="1">&nbsp;
                      类型:<input type="text" name="type" size="1" value="${UserDO.type}" size="1">
                          <input type="submit" value="更新">
                    </form>
                  </td>
                </tr>
</c:forEach>
              </table>
              <div class="addUser"><input type="button" id="addUser" value="增加用户"></div>
              <div class="form" id="form" style="display: none;">
                <form action="${pageContext.request.contextPath}/users/post" method="post">
                  姓名:<input type="text" name="username" size="7">&nbsp;
                  密码:<input type="text" name="password" size="7">&nbsp;
                  组别:<input type="text" name="identity" size="7">&nbsp;
                  电话:<input type="text" name="telephone" size="7">&nbsp;
                  <input type="submit" value="增加">
                  <br/>
                </form>
              </div>
          </div>
          <div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
  var a=b=0;
  //通过button按钮的id获取点击事件
  document.getElementById("addUser").onclick = function (){

    //使用if判断，判断button按钮的value属性
    if (this.value === "增加用户"&&a===0) {
      // 如果是隐藏，那么点击后通过div盒子的id修改css样式，将display属性值改为none
      document.getElementById("form").style.display = "block";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      a=1;
    }else if (this.value === "增加用户"&&a===1) {
      // 如果是显示，那么点击后通过div盒子的id修改css样式，将display属性值改为block
      document.getElementById("form").style.display = "none";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      a=0
    }
  };

  window.onload=function (){
    var str="${info}";
    if (str==="error"){
      alert("操作失败，数据不能为空");
    }
  }
</script>



</body>
</html>
