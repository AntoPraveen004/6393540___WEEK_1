package Sorting_Customer_Orders;

public class Order {
    public int orderId;
    public String customerName;
    public double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice;
    }
}
