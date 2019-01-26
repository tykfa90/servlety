package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet(name = "HelloWorldServlet", value = "/helloWorld")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<head>\n" +
                "<title>Statyczna strona WWW</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Dzisiaj jest " + LocalTime.now() + "</p>\n" +
                "</body>\n" +
                "</html>");

    }
}
