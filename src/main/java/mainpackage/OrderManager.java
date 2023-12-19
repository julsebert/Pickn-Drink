package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    // Eigenschaften
    private static final List<Drinks> orderItems = new ArrayList<>(); //static??
    private double finalPrice = 0;

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


    //jedes Objekt wird gefiltert, bekommt die Variable
    //drinks (vorübergehend), dann wird für das Objekt der Preis geholt
    // danach verworfen, geht zum nächsten Objekt
    private double calculatePrice(){
        orderItems.stream()
                .map(Drinks::getPrice)
                .map(preis -> finalPrice + preis);       // wird direkt auf finalPrice draufgerechnet

        return finalPrice;
    }

}
