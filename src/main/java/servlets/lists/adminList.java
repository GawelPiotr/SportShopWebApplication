package servlets.lists;

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

@WebServlet(urlPatterns = "/admin")
public class adminList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreRepository storeRepository = new StoreRepository();
        List<Product> adminList = storeRepository.getAllProducts();

        req.setAttribute("list", adminList);

        RequestDispatcher dd = req.getRequestDispatcher("/restricted/admin.jsp");
        dd.forward(req,resp);
    }
}