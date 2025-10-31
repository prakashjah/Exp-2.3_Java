import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class ProductStreamOps {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 75000),
            new Product("Phone", "Electronics", 45000),
            new Product("Shirt", "Clothing", 1500),
            new Product("Jeans", "Clothing", 2000),
            new Product("Fridge", "Appliances", 30000)
        );

        System.out.println("Group by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((k, v) -> {
            System.out.println(k + ": " + v.stream().map(p -> p.name).collect(Collectors.joining(", ")));
        });

        System.out.println("\nProduct with Maximum Price:");
        products.stream()
                .max(Comparator.comparingDouble(p -> p.price))
                .ifPresent(p -> System.out.println(p.name + " - " + p.price));

        System.out.println("\nAverage Price per Category:");
        Map<String, Double> avgPrice = products.stream()
                .collect(Collectors.groupingBy(p -> p.category, Collectors.averagingDouble(p -> p.price)));
        avgPrice.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
