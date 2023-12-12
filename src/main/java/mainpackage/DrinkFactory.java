package mainpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DrinkFactory {
    public DrinkFactory(){
        initDrinks();
        logger.info("You created the DrinksList");
    }

    private static Logger logger = LogManager.getLogger(Driver.class);

    private static Map<String, Drinks> drinks = new HashMap<>();
    // HashMaps speichern key/value Paare in einer ArrayList
    // Hier: key -> Name des Getränks Typ String, value -> drinks-Objekt mit allen Daten

    public static void initDrinks(){

        // Drinks mit der Category: COCKTAILS
        drinks.put("Himbeermojito", new Drinks("Himbeermojito", "Rum Havana Club, weißer Rohrzucker, Limettensaft, Minze, Himbeeren", 8, Category.COCKTAILS));
        drinks.put("Aperol Sour", new Drinks("Aperol Sour", "Aperol, Zitronensaft, Zuckersirup, Orangenspalte" , 6, Category.COCKTAILS));
        drinks.put("Whiskey Sour", new Drinks("Whiskey Sour" , "Bourbon Whiskey, Zitronensaft, Zuckersirup", 8, Category.COCKTAILS));
        drinks.put("Watermelon Man", new Drinks("Watermelon Man", "Wassermelonenlikör, Grenadinesirup, Zitronensaft, Orangensaft, Wodka", 8, Category.COCKTAILS));
        drinks.put("Long Island IceTea", new Drinks("Long Island IceTea" , "weißer Rum, Orangenlikör, Wodka, Tequila, Gin, Limettensaft, Zuckersirup, Cola", 10, Category.COCKTAILS));
        drinks.put("Espresso Martini", new Drinks("Espresso Martini", "Gin, Creme de Moka, Espresso", 10, Category.COCKTAILS));
        drinks.put("Jäger Bomb", new Drinks("Jäger Bomb","Jägermeister, Energy" ,7, Category.COCKTAILS));
        drinks.put("Sommerschorle", new Drinks("Sommerschorle", "Weinschorle, Minze, Holunderblütensirup", 4, Category.COCKTAILS));

        // Drinks mit der Category: SHOTS
        drinks.put("Tequila", new Drinks("Tequila", "Tequila, Zitrone, Salz", 2, Category.SHOTS));
        drinks.put("Mexikaner", new Drinks("Mexikaner", "Tomatensaft, Korn, Tabascosauce, Zitronensaft, Salz, Pfeffer", 2, Category.SHOTS));
        drinks.put("Berliner Luft", new Drinks("Berliner Luft", "Berliner Luft", 2, Category.SHOTS));
        drinks.put("Schüttler", new Drinks("Schüttler", "blue curacao Likör, Zitronensaft", 2, Category.SHOTS));
        drinks.put("Taj Mahal", new Drinks("Taj Mahal", "Bols Likör, Joghurt, Maracujasaft", 2, Category.SHOTS));

        // Drinks mit der Category: DRIVERSDRINK
        drinks.put("Cola", new Drinks("Cola", "Cola", 4, Category.DRIVERSDRINKS));
        drinks.put("Orangensaft", new Drinks("Orangensaft", "Orangensaft", 4, Category.DRIVERSDRINKS));
        drinks.put("Ice Tea", new Drinks("Ice Tea", "Ice Tea", 4, Category.DRIVERSDRINKS));
        drinks.put("Wasser", new Drinks("Wasser", "Wasser", 2, Category.DRIVERSDRINKS));
        drinks.put("Virgin Mojito", new Drinks("Virgin Mojito", "Limettensaft, Limettenschale, Minze, brauner Zucker, Limettensirup", 5, Category.DRIVERSDRINKS));

        logger.info("All drinks have been created.");
    }
    public static Drinks createDrink(String name){
        try{
            if (name == null || !drinks.containsKey(name)){
                throw new NullPointerException("The specified drink is not on the menu.");
            }
            return drinks.get(name);
        }
        catch (NullPointerException e){
            logger.error("The specified drink is not on the menu.", e);
            return null; // so o.k?
        }
        // Exception einfügen, falls es das Getränk nicht gibt --> vielleicht hier eigene Exception erstellen
    };

    public static Collection<Drinks> getAllDrinks () {
        return drinks.values();
    }
    // über ID kann dann bei der XML Drinks die Liste aufgeführt werden mit dieser Methode,


}
