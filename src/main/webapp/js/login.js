$(function(){
  //给登录按钮添加点击事件
  $("#login").on('click',function(event){
    $.ajax({
      type:"post",                       					 //提交方式为POST
      url:"/User/login",        //设计提交数据处理的脚本文件的地址
      data: JSON.stringify
      ({
        username: $(" input[name='username'] ").val(),
        password: $(" input[name='password'] ").val(),
      }),
      dataType:'json',                   					 //设置提交数据的类型为json
      contentType:'application/json',
      // contentType: "application/json; charset=utf-8",
      success:function(data){          					 //只有返回的标志为1，才进行处理
        if(data.code==200){             					 //只有返回值为1，才允许跳转到后台
          alert(data.msg);                               //先弹出提示框，提醒用户成功登陆
          localStorage.clear()
          localStorage.token = data.data;
          window.location.href="/admin/index/index";
        }else {                          					 //输出错误信息
          alert(data.msg);
        }
      }
    });
  })
})
