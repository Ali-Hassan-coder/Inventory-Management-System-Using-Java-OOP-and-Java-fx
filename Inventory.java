import java.io.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        System.out.println("Product removed successfully (if it existed).");
    }

    public Product searchProduct(String searchTerm) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchTerm) || product.getProductId().equals(searchTerm)) {
                return product;
            }
        }
        return null;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : products) {
                writer.write(productToString(product)); // Save product as a comma-separated string
                writer.newLine();
            }
            System.out.println("Products saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = parseProductFromString(line);
                if (product != null) {
                    products.add(product);
                }
            }
            System.out.println("Products loaded from file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty inventory.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    private String productToString(Product product) {
        if (product instanceof Shirt) {
            Shirt shirt = (Shirt) product;
            return "Shirt," + shirt.getProductId() + "," + shirt.getName() + "," + shirt.getPrice() + ","
                    + shirt.getQuantity() + "," + shirt.getColor() + "," + shirt.getBrand() + "," + shirt.getSize();
        } else if (product instanceof Pants) {
            Pants pants = (Pants) product;
            return "Pants," + pants.getProductId() + "," + pants.getName() + "," + pants.getPrice() + ","
                    + pants.getQuantity() + "," + pants.getMaterial() + "," + pants.getSize();
        } else if (product instanceof Shoe) {
            Shoe shoe = (Shoe) product;
            return "Shoe," + shoe.getProductId() + "," + shoe.getName() + "," + shoe.getPrice() + ","
                    + shoe.getQuantity() + "," + shoe.getBrand() + "," + shoe.getShoeSize() + "," + shoe.getType();
        } else if (product instanceof Jacket) {
            Jacket jacket = (Jacket) product;
            return "Jacket," + jacket.getProductId() + "," + jacket.getName() + "," + jacket.getPrice() + ","
                    + jacket.getQuantity() + "," + jacket.getMaterial() + "," + jacket.getColor() + "," + jacket.getSize();
        }
        return null;
    }

    private Product parseProductFromString(String line) {
        String[] parts = line.split(",");
        switch (parts[0]) {
            case "Shirt":
                return new Shirt(parts[1], parts[2], Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), parts[5], parts[6], Size.valueOf(parts[7]));
            case "Pants":
                return new Pants(parts[1], parts[2], Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), Size.valueOf(parts[5]), parts[6]);
            case "Shoe":
                return new Shoe(parts[1], parts[2], Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), parts[5], Integer.parseInt(parts[6]), parts[7]);
            case "Jacket":
                return new Jacket(parts[1], parts[2], Double.parseDouble(parts[3]),
                        Integer.parseInt(parts[4]), parts[5], parts[6], Size.valueOf(parts[7]));
            default:
                return null;
        }
    }
}
