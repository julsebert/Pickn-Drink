package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // Eigenschaften
    private List<Drinks> order;
    private int orderID;
    private double finalPrice = 0;

    // Konstruktor
    Order() {
        order = new ArrayList<>();
    }

    // Methoden
    public void addDrink(Drinks drink){
        order.add(drink);
    }

    private void removeDrink(Drinks drink){
        order.remove(drink);
    }

    private List<Drinks> getDrinks() {
        return order;
    }


    //jedes Objekt wird gefiltert, bekommt die Variable
    //drinks (vorübergehend), dann wird für das Objekt der Preis geholt
    // danach verworfen, geht zum nächsten Objekt
    private double calculatePrice(){
        order.stream()
                .map(Drinks::getPrice)
                .map(preis -> finalPrice + preis);       // wird direkt auf finalPrice draufgerechnet

        return finalPrice;
    }

}
