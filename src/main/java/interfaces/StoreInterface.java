package interfaces;

import classes.Client;
import classes.History;
import classes.Product;

import java.util.List;

public interface StoreInterface {

    List<Product> getAllProducts();

    List<Product> getProductByType(String type);

    List<Product> getProductByClientId(Integer id);

    Client getClientByNick(String nick);

    void saveClient(Client client);

    void saveProduct(Product product);

    void saveHistoryEntry(History history);

    void addProductQuantityById(Integer productId, Integer quantity);

    void setReservedById(Integer productId, Integer reservedValue);

    List<History> getHistoryByClientId(Integer clientId);

    Integer getReservedById(Integer productId);

    Product getProductById(Integer productId);
}