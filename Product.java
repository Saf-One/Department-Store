package SafShop;

public abstract class Product implements Discountable{

    private String productID;
    private String name;
    private String category;
    private double price;
    private double discountedPrice;
    private double quantity;


    public Product(String productID, String name, String category, double price, double discountedPrice, double quantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getQuantity() {
        return quantity;
    }

    public abstract double applyDiscount();

    public void showDetails(){
        System.out.println("\nProduct ID: " + productID);
        System.out.println("Product Name: " + name);
        System.out.println("Product Category: " + category);
        System.out.println("Product Price: " + price);

    }

    abstract void additionalInfo();
}
