package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 账目修改servlet
 *
 * @author Neal
 */
public class UpdateAccountServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordName = request.getParameter("recordName");
        String money = request.getParameter("money");
        String recordType = request.getParameter("recordType");
        String recordMode = request.getParameter("recordMode");
        String recordDate = request.getParameter("recordDate");
        String recordRemark = request.getParameter("recordRemark");
        AccountsEx accountsEx = new AccountsEx();
        accountsEx.setBookId(1);
        accountsEx.setRecordName(recordName);
        accountsEx.setRecordType(recordType);
        accountsEx.setRecordMode(recordMode);
        accountsEx.setRecordRemark(recordRemark);
        accountsEx.setMoney(new BigDecimal(money));
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm");
        try {
            format.parse(recordDate);
            accountsEx.setRecordDate(Timestamp.valueOf(recordDate + ":00"));
        } catch (ParseException e) {
            accountsEx.setRecordDate(Timestamp.valueOf(recordDate));
        }
        AccountService accountService = new AccountServiceImpl();
        try {
            accountService.updateAccounts(accountsEx);
            request.getRequestDispatcher(request.getContextPath() + "/account/ShowAccountServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
