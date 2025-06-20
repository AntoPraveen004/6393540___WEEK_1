package Library_Management_System;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Library {

    public static Book linearSearch(Book[] books, String key) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(key)) {
                return b;
            }
        }
        return null;
    }

   
    public static Book binarySearch(Book[] books, String key) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(key);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }


    public static void displayBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "James Gosling"),
            new Book(2, "Python Basics", "Guido van Rossum"),
            new Book(3, "Data Structures", "Robert Lafore"),
            new Book(4, "Algorithms", "Thomas Cormen"),
            new Book(5, "Operating Systems", "Silberschatz")
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Linear Search by Title");
        System.out.println("2. Binary Search by Title");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();

        Book foundBook = null;

        if (choice == 1) {
            foundBook = linearSearch(books, title);
            System.out.println("\n[Using Linear Search]");
        } else if (choice == 2) {
            foundBook = binarySearch(books, title);
            System.out.println("\n[Using Binary Search]");
        }

        if (foundBook != null) {
            System.out.println("Book Found:\n" + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        sc.close();
    }
}
