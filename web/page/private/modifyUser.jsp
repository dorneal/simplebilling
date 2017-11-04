<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的账本</title>
    <link rel="shortcut icon" href="/simplebilling/img/icon/webIcon.ico">
    <link rel="stylesheet" href="/simplebilling/css/bootstrap.css">
    <link rel="stylesheet" href="/simplebilling/css/style.css">
    <link rel="stylesheet" href="/simplebilling/css/private.css">
    <link rel="stylesheet" href="/simplebilling/css/date.css">
    <link rel="stylesheet" href="/simplebilling/css/load.css">
    <script src="/simplebilling/js/jquery-3.2.1.js"></script>
    <script src="/simplebilling/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/simplebilling/js/date.js"></script>
    <!--日期选择控件-->
    <script type="text/javascript">
        $(function () {
            $('#endTime').date({theme: "datetime"});
        });
    </script>
</head>
<body>
<!--预加载动画-->
<div class="animation">
    <div class='loader loader4'>
        <div>
            <div>
                <div>
                    <div>
                        <div>
                            <div>
                                <div>
                                    <div>
                                        <div>
                                            <div></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    document.onreadystatechange = subSomething;//当页面加载状态改变的时候执行这个方法.
    function subSomething() {
        if (document.readyState === "Loaded") //当页面加载状态
        {
            $('div.animation').show();
            $('section').hide();
        } else {
            $('section').show();
            $('div.animation').hide();
        }
    }
</script>

<!--主显示界面-->
<section>
    <jsp:include page="head.jsp"/>

    <!--主要显示框架-->
    <section id="main">
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default" style="margin-bottom: 20px;margin-top: 20px;">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    记账
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <form class="bs-example bs-example-form" role="form"
                                          action="/simplebilling/user/UserModifyServlet">
                                        <input type="hidden" value="${sessionScope.user.userId}" name="userId">
                                        <div class="input-group">
                                            <span class="input-group-addon icon-user icon-big-color"></span>
                                            <input id="input1" type="text" class="form-control" placeholder="用户名"
                                                   maxlength="10" value="${sessionScope.user.userName}" name="userName">
                                        </div>
                                        <span class="input1"></span>
                                        <br>
                                        <div class="input-group">
                                            <span class="icon-users input-group-addon icon-big-color"></span>
                                            <select id="input2" class="form-control" name="userSex">
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon icon-mobile icon-big-color"></span>
                                            <input id="input3" type="tel" class="form-control" maxlength="11"
                                                   name="userPhonenum"
                                                   minlength="11" placeholder="手机号码"
                                                   value="${sessionScope.user.userPhonenum}">
                                        </div>
                                        <span class="input2"></span>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon icon-mail icon-big-color"></span>
                                            <input id="input4" type="email" class="form-control" maxlength="50"
                                                   name="userEmail"
                                                   placeholder="Email" value="${sessionScope.user.userEmail}">
                                        </div>
                                        <span class="input3"></span>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon icon-clock2 icon-big-color"></span>
                                            <input id="input5" type="text" disabled class="form-control"
                                                   name="registerDate"
                                                   value="${sessionScope.user.registerDate}">
                                        </div>
                                        <br>
                                        <div class="input-group" style="text-align: center;">
                                            <label>
                                <textarea id="input7" class="form-control" rows="3" cols="50" name="userSignature"
                                          style="resize:none;"
                                          placeholder="个性签名">${sessionScope.user.userSignature}</textarea>
                                            </label>
                                        </div>
                                        <br>
                                        <a id="updateUser" href="#"
                                           class="btn btn-default btn-success">确定</a>
                                    </form>
                                    <!--简单表单验证-->
                                    <script>
                                        // 正则验证
                                        var nameReg = /^[a-zA-Z0-9_]+$/;
                                        var phoneReg = /^1[3|4|5|8][0-9]\d{4,8}$/;
                                        var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                                        var flag1 = false, flag2 = false, flag3 = false;
                                        //验证
                                        $(document).ready(
                                            function myProcess() {
                                                $('input#input1').blur(function () {
                                                    var userName = $('input#input1').val().trim();
                                                    if (!nameReg.test(userName)) {
                                                        $('span.input1').html("请输入字母跟数字").css("color", "red");
                                                    } else {
                                                        flag1 = true;
                                                        $('span.input1').empty();
                                                        $('div.input-group:eq(0)').addClass("has-success");
                                                    }
                                                });
                                                $('input#input3').blur(function () {
                                                    var userPhoneNum = $('input#input3').val().trim();
                                                    if (!phoneReg.test(userPhoneNum)) {
                                                        $('span.input2').html("请输入正确的手机号码").css("color", "red");
                                                    } else {
                                                        flag2 = true;
                                                        $('span.input2').empty();
                                                        $('div.input-group:eq(2)').addClass("has-success");
                                                    }
                                                });
                                                $('input#input4').blur(function () {
                                                    var userEmail = $('input#input4').val().trim();
                                                    if (!emailReg.test(userEmail)) {
                                                        $('span.input3').html("请输入正确的邮箱").css("color", "red");
                                                    } else {
                                                        flag3 = true;
                                                        $('span.input3').empty();
                                                        $('div.input-group:eq(3)').addClass("has-success");
                                                    }
                                                });
                                            },
                                            $('a#updateUser').click(function () {
                                                if (flag1 && flag2 && flag3) {
                                                    var userModifyJson = {
                                                        "userId": $('input:hidden').val().trim(),
                                                        "userName": $('input#input1').val().trim(),
                                                        "userSex": $('select#input2  option:selected').text(),
                                                        "userPhonenum": $('input#input3').val().trim(),
                                                        "userSignature": $('textarea#input7').val().trim(),
                                                        "userEmail": $('input#input4').val().trim()
                                                    };
                                                    $.ajax({
                                                        url: "/simplebilling/user/UserModifyServlet",
                                                        type: "post",
                                                        data: {"userModifyJson": JSON.stringify(userModifyJson)},
                                                        dataType: "text",
                                                        success: function (data) {
                                                            if (data === "existEmail") {
                                                                $('div.input-group:eq(3)').addClass("has-error");
                                                                $('span.input3').html("该邮箱已被注册！！！").css("color", "red");
                                                            }
                                                            if (data === "existUserName") {
                                                                $('div.input-group:eq(0)').addClass("has-error");
                                                                $('span.input1').html("该用户名已存在！！！").css("color", "red");
                                                            }
                                                            if (data === "existPhoneNum") {
                                                                $('div.input-group:eq(2)').addClass("has-error");
                                                                $('span.input2').html("该手机号码已被注册").css("color", "red");
                                                            }
                                                            if (data === "SUCCESS") {
                                                                window.location.href = "/simplebilling/page/public/index.html";
                                                            }
                                                        }
                                                    })
                                                } else {
                                                    alert("请正确填写");
                                                }
                                            })
                                        );
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>

<div id="datePlugin"></div>

<jsp:include page="footer.jsp"/>
</body>
</html>