package SWED.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {

    public static void main(String[] args) {
        Client client = new Client();
        client.order();
    }
}

class Client {
    MealCourseOne mealCourseOne;
    MealCourseTwo mealCourseTwo;

    public Client() {
        mealCourseOne = new MealCourseOne();
        mealCourseTwo = new MealCourseTwo();
    }

    public void order() {
        System.out.println("Welcome to the Restaurant!");
        System.out.println("Here is the menu: ");
        Menu menu = new Menu();
        menu.printMenu();
        mealCourseOne.buildMainDish();
        mealCourseOne.buildBeverage();
        mealCourseOne.getMeal().displayMeal();
        mealCourseOne.getMeal().getPrice();
        mealCourseTwo.buildMainDish();
        mealCourseTwo.buildBeverage();
        mealCourseTwo.getMeal().displayMeal();
        mealCourseTwo.getMeal().getPrice();
    }

}

class MealCourseOne implements MealBuilder {
    Meal meal = new Meal();

    public void buildMainDish() {
        MainDish mainDish = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose your main dish: ");
            String dishName = scanner.nextLine();
            MainDishFactory dishFactory = new MainDishFactory();
            mainDish = dishFactory.getMainDish(dishName);
            if (mainDish != null) {
                System.out.println("Do you want salt or no salt? Y or N");
                String hasSalt = scanner.nextLine();
                if (hasSalt.equals("Y")) {
                    System.out.println(mainDish.getName() + " " + mainDish.getPrice());
                    break;
                } else if (hasSalt.equals("N")) {
                    mainDish.computePriceNoSalt();
                    System.out.println(mainDish.getName() + " " + mainDish.getPrice());
                    break;
                } else {
                    System.out.println("Wrong type");
                }
            } else {
                System.out.println("Wrong name");
            }
        }
        meal.addMainDish(mainDish);
    }

    public void buildBeverage() {
        Beverage beverage = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose your beverage: ");
            String beverageName = scanner.nextLine();
            BeverageFactory beverageFactory = new BeverageFactory();
            beverage = beverageFactory.getBeverage(beverageName);
            scanner.close();
            if (beverage != null) {
                System.out.println(beverage.getName() + " " + beverage.getPrice());
                break;
            } else {
                System.out.println("Wrong name, Please input again");
            }
        }
        meal.addBeverage(beverage);
    }

    public void reset() {
        meal = new Meal();
    }

    public Meal getMeal() {
        return meal;
    }
}

class MealCourseTwo implements MealBuilder {
    Meal meal;

    public void buildMainDish() {
        MainDish mainDish;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose your main dish: ");
            String dishName = scanner.nextLine();
            scanner.close();
            MainDishFactory dishFactory = new MainDishFactory();
            mainDish = dishFactory.getMainDish(dishName);
            if (mainDish != null) {
                System.out.println("Do you want salt or no salt? Y or N");
                String hasSalt = scanner.nextLine();
                if (hasSalt.equals("Y")) {
                    System.out.println(mainDish.getName() + " " + mainDish.getPrice());
                    break;
                } else if (hasSalt.equals("N")) {
                    mainDish.computePriceNoSalt();
                    System.out.println(mainDish.getName() + " " + mainDish.getPrice());
                    break;
                } else {
                    System.out.println("Wrong type");
                }
            } else {
                System.out.println("Wrong name");
            }
        }
        meal.addMainDish(mainDish);
    }

    public void buildBeverage() {
        Beverage beverage = null;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose your beverage: ");
            String beverageName = scanner.nextLine();
            BeverageFactory beverageFactory = new BeverageFactory();
            beverage = beverageFactory.getBeverage(beverageName);
            if (beverage != null) {
                scanner.close();
                System.out.println(beverage.getName() + " " + beverage.getPrice());
                break;
            } else {
                System.out.println("Wrong name, Please input again");
            }
        }
        meal.addBeverage(beverage);
    }

    public void reset() {
        meal = new Meal();
    }

    public Meal getMeal() {
        return meal;
    }
}

interface Item {
    public String getName();

    public double getPrice();
}

class Menu {
    private ArrayList<Item> dishes = new ArrayList<Item>();
    private DishFactory dishFactory = new DishFactory();
    private String[] dishNames = { "ChickenBurger", "VegetableBurger", "Coke", "Pepsi", "Flan", "Fruit" };

    public ArrayList<Item> getDishes() {
        return dishes;
    }

    public void printMenu() {
        for (int i = 0; i < dishNames.length; i++) {
            dishes.add(dishFactory.getDish(dishNames[i]));
        }
        for (Item dish : dishes) {
            System.out.println(dish.getName() + " " + dish.getPrice() + "\n");
        }
    }
}

interface MealBuilder {
    public void reset();

    public void buildMainDish();

    public void buildBeverage();

    // public void buildDessert();

    public Meal getMeal();

}

class Meal {
    private ArrayList<Item> dishes = new ArrayList<Item>();

    private MainDish mainDish;
    private Beverage beverage;
    private Dessert dessert;

    public Meal(MainDish mainDish, Beverage beverage, Dessert dessert) {
        this.mainDish = mainDish;
        this.beverage = beverage;
        this.dessert = dessert;
    }

    public Meal() {
    }

    public void addMainDish(MainDish mainDish) {
        this.mainDish = mainDish;
    }

    public void addBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void addDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void displayMeal() {
        System.out.println("Your meal consists of: ");
        System.out.println(mainDish.getName());
        if (beverage != null) {
            System.out.println(beverage.getName());
        }
        if (dessert != null) {
            System.out.println(dessert.getName());
        }
    }

    public void getPrice() {
        double price = 0;
        System.out.println("The price of your meal is: ");
        price += mainDish.getPrice();
        if (beverage != null) {
            price += beverage.getPrice();
        }
        if (dessert != null) {
            price += dessert.getPrice();
        }
        System.out.println("Total price of your meal is: " + price);
    }
}

class MainDish implements Item {
    private String name;
    private double price;

    public MainDish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void computePriceNoSalt() {
        price = price * 0.9;
    }
}

class ChickenBurger extends MainDish {
    public ChickenBurger() {
        super("ChickenBurger", 50.0);
    }
}

class VegetableBurger extends MainDish {
    public VegetableBurger() {
        super("VegetableBurger", 25.0);
    }
}

class Beverage implements Item {
    private String name;
    private double price;

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Coke extends Beverage {
    public Coke() {
        super("Coke", 10.0);
    }
}

class Pepsi extends Beverage {
    public Pepsi() {
        super("Pepsi", 12.0);
    }
}

class Dessert implements Item {
    private String name;
    private double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Flan extends Dessert {
    public Flan() {
        super("Flan", 10.0);
    }
}

class Fruit extends Dessert {
    public Fruit() {
        super("Fruit", 15.0);
    }
}

class DishFactory {
    public Item getDish(String dish) {
        if (dish.equals("ChickenBurger")) {
            return new ChickenBurger();
        } else if (dish.equals("VegetableBurger")) {
            return new VegetableBurger();
        } else if (dish.equals("Coke")) {
            return new Coke();
        } else if (dish.equals("Pepsi")) {
            return new Pepsi();
        } else if (dish.equals("Flan")) {
            return new Flan();
        } else if (dish.equals("Fruit")) {
            return new Fruit();
        } else {
            return null;
        }
    }
}

class MainDishFactory {
    public MainDish getMainDish(String dish) {
        if (dish.equals("ChickenBurger")) {
            return new ChickenBurger();
        } else if (dish.equals("VegetableBurger")) {
            return new VegetableBurger();
        } else {
            return null;
        }
    }
}

class BeverageFactory {
    public Beverage getBeverage(String dish) {
        if (dish.equals("Coke")) {
            return new Coke();
        } else if (dish.equals("Pepsi")) {
            return new Pepsi();
        } else {
            return null;
        }
    }
}

class DessertFactory {
    public Dessert getDessert(String dish) {
        if (dish.equals("Flan")) {
            return new Flan();
        } else if (dish.equals("Fruit")) {
            return new Fruit();
        } else {
            return null;
        }
    }
}
