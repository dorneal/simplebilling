package com.account.servlet.user;


import com.account.entity.UsersEx;
import com.account.service.UserService;
import com.account.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 用户修改信息servlet
 *
 * @author Neal
 */
public class UserModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userModifyJson = request.getParameter("userModifyJson");
        Gson gson = new Gson();
        UsersEx usersEx = gson.fromJson(userModifyJson, UsersEx.class);
        UserService userService = new UserServiceImpl();
        try {
            int flag1 = userService.existEmail(usersEx);
            int flag2 = userService.existUserName(usersEx);
            int flag3 = userService.existPhoneNum(usersEx);
            if (flag1 <= 1) {
                if (flag2 <= 1) {
                    if (flag3 <= 1) {
                        out.write("SUCCESS");
                        userService.update(usersEx);
                    } else {
                        out.write("existPhoneNum");
                    }
                } else {
                    out.write("existUserName");
                }
            } else {
                out.write("existEmail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
