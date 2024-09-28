package SafShop;

import java.util.Random;

public class Clothing extends Product{
    private String type;
    private String size;
    private String color;

    public Clothing(String productID, String name, String category, double price,double discountedPrice,double quantity, String type, String size, String color) {
        super(productID, name, category, price, 0,0);
        this.type = type;
        this.size = size;
        this.color = color;
        applyDiscount();
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    void additionalInfo() {
        System.out.println("Type : " + type);
        System.out.println("Size : " + size);
        System.out.println("Color : " + color);
    }

    @Override
    public double applyDiscount() {
        Random rand = new Random();
        double randdisc = rand.nextInt(10,50);
        double discountAmount = (randdisc/100) * getPrice();
        double discountPrice = getPrice() - discountAmount;
        setDiscountedPrice(discountPrice);
        return discountPrice;
    }
}
