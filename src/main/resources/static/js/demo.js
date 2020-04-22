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
/*发布景点信息的ajax的写法*/
function publishView() {
    var title = $("#title").val();
    var openTime = $("#openTime").val();
    var address = $("#address").val();
    var price = $("#price").val();
    var description = $("#description").val();
    var tag = $("#tag").val();
    if (!title) {
        alert("您未添加景区名称，不符合规范哦！！");
        return;
    }
    if (!openTime) {
        alert("您未添加营业时间，不符合规范哦！！");
        return;
    }
    if (!address) {
        alert("请添加详细地址，方便游客导航！！");
        return;
    }
    if (!description) {
        alert("您未添加描述信息，不符合规范哦！！");
        return;
    }
    if (!tag) {
        alert("只要要选一个tag，来标注景区的特色！！");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/publish/landscape",
        data: JSON.stringify({
            "title": title,
            "openTime": openTime,
            "address": address,
            "price": price,
            "description": description,
            "tag": tag
        }),
        dataType: "json",
        contentType: 'application/json'
    });

}