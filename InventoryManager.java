import java.util.ArrayList;

class Product {
    private String name;
    private int id;
    private int quantity;
    private double price;

    // Constructor
    public Product(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to calculate total value of inventory
    public double calculateTotalValue() {
        return quantity * price;
    }

    // Method to display product information
    public void displayProductInfo() {
        System.out.println("Product Name: " + name);
        System.out.println("Product ID: " + id);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        // Create an ArrayList to store products
        ArrayList<Product> inventory = new ArrayList<>();

        // Add products to the inventory
        inventory.add(new Product("Laptop", 1001, 5, 999.99));
        inventory.add(new Product("Smartphone", 1002, 10, 499.99));
        inventory.add(new Product("Tablet", 1003, 8, 299.99));

        // Update quantity of a product
        for (Product product : inventory) {
            if (product.getName().equals("Laptop")) {
                product.setQuantity(7);
            }
        }

        // Display product details and total inventory value
        double totalValue = 0;
        for (Product product : inventory) {
            product.displayProductInfo();
            totalValue += product.calculateTotalValue();
            System.out.println();
        }

        System.out.println("Total Inventory Value: $" + totalValue);
    }
}
