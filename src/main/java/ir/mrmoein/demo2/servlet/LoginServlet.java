package ir.mrmoein.demo2.servlet;

import ir.mrmoein.demo2.access.LocatorAccess;
import ir.mrmoein.demo2.model.dto.UserRespDTO;
import ir.mrmoein.demo2.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class LoginServlet extends HttpServlet {
    private final UserServiceImpl service = LocatorAccess.getService(UserServiceImpl.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserRespDTO user = service.login(username, password);

        if (user == null) {
            req.getRequestDispatcher("/auth/signup").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/dashboard.jsp").forward(req , resp);
        }
    }
}
