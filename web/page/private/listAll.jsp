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
<jsp:include page="loading.jsp"/>
<!--主显示界面-->
<section>
    <!--主导航-->
    <jsp:include page="head.jsp"/>
    <section id="main">
        <section>
            <div class="container" style="margin-top: 50px;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            本周
                        </h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-condensed">
                            <thead>
                            <tr>
                                <th>类型</th>
                                <th>金额</th>
                                <th>日期</th>
                                <th>点击数</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>