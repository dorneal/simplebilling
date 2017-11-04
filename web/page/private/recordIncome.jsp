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
            $('#endTime2').date({theme: "datetime"});
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
                                <!--收入面板-->
                                <form action="${pageContext.request.contextPath}/account/InsertAccountServlet"
                                      method="post">
                                    <div class="tab-pane" id="panel-731068">
                                        <input type="hidden" value="收入" name="recordName">
                                        <div class="input-group input-group-lg">
                                            <span class="icon-calculator input-group-addon"></span>
                                            <input name="money" id="cl2" type="text" class="form-control" dir="ltr"
                                                   placeholder="请输入"
                                                   onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
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
                                            <select class="form-control select-spend-category" name="recordType">
                                                <option value="工资收入">工资收入</option>
                                                <option value="利息收入">利息收入</option>
                                                <option value="加班收入">加班收入</option>
                                                <option value="奖金收入">奖金收入</option>
                                                <option value="投资收入">投资收入</option>
                                                <option value="兼职收入">兼职收入</option>
                                                <option value="其他收入">其他收入</option>
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
                                            <input id="endTime2" class="kbtn form-control" name="recordDate">
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