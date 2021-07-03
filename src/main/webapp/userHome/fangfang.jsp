<%--
  Created by IntelliJ IDEA.
  User: 韩成峰
  Date: 2021/7/2
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title></title>
  <style type="text/css">
    html {
      height: 100%
    }

    body {
      height: 100%;
      margin: 0px;
      padding: 0px
    }

    #container {width:100%; height: 80%; }

  </style>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <!--    引入ECharts文件-->
  <script src="https://cdn.staticfile.org/echarts/5.0.2/echarts.min.js"></script>
  <!-- 引入Jquery -->
  <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
  <!-- 引入art-template.js -->

  //引入高德api
  <script src="https://webapi.amap.com/maps?v=2.0&key=86b89ad4e1f9cdd0d722816d4d3ce8ca" type="text/javascript"></script>

  <script src="../js/art-template.js" type="text/javascript" charset="utf-8"></script>
  <meta name="description" content="">
  <meta name="author" content="">
  <title>欢迎访问智慧班车</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">欢迎访问智慧班车</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">欢迎您,</a></li>
        <li><a href="#"></a></li>
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
        <li><a href="userHome.jsp">排班信息汇总</a></li>
        <li class="active"><a href="#">地理信息汇总</a></li>
        <li><a href="personalCenter.jsp">个人中心</a></li>

      </ul>
    </div>

    <div id="my_bgc" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div id="mysub-header">
        <h1 class="sub-header">排班信息汇总</h1>
      </div>
      <div class="table-responsive">
        <div class="table table-striped">
          <div>

            <div id="data5">
              <div style="font-size:18px;margin-left:155px;">地理信息</div>

              <div id="container"></div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://webapi.amap.com/loader.js"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
<script type="text/javascript" >
  AMapLoader.load({
    "key": "86b89ad4e1f9cdd0d722816d4d3ce8ca",              // 申请好的Web端开发者Key，首次调用 load 时必填
    "version": "2.0",   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
    "plugins": [],           // 需要使用的的插件列表，如比例尺'AMap.Scale'等
    "AMapUI": {             // 是否加载 AMapUI，缺省不加载
      "version": '1.1',   // AMapUI 缺省 1.1
      "plugins":['overlay/SimpleMarker'],       // 需要加载的 AMapUI ui插件
    },
    "Loca":{                // 是否加载 Loca， 缺省不加载
      "version": '1.3.2'  // Loca 版本，缺省 1.3.2
    },
  }).then((AMap)=>{
    var map = new AMap.Map('container');
    map.addControl(new AMap.Scale());
    new AMapUI.SimpleMarker({
      map: map,
      position: map.getCenter(),
    });
  }).catch((e)=>{
    console.error(e);  //加载错误提示
  });
</script>

<script type="text/javascript">

  var map = new AMap.Map('container', {
    zoom:15,//级别
    center: [120.032, 30.225],//中心点坐标
    viewMode:'3D'//使用3D视图
  });

  AMap.plugin('AMap.Driving',function(){//异步加载插件
    var driving = new AMap.Driving();//驾车路线规划
    driving.search(/*参数*/)
  });

  var markers = [];
  <c:forEach items="${applicationScope.stationList}" var = "item" varStatus="station" >
  var temp1 = new AMap.Marker({
    position: new AMap.LngLat('${item.x}','${item.y}'), // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
    title: '${item.position}',
    map: map,
    clickable: true
  })
  temp1.on('dblclick',function(e){
    var msg = "确定选择该车站？";
    if (confirm(msg)==true){
      setform(e.target.getLabel().content);
    }else{
      return false;
    }
  })
  temp1.setLabel({

    content: "${item.position}", //设置文本标注内容
    direction: 'top' //设置文本标注方位
  });
  map.add(temp1);

  </c:forEach>
  function setform(name){
    window.location.href="${pageContext.request.contextPath}/appointments/get?name="+name;
  }

</script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>
