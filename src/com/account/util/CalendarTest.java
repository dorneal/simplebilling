package com.account.util;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(new Timestamp(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(calendar.getTime());
        try {
            calendar.add(Calendar.DAY_OF_WEEK, -DateJudgmentUtil.dayForWeek(new Timestamp(System.currentTimeMillis())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("----------" + DateJudgmentUtil.getPeriodOfWeek(DateJudgmentUtil.dayForWeek(new Timestamp(System.currentTimeMillis()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        AccountService accountService = new AccountServiceImpl();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        try {
            List<AccountsEx> accountsExList =
                    accountService.listAccountsByDate(
                            1,
                            new java.sql.Date(DateJudgmentUtil.getPeriodOfWeek(DateJudgmentUtil.dayForWeek(sqlDate)).getTime()),
                            sqlDate);
            System.out.println(accountsExList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(calendar.getTime());
    }
}
