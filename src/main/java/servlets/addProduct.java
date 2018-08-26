package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addProduct")
public class addProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        String colour = req.getParameter("colour");




                        <select name="type">
                    <option value="boot">boot</option>
                    <option value="pants">pants</option>
                    <option value="shirt">shirt</option>
                    <%--zrobić ściąganie wartości z enuma--%>
                </select>
            </td>
            <td><input type="text" name="colour"></td>
            <td><input type="text" name="size"></td>
            <td><input type="text" name="quantity"></td>
            <td><input type="text" name="reserved" value="0"></td>

        RequestDispatcher dd = req.getRequestDispatcher("/admin");
        dd.forward(req, resp);
    }
}
