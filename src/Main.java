import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        String productsFilePath = "products.txt";
        String ordersFilePath = "orders.txt";
        String customersFilePath = "customers.txt";

        try {
            if (!fileManager.fileExists(productsFilePath)) {
                fileManager.createFile(productsFilePath);
                System.out.println(productsFilePath + " created.");
            } else {
                System.out.println(productsFilePath + " already exists.");
            }

            if (!fileManager.fileExists(ordersFilePath)) {
                fileManager.createFile(ordersFilePath);
                System.out.println(ordersFilePath + " created.");
            } else {
                System.out.println(ordersFilePath + " already exists.");
            }

            if (!fileManager.fileExists(customersFilePath)) {
                fileManager.createFile(customersFilePath);
                System.out.println(customersFilePath + " created.");
            } else {
                System.out.println(customersFilePath + " already exists.");
            }

            Product apple = new Product(1, "Apple", 3.0, 10);
            Product orange = new Product(2, "Orange", 5.0, 8);
            Product banana = new Product(3, "Banana", 7.99, 5);


            Inventory inventory = new Inventory();
            inventory.addProduct(apple);
            inventory.addProduct(orange);
            inventory.addProduct(banana);


            fileManager.writeProductToFile(productsFilePath, inventory.getProductById(1));
            fileManager.writeProductToFile(productsFilePath, inventory.getProductById(2));
            fileManager.writeProductToFile(productsFilePath, inventory.getProductById(3));

            try {
                String productData = fileManager.readProductsFromFile(productsFilePath);
                System.out.println(productData);
            } catch (IOException e) {
                e.printStackTrace();
            }
            inventory.listAllProducts();
            inventory.updateStock(2, 10);
            //yeni stokun product.txtye eklenmesi
            fileManager.writeProductToFile(productsFilePath, inventory.getProductById(2));
            inventory.listAllProducts();


            Customer customer = new Customer(1, "John", "Doe");
            Customer customer2 = new Customer(2, "Jane", "Doe");
            Customer customer3 = new Customer(3, "Bob", "Smith");

            fileManager.writeCustomerToFile(customersFilePath, customer);
            fileManager.writeCustomerToFile(customersFilePath, customer2);
            fileManager.writeCustomerToFile(customersFilePath, customer3);


            try {
                String customersData = fileManager.readCustomersFromFile(customersFilePath);
                System.out.println(customersData);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Order order1 = new Order(1, customer , inventory.getProductById(1), 0.0);
            order1.addProduct(inventory.getProductById(1), 3);  // 3 adet Apple
            order1.addProduct(inventory.getProductById(2), 2);  // 2 adet Orange
            order1.addProduct(inventory.getProductById(3), 1);  // 1 adet Banana

            fileManager.writeOrderToFile(ordersFilePath, order1);

            Order order2 = new Order(2, customer2 , inventory.getProductById(1), 0.0);
            order2.addProduct(inventory.getProductById(1), 6);  // 6 adet Apple
            order2.addProduct(inventory.getProductById(3), 2);  // 2 adet Banana

            fileManager.writeOrderToFile(ordersFilePath, order2);

            try {
                String ordersData = fileManager.readOrdersFromFile(ordersFilePath);
               System.out.println(ordersData);
            } catch (IOException e) {
                e.printStackTrace();
            }


//        } catch (CustomException e) {
//            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }
    }
}
