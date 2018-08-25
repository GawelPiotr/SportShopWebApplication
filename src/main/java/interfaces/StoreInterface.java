package interfaces;


import classes.Client;
import classes.Product;

import java.util.List;

public interface StoreInterface {

    List<Product> getAll();
    List<Product> getByType(String type);
    List<Product> GetProductByClientId(Integer id_client );
    Client getClientByNick(String nick);
    void saveClient(Client client);
    void saveProduct(Product product);
    void historyEntry(Integer id_product, Integer id_client);
    void addProductQuantityById(Integer id_product, Integer quantity);
}
