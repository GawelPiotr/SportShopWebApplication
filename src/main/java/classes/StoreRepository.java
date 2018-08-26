package classes;

import interfaces.StoreInterface;

import java.util.List;
import java.util.stream.Collectors;

public class StoreRepository implements StoreInterface {

    @Override
    public List<Product> getAllProducts() {
        ProductsFactory productsFactory = ProductsFactory.getInstance();
        List<Product> tempList = productsFactory.getProductList();
        return tempList;
    }

    @Override
    public List<Product> getProductByType(String type) {
        ProductsFactory productsFactory = ProductsFactory.getInstance();
        List<Product> tempList = productsFactory
                .getProductList();

        tempList = tempList.stream().filter(t -> type.equals(t.getType())).collect(Collectors.toList());

        return tempList;
    }

    @Override
    public List<Product> getProductByClientId(Integer id) {
        return null;
    }

    @Override
    public Client getClientByNick(String nick) {
        return null;
    }

    @Override
    public void saveClient(Client client) {

    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void saveHistoryEntry(History history) {

    }

    @Override
    public void addProductQuantityById(Integer id_product, Integer quantity) {

    }

    @Override
    public void setReservedById(Integer product_id, Integer reservedValue) {
        ProductsFactory productsFactory = ProductsFactory.getInstance();
        for (Product product : productsFactory.getProductList()) {
            if (product_id.equals(product.getProduct_id())){
                product.setReserved(reservedValue);
            }
        }
    }

    @Override
    public List<History> getHistoryByClientId(Integer clientId) {
        return null;
    }

    @Override
    public Integer getReservedById(Integer productId) {
        ProductsFactory productsFactory = ProductsFactory.getInstance();
        for (Product product : productsFactory.getProductList()) {
            if (productId.equals(product.getProduct_id())){
                return product.getReserved();
            }
        }
        return 0;
    }

    @Override
    public Product getProductById(Integer productId) {
        ProductsFactory productsFactory = ProductsFactory.getInstance();
        for (Product product : productsFactory.getProductList()) {
            if (productId.equals(product.getProduct_id())){
                return product;
            }
        }
        return null;
    }
}
