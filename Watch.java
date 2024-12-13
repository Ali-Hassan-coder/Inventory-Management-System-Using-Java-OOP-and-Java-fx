public class Watch extends Product {
    private String brand;   // Brand of the watch
    private String material; // Material of the watch (e.g., leather, steel)
    private String type;     // Type of watch (e.g., analog, digital)

    public Watch(String productId, String name, double price, int quantity, String brand, String material, String type) {
        super(productId, name, price, quantity);
        this.brand = brand;
        this.material = material;
        this.type = type;
    }

    // Getters and Setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return super.toString() + ", Brand=" + brand + ", Material=" + material + ", Type=" + type;
    }
}
