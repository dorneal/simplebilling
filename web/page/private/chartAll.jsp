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
    <script src="/simplebilling/js/echarts.min.js"></script>
    <script src="/simplebilling/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/simplebilling/js/date.js"></script>
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
                                    所 有(条形图分析)
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div id="eca1" style="margin:0 auto;"></div>
                                <script src="/simplebilling/js/macarons.js"></script>
                                <script>
                                    var myBarChart = document.getElementById('eca1');
                                    var resizeMyBarChartContainer = function () {
                                        if (window.innerWidth < 800) {
                                            myBarChart.style.width = window.innerWidth * .8 + 'px';
                                            myBarChart.style.height = window.innerHeight / 2 + 'px';
                                        } else {
                                            myBarChart.style.width = window.innerWidth / 2 + 'px';
                                            myBarChart.style.height = window.innerHeight / 2 + 'px';
                                        }
                                    };
                                    resizeMyBarChartContainer();
                                    // 第二个参数可以指定前面引入的主题
                                    var chart = echarts.init(myBarChart, 'macarons');
                                    // 指定图表的配置项和数据
                                    var option = {
                                        title: {
                                            text: 'ECharts 入门示例',
                                            x:'center'
                                        },
                                        tooltip: {
                                            trigger:'item'
                                        },
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
                                        resizeMyBarChartContainer();
                                        chart.resize();
                                    });
                                </script>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    本 周(饼图分析)
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div id="eca2" style="margin:0 auto;"></div>
                                <script>
                                    var myRadiusChar = document.getElementById('eca2');
                                    var resizeMyRadiusChar = function () {
                                        if (window.innerWidth < 800) {
                                            myRadiusChar.style.width = window.innerWidth * .8 + 'px';
                                            myRadiusChar.style.height = window.innerHeight / 2 + 'px';
                                        } else {
                                            myRadiusChar.style.width = window.innerWidth / 2 + 'px';
                                            myRadiusChar.style.height = window.innerHeight / 2 + 'px';
                                        }
                                    };
                                    resizeMyRadiusChar();
                                    var chart = echarts.init(myRadiusChar);
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
                                        resizeMyRadiusChar();
                                        chart.resize();
                                    });
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>