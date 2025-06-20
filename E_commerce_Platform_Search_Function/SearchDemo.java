package E_commerce_Platform_Search_Function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchDemo {

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Shoes", "Fashion"),
            new Product(2, "Laptop", "Electronics"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Shirt", "Fashion")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchKey = sc.nextLine();

        Product foundLinear = linearSearch(products, searchKey);
        System.out.println("\nLinear Search Result:");
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        Product foundBinary = binarySearch(products, searchKey);
        System.out.println("\nBinary Search Result:");
        System.out.println(foundBinary != null ? foundBinary : "Product not found");

        sc.close();
    }

    public static Product linearSearch(Product[] products, String key) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String key) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(key);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}
