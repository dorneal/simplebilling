package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 查询该账目，并跳转显示到页面servlet
 *
 * @author Neal
 */
public class ToUpdatePageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        AccountService accountService = new AccountServiceImpl();
        try {
            AccountsEx accountsEx = accountService.getAccounts(Integer.valueOf(recordId));
            request.setAttribute("accountsEx", accountsEx);
            String flag = "收入";
            if (flag.equals(accountsEx.getRecordName())) {
                request.getRequestDispatcher("/page/private/recordModifyIncome.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/page/private/recordModifyOut.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
