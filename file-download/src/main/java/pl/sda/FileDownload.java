package pl.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "FileDownloadServlet", value = "/download")
public class FileDownload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>SDA - File Download</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "   <form method=\"post\" action=\"/download\">\n" +
                "       <p>Select file to download: </p>" +
                "       <input type=\"text\" name=\"fileToDownload\"></input>\n" +
                "       <input type=\"submit\" value=\"Download\"></input>\n" +
                "   </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileToDownload = req.getParameter("fileToDownload");

        if (StringUtils.isBlank(fileToDownload)) {
            resp.getWriter().println("<html>" +
                    "<body>" +
                    "<p>Brak nazwy pliku</p>" +
                    "<a href=\"/download\">Back</a>" +
                    "</body>" +
                    "</html>");
            return;
        }

        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/" + fileToDownload);

        if (inputStream == null) {
            resp.getWriter().println("File not available for download: " + fileToDownload);
            return;
        }

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileToDownload + "\"");

        ServletOutputStream respOutputStream = resp.getOutputStream();

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            respOutputStream.write(buffer, 0, bytesRead);
        }
        respOutputStream.flush();
        respOutputStream.close();

    }
}
