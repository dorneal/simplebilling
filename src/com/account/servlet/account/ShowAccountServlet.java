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
 * 进入系统时查询，显示用户所有账目记录并分页显示
 *
 * @author Neal
 */
public class ShowAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        // 从session中取得ID数据
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        // 获取当前页数
        String currentPage = request.getParameter("currentPage");
        // 获取页面大小
        String pageSize = request.getParameter("pageSize");
        PageBean<AccountsEx> pageBean;
        try {
            // 查询封装
            // 当前页是否为空，为空则判断当前页的显示大小是否为空
            if (currentPage == null) {
                if (pageSize == null) {
                    // 设置默认页面显示大小
                    pageBean = accountService.pageListAccounts(1, usersEx.getUserId(), 10);
                } else {
                    // 设置为用户选择的页面大小
                    pageBean = accountService.pageListAccounts(1, usersEx.getUserId(), Integer.valueOf(pageSize));
                }
            } else {
                if (pageSize == null) {
                    pageBean = accountService.pageListAccounts(Integer.valueOf(currentPage), usersEx.getUserId(), 10);
                } else {
                    pageBean = accountService.pageListAccounts(Integer.valueOf(currentPage), usersEx.getUserId(), Integer.valueOf(pageSize));
                }
            }
            // 放置页面
            request.setAttribute("pageBean", pageBean);
            // 转发到用户数据显示页面
            request.getRequestDispatcher("/page/private/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
