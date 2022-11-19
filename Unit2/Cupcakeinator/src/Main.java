import java.util.ArrayList;
import java.util.Scanner;

class Cupcake{
    public double price;
    public String name;

    public Cupcake() {
        this.name = "Generic Cupcake";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake{
    public RedVelvet() {
        this.name = "Red Velvet";
    }

    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake{
    public Chocolate() {
        this.name = "Chocolate";
    }

    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

class Drink{
    public double price;
    public String name;

    public Drink() {
        this.name = "Water";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void type(){
        System.out.println("A bottle of water");
    }
}

class Soda extends Drink{
    public Soda() {
        this.setName("Soda");
    }

    @Override
    public void type() {
        System.out.println("A bottle of soda");
    }
}

class Milk extends Drink{
    public Milk() {
        this.setName("Milk");
    }

    @Override
    public void type() {
        System.out.println("A bottle of milk");
    }
}

public class Main {


    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. " +
                "We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        // Standard Cupcake
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);

        cupcake.setPrice(price);

        // RedVelvet
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the red velvet cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        // Chocolate
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the chocolate cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Drink water = new Drink();
        Drink soda = new Soda();
        Drink milk = new Milk();

        // Water
        System.out.println("\nWe are deciding on the price for our generic drink. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for a bottle of water? " +
                "(Input a numerical number taken to 2 decimal places)");

        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        water.setPrice(price);

        // soda
        System.out.println("We are deciding on the price for our soda. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for a bottle of soda? " +
                "(Input a numerical number taken to 2 decimal places)");

        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);

        // milk
        System.out.println("We are deciding on the price for our milk. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for a bottle of milk? " +
                "(Input a numerical number taken to 2 decimal places)");

        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu,drinkMenu);
    }
}