<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="/simplebilling/css/load.css">
    <script src="/simplebilling/js/jquery-3.2.1.js"></script>
    <script src="/simplebilling/js/bootstrap.min.js"></script>
    <script src="/simplebilling/js/echarts.min.js"></script>
</head>
<body>
<jsp:include page="loading.jsp"/>
<!--主显示界面-->
<section>
    <jsp:include page="head.jsp"/>
    <section id="main">
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default" style="margin-bottom: 20px;margin-top: 20px;">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    所有记录
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>记录名</th>
                                            <th>记录类型</th>
                                            <th>记录方式</th>
                                            <th>金额</th>
                                            <th>时间</th>
                                            <th>备注</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.pageBean.lists}" var="account">
                                            <tr>
                                                <td>${account.recordId}</td>
                                                <td>${account.recordName}</td>
                                                <td>${account.recordType}</td>
                                                <td>${account.recordMode}</td>
                                                <td>${account.money}</td>
                                                <td>${account.recordDate}</td>
                                                <td>${account.recordRemark}</td>
                                                <td>
                                                    <a href="">删除</a>
                                                    <a href="">修改</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <script>
                                            $('table.table tbody').find("tr").each(function () {
                                                var tdArrays = $(this).children();
                                                if (tdArrays.eq(1).text() === "收入") {
                                                    $(this).addClass('success');
                                                } else {
                                                    $(this).addClass('danger');
                                                }
                                            });
                                        </script>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<!--尾部-->
<jsp:include page="footer.jsp"/>
</body>
</html>