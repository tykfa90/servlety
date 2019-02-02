package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "ArticleControllerServlet", value = "/articles")
public class ArticleControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<Article> articles = new ArticleService().getAvailableArticles();

        String articlesOptions = articles.stream()
                .map(article -> "<option value=" +
                        article.getId() + ">" +
                        article.getName() + "</option>")
                .collect(Collectors.joining());

        String selectWithArticles = "<label for=\"user\">Article: </label>" +
                "<select name=\"articleId\" id=\"articles\">" +
                articlesOptions +
                "</select>";

        PrintWriter writer = resp.getWriter();


        writer.println("<html>" +
                "<body>" +
                "   <form method=\"post\">" +
                selectWithArticles +
                "       <br />\n" +
                "       <label for=\"quantity\">Quantity: </label>" +
                "       <input type=\"number\" id=\"quantity\" min=\"1\" name=\"quantity\">" +
                "       <br />" +
                "       <input type=\"Submit\" value=\"Add\">" +
                "   </form>" +
                "   <br />" +
                "   <a href=\"/basket\">Go to basket</a>" +
                "</body>" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("articleId"));
        BigDecimal quantity = new BigDecimal(req.getParameter("quantity"));

        Map<Long, BigDecimal> articleQuantityMap = (Map<Long, BigDecimal>) req.getSession().getAttribute("basket");
        if (articleQuantityMap == null) {
            articleQuantityMap = new HashMap<>();
            req.getSession().setAttribute("basket", articleQuantityMap);
        }
        articleQuantityMap.compute(articleId, (k, v) -> (v == null) ? quantity : v.add(quantity));

        PrintWriter writer = resp.getWriter();
        writer.println("<html>" +
                "<body>" +
                "   <p>Article added to the basket</p>" +
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
