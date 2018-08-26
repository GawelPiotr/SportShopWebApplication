package servlets;

import classes.BasketEntry;
import classes.Product;
import classes.StoreRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/buy")
public class buy extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BasketEntry> basket = new ArrayList<>();
        if ((List<BasketEntry>)req.getSession().getAttribute("basket") != null) {
            basket = (List<BasketEntry>) req.getSession().getAttribute("basket");
        }



        RequestDispatcher dd = req.getRequestDispatcher("/index.jsp");
        dd.forward(req,resp);
    }
}
