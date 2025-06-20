package InventoryManagement;
import InventoryManagement.Product;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added!");
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) { 
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add 2. Update 3. Delete 4. Display 5. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter ID, Name, Quantity, Price: ");
                int id = sc.nextInt();
                String name = sc.next();
                int qty = sc.nextInt();
                double price = sc.nextDouble();
                manager.addProduct(new Product(id, name, qty, price));
            } else if (choice == 2) {
                System.out.print("Enter ID, New Quantity, New Price: ");
                int id = sc.nextInt();
                int qty = sc.nextInt();
                double price = sc.nextDouble();
                manager.updateProduct(id, qty, price);
            } else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                manager.deleteProduct(id);
            } else if (choice == 4) {
                manager.displayInventory();
            } else {
                break;
            }
        }
        sc.close();
    }
}
