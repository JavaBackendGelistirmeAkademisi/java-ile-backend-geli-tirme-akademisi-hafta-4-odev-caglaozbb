import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalPrice;

    public Order(int id, Customer customer, Product product, double price) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
}
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }


    public List<Product> getProducts() {
        return products;
    }


    public double getPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalPrice += product.getPrice() * product.getQuantity();
        System.out.println("Product added: " + product.getName());
    }

    @Override
    public String toString() {
        return "Order [Order ID: " + orderId + ", Customer: " + customer.getName() + ", Total Price: " + totalPrice + "]";
    }
}
