package mainpackage.Logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DrinkFactory {

    // Logger
    private static final Logger logger = LogManager.getLogger(DrinkFactory.class);

    private static final Map<String, IDrinks> drinks = new HashMap<>();
    // HashMaps speichern key/value Paare in einer ArrayList
    // Hier: key -> Name des Getränks Typ String, value -> drinks-Objekt mit allen Daten


    // Methoden

    // Methode initialisiert die einzelnen Getränke. Hier können Getränke zu der Karte hinzugefügt oder weggenommen werden.
    public static void initDrinks(){

        // Drinks mit der Category: COCKTAILS
        drinks.put("Himbeermojito", new Drinks("Himbeermojito", "Havana Club rum, white cane sugar, lime juice, mint, raspberries", 8, Category.COCKTAILS, "/Himbeermojito.png"));
        drinks.put("Aperol Sour", new Drinks("Aperol Sour", "Aperol, lemon juice, sugar syrup, orange wedge" , 6, Category.COCKTAILS, "/AperolSour.png"));
        drinks.put("Whiskey Sour", new Drinks("Whiskey Sour" , "Bourbon whiskey, lemon juice, sugar syrup", 8, Category.COCKTAILS, "/WhiskeySour.png"));
        drinks.put("Watermelon Man", new Drinks("Watermelon Man", "Watermelon liqueur, grenadine syrup, lemon juice, orange juice, vodka", 8, Category.COCKTAILS, "/WatermelonMan.png"));
        drinks.put("Long Island IceTea", new Drinks("Long Island IceTea" , "white rum, orange liqueur, vodka, tequila, gin, lime juice, sugar syrup, cola", 10, Category.COCKTAILS, "/LongIslandIceTea.png"));
        drinks.put("Espresso Martini", new Drinks("Espresso Martini", "Gin, crème de moka, espresso", 10, Category.COCKTAILS, "/EspressoMartini.png"));
        drinks.put("Jäger Bomb", new Drinks("Jäger Bomb","Jägermeister, Energy" ,7, Category.COCKTAILS, "/Jägerbomb.png"));
        drinks.put("Sommerschorle", new Drinks("Sommerschorle", "Wine, soda, mint, lime, elderflower syrup", 4, Category.COCKTAILS, "/Sommerschorle.png"));

        // Drinks mit der Category: SHOTS
        drinks.put("Tequila", new Drinks("Tequila", "Tequila, lemon, salt", 2, Category.SHOTS, "/Tequila.png"));
        drinks.put("Mexikaner", new Drinks("Mexikaner", "Tomato juice, corn, Tabasco sauce, lemon juice, salt, pepper", 2, Category.SHOTS, "/Mexi.png"));
        drinks.put("Berliner Luft", new Drinks("Berliner Luft", "Berliner Luft", 2, Category.SHOTS, "/BerlinerLuft.png"));
        drinks.put("Schüttler", new Drinks("Schüttler", "blue curacao liqueur, lemon juice", 2, Category.SHOTS, "/Schüttler.png"));
        drinks.put("Taj Mahal", new Drinks("Taj Mahal", "Bols liqueur, yogurt, passion fruit juice", 2, Category.SHOTS, "/TajMahal.png"));

        // Drinks mit der Category: DRIVERSDRINK
        drinks.put("Cola", new Drinks("Cola", " ", 4, Category.DRIVERSDRINKS, "/Cola.png"));
        drinks.put("Orangensaft", new Drinks("Orangensaft", " ", 4, Category.DRIVERSDRINKS, "/Orangensaft.png"));
        drinks.put("Ice Tea", new Drinks("Ice Tea", " ", 4, Category.DRIVERSDRINKS, "/Eistee.png"));
        drinks.put("Wasser", new Drinks("Wasser", " ", 2, Category.DRIVERSDRINKS, "/Wasser.png"));
        drinks.put("Virgin Mojito", new Drinks("Virgin Mojito", "Lime juice, lime zest, mint, brown sugar, lime syrup", 5, Category.DRIVERSDRINKS, "/VirginMojito.png"));

        logger.info("All drinks have been created.");
    }

    // Methode dient dazu die Inhalte der HashMap auszugeben
    public static Collection<IDrinks> getAllDrinks () {
        return new LinkedList<>(drinks.values());
    }

    // Methode wird hier nicht genutzt, dient aber der Erweiterbarkeit der DrinkFactory
    public static IDrinks createDrink(String name){
        try{
            if (name == null || !drinks.containsKey(name)){
                throw new NullPointerException("The specified drink is not on the menu.");
            }
            logger.info(drinks.get(name) + "has been created");
            return drinks.get(name);
        }
        catch (NullPointerException e){
            logger.error("The specified drink is not on the menu.", e);
            return null;
        }
        // Exception einfügen, falls es das Getränk nicht gibt --> vielleicht hier eigene Exception erstellen
    }
}
