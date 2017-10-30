package com.account.filter;

import com.account.entity.UsersEx;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录拦截器
 *
 * @author Neal
 */
public class ExistUserFilter implements Filter {
    /**
     * pathList 需要拦截的页面
     */
    private static List<String> pathList;

    static {
        pathList = new ArrayList<>();
        pathList.add("/page/private/");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
        if (pathList.contains(path)) {
            UsersEx user = (UsersEx) request.getSession().getAttribute("user");
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/page/public/notLogin.html");
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
