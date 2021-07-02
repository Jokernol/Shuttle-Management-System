<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/7/2
  Time: 17:01
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
    <script src="art-template.js" type="text/javascript" charset="utf-8"></script>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>班车后台管理</title>
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="dashboard.css" rel="stylesheet">
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
        <li><a href="#">欢迎您 ,</a></li>
        <li><a href="#"></a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="adminHome.html">用户信息汇总</a></li>
        <li><a href="busManage.html">车辆信息汇总</a></li>
        <li><a href="rosterManage.html">排班信息汇总</a></li>
        <li class="active"><a href="#">驾驶员信息汇总</a></li>
      </ul>
    </div>

    <div id="my_bgc" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div id="mysub-header">
        <h1 class="sub-header">驾驶员信息汇总</h1>
      </div>
      <div class="table-responsive">
        <div class="table table-striped">

          <div id="data5" style="float:left;margin-left: 20px;">
            <div style="font-size:18px;margin-left:155px;">驾驶员信息</div>
            <table>
              <tr>
                <th>序号&nbsp;&nbsp;</th>
                <th>姓名&nbsp;&nbsp;</th>
                <th>家庭住址&nbsp;&nbsp;</th>
                <th>年龄&nbsp;&nbsp;</th>
                <th>驾驶经验&nbsp;&nbsp;</th>
                <th>电话&nbsp;&nbsp;</th>
              </tr>


              <tr>
                <td>11111</td>
                <td>11111</td>
                <td>11111</td>
                <td>111</td>
                <td>1111</td>
                <td>1111&nbsp;&nbsp;</td>
                <td><a href="">删除&nbsp;&nbsp;</a></td>
                <td><a name="update" id="update">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <div id="update-form" style="display: none">
                  <form action="" method="post" >
                    姓名:<input type="text" name="name" size="1">&nbsp;
                    家庭住址:<input type="text" name="address" size="1">&nbsp;
                    年龄：<input type="text" name="age" size="1">&nbsp;
                    驾驶经验：<input type="text" name="drivingExperience" size="1">&nbsp;
                    电话<input type="text" name="telephone" size="1">&nbsp;
                    <input type="submit" value="更新">
                  </form>
                </div>
              </tr>
            </table>
            <div class="addUser"><input type="button" id="addDriver" value="增加驾驶员"></div>
            <div class="form" id="form" style="display: none;">
              <form action="" method="put">
                姓名:<input type="text" name="name" size="1">&nbsp;
                家庭住址:<input type="text" name="address" size="1">&nbsp;
                年龄：<input type="text" name="age" size="1">&nbsp;
                驾驶经验：<input type="text" name="drivingExperience" size="1">&nbsp;
                电话<input type="text" name="telephone" size="1">&nbsp;
                <input type="submit" value="增加">
                <br/>
              </form>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
  var a=b=0;
  //通过button按钮的id获取点击事件
  document.getElementById("addDriver").onclick = function (){

    //使用if判断，判断button按钮的value属性
    if (a===0) {
      // 如果是隐藏，那么点击后通过div盒子的id修改css样式，将display属性值改为none
      document.getElementById("form").style.display = "block";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      a=1;
    }else if (a===1) {
      // 如果是显示，那么点击后通过div盒子的id修改css样式，将display属性值改为block
      document.getElementById("form").style.display = "none";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      a=0
    }
  };

  document.getElementById("update").onclick = function (){

    //使用if判断，判断button按钮的value属性
    if (b===0) {
      // 如果是隐藏，那么点击后通过div盒子的id修改css样式，将display属性值改为none
      document.getElementById("update-form").style.display = "block";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      b=1;
    }else if (b===1) {
      // 如果是显示，那么点击后通过div盒子的id修改css样式，将display属性值改为block
      document.getElementById("update-form").style.display = "none";
      //this关键字获取的是当前对象  通过this关键字来修改button的value值
      b=0
    }
  };

</script>

</body>
</html>
