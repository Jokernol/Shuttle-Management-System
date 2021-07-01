function login(){
  $.ajax({
    type:"post",                       					 //提交方式为POST
    url:"/User",        //设计提交数据处理的脚本文件的地址
    data:
      ({
        name: $(" input[name='username'] ").val(),
        password: $(" input[name='password'] ").val(),
      }),
    dataType: 'text',
    error:function (){
      alert("登陆异常");
    },
    success:function(result){
      if(result==="3"){
        alert("用户名不存在");
      }else if(result==="2") {
        alert("密码错误");
      }
    }
  })
};

