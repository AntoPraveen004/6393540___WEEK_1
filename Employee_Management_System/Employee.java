package Employee_Management_System;

public class Employee {
    public int employeeId;
    public String name;
    public String position;
    public double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
    }
}
