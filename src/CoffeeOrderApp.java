import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Coffee {
    private String name;
    private String[] ingredients;

    public Coffee(String name, String[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}

class CoffeeShop {
    private Map<Integer, Coffee> menu;

    public CoffeeShop() {
        menu = new HashMap<>();
        menu.put(1, new Coffee("Espresso", new String[]{"Espresso"}));
        menu.put(2, new Coffee("Double Espresso", new String[]{"2x Espresso"}));
        menu.put(3, new Coffee("Cappuccino", new String[]{"Espresso", "Steamed Milk", "Milk Foam"}));
        menu.put(4, new Coffee("Caffe Latte", new String[]{"Espresso", "2x Steamed Milk", "Milk Foam"}));
        menu.put(5, new Coffee("Mocha", new String[]{"Espresso", "Steamed Milk", "Milk Foam", "2x Hot Chocolate"}));
        menu.put(6, new Coffee("Americano", new String[]{"Espresso", "4x Hot Water"}));
        menu.put(7, new Coffee("Hot Water", new String[]{"5x Hot Water"}));
        
    }
    
    	

    public void displayMenu() {
        System.out.println("Coffe Menu:");
        for (Map.Entry<Integer, Coffee> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }

    public void orderCoffee(int coffeeNumber) {
        if (menu.containsKey(coffeeNumber)) {
            Coffee coffee = menu.get(coffeeNumber);
            String[] ingredients = coffee.getIngredients();
            System.out.println("Thank You ! " + coffee.getName() + " chosen.");
            System.out.println("---------------------------");
            System.out.println(coffee.getName() + " is getting ready. This drink has:");

            for (String ingredient : ingredients) {
                System.out.println("- " + ingredient);
            }
            
        	
            System.out.println("included.");
            System.out.println("Enjoy your meal!");
            System.out.println("---------------------------");
        } else {
            System.out.println("Invalid coffee number.");
        }
    }
}

public class CoffeeOrderApp {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our Coffee Shop");
        System.out.println("---------------------------");
        System.out.println( "Please choose one of the following coffee numbers:");
        coffeeShop.displayMenu();

        int coffeeNumber = scanner.nextInt();
        coffeeShop.orderCoffee(coffeeNumber);

        scanner.close();
    }
}
