package classes;

import java.util.ArrayList;
import java.util.List;

public class ProductsFactory {

    private static ProductsFactory instance;
    private List<Product> productList = null;

    public static ProductsFactory getInstance(){
        if (instance == null){
            instance = new ProductsFactory();
        }
        return instance;
    }

    private ProductsFactory(){
        productList = new ArrayList<>();

        productList.add(new Product("boot", "red",38,20,0));
        productList.add(new Product("boot", "blue",39,200,0));
        productList.add(new Product("pants", "red",38,20,0));
        productList.add(new Product("pants", "blue",38,20,0));
        productList.add(new Product("pants", "red",38,20,0));
        productList.add(new Product("shirt", "yellow",38,20,0));
        productList.add(new Product("shirt", "red",38,20,0));
        int counter = 1;
        for (Product product : productList) {
            product.setProductId(counter++);
        }
    }

    public List<Product> getProductList(){
        return productList;
    }
}
