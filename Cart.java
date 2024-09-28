package SafShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
        }

    public void addProduct(Product product, double quantity) {
        boolean productExists = false;

        for (Product p : products) {
            if (p.getProductID().equals(product.getProductID())) {
                p.setQuantity(p.getQuantity() + quantity);
                System.out.println("\nAdded " + quantity + " of " + p.getName()+" to the cart");
                System.out.println("\nPress any key to continue");
                Scanner scn = new Scanner(System.in);
                scn.nextLine();
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            product.setQuantity(quantity);
            products.add(product);
            System.out.println("\nSaved to the cart");
            System.out.println("\nPress any key to continue");
            Scanner scn = new Scanner(System.in);
            scn.nextLine();
        }
    }

    public void removeProduct(String productID, double quantity) {
        boolean productExists = false;

        for (Product p : products) {
            if (p.getProductID().equals(productID)) {
                productExists = true;

                if (p.getQuantity() < quantity) {
                    System.out.println("\nInvalid Quantity, Cart only has " + p.getQuantity() + " units.");
                    System.out.println("\nPress any key to continue");
                    Scanner scn = new Scanner(System.in);
                    scn.nextLine();
                } else if (p.getQuantity() == quantity) {
                    products.remove(p);
                    System.out.println("\nRemoved product: " + p.getName() + " from the cart.");
                    System.out.println("\nPress any key to continue");
                    Scanner scn = new Scanner(System.in);
                    scn.nextLine();
                } else {
                    p.setQuantity(p.getQuantity() - quantity);
                    System.out.println("\nRemoved " + quantity + " units of " + p.getName() + ".");
                    System.out.println("\nPress any key to continue");
                    Scanner scn = new Scanner(System.in);
                    scn.nextLine();
                }
                break;
            }
        }

        if (!productExists) {
            System.out.println("\nProduct with ID " + productID + " not found in the cart.");
            System.out.println("\nPress any key to continue");
            Scanner scn = new Scanner(System.in);
            scn.nextLine();
        }
    }


    public void displayCart() {
        for (Product p : products) {
            p.showDetails();
            System.out.println("Discount Applied: " + (int)(100 - ((p.getDiscountedPrice()/ p.getPrice())*100))+ "%");
            System.out.println("Discounted Product Price: " + p.getDiscountedPrice());
            System.out.println("Quantity: " + (int) p.getQuantity());
            System.out.println("Total Price for Product: " + p.getDiscountedPrice() * p.getQuantity());
            System.out.println("\nPress any key to continue");
            Scanner scn = new Scanner(System.in);
            scn.nextLine();

        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p  : products) {
            double productTotal = p.getDiscountedPrice() * p.getQuantity();
            total += productTotal;
        }
        return total;
    }
}
