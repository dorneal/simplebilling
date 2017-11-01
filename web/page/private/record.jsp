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
            $('#endTime2').date({theme: "datetime"});
        });
    </script>
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
                    <div class="col-md-12">
                        <div class="panel panel-default" style="margin-bottom: 20px;margin-top: 20px;">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    记账
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="tabbable" id="tabs-252826">
                                    <ul class="nav nav-tabs">
                                        <li class="active">
                                            <a href="#panel-344031" data-toggle="tab" contenteditable="false"
                                               style="color: #0f0f0f;">支出</a>
                                        </li>
                                        <li>
                                            <a href="#panel-731068" data-toggle="tab" contenteditable="false"
                                               style="color: #0f0f0f;">收入</a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <!--支出面板-->
                                        <div class="tab-pane active" id="panel-344031">
                                            <input type="hidden" value="1">
                                            <div class="input-group input-group-lg">
                                                <span class="icon-calculator input-group-addon"></span>
                                                <input id="cl" type="text" class="form-control" dir="ltr"
                                                       placeholder="请输入">
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
                                                <select class="form-control select-spend-category">
                                                    <option value="1">食物酒水</option>
                                                    <option value="2">行车交通</option>
                                                    <option value="3">人情往来</option>
                                                    <option value="4">衣服饰品</option>
                                                    <option value="5">交流通讯</option>
                                                    <option value="6">医疗保健</option>
                                                    <option value="7">居家物业</option>
                                                    <option value="8">休闲娱乐</option>
                                                    <option value="9">金融保险</option>
                                                    <option value="10">其他杂项</option>
                                                </select>
                                            </div>
                                            <div class="input-group input-group-lg">
                                                <span class="icon-coin-yen input-group-addon"></span>
                                                <select class="form-control select-money-category">
                                                    <option value="1"><span></span>现金</option>
                                                    <option value="2"><span></span>支付宝</option>
                                                    <option value="3"><span></span>微信</option>
                                                    <option value="4"><span></span>刷卡</option>
                                                    <option value="5"><span></span>支票</option>
                                                </select>
                                            </div>
                                            <div class="input-group input-group-lg">
                                                <span class="icon-clock input-group-addon"></span>
                                                <input id="endTime" class="kbtn form-control">
                                            </div>
                                            <div class="form-group form-group-lg">
                                                <label>
                                                    <h2><span class="icon-quill"></span>备注</h2>
                                                    <textarea class="form-control" rows="5" cols="50"
                                                              style="resize:none;" placeholder="备注"></textarea>
                                                </label>
                                            </div>
                                        </div>
                                        <!--收入面板-->
                                        <div class="tab-pane" id="panel-731068">
                                            <input type="hidden" value="2">
                                            <div class="input-group input-group-lg">
                                                <span class="icon-calculator input-group-addon"></span>
                                                <input id="cl2" type="text" class="form-control" dir="ltr"
                                                       placeholder="请输入"><span class="tips"></span>
                                            </div>
                                            <!--计算器面板-->
                                            <div id="calculator2">
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
                                                    $('div#calculator2').hide();
                                                    var cl2 = document.getElementById("cl2");
                                                    if (cl2.value.length === 0) {
                                                        $('span.tips').html("你还未输入").css("color", "red");
                                                    }
                                                    $('table.table-Calculator td').click(function () {
                                                        var values = $(this).html();
                                                        if (values !== "=") {
                                                            if (values === '÷') {
                                                                values = '/';
                                                            }
                                                            if (values === '×') {
                                                                values = '*';
                                                            }
                                                            cl2.value += values;
                                                        } else {
//                                                    暂未修复BUG，小数算术时会精度保留
                                                            cl2.value = eval(cl2.value);
                                                        }
                                                        if (values === "C") {
                                                            cl2.value = "";
                                                        }
                                                        if (values === "\u2192") {
                                                            cl2.value = cl2.value.substring(0, cl2.value.length - 2);
                                                        }
                                                    });
                                                    $('input#cl2').click(function () {
                                                        $('div#calculator2').toggle();
                                                    });
                                                });
                                            </script>
                                            <div class="input-group input-group-lg">
                                                <span class="icon-tree input-group-addon"></span>
                                                <select class="form-control select-spend-category">
                                                    <option value="1">工资收入</option>
                                                    <option value="2">利息收入</option>
                                                    <option value="3">加班收入</option>
                                                    <option value="4">奖金收入</option>
                                                    <option value="5">投资收入</option>
                                                    <option value="6">兼职收入</option>
                                                    <option value="7">其他收入</option>
                                                </select>
                                            </div>
                                            <div class="input-group input-group-lg">
                                                <span class="icon-coin-yen input-group-addon"></span>
                                                <select class="form-control select-money-category">
                                                    <option value="1">现金</option>
                                                    <option value="2">支付宝</option>
                                                    <option value="3">微信</option>
                                                    <option value="4">刷卡</option>
                                                    <option value="5">支票</option>
                                                </select>
                                            </div>
                                            <div class="input-group input-group-lg">
                                                <span class="icon-clock input-group-addon"></span>
                                                <input id="endTime2" class="kbtn form-control">
                                            </div>
                                            <div class="form-group form-group-lg">
                                                <label>
                                                    <h2><span class="icon-quill"></span>备注</h2>
                                                    <textarea class="form-control" rows="5" cols="50"
                                                              style="resize:none;" placeholder="备注"></textarea>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
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