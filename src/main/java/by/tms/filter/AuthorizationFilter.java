package by.tms.filter;

import by.tms.storage.InMemoryUserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"AuthorizationServlet"})
public class AuthorizationFilter extends HttpFilter {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (req.getMethod().equals("POST")) {
            if (inMemoryUserStorage.getUsers().size() > 0 && inMemoryUserStorage.isRegistered(login, password)) {
                chain.doFilter(req, res);
            } else {
                req.setAttribute("wrongLoginOrPassMessage", "Wrong login or password");
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
