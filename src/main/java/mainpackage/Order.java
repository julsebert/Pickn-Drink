package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Drinks> order = new ArrayList<>();
    private int orderID;
    private double finalPrice = 0;



    private void addDrink(Drinks drink){
        order.add(drink);
    }

    private void removeDrink(Drinks drink){
        order.remove(drink);
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
