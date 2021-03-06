package pl.sda;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class UserEditController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = userService.getUser(Long.parseLong(req.getParameter("userId")));

        req.setAttribute("user", user);

        req.getRequestDispatcher("WEB-INF/userCreate.jsp").forward(req, resp);
    }
}
