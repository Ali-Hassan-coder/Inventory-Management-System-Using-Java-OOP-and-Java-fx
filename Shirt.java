public class Shirt extends Product {
    private String color;
    private String brand;
    private Size size;

    public Shirt(String productId, String name, double price, int quantity, String color, String brand, Size size) {
        super(productId, name, price, quantity);
        this.color = color;
        this.brand = brand;
        this.size = size;
    }


    public String getColor() {
        return color; }
    public void setColor(String color) { this.color = color; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    @Override
    public String toString() {
        return super.toString() + ", Color=" + color + ", Brand=" + brand + ", Size=" + size;
    }
}
