import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<Product, Integer> products; // Ürünler ve miktarları
    private double totalPrice;

    public Order(int id, Customer customer, Product product, double price) {
        this.orderId = id;
        this.customer = customer;
        this.products = new HashMap<>();
        this.totalPrice = 0.0;
}
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }


    public Map<Product, Integer> getProducts() {
        return products;
    }


    public double getPrice() {
        return totalPrice;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            this.products.put(product, quantity);
            this.totalPrice += product.getPrice() * quantity;
            System.out.println("Product added: " + product.getName() + " Quantity: " + quantity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Products: \n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            sb.append(entry.getKey().toString())
                    .append(" Quantity: ").append(entry.getValue()).append("\n");
        }
        sb.append("Total Price: ").append(totalPrice).append("\n");
        return sb.toString();
    }
}
