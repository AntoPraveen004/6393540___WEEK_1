package Task_Management_System;

import java.util.Scanner;

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManager {
    Node head = null;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
//        	System.out.println("sfsf");
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Task added.");
    }


    public Task searchTask(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == id)
                return temp.task;
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        Node temp = head, prev = null;

        if (temp != null && temp.task.taskId == id) {
            head = temp.next;
            System.out.println("Task deleted.");
            return;
        }

        while (temp != null && temp.task.taskId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Task not found.");
            return;
        }

        prev.next = temp.next;
        System.out.println("Task deleted.");
    }

    
    public void displayTasks() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No tasks available.");
        } else {
            while (temp != null) {
                System.out.println(temp.task);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add 2. Search 3. Delete 4. Display 5. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter ID, Name, Status: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String status = sc.next();
                    manager.addTask(new Task(id, name, status));
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    id = sc.nextInt();
                    Task t = manager.searchTask(id);
                    System.out.println(t != null ? t : "Not found");
                    break;
                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteTask(id);
                    break;
                case 4:
                    manager.displayTasks();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
