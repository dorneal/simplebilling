package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 获取所有的记录servlet，用于可视化数据显示
 *
 * @author Neal
 */
public class AllAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        AccountService accountService = new AccountServiceImpl();
        // 获取session的用户，取得id
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        // 获取用户注册时间
        java.util.Date date = usersEx.getRegisterDate();
        try {
            // 调用查询方法，查询这个时间段的数据
            List<AccountsEx> accountsExList =
                    accountService.listAccountsByDate(
                            usersEx.getUserId(),
                            new Date(date.getTime()),
                            new Timestamp(System.currentTimeMillis()));
            Gson gson = new Gson();
            // 将数据封装成json字符串
            String allAccountsJson = gson.toJson(accountsExList);
            response.getWriter().write(allAccountsJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
