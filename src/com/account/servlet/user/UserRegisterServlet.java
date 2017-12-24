package com.account.servlet.user;

import com.account.entity.UsersEx;
import com.account.service.UserService;
import com.account.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 用户注册servlet
 *
 * @author Neal
 */
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String userRegisterJson = request.getParameter("userRegisterJson");
        Gson gson = new Gson();
        UsersEx usersEx = gson.fromJson(userRegisterJson, UsersEx.class);
        usersEx.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        UserService userService = new UserServiceImpl();
        try {
            // 根据返回的count计算，是否存在多个值，注册时，必须要返回的count为0，更新时，可以小于等于1
            int flag1 = userService.existEmail(usersEx);
            int flag2 = userService.existUserName(usersEx);
            int flag3 = userService.existPhoneNum(usersEx);
            if (flag1 == 0) {
                if (flag2 == 0) {
                    if (flag3 == 0) {
                        out.write("SUCCESS");
                        userService.saveUser(usersEx);
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
