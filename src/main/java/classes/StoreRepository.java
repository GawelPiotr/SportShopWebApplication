package classes;

import interfaces.StoreInterface;

import java.util.List;

public class StoreRepository implements StoreInterface {



    public List<Product> getAll() {
        return null;
    }

    public List<Product> getByType(String type) {
        return null;
    }

    public List<Product> GetProductByClientId(Integer id_client) {
        return null;
    }


    public Client getClientByNick(String nick) {
        return null;
    }

    public void saveClient(Client client) {

    }

    public void saveProduct(Product product) {

    }

    public void historyEntry(Integer id_product, Integer ic_client) {

    }

    public void addProductQuantityById(Integer id_product, Integer quantity) {

    }
}
