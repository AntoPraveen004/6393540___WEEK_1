package Sorting_Customer_Orders;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 499.99),
            new Order(102, "Bob", 1299.50),
            new Order(103, "Charlie", 299.75),
            new Order(104, "David", 850.00),
            new Order(105, "Eve", 1499.00)
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Bubble Sort\n2. Quick Sort");
        System.out.print("Choose sorting method (1 or 2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            OrderSorting.bubbleSort(orders);
            System.out.println("\nSorted using Bubble Sort:");
        } else {
            OrderSorting.quickSort(orders, 0, orders.length - 1);
            System.out.println("\nSorted using Quick Sort:");
        }

        OrderSorting.display(orders);
        sc.close();
    }
}
