function login(){
  var formdata = new FormData();
  var username=document.getElementById("username");
  var password=document.getElementById("password");
  formdata.append("username","password");
  formdata.set("username",username)
  formdata.set("password",password)
  var xhr=new XMLHttpRequest();
  xhr.open("post","sessions/post");
  xhr.send(formdata);
  xhr.onload=function () {
    var result="${info}";
    if (result!=null){
      alert(result);
    }
  }
};
function regist(){
  window.location.href="regist.jsp";
};
