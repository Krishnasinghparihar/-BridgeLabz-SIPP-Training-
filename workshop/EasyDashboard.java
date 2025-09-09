
import java.util.*;
import java.util.stream.*;

class Item {
    String name, category;
    double price;
    Item(String n, String c, double p) { name = n; category = c; price = p; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String toString() { return name + " ($" + price + ")"; }
}


public class EasyDashboard {
    public static void main(String[] args) {

        Item i1 = new Item("Laptop", "Electronics", 800);
        Item i2 = new Item("Phone", "Electronics", 600);
        Item i3 = new Item("Mixer", "Home Appliances", 200);
        Item i4 = new Item("Treadmill", "Fitness", 400);
        Item i5 = new Item("Blender", "Home Appliances", 120);

        Map<String, Map<String, Map<String, List<Item>>>> cityToStoresMap = new HashMap<>();
        Map<String, Map<String, List<Item>>> storeMap = new HashMap<>();
        Map<String, List<Item>> customerMap = new HashMap<>();
        customerMap.put("C1", Arrays.asList(i1, i2, i3, i4)); // >=3 orders
        customerMap.put("C2", Arrays.asList(i5, i3, i2));      // >=3 orders
        storeMap.put("Store1", customerMap);
        cityToStoresMap.put("City1", storeMap);

        // --- Stream Pipeline ---
        List<Item> topAffordablePicks = cityToStoresMap.values().stream()
            .flatMap(stores -> stores.values().stream())
            .flatMap(customers -> customers.values().stream())
            .filter(orders -> orders.size() >= 3) // at least 3 orders
            .flatMap(List::stream) // all items
            .distinct()
            .sorted(Comparator.comparingDouble(Item::getPrice).reversed())
            .peek(i -> System.out.println("Flowing: " + i))
            .skip(2).limit(10) // skip 2 costly, take next 10
            .collect(Collectors.toList());

        // Group by category
        Map<String, List<Item>> itemsByCategory =
            topAffordablePicks.stream().collect(Collectors.groupingBy(Item::getCategory));

        // Other operations
        long electronicsCount = itemsByCategory.getOrDefault("Electronics", List.of()).size();
        boolean anyOver500 = topAffordablePicks.stream().anyMatch(i -> i.getPrice() > 500);
        boolean allAbove10 = topAffordablePicks.stream().allMatch(i -> i.getPrice() > 10);
        boolean noneEmptyName = topAffordablePicks.stream().noneMatch(i -> i.getName() == null || i.getName().isEmpty());
        Optional<Item> firstHome = itemsByCategory.getOrDefault("Home Appliances", List.of()).stream().findFirst();
        Optional<Item> anyFitness = itemsByCategory.getOrDefault("Fitness", List.of()).stream().findAny();
        double totalValue = topAffordablePicks.stream().map(Item::getPrice).reduce(0.0, Double::sum);

        // --- Print Results ---
        System.out.println("Top Affordable Picks: " + topAffordablePicks);
        System.out.println("Electronics count: " + electronicsCount);
        System.out.println("Any > $500? " + anyOver500);
        System.out.println("All > $10? " + allAbove10);
        System.out.println("None empty name? " + noneEmptyName);
        System.out.println("First Home Appliance: " + firstHome);
        System.out.println("Any Fitness: " + anyFitness);
        System.out.println("Total Value: $" + totalValue);
    }
}
    