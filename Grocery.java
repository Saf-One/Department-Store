package SafShop;

import java.util.Random;

public class Grocery extends Product{
    private String type;
    private double weight;

    public Grocery(String productID, String name, String category, double price, double discountedPrice,double quantity, String type, double weight) {
        super(productID, name, category, price, 0,0);
        this.type = type;
        this.weight = weight;
        applyDiscount();
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    void additionalInfo() {
        System.out.println("Type: " + type);
        System.out.println("Weight: " + weight +" kg");
    }

    @Override
    public double applyDiscount() {
        Random rand = new Random();
        double randdisc = rand.nextInt(10,30);
        double discountAmount = (randdisc/100) * getPrice();
        double discountPrice = getPrice() - discountAmount;
        setDiscountedPrice(discountPrice);
        return discountPrice;
    }
}
