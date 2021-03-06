package com.account.servlet.account;

import com.account.entity.AccountsEx;
import com.account.entity.UsersEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 账目修改servlet
 *
 * @author Neal
 */
public class UpdateAccountServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取页面数据
        String recordName = request.getParameter("recordName");
        String recordId = request.getParameter("recordId");
        String money = request.getParameter("money");
        String recordType = request.getParameter("recordType");
        String recordMode = request.getParameter("recordMode");
        String recordDate = request.getParameter("recordDate");
        String recordRemark = request.getParameter("recordRemark");

        // 获取用户session
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        AccountsEx accountsEx = new AccountsEx();
        accountsEx.setRecordId(Integer.valueOf(recordId));
        accountsEx.setUserId(usersEx.getUserId());
        accountsEx.setRecordName(recordName);
        accountsEx.setRecordType(recordType);
        accountsEx.setRecordMode(recordMode);
        accountsEx.setRecordRemark(recordRemark);
        accountsEx.setMoney(new BigDecimal(money));

        // 防止前端的日期跟后台的日期不同，做个转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 格式化数据
            Date date = format.parse(recordDate);
            // 为对象设置日期
            accountsEx.setRecordDate(new Timestamp(date.getTime()));
        } catch (Exception e) {
            accountsEx.setRecordDate(Timestamp.valueOf(recordDate + ":00"));
        }
        AccountService accountService = new AccountServiceImpl();
        try {
            // 去更新
            accountService.updateAccounts(accountsEx);
            // 更新成功后，跳转到数据分页显示servlet
            request.getRequestDispatcher("/account/ShowAccountServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
