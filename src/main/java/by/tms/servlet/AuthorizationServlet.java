package by.tms.servlet;

import by.tms.model.Role;
import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User authorizedUser = inMemoryUserStorage.getByLogin(login);
        req.getSession().setAttribute("user", authorizedUser);
        req.getSession().setAttribute("isGuest", false);
        req.getSession().setAttribute("isUser", true);
        if (authorizedUser.getRole().equals(Role.ADMIN)) {
            req.getSession().setAttribute("isAdmin", true);
        }
        resp.sendRedirect("/");
    }
}
