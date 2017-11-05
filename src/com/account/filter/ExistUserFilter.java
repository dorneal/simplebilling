package com.account.filter;

import com.account.entity.UsersEx;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 *
 * @author Neal
 */
public class ExistUserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取session中拿到user
        UsersEx user = (UsersEx) request.getSession().getAttribute("user");
        // 不为空则放行进入系统
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 未登录，跳转到未登录提示页面
            response.sendRedirect(request.getContextPath() + "/page/public/notLogin.html");
        }
    }

    @Override
    public void destroy() {

    }
}
