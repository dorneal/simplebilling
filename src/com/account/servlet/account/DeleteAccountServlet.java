package com.account.servlet.account;

import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从页面拿到账目ID
        String recordId = request.getParameter("recordId");
        AccountService accountService = new AccountServiceImpl();
        try {
            // 进行删除
            accountService.removeAccounts(Integer.valueOf(recordId));
            // 重定向到分页数据显示页面
            response.sendRedirect(request.getContextPath() + "/account/ShowAccountServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
