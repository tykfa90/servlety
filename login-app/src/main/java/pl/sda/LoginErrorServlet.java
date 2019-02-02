package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(name = "LoginErrorServlet", value = "/loginError")
public class LoginErrorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<String> validationMessage = (Collection<String>) req.getAttribute("validationMessage");

        resp.getWriter().println("<html>" +
                "<body>" +
                validationMessage.stream()
                        .map(message -> "<p>" + message + "</p>")
                        .collect(Collectors.joining())+
                "</body>" +
                "</html>");
    }
}
