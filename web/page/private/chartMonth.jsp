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
                                    本 月(条形图分析)
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div id="eca1" style="margin:0 auto;"></div>
                                <script src="/simplebilling/js/macarons.js"></script>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    本 月(饼图分析)
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div id="eca2" style="margin:0 auto;"></div>
                                <script>
                                    var myBarChart = document.getElementById('eca1');
                                    var myRadiusChar = document.getElementById('eca2');
                                    var resizeMyBarChartContainer = function () {
                                        if (window.innerWidth < 800) {
                                            myBarChart.style.width = window.innerWidth * .8 + 'px';
                                            myBarChart.style.height = window.innerHeight / 2 + 'px';
                                        } else {
                                            myBarChart.style.width = window.innerWidth / 2 + 'px';
                                            myBarChart.style.height = window.innerHeight / 2 + 'px';
                                        }
                                    };
                                    var resizeMyRadiusChar = function () {
                                        if (window.innerWidth < 800) {
                                            myRadiusChar.style.width = window.innerWidth * .8 + 'px';
                                            myRadiusChar.style.height = window.innerHeight / 2 + 'px';
                                        } else {
                                            myRadiusChar.style.width = window.innerWidth / 2 + 'px';
                                            myRadiusChar.style.height = window.innerHeight / 2 + 'px';
                                        }
                                    };
                                    resizeMyBarChartContainer();
                                    resizeMyRadiusChar();
                                    // 第二个参数可以指定前面引入的主题
                                    var chart = echarts.init(myBarChart, 'macarons');
                                    var myChart = echarts.init(myRadiusChar, 'macarons');
                                    // 设置加载动画
                                    chart.showLoading();
                                    myChart.showLoading();
                                    // 初始 option
                                    chart.setOption({
                                        title: {
                                            text: '本月消费情况'
                                        },
                                        tooltip: {},
                                        legend: {
                                            data: ['支出']
                                        },
                                        xAxis: {
                                            data: []
                                        },
                                        yAxis: {
                                            type: 'value'
                                        },
                                        series: [{
                                            name: '支出',
                                            type: 'bar',
                                            data: []
                                        }]
                                    });
                                    // 指定图表的配置项和数据
                                    myChart.setOption({
                                        title: {
                                            text: '本月收入情况'
                                        },
                                        center: ['50%', '50%'],
                                        series: [
                                            {
                                                name: '访问来源',
                                                type: 'pie',
                                                radius: '55%',
                                                data: []
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
                                    // 异步加载、装填数据
                                    $.ajax({
                                        async: false,
                                        type: 'post',
                                        url: '/simplebilling/account/MonthAccountServlet',
                                        dataType: 'json',
                                        success: function (data) {
                                            var nameArray = [], moneyArray = [];
                                            var nameIncomeArray = [], moneyIncomeArray = [];
                                            for (var i = 0; i < data.length; i++) {
                                                if (data[i].recordName === "支出") {
                                                    nameArray.push(data[i].recordType);
                                                    moneyArray.push(data[i].money);
                                                } else {
                                                    nameIncomeArray.push(data[i].recordType);
                                                    moneyIncomeArray.push(data[i].money);
                                                }
                                            }
                                            chart.hideLoading();
                                            chart.setOption({
                                                xAxis: [{
                                                    data: nameArray
                                                }],
                                                series: [{
                                                    name: '支出',
                                                    type: 'bar',
                                                    data: moneyArray
                                                }]
                                            });
                                            myChart.hideLoading();
                                            myChart.setOption({
                                                series: [
                                                    {
                                                        name: '访问来源',
                                                        type: 'pie',
                                                        radius: '55%',
                                                        data: [{name:nameIncomeArray[0],value:moneyIncomeArray[0]},
                                                            {name:nameIncomeArray[1],value:moneyIncomeArray[1]},

                                                            {name:nameIncomeArray[3],value:moneyIncomeArray[3]}]
                                                    }
                                                ]
                                            })
                                        },
                                        error: function () {
                                            console.log('error');
                                        }
                                    });
                                    $(window).resize(function () {
                                        resizeMyBarChartContainer();
                                        chart.resize();
                                    });
                                    $(window).resize(function () {
                                        resizeMyRadiusChar();
                                        myChart.resize();
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