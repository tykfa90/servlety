package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        if (!new LoginValidator().isValid(user, password)) {
            req.setAttribute("validationMessage", Arrays.asList(
                    "Invalid user name or password",
                    "Password cannot be empty"
            ));
            req.getRequestDispatcher("/loginError").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("main");
    }
}
