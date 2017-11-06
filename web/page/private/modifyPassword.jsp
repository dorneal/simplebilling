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
                                <h3 class="panel-title">密码修改</h3>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <form class="bs-example bs-example-form" role="form" method="post">
                                        <div class="input-group">
                                            <span class="input-group-addon icon-key icon-big-color"></span>
                                            <input id="input1" type="password" class="form-control" placeholder="原密码"
                                                   maxlength="6" name="newPassword">
                                        </div>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon icon-key icon-big-color"></span>
                                            <input id="input2" type="password" class="form-control" placeholder="要修改的密码"
                                                   maxlength="6" name="userPassword2">
                                        </div>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon icon-key icon-big-color"></span>
                                            <input id="input3" type="password" class="form-control" placeholder="再次输入"
                                                   maxlength="6">
                                        </div>
                                        <br>
                                        <button id="modifyPassword" class="btn btn-default btn-success">确定</button>
                                    </form>
                                    <script>
                                        $('button#modifyPassword').click(function () {
                                            var password = $('input#input2').val().trim();
                                            var password2 = $('input#input3').val().trim();
                                            if (password2 === password && password.length === password2.length) {
                                                var oldPassword = $('input#input1').val().trim();
                                                $.ajax({
                                                    type: "post",
                                                    url: "/simplebilling/user/ModifyPasswordServlet",
                                                    data: {
                                                        oldPassword: oldPassword,
                                                        newPassword: password
                                                    },
                                                    dateType: "text",
                                                    success: function (data) {
                                                        if (data === 'SUCCESS') {
                                                            // 跳转到退出系统servlet
                                                            window.location.href = "/simplebilling/user/UserQuitServlet";
                                                            alert("密码修改成功");
                                                        } else {
                                                            alert(data);
                                                        }
                                                    },
                                                    error: function (data) {
                                                        alert(data);
                                                    }
                                                });
                                            } else {
                                                alert("两次密码不一致");
                                            }
                                        });
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