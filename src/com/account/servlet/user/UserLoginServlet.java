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
 * 用户登录servlet
 *
 * @author Neal
 */
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取前端传来的json字符串
        String userJson = request.getParameter("userJson");
        // 将json字符串绑定到对象中去
        Gson gson = new Gson();
        UsersEx usersEx = gson.fromJson(userJson, UsersEx.class);
        // 进行登录判断
        UserService userService = new UserServiceImpl();
        try {
            UsersEx user = userService.login(usersEx);
            if (user != null) {
                // 将对象存入session
                request.getSession().setAttribute("user", user);
                out.write("SUCCESS");
            } else {
                out.write("FAIL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 向前端传值
        out.flush();
        out.close();
    }
}
