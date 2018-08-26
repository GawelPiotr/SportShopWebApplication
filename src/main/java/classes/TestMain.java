package classes;

public class TestMain {
    public static void main(String[] args) {


        Product product1 = new Product();
        Product product2 = new Product();
        Client client1 = new Client();
        Client client2 = new Client();
        History history1 = new History();
        History history2 = new History();
        StoreRepository storeRepository = new StoreRepository();


        //saveProduct1
        product1.setType("Boots");
        product1.setColour("Red");
        product1.setSize(42);
        product1.setQuantity(20);
        product1.setReserved(0);
        storeRepository.saveProduct(product1);

        //saveProduct2
        product2.setType("Shirt");
        product2.setColour("Blue");
        product2.setSize(40);
        product2.setQuantity(18);
        product2.setReserved(0);
        storeRepository.saveProduct(product2);

        //saveClient1
        client1.setNick("Zenon");
        storeRepository.saveClient(client1);

        //saveClient2
        client2.setNick("Hiaca");
        storeRepository.saveClient(client2);

        //saveHistoryEntry
        history1.setProductId(1);
        history1.setClientId(2);
        history1.setQuantity(8);
        storeRepository.saveHistoryEntry(history1);


        storeRepository.setProductQuantityById(1, 50);

        storeRepository.setReservedById(1, 9);

        //System.out.println(storeRepository.getAllProducts());
//
//        System.out.println(storeRepository.getProductByType("Shirt"));
//
//        System.out.println(storeRepository.getClientByNick("Zenon"));
//
//        System.out.println(storeRepository.getHistoryByClientId(2));
//
//        System.out.println(storeRepository.getReservedById(1));
//
//        System.out.println(storeRepository.getProductByProductId(1));
    }
}
