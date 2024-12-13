public class Jacket extends Product {
    private String material;
    private String color;
    private Size size;

    public Jacket(String productId, String name, double price, int quantity, String material, String color, Size size) {
        super(productId, name, price, quantity);
        this.material = material;
        this.color = color;
        this.size = size;
    }


    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    @Override
    public String toString() {
        return super.toString() + ", Material=" + material + ", Color=" + color + ", Size=" + size;
    }
}
