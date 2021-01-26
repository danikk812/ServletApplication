package by.tms.servlet;

import by.tms.model.Basket;
import by.tms.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/basket/delete")
public class BasketDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Basket basket = (Basket) req.getSession().getAttribute("basket");
        Book byId = basket.getById(Integer.parseInt(id));
        basket.deleteBook(byId);
        resp.sendRedirect("/account");
    }
}
