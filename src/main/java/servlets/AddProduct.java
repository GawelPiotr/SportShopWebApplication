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

@WebServlet(urlPatterns = "/addProduct")
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO handle with empty fields
        String type = req.getParameter("type");
        String colour = req.getParameter("colour");
        Integer size = Integer.parseInt(req.getParameter("size"));
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        Integer reserved = Integer.parseInt(req.getParameter("reserved"));

        Product newProduct = new Product(type,colour,size,quantity,reserved);

        StoreRepository storeRepository = new StoreRepository();
        storeRepository.saveProduct(newProduct);

        RequestDispatcher dd = req.getRequestDispatcher("/admin");
        dd.forward(req, resp);
    }
}
