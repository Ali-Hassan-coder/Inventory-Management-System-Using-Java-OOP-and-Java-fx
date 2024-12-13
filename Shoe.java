public class Shoe extends Product {
    private String brand;
    private double shoeSize;
    private String type;

    public Shoe(String productId, String name, double price, int quantity, String brand, double shoeSize, String type) {
        super(productId, name, price, quantity);
        this.brand = brand;
        this.shoeSize = shoeSize;
        this.type = type;
    }


    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getShoeSize() { return shoeSize; }
    public void setShoeSize(double shoeSize) { this.shoeSize = shoeSize; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return super.toString() + ", Brand=" + brand + ", ShoeSize=" + shoeSize + ", Type=" + type;
    }
}
