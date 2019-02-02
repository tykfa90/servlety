package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BasketControllerServlet", value = "/basket")
public class BasketControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Long, BigDecimal> basket = (Map<Long, BigDecimal>) req.getSession().getAttribute("basket");
        if (basket == null) {
            basket = new HashMap<>();
        }

        // Monika - ten kod poniżej działa, ale wyświetla koszyk brzydko, w postaci "["id artykułu"="ilość w koszyku"]
        // Możesz sobie to przerobić, ale generalnie to działa tak jak powinno, przynajmniej według Adama.
        PrintWriter writer = resp.getWriter();
        writer.println("<html>" +
                "<body>" +
                "   <p>Your basket contents</p>" +
                "   <br />" +
                basket.entrySet() +
                "   <br />" +
                "   <a href=\"/articles\">Add another article</a>" +
                "<br />" +
                "<a href=\"/basket\">Go to basket</a>" +
                "<br />" +
                "</body>" +
                "</html>"
        );
    }
}
