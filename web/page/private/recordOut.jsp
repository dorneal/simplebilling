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
                                <!--支出面板-->
                                <form action="${pageContext.request.contextPath}/account/InsertAccountServlet"
                                      method="post">
                                    <div class="tab-pane active" id="panel-344031">
                                        <input type="hidden" value="支出" name="recordName">
                                        <div class="input-group input-group-lg">
                                            <span class="icon-calculator input-group-addon"></span>
                                            <input id="cl" type="text" class="form-control" dir="ltr"
                                                   placeholder="请输入" name="money">
                                        </div>
                                        <!--计算器面板-->
                                        <div id="calculator">
                                            <table class="table-Calculator" border="1" cellspacing="0">
                                                <tr>
                                                    <td>C</td>
                                                    <td>→</td>
                                                    <td>%</td>
                                                    <td>&divide;</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>2</td>
                                                    <td>3</td>
                                                    <td>&times;</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>5</td>
                                                    <td>6</td>
                                                    <td>-</td>
                                                </tr>
                                                <tr>
                                                    <td>7</td>
                                                    <td>8</td>
                                                    <td>9</td>
                                                    <td>+</td>
                                                </tr>
                                                <tr>
                                                    <td>0</td>
                                                    <td>.</td>
                                                    <td colspan="2">=</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <script>
                                            $(function () {
                                                $('div#calculator').hide();
                                                var cl = document.getElementById("cl");
                                                $('table.table-Calculator td').click(function () {
                                                    var values = $(this).html();
                                                    if (values !== "=") {
                                                        if (values === '÷') {
                                                            values = '/';
                                                        }
                                                        if (values === '×') {
                                                            values = '*';
                                                        }
                                                        cl.value += values;
                                                    } else {
                                                        cl.value = eval(cl.value);
                                                    }
                                                    if (values === "C") {
                                                        cl.value = "";
                                                    }
                                                    if (values === "\u2192") {
                                                        cl.value = cl.value.substring(0, cl.value.length - 2);
                                                    }
                                                });
                                                $('input#cl').click(function () {
                                                    $('div#calculator').toggle();
                                                });
                                            });
                                        </script>
                                        <div class="input-group input-group-lg">
                                            <span class="icon-tree input-group-addon"></span>
                                            <select class="form-control select-spend-category" name="recordType">
                                                <option value="食品酒水">食品酒水</option>
                                                <option value="行车交通">行车交通</option>
                                                <option value="人情往来">人情往来</option>
                                                <option value="衣服饰品">衣服饰品</option>
                                                <option value="交流通讯">交流通讯</option>
                                                <option value="医疗保健">医疗保健</option>
                                                <option value="居家物业">居家物业</option>
                                                <option value="休闲娱乐">休闲娱乐</option>
                                                <option value="金融保险">金融保险</option>
                                                <option value="其他杂项">其他杂项</option>
                                            </select>
                                        </div>
                                        <div class="input-group input-group-lg">
                                            <span class="icon-coin-yen input-group-addon"></span>
                                            <select class="form-control select-money-category" name="recordMode">
                                                <option value="现金">现金</option>
                                                <option value="支付宝">支付宝</option>
                                                <option value="微信">微信</option>
                                                <option value="刷卡">刷卡</option>
                                                <option value="支票">支票</option>
                                            </select>
                                        </div>
                                        <div class="input-group input-group-lg">
                                            <span class="icon-clock input-group-addon"></span>
                                            <input id="endTime" type="text" class="kbtn form-control" name="recordDate">
                                        </div>
                                        <div class="form-group form-group-lg">
                                            <label>
                                                <h2><span class="icon-quill"></span>备注</h2>
                                                <textarea name="recordRemark" class="form-control" rows="5" cols="50"
                                                          style="resize:none;" placeholder="备注"></textarea>
                                            </label>
                                        </div>
                                        <input type="submit" value="提交" class="btn btn-default">
                                    </div>
                                </form>
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