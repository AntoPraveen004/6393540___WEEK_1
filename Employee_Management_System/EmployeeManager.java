package Employee_Management_System;
import java.util.Scanner;

import Employee_Management_System.Employee;

public class EmployeeManager {
    private static final int MAX = 100;
    private Employee[] employees = new Employee[MAX];
    private int size = 0;

    public void addEmployee(Employee emp) {
        if (size < MAX) {
            employees[size++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }


    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        size--;
        System.out.println("Employee deleted.");
    }


    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees found.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add 2. Search 3. Delete 4. Display 5. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter ID, Name, Position, Salary: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String position = sc.next();
                    double salary = sc.nextDouble();
                    manager.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    Employee e = manager.searchEmployee(id);
                    System.out.println(e != null ? e : "Not found");
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteEmployee(id);
                    break;
                case 4:
                    manager.displayEmployees();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
