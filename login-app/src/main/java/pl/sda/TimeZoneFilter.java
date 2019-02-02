package pl.sda;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;

@WebFilter(filterName = "TimeZoneFilter", value = "/main")
public class TimeZoneFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.addCookie(new Cookie("timeZone", TimeZone.getDefault().getDisplayName().replaceAll(" ", "")));

        chain.doFilter(req, res);
    }
}