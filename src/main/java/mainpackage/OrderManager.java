package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    // Eigenschaften
    private static final List<Drinks> orderItems = new ArrayList<>(); //static??


    // Methoden
    public void addDrink(Drinks drink) {
        orderItems.add(drink);
    }
    public void removeDrink(Drinks drink) {
        orderItems.remove(drink);
    }
    public static List<Drinks> getOrderItems() {
        return orderItems;
    } // static??
    public void clearOrder() {
        orderItems.clear();
    }

    // in folgender Methode wird berechnet, wie oft das Getränk bestellt wurde
    public int getCount(Drinks drink) {
        int count = 0;
        for (Drinks item : orderItems) {
            if (item.equals(drink)) {
                count++;
            }

        }

        return count;

    }

    // Berechnet den Preis für die Anzahl an gleichen Getränken
    public double getPriceForIdenticalDrinks(Drinks drink){
        return getCount(drink) * drink.getPrice();
    }

}
