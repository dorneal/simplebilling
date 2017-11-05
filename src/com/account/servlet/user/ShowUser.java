package com.account.servlet.user;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 显示用户信息，以及简单账目信息
 *
 * @author Neal
 */
public class ShowUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session中的user对象
        UsersEx user = (UsersEx) request.getSession().getAttribute("user");
        AccountService accountService = new AccountServiceImpl();
        try {
            // 查询该用户的所有数据
            List<AccountsEx> listAccounts = accountService.listAccounts(user.getUserId());
            // 将数据放入request中
            request.setAttribute("listAccounts", listAccounts);
            // 重定向到分页显示页面
            response.sendRedirect(request.getContextPath() + "/account/ShowAccountServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
