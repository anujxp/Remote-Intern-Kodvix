
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
}

public class ObjectExperiment {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 80000);
        
        // Check if a product is "Premium" (Price > 50000)
        Predicate<Product> isPremium = p -> p.price > 50000;
        
        // Check if name contains 'a'
        Predicate<Product> hasLetterA = p -> p.name.contains("a");

        // Combine: Premium products that have 'a' in their name
        boolean result = isPremium.and(hasLetterA).test(p1);
        System.out.println("Is it a premium product with 'a'? " + result);
    }
}