<%--
  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/7/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%><!DOCTYPE html>

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

    #container {
      height: 100%
    }
  </style>
  <script type="text/javascript" src="https://api.map.baidu.com/api?v=1.0&type=webgl&ak=D0IqPzMbg8BTi8hNNhhhydRZkCa21Hri">
  </script></head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<body>
<div id="container"></div>
<script type="text/javascript">
  var map = new BMapGL.Map("container");
  // 创建地图实例
  var point = new BMapGL.Point(116.404, 39.915);
  // 创建点坐标
  map.centerAndZoom(point, 15);
  // 初始化地图，设置中心点坐标和地图级别
</script>

</body>
</html>
