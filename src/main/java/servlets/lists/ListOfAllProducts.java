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

@WebServlet(urlPatterns = "")
public class ListOfAllProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAllProductsToVariables(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAllProductsToVariables(req, resp);
    }

    private void setAllProductsToVariables(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreRepository storeRepository = new StoreRepository();
        List<Product> allProductsList = storeRepository.getAllProducts();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(allProductsList);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");

        req.setAttribute("list", allProductsList);
        req.setAttribute("loggedUserName", req.getRemoteUser());

        RequestDispatcher dd = req.getRequestDispatcher("/index.jsp");
        dd.forward(req, resp);
    }
}
