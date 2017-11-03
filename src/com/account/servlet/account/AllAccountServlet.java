package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * 获取所有的记录servlet
 *
 * @author Neal
 */
public class AllAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        // 创建一个sqlDate
        Date sqlDate = new Date(new java.util.Date().getTime());
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
                            sqlDate);
            System.out.println(accountsExList.size());
            Gson gson = new Gson();
            String allAccountsJson = gson.toJson(accountsExList);
            response.getWriter().write(allAccountsJson);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
