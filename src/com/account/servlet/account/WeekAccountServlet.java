package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;
import com.account.util.DateJudgmentUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 每周账目记录的servlet
 *
 * @author Neal
 */
public class WeekAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        // 创建一个sqlDate
        Date sqlDate = new Date(new java.util.Date().getTime());
        // 获取session的用户，取得id
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        try {
            // 调用查询方法，查询这个时间段的数据
            List<AccountsEx> accountsExList =
                    accountService.listAccountsByDate(
                            usersEx.getUserId(),
                            new Date(DateJudgmentUtil.getPeriodOfWeek(DateJudgmentUtil.dayForWeek(sqlDate)).getTime()),
                            new Timestamp(System.currentTimeMillis()));
            Gson gson = new Gson();
            String weekAccountsJson = gson.toJson(accountsExList);
            response.getWriter().write(weekAccountsJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
