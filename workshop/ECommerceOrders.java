import java.util.*;

class Order {
    int id;
    String customerName;
    double amount;
    String status;  

    public Order(int id, String customerName, double amount, String status) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }
}

public class ECommerceOrders {
    public static void main(String[] args) {
        // Sample orders
        List<Order> orders = Arrays.asList(
            new Order(1, "A", 1000, "DELIVERED"),
            new Order(2, "B", 2000, "PENDING"),
            new Order(3, "A", 500, "DELIVERED"),
            new Order(4, "C", 1500, "CANCELLED"),
            new Order(5, "C", 1200, "DELIVERED")
        );

        double totalRevenue = 0;
        Map<String, Double> customerSpend = new HashMap<>();
        List<Order> completed = new ArrayList<>();
        List<Order> incomplete = new ArrayList<>();
        Set<String> uniqueCustomers = new HashSet<>();

        for (Order o : orders) {
            uniqueCustomers.add(o.customerName);

           
            if (o.status.equals("DELIVERED")) {
                totalRevenue += o.amount;
            }

            customerSpend.put(o.customerName,
                customerSpend.getOrDefault(o.customerName, 0.0) + o.amount);

          
            if (o.status.equals("DELIVERED")) {
                completed.add(o);
            } else {
                incomplete.add(o);
            }
        }

        
        String maxCustomer = null;
        double maxSpend = 0;
        for (Map.Entry<String, Double> entry : customerSpend.entrySet()) {
            if (entry.getValue() > maxSpend) {
                maxSpend = entry.getValue();
                maxCustomer = entry.getKey();
            }
        }

        System.out.println("Total Revenue (DELIVERED only): " + totalRevenue);
        System.out.println("Customer Total Spend: " + customerSpend);
        System.out.println("Customer with Max Spend: " + maxCustomer + " (" + maxSpend + ")");
        System.out.println("Completed Orders: " + completed.size());
        System.out.println("Incomplete Orders: " + incomplete.size());
        System.out.println("Unique Customers: " + uniqueCustomers);
    }
}