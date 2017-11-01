<%@ page contentType="text/html;charset=UTF-8" %>
<!--主导航-->
<header style="z-index: 1001">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Simple <span class="icon-coin-yen"></span> Billing
                    <span class="icon-menu4"></span></a>
            </div>
            <div class="collapse navbar-collapse navbar-right" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">${sessionScope.user.userName}</a></li>
                    <li><a href="#">上传</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            More <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/simplebilling/page/public/index.html">主页</a></li>
                            <li><a href="#">我的信息</a></li>
                            <li class="divider"></li>
                            <li><a href="#">上传备份</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/user/UserQuitServlet">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!--侧导航-->
    <aside>
        <section>
            <div class="content-menu-project">
                <ul>
                    <li class="first-class-menu">
                        <ol>
                            <li><a href="${pageContext.request.contextPath}/page/private/record.jsp"><h2><span
                                    class="icon-calculator"></span> 记账</h2></a></li>
                            <li class="second-class-menu"><h2><span class="icon-plus"></span> <span
                                    class="icon-equalizer"></span> 查询</h2>
                                <ol>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/chartWeek.jsp.jsp">
                                        <h3>本周</h3>
                                    </a></li>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/chartMonth.jsp"><h3>
                                        本月</h3></a></li>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/chartAll.jsp"><h3>
                                        所有</h3></a></li>
                                </ol>
                            </li>
                            <li class="second-class-menu"><h2><span class="icon-plus"></span> <span
                                    class="icon-stats-dots"></span> 修改</h2>
                                <ol>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/"><h3>编辑信息</h3></a>
                                    </li>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/"><h3>修改账目</h3></a>
                                    </li>
                                </ol>
                            </li>
                            <li><a href=""><h2 href="${pageContext.request.contextPath}/page/private/"><span
                                    class="icon-bubbles4"></span> 导出</h2></a></li>
                            <li class="second-class-menu"><h2><span class="icon-plus"></span> <span
                                    class="icon-question"></span> 帮助</h2>
                                <ol>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/"><h3>关于记账</h3></a>
                                    </li>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/"><h3>关于修改</h3></a>
                                    </li>
                                    <li class="third-class-menu"><a
                                            href="${pageContext.request.contextPath}/page/private/"><h3>关于导出</h3></a>
                                    </li>
                                </ol>
                            </li>
                        </ol>
                    </li>
                </ul>
            </div>
        </section>
    </aside>
</header>
<script>
    function dynamicMenu(obj) {
        var firstmenu = $("." + obj + " .first-class-menu>h1");
        var secondmenu = $("." + obj + " .second-class-menu>h2");
        if (secondmenu) {
            secondmenu.next("ol").hide();
        }
        firstmenu.on("click", function () {
            firstmenu.next("ol").slideToggle();
        });
        secondmenu.on('click', function () {
            var sf = $(this).find("span:first");
            if (sf.hasClass("icon-plus")) {
                sf.removeClass("icon-plus").addClass("icon-minus");
            } else {
                sf.removeClass("icon-minus").addClass("icon-plus");
            }
            $(this).next("ol").slideToggle().parent("li").siblings('li').children("ol").slideUp();
        });
    }

    dynamicMenu("content-menu-project");
    var ttit = $('a.navbar-brand');
    ttit.on("click", function () {
        var titleSpan = $('a.navbar-brand span:last');
        $('div.content-menu-project').slideToggle(function () {
            if (titleSpan.hasClass("icon-menu4")) {
                titleSpan.removeClass("icon-menu4").addClass("icon-menu3");
            } else {
                titleSpan.removeClass("icon-menu3").addClass("icon-menu4");
            }
        });
    });
</script>
