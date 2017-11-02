package com.account.servlet.account;

import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 删除账目记录servlet
 *
 * @author Neal
 */
public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        AccountService accountService = new AccountServiceImpl();
        try {
            accountService.removeAccounts(Integer.valueOf(recordId));
            response.sendRedirect(request.getContextPath() + "/account/ShowAccountServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
