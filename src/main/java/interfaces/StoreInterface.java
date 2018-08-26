package interfaces;

import classes.Client;
import classes.History;
import classes.Product;

import java.util.List;

public interface StoreInterface {

    List<Product> getAllProducts();                                                 //OK

    List<Product> getProductByType(String type);                                    //OK

    List<Product> getProductByClientId(Integer id);                                 //FAULT

    Client getClientByNick(String nick);                                            //OK

    void saveClient(Client client);                                                 //OK

    void saveProduct(Product product);                                              //OK

    void saveHistoryEntry(History history);                                         //OK

    void addProductQuantityById(Integer productId, Integer quantity);               //

    void setReservedById(Integer productId, Integer reservedValue);

    List<History> getHistoryByClientId(Integer clientId);

}
