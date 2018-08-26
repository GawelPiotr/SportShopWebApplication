package interfaces;

import classes.Client;
import classes.History;
import classes.Product;

import java.util.List;

import java.util.Optional;

public interface StoreInterface {

    List<Product> getAllProducts();                                                 //OK

    List<Product> getProductByType(String type);                                    //OK

    List<Product> getProductByClientId(Integer id);                                 //FAULT

    Optional<Client> getClientByNick(String nick);                                  //OK

    void saveClient(Client client);                                                 //OK

    void saveProduct(Product product);                                              //OK

    void saveHistoryEntry(History history);                                         //OK

    void setProductQuantityById(Integer productId, Integer quantity);               //OK

    void setReservedById(Integer productId, Integer reservedValue);                 //OK

    List<History> getHistoryByClientId(Integer clientId);                           //OK

    Optional<Integer> getReservedById(Integer productId);                           //OK

    Optional<Product> getProductByProductId(Integer productId);                     //OK

}
