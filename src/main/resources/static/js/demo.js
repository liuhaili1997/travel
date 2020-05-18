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
function alterError() {
    /*var errorInformation = $("#viewError").val();
    if (errorInformation) {
        alert(errorInformation);
        return;
    }*/
    var title = $("#viewTitle").val();
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

}

function hotelError() {
    var name = $("#hotelName").val();
    var address = $("#hotelAddress").val();
    var price = $("#hotelPrice").val();
    var description = $("#hotelDescription").val();
    var tag = $("#hotelTag").val();
    if (!name) {
        alert("您未添加名称，不符合规范哦！！");
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
    if (!price) {
        alert("酒店入住必须要有价格，请记得输入价格！！");
        return;
    }
    if (!tag) {
        alert("只要要选一个tag，来标注景区的特色！！");
        return;
    }

}
/*发布景点信息的ajax的写法*/
function publishView() {
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

/*展示标签和点击效果*/
/**
 * tag的实现点击就显示在输入框中
 */
function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#hotelTag").val();
    /*判断tag是否已经存在标签中了*/
    if (previous.indexOf(value) == -1) {
        //是否有原有的标签
        if (previous) {
            /*有tag，将新的添加在后面*/
            $("#hotelTag").val(previous + ',' + value);
        } else {
            /*没有tag，将其作为第一个tag*/
            $("#hotelTag").val(value)
        }
    }
}

/**
 * 点击标签框的时候就展示tag
 */
function showSelectTag() {
    $("#select-tag").show();
}

/*view---tag*/
function showViewTag() {
    $("#view-tag").show();

}

function showViewTag3() {
    $("#view-tag3").show();
}

function showViewTag4() {
    $("#view-tag4").show();

}

function showViewTag5() {
    $("#view-tag5").show();

}
function viewTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    /*判断tag是否已经存在标签中了*/
    if (previous.indexOf(value) == -1) {
        //是否有原有的标签
        if (previous) {
            /*有tag，将新的添加在后面*/
            $("#tag").val(previous + ',' + value);
        } else {
            /*没有tag，将其作为第一个tag*/
            $("#tag").val(value)
        }
    }
}

function viewTag3(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag3").val();
    /*判断tag是否已经存在标签中了*/
    if (previous.indexOf(value) == -1) {
        //是否有原有的标签
        if (previous) {
            /*有tag，将新的添加在后面*/
            $("#tag3").val(previous + ',' + value);
        } else {
            /*没有tag，将其作为第一个tag*/
            $("#tag3").val(value)
        }
    }
}
function viewTag4(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag4").val();
    /*判断tag是否已经存在标签中了*/
    if (previous.indexOf(value) == -1) {
        //是否有原有的标签
        if (previous) {
            /*有tag，将新的添加在后面*/
            $("#tag4").val(previous + ',' + value);
        } else {
            /*没有tag，将其作为第一个tag*/
            $("#tag4").val(value)
        }
    }
}
function viewTag5(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag5").val();
    /*判断tag是否已经存在标签中了*/
    if (previous.indexOf(value) == -1) {
        //是否有原有的标签
        if (previous) {
            /*有tag，将新的添加在后面*/
            $("#tag5").val(previous + ',' + value);
        } else {
            /*没有tag，将其作为第一个tag*/
            $("#tag5").val(value)
        }
    }
}

function post() {
    $.ajax({
        success: function (response) {
            if (response.code == 200) {
                /*$("#comment_section").hide()*/
                window.location.reload();
            } else {
                if (response.code == 3001) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("http://localhost:9999/login")
                        window.localStorage.setItem("closeable", true);
                    }
                } else {
                    alert(response.message)
                }
            }
            console.log(response)
        },
        dataType: "json",
        contentType: 'application/json'
    });
}