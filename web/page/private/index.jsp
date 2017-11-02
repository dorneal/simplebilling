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
                                            <%--<th>ID</th>--%>
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
                                                <td style="display: none;">${account.recordId}</td>
                                                <td>${account.recordName}</td>
                                                <td>${account.recordType}</td>
                                                <td>${account.recordMode}</td>
                                                <td>${account.money}</td>
                                                <td>${account.recordDate}</td>
                                                <td>${account.recordRemark}</td>
                                                <td>
                                                    <a href="javascript:if(confirm('确实要删除吗?'))location='${pageContext.request.contextPath}/account/DeleteAccountServlet?recordId=${account.recordId}'">删除</a>
                                                    <a href="${pageContext.request.contextPath}/account/ToUpdatePageServlet?recordId=${account.recordId}">修改</a>
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
                                <ul class="pagination" style="margin: 0 auto;">
                                    <c:if test="${requestScope.pageBean.currPage==1}">
                                        <li class="disabled"><a href="#">&laquo;</a></li>
                                    </c:if>
                                    <c:if test="${requestScope.pageBean.currPage!=1}">
                                        <li><a href="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${requestScope.pageBean.currPage-1}&pageSize=${requestScope.pageBean.pageSize}">&laquo;</a></li>
                                    </c:if>
                                    <li class="active"><a name="currentPage" href="#">${requestScope.pageBean.currPage}</a></li>
                                    <c:if test="${requestScope.pageBean.currPage>requestScope.pageBean.totalPage}">
                                        <li class="disabled"><a href="#">&raquo;</a></li>
                                    </c:if>
                                    <c:if test="${requestScope.pageBean.currPage<=requestScope.pageBean.totalPage}">
                                        <li><a href="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${requestScope.pageBean.currPage+1}&pageSize=${requestScope.pageBean.pageSize}">&raquo;</a></li>
                                    </c:if>
                                    <li>
                                        &nbsp;&nbsp;页数
                                        <select class="form-control" style="width: 65px;display: inline" onchange="location.href=this.value;">
                                            <option style="display: none;">1</option>
                                            <c:forEach var="lba" begin="1" end="${requestScope.pageBean.totalPage+1}" step="1">
                                                <option value="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${lba}&pageSize=${requestScope.pageBean.pageSize}">${lba}</option>
                                            </c:forEach>
                                        </select>
                                    </li>
                                    <li>
                                        &nbsp;&nbsp;页面大小
                                        <select class="form-control" style="width: 65px;display: inline" name="pageSize" onchange="location.href=this.value;">
                                            <option style="display: none;">10</option>
                                            <option value="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${requestScope.pageBean.currPage}&pageSize=10">10</option>
                                            <option value="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${requestScope.pageBean.currPage}&pageSize=20">20</option>
                                            <option value="${pageContext.request.contextPath}/account/ShowAccountServlet?currentPage=${requestScope.pageBean.currPage}&pageSize=30">30</option>
                                        </select>
                                    </li>
                                </ul>
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