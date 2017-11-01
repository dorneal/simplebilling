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
import java.sql.Timestamp;

/**
 * 用户注册servlet
 *
 * @author Neal
 */
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String userRegisterJson = request.getParameter("userRegisterJson");
        System.out.println("-----------------" + userRegisterJson);
        Gson gson = new Gson();
        UsersEx usersEx = gson.fromJson(userRegisterJson, UsersEx.class);
        usersEx.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        System.out.println("++++++++++++++++++" + usersEx.toString());
        UserService userService = new UserServiceImpl();
        try {
            boolean flag1 = userService.existEmail(usersEx);
            boolean flag2 = userService.existUserName(usersEx);
            boolean flag3 = userService.existPhoneNum(usersEx);
            if (flag1) {
                if (flag2) {
                    if (flag3) {
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
