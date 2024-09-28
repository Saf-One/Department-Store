package SafShop;
import java.util.Random;

public class Electronics extends Product{

    private String brand;
    private String model;
    private String warranty;

    public Electronics(String productID, String name, String category, double price, double discountedPrice,double quantity, String brand, String model, String warranty) {
        super(productID, name, category, price, 0,0);
        this.brand = brand;
        this.model = model;
        this.warranty = warranty;
        applyDiscount();
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }


    @Override
    void additionalInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Warranty: " + warranty);
    }

    @Override
    public double applyDiscount() {
        Random rand = new Random();
        double randdisc = rand.nextInt(5, 15);
        double discountAmount = (randdisc/100) * getPrice();
        double discountPrice = getPrice() - discountAmount;
        setDiscountedPrice(discountPrice);
        return discountPrice;
    }
}
