package com.account.servlet.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户退出系统servlet
 *
 * @author Neal
 */
public class UserQuitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 清除该用户session
        request.getSession().removeAttribute("user");
        // 重定向到主页
        response.sendRedirect(request.getContextPath() + "/page/public/index.html");
    }
}
