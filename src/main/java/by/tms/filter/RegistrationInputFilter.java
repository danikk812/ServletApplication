package by.tms.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"RegistrationServlet"})
public class RegistrationInputFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (req.getMethod().equals("POST")) {
           if (name.length() < 3 || login.length() < 3 || password.length() < 3) {
               req.setAttribute("tooShortMessage", "Too short name, login or password (at least 3 symbols)");
               getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
           } else {
               chain.doFilter(req, res);
           }
        } else {
            chain.doFilter(req, res);
        }
    }
}
