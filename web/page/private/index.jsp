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
    <!--主要显示框架-->
    <section id="main">
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-6">
                        <div id="eca1" style="padding: 10px;border: 1px solid #ccc;"></div>
                        <script src="/simplebilling/js/macarons.js"></script>
                        <script>
                            var width = $(window).width();
                            var height = $(window).height();
                            if (width < 800) {
                                $('#eca1').css("width", width - 35);
                                $('#eca1').css("height", height / 2);
                                $('#eca1').css("margin-bottom", "10px");
                            } else {
                                $('#eca1').css("width", width / 3 - 40);
                                $('#eca1').css("height", height / 2);
                            }
                            // 第二个参数可以指定前面引入的主题
                            var chart = echarts.init(document.getElementById('eca1'), 'macarons');
                            // 指定图表的配置项和数据
                            var option = {
                                title: {
                                    text: 'ECharts 入门示例'
                                },
                                tooltip: {},
                                legend: {
                                    orient: 'vertical',
                                    x: 'right',
                                    data: ['销量']
                                },
                                xAxis: {
                                    data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
                                },
                                yAxis: {},
                                series: [{
                                    name: '销量',
                                    type: 'bar',
                                    data: [5, 20, 36, 10, 10, 20]
                                }]
                            };
                            chart.setOption(option);
                            $(window).resize(function () {
                                chart.resize();
                            });
                        </script>
                    </div>
                    <div class="col-sm-6 col-md-6">
                        <div id="eca2" style="padding: 10px;border: 1px solid #ccc;"></div>
                        <script>
                            var width = $(window).width();
                            var height = $(window).height();
                            if (width < 800) {
                                $('#eca2').css("width", width - 35);
                                $('#eca2').css("height", height / 2);
                            } else {
                                $('#eca2').css("width", width / 3 - 50);
                                $('#eca2').css("height", height / 2);
                            }
                            var chart = echarts.init(document.getElementById('eca2'));
                            // 指定图表的配置项和数据
                            chart.setOption({
                                center: ['50%', '50%'],
                                series: [
                                    {
                                        name: '访问来源',
                                        type: 'pie',
                                        radius: '55%',
                                        data: [
                                            {value: 235, name: '视频广告'},
                                            {value: 274, name: '联盟广告'},
                                            {value: 310, name: '邮件营销'},
                                            {value: 335, name: '直接访问'},
                                            {value: 400, name: '搜索引擎'}
                                        ]
                                    }
                                ],
                                roseType: 'angle',
                                itemStyle: {
                                    normal: {
                                        // 阴影的大小
                                        shadowBlur: 100,
                                        // 阴影水平方向上的偏移
                                        shadowOffsetX: 0,
                                        // 阴影垂直方向上的偏移
                                        shadowOffsetY: 0,
                                        // 阴影颜色
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            });
                            $(window).resize(function () {
                                chart.resize();
                            });
                        </script>
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