import java.util.ArrayList;
import java.util.List;
public class Inventory {

    private List<Product> products;


    public Inventory() {
        this.products = new ArrayList<>();
    }


    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }


    public void updateStock(int productId, int newQuantity) throws CustomException {
        Product product = getProductById(productId);
        if (product != null) {
            if (newQuantity < 0) {
                throw new CustomException("Quantity cannot be negative.");
            }
            product.setQuantity(newQuantity);
            System.out.println("Stock updated for product: " + product.getName() + " New stock: " + newQuantity);
        } else {
            throw new CustomException("Product not found: ID " + productId);
        }
    }


    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Inventory Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
