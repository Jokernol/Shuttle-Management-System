<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="input-card" style="width:18rem">
  <h4>DOM事件的绑定与解绑</h4>
  <div>
    <div class="input-item">
      <button id="bt1" class="btn" style="margin-right:1rem;">标记地点</button>
      <button id="bt2" class="btn">取消标记</button>
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


  var temp = new AMap.Marker({
    position: new AMap.LngLat(111,20), // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
  })
  map.add(temp);
  var markers = [];
      <c:forEach items="${applicationScope.stationList}" var = "item" varStatus="station" >
    alert(${item.x})
    var temp1 = new AMap.Marker({
    position: new AMap.LngLat('${item.x}','${item.y}'), // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
    title: '${item.position}',
    map: map,
    clickable: true
  })
  map.add(temp1);
  temp1.setLabel({

    content: "${item.position}", //设置文本标注内容
    direction: 'top' //设置文本标注方位
  });
      </c:forEach>

  // var infoWindow = new AMap.InfoWindow({ //创建信息窗体
  //   isCustom: true,  //使用自定义窗体
  //   content:'<div>信息窗体</div>', //信息窗体的内容可以是任意html片段
  //   offset: new AMap.Pixel(16, -45)
  // });
  // var onMarkerClick  =  function(e) {
  //   infoWindow.open(map, e.target.getPosition());//打开信息窗体
  //   //e.target就是被点击的Marker
  // }
  // var marker = new AMap.Marker({
  //   position: [116.481181, 39.989792]
  // })
  // map.add(marker);
  // marker.on('click',onMarkerClick);//绑定click事件


  // var map = new BMap.Map("container");  // 创建地图实例
  // var point = new BMap.Point(120.032, 30.225);
  // // 创建点坐标

  // map.enableScrollWheelZoom(true);
  // // 初始化地图，设置中心点坐标和地图级别
  // var marker = new BMapGL.Marker(point);        // 创建标注
  // map.centerAndZoom(point, 18);
  // map.addOverlay(marker);
  //
  //
  // marker.addEventListener("click", function(){
  //   alert("您点击了标注");
  //
  // });
  //
  // // marker.addEventListener('rightclick',function (){
  // // alert("水水水水");
  // // });
  //
  // //获得坐标点
  // map.addEventListener('click', function(e) {
  //   alert('点击的经纬度：' + e.latlng.lng + ', ' + e.latlng.lat);
  // });
  //
  // map.addEventListener('')
  //
  //
  // var txtMenuItem = [
  //   {
  //     text:'放大',                             // 定义菜单项的显示文本
  //     callback: function () {                 // 定义菜单项点击触发的回调函数
  //       map.zoomIn();
  //     }
  //   },
  //   {
  //     text:'缩小',
  //     callback: function () {
  //       map.zoomOut();
  //     }
  //   }
  // ];
  // for(var i = 0; i < txtMenuItem.length; i++){
  //   menu.addItem(new BMapGL.MenuItem(               // 定义菜单项实例
  //     txtMenuItem[i].text,                        // 传入菜单项的显示文本
  //     txtMenuItem[i].callback,                    // 传入菜单项的回调函数
  //     {
  //       width: 300,                             // 指定菜单项的宽度
  //       id: 'menu' + i                          // 指定菜单项dom的id
  //     }
  //   ));
  //
  // }
  // map.addContextMenu(menu);

</script>
<form action="${pageContext.request.contextPath}/station.do" method="get">
  <input type="submit" value="提交">
</form>
</body>
</html>
