import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("");

        System.out.println("Welcome to the Inventory Management System!");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n1. Sign Up");
            System.out.println("2. Log In");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (userManager.registerUser(username, password)) {
                        System.out.println("User registered successfully! You can now log in.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (userManager.loginUser(username, password)) {
                        System.out.println("Login successful!");
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid credentials, please try again.");
                    }
                    break;

                default:
                    System.out.println("Invalid option! Please choose either 1 or 2.");
            }
        }

        Inventory inventory = new Inventory();
        String filename = "products.txt";
        inventory.loadFromFile(filename);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Remove Product");
            System.out.println("4. List All Products");
            System.out.println("5. Save Products to File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choose product type to add:");
                    System.out.println("1. Shirt");
                    System.out.println("2. Pants");
                    System.out.println("3. Shoes");
                    System.out.println("4. Jacket");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    switch (type) {
                        case 1:
                            System.out.print("Enter Color: ");
                            String color = scanner.nextLine();
                            System.out.print("Enter Brand: ");
                            String brand = scanner.nextLine();
                            System.out.print("Enter Size (SMALL, MEDIUM, LARGE): ");
                            Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                            inventory.addProduct(new Shirt(productId, name, price, quantity, color, brand, size));
                            break;
                        case 2:
                            System.out.print("Enter Material: ");
                            String material = scanner.nextLine();
                            System.out.print("Enter Size (SMALL, MEDIUM, LARGE): ");
                            size = Size.valueOf(scanner.nextLine().toUpperCase());
                            inventory.addProduct(new Pants(productId, name, price, quantity, size, material));
                            break;
                        case 3:
                            System.out.print("Enter Brand: ");
                            brand = scanner.nextLine();
                            System.out.print("Enter Size (e.g., 42): ");
                            int shoeSize = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Type (e.g., Running, Casual): ");
                            String shoeType = scanner.nextLine();
                            inventory.addProduct(new Shoe(productId, name, price, quantity, brand, shoeSize, shoeType));
                            break;
                        case 4:
                            System.out.print("Enter Material: ");
                            material = scanner.nextLine();
                            System.out.print("Enter Color: ");
                            color = scanner.nextLine();
                            System.out.print("Enter Size (SMALL, MEDIUM, LARGE): ");
                            size = Size.valueOf(scanner.nextLine().toUpperCase());
                            inventory.addProduct(new Jacket(productId, name, price, quantity, material, color, size));
                            break;
                        default:
                            System.out.println("Invalid product type!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID or Name to search: ");
                    String searchTerm = scanner.nextLine();
                    Product foundProduct = inventory.searchProduct(searchTerm);
                    if (foundProduct != null) {
                        System.out.println("Product Found: " + foundProduct);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    String productIdToRemove = scanner.nextLine();
                    inventory.removeProduct(productIdToRemove);
                    break;

                case 4:
                    inventory.listProducts();
                    break;

                case 5:
                    inventory.saveToFile(filename);
                    break;

                case 6:
                    System.out.println("Saving data to file and exiting...");
                    inventory.saveToFile(filename);
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
