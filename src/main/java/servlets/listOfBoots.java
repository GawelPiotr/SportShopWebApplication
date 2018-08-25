package servlets;

import classes.Product;
import classes.StoreRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/boots")
public class listOfBoots extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreRepository storeRepository = new StoreRepository();
        List<Product> bootsList = storeRepository.getByType("boot");

        req.setAttribute("bootsList", bootsList);

        RequestDispatcher dd = req.getRequestDispatcher("/boots.jsp");
        dd.forward(req,resp);
    }
}