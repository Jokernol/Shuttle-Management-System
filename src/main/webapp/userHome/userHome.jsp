<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/7/2
  Time: 20:33
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
  <title>欢迎访问智慧班车</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/dashboard.css" rel="stylesheet">

</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">欢迎访问智慧班车</a>
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
        <li class="active"><a href="#">排班信息汇总</a></li>
        <li><a href="${pageContext.request.contextPath}/userHome/fangfang.jsp">地理信息汇总</a></li>
        <li><a href="${pageContext.request.contextPath}/userHome/personalCenter.jsp">个人中心</a></li>

      </ul>
    </div>

    <div id="my_bgc" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div id="mysub-header">
        <h1 class="sub-header">排班信息汇总</h1>
      </div>
      <div class="table-responsive">
        <div class="table table-striped">
            <div id="data5" style="float:left;margin-left: 20px;">
              <div style="font-size:18px;margin-left:155px;">排班信息</div>
                <table>
                  <tr>
                    <th>车序号&nbsp;&nbsp;</th>
                    <th>驾驶员编号&nbsp;&nbsp;</th>
                    <th>出发地&nbsp;&nbsp;</th>
                    <th>目的地&nbsp;&nbsp;</th>
                    <th>出发时间&nbsp;&nbsp;</th>
                    <th>剩余座位</th>
                  </tr>
                  <c:forEach items="${applicationScope.rosterDOList}" var="Roster">
                    <tr>
                      <td><input size="5px" style="border:none;outline:medium;" value="${Roster.busId}" readonly>&nbsp;&nbsp;&nbsp;</td>
                      <td><input size="5px" style="border:none;outline:medium;" value="${Roster.driverId}" readonly>&nbsp;&nbsp;&nbsp;</td>
                      <td>${Roster.origin}&nbsp;&nbsp;&nbsp;</td>
                      <td>${Roster.destination}&nbsp;&nbsp;&nbsp;</td>
                      <td>${Roster.departureTime}&nbsp;&nbsp;&nbsp;</td>
                      <td>${Roster.rest}</td>
                      <td><a name="appointment" id="appointment" href="${pageContext.request.contextPath}/appointments/post?rosterId=${Roster.id}">预约</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
                  </c:forEach>
              </table>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
  function appoinment(){
    var method=document.getElementById("appointment");
    var result="${param.info}";
    if(method.innerText==="预约"&&result==="预约成功"){
          document.getElementById("appointment").innerText="取消预约";
    }else if (method.innerText==="取消预约"&&result==="取消预约成功"){
          document.getElementById("appointment").innerText="预约";
    }
  }



</script>
</html>
