/**
 * 判断收/支
 * @param data
 */
function recordNameChange(data) {
    if (data === 1) {
        data = "支出";
    }
    if (data === 2) {
        data = "收入";
    }
    return data;
}

/**
 * 判断支出方式
 * @param data
 */
function recordTypeChange(data) {
    switch (data) {
        case 1:
            data = "食物酒水";
            break;
        case 2:
            data = "行车交通";
            break;
        case 3:
            data = "人情往来";
            break;
        case 4:
            data = "衣服饰品";
            break;
        case 5:
            data = "交流通讯";
            break;
        case 6:
            data = "医疗保健";
            break;
        case 7:
            data = "居家物业";
            break;
        case 8:
            data = "休闲娱乐";
            break;
        case 9:
            data = "金融保险";
            break;
        case 10:
            data = "其他杂项";
            break;
        default:
            data = "unknow";
    }
    return data;
}

/**
 * 判断支付模式
 * @param data
 */
function recordMode(data) {
    switch (data) {
        case 1:
            data = "现金";
            break;
        case 2:
            data = "支付宝";
            break;
        case 3:
            data = "微信";
            break;
        case 4:
            data = "刷卡";
            break;
        case 5:
            data = "支票";
            break;
        default:
            data = "unknow";
    }
    return data;
}

/**
 * 判断收入类型
 * @param data
 */
function incomeType(data) {
    switch (data) {
        case 1:
            data = "工资收入";
            break;
        case 2:
            data = "利息收入";
            break;
        case 3:
            data = "加班收入";
            break;
        case 4:
            data = "奖金收入";
            break;
        case 5:
            data = "投资收入";
            break;
        case 6:
            data = "兼职收入";
            break;
        case 7:
            data = "其他收入";
            break;
        default:
            data = "unknow";
    }
    return data;
}