package com.account.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类，根据给的日期返回一个日期
 *
 * @author Neal
 */
public class DateJudgmentUtil {

    /**
     * 根据星期时间段，给出该时间星期一的日期
     *
     * @param time 时间段
     * @return Date
     */
    public static Date getPeriodOfWeek(int time) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, -time);
        return calendar.getTime();
    }

    /**
     * 返回一个到这周一的时间段
     *
     * @param date 当前时间
     * @return 时间段
     */
    public static int dayForWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek;
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek - 1;
    }

    /**
     * 返回一个到这个月1号的时间段
     *
     * @return int
     */
    public static int dayForMonth() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1;
    }
}
