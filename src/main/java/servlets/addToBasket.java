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

@WebServlet(urlPatterns = "/basket")
public class addToBasket extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BasketEntry> basket = new ArrayList<>();
        if ((List<BasketEntry>)req.getSession().getAttribute("basket") != null) {
            basket = (List<BasketEntry>) req.getSession().getAttribute("basket");
        }
        StoreRepository storeRepository = new StoreRepository();
        Integer productId = Integer.parseInt(req.getParameter("productIdToBuy"));
        Product product = storeRepository.getProductById(productId);
        Integer quantityToReserve = Integer.parseInt(req.getParameter("quantityToBuy"));
        Integer actuallyReservedQuantity = storeRepository.getReservedById(productId);
        Integer newReservedQuantity = actuallyReservedQuantity + quantityToReserve;
        Integer actualQuantity = product.getQuantity();

        if (actualQuantity>=newReservedQuantity) {
            storeRepository.setReservedById(productId, newReservedQuantity);
            basket.add(new BasketEntry(productId, quantityToReserve));
            req.getSession().setAttribute("basket", basket);
        }else{
            req.setAttribute("quantityToHigh", true);
        }

        RequestDispatcher dd = req.getRequestDispatcher("/");
        dd.forward(req,resp);
    }
}
