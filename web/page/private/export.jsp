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
    <section id="main">
        <section>
            <div class="container" style="margin-top: 50px;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            导出
                        </h3>
                    </div>
                    <div class="panel-body">
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
