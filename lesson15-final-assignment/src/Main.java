import bean.Customer;
import bean.Order;
import bean.Product;
import common.SampleData;

import java.util.List;

/** Điểm bắt đầu của bài làm. Đọc README.md trước khi triển khai. */
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = SampleData.customers();
        List<Product> products = SampleData.products();
        List<Order> orders = SampleData.orders();
        List<Order> invalidOrders = SampleData.invalidOrders();

        System.out.println("JAVA CORE FINAL ASSIGNMENT - NOVA SHOP");
        System.out.println("Raw customer records: " + customers.size());
        System.out.println("Products: " + products.size());
        System.out.println("Orders: " + orders.size());
        System.out.println("Invalid order scenarios: " + invalidOrders.size());
        System.out.println("Report period: " + SampleData.REPORT_FROM + " -> " + SampleData.REPORT_TO);
        System.out.println("Read lesson15-final-assignment/README.md and implement your application.");
    }
}
