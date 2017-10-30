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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 这里查值，放值
        UsersEx user = (UsersEx) request.getSession().getAttribute("user");
        AccountService accountService = new AccountServiceImpl();
        try {
            List<AccountsEx> listAccounts = accountService.listAccounts(user.getUserId());
            if (listAccounts != null) {
                request.setAttribute("listAccounts", listAccounts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/page/private/index.jsp");
    }
}
