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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用于用户搜索改日期的记录，进行分页显示
 *
 * @author Neal
 */
public class SearchAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取搜索日期
        String searchDate = request.getParameter("searchDate");
        // 从session中获取该用户
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        // 如果不为空
        if (searchDate != null && !"".equals(searchDate)) {
            // 格式化日期
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = simpleDateFormat.parse(searchDate);
                AccountService accountService = new AccountServiceImpl();
                // 进行查找
                List<AccountsEx> accountSearchList = accountService.listAccountsBySearchDate(usersEx.getUserId(), new java.sql.Date(date.getTime()));
                request.setAttribute("accountSearchList", accountSearchList);
                // 跳转到结果显示页面
                request.getRequestDispatcher("/page/private/accountSearch.jsp").forward(request, response);
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            // 搜索的为空，则跳转到数据显示页面
            response.sendRedirect("/simplebilling/account/ShowAccountServlet");
        }
    }
}
