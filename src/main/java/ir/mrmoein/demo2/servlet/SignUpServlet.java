package ir.mrmoein.demo2.servlet;

import ir.mrmoein.demo2.access.LocatorAccess;
import ir.mrmoein.demo2.model.dto.UserReqDTO;
import ir.mrmoein.demo2.model.dto.UserRespDTO;
import ir.mrmoein.demo2.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Set;

@NoArgsConstructor
public class SignUpServlet extends HttpServlet {
    private final UserServiceImpl service = LocatorAccess.getService(UserServiceImpl.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserReqDTO user = new UserReqDTO(username, password, email);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserReqDTO>> validate = validator.validate(user);
        if (validate.isEmpty()) {
            service.signup(user);
            UserRespDTO userResp = service.login(username, password);
            if (userResp != null) {
                HttpSession session = req.getSession();// this line create a session
                session.setAttribute("userID", userResp.getId());
                req.getRequestDispatcher("/view/dashboard.jsp").include(req, resp);
            } else {
                req.setAttribute("alertError", "Login failed. Invalid username or password.");
                req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
            }
            factory.close();
        } else {
            req.setAttribute("alertError", "Error For user or pass or email at bean Validation");
            req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
