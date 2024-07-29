
import java.util.*; //for Scanner Array list

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Pizza Shop!");
        System.out.print("Is this a delivery order? (yes/no): ");
        String deliveryChoice = input.next();
        boolean isDelivery = deliveryChoice.equalsIgnoreCase("yes"); // to find gold customer or not

        System.out.println("Is the customer a Gold customer? (yes/no):");
        String customerType = input.next();

        if (customerType.equalsIgnoreCase("yes")) {
            System.out.println("You are our gold customer you will receive our promotion messages");
        } else {
            System.out.println("Be our gold customer for get our promotion messages");
        }

      //  Topping topping = new Topping(customerType, 0);
        // PizzaOrder order = new PizzaOrder( isDelivery);
// veg topping list
        List<Topping> vegToppings = new ArrayList<>();
        vegToppings.add(new Topping("Olives", 250.00));
        vegToppings.add(new Topping("Mushrooms", 100.00));
        vegToppings.add(new Topping("Onions", 50.00));
        vegToppings.add(new Topping("Extra cheese", 250.00));
        vegToppings.add(new Topping("Extra Spices", 105.00));
        vegToppings.add(new Topping("Tomato", 75.00));
        vegToppings.add(new Topping("Peppers", 125.00));
        vegToppings.add(new Topping("Corn", 175.00));
//non veg topping list
        List<Topping> nonVegToppings = new ArrayList<>();
        nonVegToppings.add(new Topping("Pepperoni", 175.00));
        nonVegToppings.add(new Topping("Bacon", 350.00));
        nonVegToppings.add(new Topping("Beef", 275.00));
        nonVegToppings.add(new Topping("Chicken", 250.00));
        nonVegToppings.add(new Topping("Sausages", 175.00));
        nonVegToppings.add(new Topping("Sea Foods", 350.00));
        nonVegToppings.add(new Topping("Eggs", 75.00));
        nonVegToppings.add(new Topping("Extra Cheese", 250.00));
        nonVegToppings.add(new Topping("Extra Spices", 105.00));
        nonVegToppings.add(new Topping("Mushrooms", 100.00));
        nonVegToppings.add(new Topping("Tomato", 75.00));
        nonVegToppings.add(new Topping("Peppers", 125.00));
        nonVegToppings.add(new Topping("Corn", 175.00));
        nonVegToppings.add(new Topping("Onions", 50.00));

        System.out.print("Choose your pizza and topping type (Veg/Non-Veg): ");// get input for veg or non veg pizza

        String Choice = input.next();

        List<Topping> selectedToppings;
        if (Choice.equalsIgnoreCase("veg")) {
            selectedToppings = vegToppings;
        } else if (Choice.equalsIgnoreCase("non-veg")) {
            selectedToppings = nonVegToppings;
        } else {
            System.out.println("Invalid choice. Please select veg or non-veg toppings.");
            input.close();
            return;
        }

        //double totalToppingCost = 0.00;
        System.out.println("Available toppings:");
        for (int i = 0; i < selectedToppings.size(); i++) {
            System.out.println((i + 1) + ". " + selectedToppings.get(i).getName() +
                    " - RS." + selectedToppings.get(i).getCost());
          
           
        }
        System.out.print("Enter your preferred toppings (ex:1,2,3,4): ");
        String toppingsInput = input.next();

        double totalToppingCost = 0.00;
       
        String[] selectedToppingInputs = toppingsInput.split(",");
        for (String index : selectedToppingInputs) {
            int toppingIndex = Integer.parseInt(index) - 1;
            if (toppingIndex >= 0 && toppingIndex < selectedToppings.size()) {
                totalToppingCost += selectedToppings.get(toppingIndex).getCost();
              //  System.out.println("Your total cost for selected toppings: "+totalToppingCost); // show cost for selected toppings 
            }
        }
        List<Beverage> beverages = new ArrayList<>();
        // beverage list
        beverages.add(new Beverage("Coke", 150.00));
        beverages.add(new Beverage("Sprite", 175.00));
        beverages.add(new Beverage("Iced Tea", 100.00));
        beverages.add(new Beverage("Coke Zero", 150.00));
        beverages.add(new Beverage("Sparkling Water", 125.00));
        beverages.add(new Beverage("Iced Americano", 100.00));
        beverages.add(new Beverage("Water", 20.00));


        System.out.print("Would you like any beverage? (yes/no): ");
        String beverageChoice = input.next();

        double totalBeveragesCost = 0.00;
        if (beverageChoice.equalsIgnoreCase("yes")) {

            System.out.println("Available beverages:");
            for (int i = 0; i < beverages.size(); i++) {
                System.out.println((i + 1) + ". " + beverages.get(i).getName() +
                        " - RS." + beverages.get(i).getCost());
            }

            System.out.print("Enter your preferred beverages (e.g., 1,2,3,4): ");
            String beverageInputs = input.next();
            String[] selectedBeverageInputs = beverageInputs.split(",");

            for (String index : selectedBeverageInputs) {
                int beverageIndex = Integer.parseInt(index) - 1;
                if (beverageIndex >= 0 && beverageIndex < beverages.size()) {
                    totalBeveragesCost += beverages.get(beverageIndex).getCost();
                 //   System.out.println("Your total cost for selected beverages: "+totalBeveragesCost);//show cost for beverages
                }
            }
        }
        double deliveryOderTotalCost = 0.00;
        double mainPrice = 3000.00;//the main price of every veg and non veg pizza
        double totalCost = mainPrice + totalToppingCost + totalBeveragesCost;

        // for charge delivery charges when the oder is delivery oder
        if (isDelivery) {
            deliveryOderTotalCost = totalCost + 400.00;
            System.out.println("Total price of your oder with delivery charge:" + deliveryOderTotalCost);

        } else {

            System.out.println("Total price of your  order: RS. " + totalCost);//total cost for normal pick up oder
        }

        //to give discount customers who has total price more than rs.5000
        if (totalCost > 5000) {
            totalCost = totalCost * 0.8;
            System.out.println("You got 20% discount your new price is:RS. " + totalCost);
        }
//for count pizzas
        PizzaCount pizzaCount = new PizzaCount();
        pizzaCount.pizzaCounter();
        System.out.println("The number of pizzas made today: "+pizzaCount.getTotalPizzas());

        input.close();

    }
}
