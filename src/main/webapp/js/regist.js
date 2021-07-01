function regist(){
  $.ajax({
    type:"put",                       					 //提交方式为POST
    url:"/User",        //设计提交数据处理的脚本文件的地址
    data:
      ({
        username: $(" input[name='username'] ").val(),
        password: $(" input[name='password'] ").val(),
        identity: $(" input[name='identity'] ").val(),
        telephone:$(" input[name='telephone'] ").val(),
      }),
    dataType: 'text',
    error:function (){
      alert("注册异常");
    },
    success:function(result){
      if(result==="1"){
        alert("用户名已存在");
      }
    }
  })
};
