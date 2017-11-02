package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.entity.PageBean;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 进入系统时查询显示所有账目记录并分页显示
 *
 * @author Neal
 */
public class ShowAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        // 从session中取得ID数据
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        PageBean<AccountsEx> pageBean;
        try {
            // 查询封装
            if (currentPage == null) {
                if (pageSize == null) {
                    pageBean = accountService.pageListAccounts(1, usersEx.getUserId(), 10);
                } else {
                    pageBean = accountService.pageListAccounts(1, usersEx.getUserId(), Integer.valueOf(pageSize));
                }
            } else {
                if (pageSize == null) {
                    pageBean = accountService.pageListAccounts(Integer.valueOf(currentPage), usersEx.getUserId(), 10);
                } else {
                    pageBean = accountService.pageListAccounts(Integer.valueOf(currentPage), usersEx.getUserId(), Integer.valueOf(pageSize));
                }
            }
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("/page/private/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
