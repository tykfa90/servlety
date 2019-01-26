package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "CourseSelectionServle", value = "/courseSelection")
public class CourseSelectionServlet extends HttpServlet {

    Map<String, Collection<String>> courses = new HashMap<>();

    public CourseSelectionServlet() {
        courses.put("PROGRAMMER", Arrays.asList("Java", "C#", "C++"));
        courses.put("TESTER", Arrays.asList("Selenium", "Ranorex"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseType = req.getParameter("courseType");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>SDA - " + courseType + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Selected course type: " + courseType + "</p>\n" +
                "<select>" +
                courses.get(courseType).stream()
                        .map(course -> "<option>" + course + "</option>").collect(Collectors.joining()) +
                "</select>" +
                "</body>\n" +
                "</html>");
    }
}
