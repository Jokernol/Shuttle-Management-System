<%--
  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/7/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%><!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      height: 80%;
      margin: 0px;
      padding: 0px
    }

    #container {width:100%; height: 90%; }

  </style>
  <script src="https://webapi.amap.com/maps?v=2.0&key=86b89ad4e1f9cdd0d722816d4d3ce8ca" type="text/javascript"></script>
</head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<body>
<div id="container"></div>
<script src="https://webapi.amap.com/loader.js"></script>
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
  });

  var clickHandler = function(e) {
    map.clearMap();
   var    marker = new AMap.Marker({
    position: new AMap.LngLat(e.lnglat.getLng(), e.lnglat.getLat())});

    map.add(marker);
    document.getElementById("lngX").value = e.lnglat.getLng();
    document.getElementById("latY").value = e.lnglat.getLat();
    return e.lnglat.getLng(), e.lnglat.getLat();

  };

  map.on('click', clickHandler);

  function isNull(){
    var  x =  document.getElementById("lngX").value;
    var  y =  document.getElementById("latY").value;
    if (x===""||y===""){
      alert("请选择地点");
      return false;
    }
    return  true;
  }
</script>
<form action="${pageContext.request.contextPath}/station.do" method="post">
  车站名:
  <input name="position" >
  <input type="text" id="lngX" name="lngX" value=""  hidden/>
  <input type="text" id="latY" name="latY" value=""  hidden/>
  <input onclick="return isNull()" value="提交" type="submit" >
</form>
</body>
</html>
