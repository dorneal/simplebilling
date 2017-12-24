package com.account.servlet.user;

import com.account.entity.UsersEx;
import com.account.service.UserService;
import com.account.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 用户密码修改类
 *
 * @author Neal
 */
public class ModifyPasswordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        // 获取新旧密码
        String password = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        // 从session中取得id和旧密码
        UsersEx usersEx2 = (UsersEx) request.getSession().getAttribute("user");
        // 进行旧密码比对
        if (password.equals(usersEx2.getUserPassword())) {
            // 创建一个对象
            UsersEx usersEx = new UsersEx();
            usersEx.setUserPassword(password);
            usersEx.setUserId(usersEx2.getUserId());
            try {
                UserService userService = new UserServiceImpl();
                boolean flag = userService.modifyPassword(usersEx, newPassword);
                if (flag) {
                    out.write("SUCCESS");
                } else {
                    out.write("修改失败！！！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            out.write("原密码错误！！！");
        }
        out.flush();
        out.close();
    }
}
