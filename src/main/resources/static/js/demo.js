/*
借鉴获取值，显示在前端
function Login(){
    var username=$.trim($("#InputUsername").val());//获取用户名trim是去掉空格
    var password=$.trim($("#InputUserPwd").val());//获取密码
    if(username==""||password==""){
        layer.alert("用户名或者密码不能为空!",{
            title:"提示",
            icon:5,
        });
    }
}*/

/*
这样可以直接修改id对应属性的css样式
function LoginDisplay() {
    $("#login").css("display", "block");
    $("#bg").css("display", "block");

}*/
/*下面的方法用于提示前端什么没有填写    注册界面*/
function registerVerify() {
    var errorInformation = $("#registerError").val();
    if (errorInformation) {
        alert(errorInformation);
        return;
    }

}
function loginVerify() {
    var errorInformation = $("#loginError").val();
    if (errorInformation) {
        alert(errorInformation);
        return;
    }

}