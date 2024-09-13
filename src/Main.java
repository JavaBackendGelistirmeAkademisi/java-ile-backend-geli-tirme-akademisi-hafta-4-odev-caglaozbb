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

            Inventory inventory = new Inventory();
            inventory.addProduct(new Product(1, "Apple", 3.0, 10));
            inventory.addProduct(new Product(2, "Orange", 5.0, 8));
            inventory.addProduct(new Product(3, "Banana", 7.99, 5));

            fileManager.writeToFile(productsFilePath, inventory.getProductById(1).toString());
            fileManager.writeToFile(productsFilePath, inventory.getProductById(2).toString());
            fileManager.writeToFile(productsFilePath, inventory.getProductById(3).toString());

            inventory.listAllProducts();
            inventory.updateStock(2, 10);
            inventory.listAllProducts();

            String productsData = fileManager.readFromFile(productsFilePath);
            System.out.println(productsData);

            Customer customer = new Customer(1, "John", "Doe");
            Customer customer2 = new Customer(2, "Jane", "Doe");
            Customer customer3 = new Customer(3, "Bob", "Smith");

            fileManager.writeCustomerToFile(customersFilePath, customer);
            fileManager.writeCustomerToFile(customersFilePath, customer2);
            fileManager.writeCustomerToFile(customersFilePath, customer3);

            String customersData = fileManager.readCustomersFromFile(customersFilePath);
            System.out.println(customersData);

            Order order = new Order(1, customer, inventory.getProductById(1), 3.0);

            order.addProduct(inventory.getProductById(2));
            order.addProduct(inventory.getProductById(3));


            fileManager.writeToFile(ordersFilePath, order.toString());

            String ordersData = fileManager.readFromFile(ordersFilePath);
            System.out.println(ordersData);


        } catch (CustomException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
