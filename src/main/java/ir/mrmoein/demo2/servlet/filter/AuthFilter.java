package ir.mrmoein.demo2.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession httpSession = req.getSession(false);

        if (httpSession == null){
            req.getRequestDispatcher("view/signup.jsp").forward(request ,response);
        } else {
            req.getRequestDispatcher("view/login.jsp").forward(request,response);
        }
    }
}
