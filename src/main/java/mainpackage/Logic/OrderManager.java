package mainpackage.Logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderManager {

    // Logger
    private static final Logger logger = LogManager.getLogger(OrderManager.class);

    // Eigenschaften
    private final List<IDrinks> orderItems = new ArrayList<>();
    private static OrderManager instance;

    // Konstruktor
    private OrderManager(){
    }

    // Singleton -> Das Singleton ist ein in der Softwareentwicklung eingesetztes Entwurfsmuster und
    // gehört zur Kategorie der Erzeugungsmuster. Es stellt sicher, dass von einer Klasse genau ein Objekt
    // existiert. Dieses Singleton ist darüber hinaus üblicherweise global verfügbar.
    public static OrderManager getInstance(){
        if (instance == null){
            instance = new OrderManager();
            logger.info("Instance has been created.");
        }
        logger.info("Instance already exists.");
        return instance;
    }

    // Methoden
    public void addDrink(IDrinks drink) {
        logger.info("AddDrink was executed.");
        orderItems.add(drink);
    }
    public void removeDrink(IDrinks drink) {
        logger.info("RemoveDrink was executed.");
        orderItems.remove(drink);
    }
    public List<IDrinks> getOrderItems() {
        logger.info("GetOrderItems was executed.");
        return new LinkedList<>(orderItems);
    }
    public void clearOrder() {
        logger.info("ClearOrder was executed.");
        orderItems.clear();
    }

    // in folgender Methode wird berechnet, wie oft das Getränk bestellt wurde
    public int getCount(IDrinks drink) {
        int count = 0;
        for (IDrinks item : orderItems) {
            if (item.equals(drink)) {
                count++;
                logger.info("New count: "+ count);
            }
        }
        logger.info("The " + drink.getName() + " was counted " + count + " times.");
        return count;
    }

    // Berechnet den Preis für die Anzahl an gleichen Getränken
    public double getPriceForIdenticalDrinks(IDrinks drink){
        logger.info("The total price for " + drink.getName() + " has been calculated.");
        return getCount(drink) * drink.getPrice();
    }
}
