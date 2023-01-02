package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class AuthFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String userLink = (String)((HttpServletRequest)req).getSession().getAttribute("user");
        if (userLink == null || !userLink.contains("/user/") || userLink.endsWith("/user/")) {
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
        chain.doFilter(req, res);
    }
}