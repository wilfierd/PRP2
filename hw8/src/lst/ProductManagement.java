
package lst;
import java.util.*;


class Product {
    String name;
    Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> products = new HashMap<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter product list from keyboard");
            System.out.println("2. Sort in descending order by price and output to the screen");
            System.out.println("3. Find and delete products by name entered from the keyboard");
            System.out.println("4. Export the average price of the products");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterProductList(scanner, products);
                    break;
                case 2:
                    sortAndOutput(products);
                    break;
                case 3:
                    findAndDeleteProduct(scanner, products);
                    break;
                case 4:
                    exportAveragePrice(products);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enterProductList(Scanner scanner, Map<String, Double> products) {
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            products.put(name, price);
        }
        System.out.println("Product list entered successfully.");
    }

    private static void sortAndOutput(Map<String, Double> products) {
        List<Map.Entry<String, Double>> productList = new ArrayList<>(products.entrySet());
        productList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Products sorted in descending order by price:");
        for (Map.Entry<String, Double> entry : productList) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    private static void findAndDeleteProduct(Scanner scanner, Map<String, Double> products) {
        System.out.print("Enter the name of the product to delete: ");
        String productName = scanner.nextLine();

        if (products.containsKey(productName)) {
            products.remove(productName);
            System.out.println("Product '" + productName + "' deleted successfully.");
        } else {
            System.out.println("Product '" + productName + "' not found.");
        }
    }

    private static void exportAveragePrice(Map<String, Double> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        double total = 0;
        for (double price : products.values()) {
            total += price;
        }
        double average = total / products.size();

        System.out.println("Average price of products: $" + average);
    }
}
