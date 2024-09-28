package SafShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        Electronics[] electronics = {
                new Electronics("E001", "Samsung Neo Qled", "Television", 289000.0, 0,0, "Samsung", "STV4548", "2 years"),
                new Electronics("E002", "Dell Inspiron", "Laptop", 80000.0, 0,0, "Dell", "DL5012", "1 year"),
                new Electronics("E003", "Apple iPhone 13", "Smartphone", 60000.0, 0,0, "Apple", "IP13P", "1 year"),
                new Electronics("E004", "Sony PlayStation 5", "Gaming Console", 35000.0, 0, 0,"Sony", "PS5001", "2 years"),
                new Electronics("E005", "Sony WH-1000XM4", "Headphones", 15000.0, 0,0, "Sony", "SH1004", "1 year"),
                new Electronics("E006", "Apple iPad Air", "Tablet", 50000.0, 0,0, "Apple", "IPAD123", "1 year"),
                new Electronics("E007","FitBit Tracker", "Accessory",15000, 0,0,"FitBit","FB17G","6 months")
        };

        Clothing[] clothing = {
                new Clothing("C001", "Nike Dry Fit", "T-Shirt", 800.0, 0,0, "Torso", "S/M/L", "White"),
                new Clothing("C002", "Levi 501", "Jeans", 2500.0, 0, 0,"Bottom", "28/30/32", "Blue"),
                new Clothing("C003", "Zara Party Dress", "Dress", 3500.0, 0,0, "Full Body", "S/M/L", "Red"),
                new Clothing("C004", "Adidas Windbreaker", "Jacket", 1800.0, 0,0, "Torso", "S/M/L", "Black"),
                new Clothing("C005", "Vans Old Skool", "Shoes", 1200.0, 0,0, "Footwear", "7/8/9", "Black"),
                new Clothing("C006","LaCoste Polo Shirt", "Shirt", 1500.0,0,0, "Torso","S/M/XXL","Blue")

        };

        Grocery[] grocery = {
                new Grocery("G001", "Apples", "Fruit", 80.0, 0,0, "Produce", 1),
                new Grocery("G002", "Fish", "Meat", 240.0, 0,0, "Seafood", 1.75),
                new Grocery("G003", "Rice", "Grains", 400.0, 0,0, "Produce", 10),
                new Grocery("G004", "Eggs", "Dairy", 72.0, 0,0, "Poultry", 1),
                new Grocery("G005", "Milk", "Beverage", 60.0, 0,0, "Dairy", 0.5)
        };

        while(true){
            System.out.print("\nWelcome to the store! All items UpTo 50% Off!\n1. View Items\n2. View Cart\n3. Remove Items from Cart\n4. Head to CheckOut\n5. Exit\n\nPlease Select an Option: ");
            int mainmenu = sc.nextInt();
            switch(mainmenu) {

                case 1:
                    while (true) {
                        System.out.print("1. Electronics\n2. Clothing\n3. Grocery\n4. Go Back\n\nSelect an option: ");
                        int catmenu = sc.nextInt();
                        switch (catmenu) {
                            case 1:
                                displayProducts(electronics, cart);
                                break;
                            case 2:
                                displayProducts(clothing, cart);
                                break;
                            case 3:
                                displayProducts(grocery, cart);
                                break;
                            default:
                                System.out.println("\nInvalid Selection\n");
                                System.out.println("\nPress any key to continue");
                                Scanner scn = new Scanner(System.in);
                                scn.nextLine();
                                break;
                        }
                        if (catmenu == 4) {
                            break;
                        }
                    }
                    break;
                case 2:
                    cart.displayCart();
                    break;
                case 3:
                    cart.displayCart();
                        System.out.print("\nEnter the Product ID to remove: ");
                        String productID = sc.next();
                        System.out.print("\nEnter the quantity to remove: ");
                        double quantity = sc.nextDouble();
                        cart.removeProduct(productID, quantity);
                    break;

                case 4:
                    System.out.println("\nTotal: " + cart.calculateTotal());
                    double totalAmount = cart.calculateTotal();
                    double PayIT = totalAmount;

                    while (PayIT > 0) {
                        System.out.println("\nAmount remaining: " + PayIT);
                        System.out.print("\nEnter the amount to pay: ");
                        double amount = sc.nextDouble();

                        if (amount >= PayIT) {
                            double change = amount - PayIT;
                            if (change > 0) {
                                System.out.println("\nTransaction successful! Your change: " + (int)change);
                                System.out.println("\nPress any key to continue");
                                Scanner scn = new Scanner(System.in);
                                scn.nextLine();
                            } else {
                                System.out.println("\nTransaction successful! Have a Nice Day");
                                System.out.println("\nPress any key to continue");
                                Scanner scn = new Scanner(System.in);
                                scn.nextLine();
                            }
                            System.exit(0);
                        } else {
                            PayIT -= amount;
                            System.out.println("\nPartial payment accepted. Pure Dede Gareeb.");
                            System.out.println("\nPress any key to continue");
                            Scanner scn = new Scanner(System.in);
                            scn.nextLine();
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid Selection\n");
                    System.out.println("\nPress any key to continue");
                    Scanner scn = new Scanner(System.in);
                    scn.nextLine();
            }
        }
    }

    public static void displayProducts(Product[] products, Cart cart) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i].getName());
            }
            System.out.print((products.length+1)+". Go Back\n\nSelect an Option to Check Product Description: ");
            int prodmenu = sc.nextInt();
            if (prodmenu > 0 && prodmenu <= products.length) {
                Product selectedProduct = products[prodmenu - 1];
                while (true) {
                    selectedProduct.showDetails();
                    selectedProduct.additionalInfo();
                    System.out.print("\n1. Add to Cart\n2. Go Back\n\nSelect an Option: ");
                    int addmenu = sc.nextInt();
                    if(addmenu == 1) {
                        System.out.print("\nEnter Quantity: ");
                        double quantityprod = sc.nextDouble();
                        cart.addProduct(selectedProduct, quantityprod);
                    }
                    else if(addmenu == 2) {
                        break;
                    }
                }
            } else if (prodmenu == (products.length+1)) {
                break;
            } else {
                System.out.println("\nInvalid Selection\n");
                System.out.println("\nPress any key to continue");
                Scanner scn = new Scanner(System.in);
                scn.nextLine();
            }
        }
    }
}