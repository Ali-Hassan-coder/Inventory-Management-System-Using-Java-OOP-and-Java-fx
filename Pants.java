public class Pants extends Product {
    private Size size;
    private String material;

    public Pants(String productId, String name, double price, int quantity, Size size, String material) {
        super(productId, name, price, quantity);

        this.size = size;
        this.material = material;
    }

    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public String toString() {
        return super.toString() + ", Size=" + size + ", Material=" + material;
    }
}
