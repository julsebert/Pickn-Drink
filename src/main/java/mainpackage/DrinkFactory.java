package mainpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrinkFactory {

    private static Logger logger = LogManager.getLogger(Driver.class);

    public static Drinks createDrink(String name ){

        switch(name){

            case "Himbeermojito" : logger.info("Creating instance");
                return new Drinks("Himbeermojito", "Himbeere", 8, Category.COCKTAILS);
            case "Aperol Sour": logger.info("Creating instance");
                return new Drinks("Aperol Sour", "Säure" , 6, Category.COCKTAILS);
            case "Whiskey Sour":  logger.info("Creating instance");
                return new Drinks("Whiskey Sour" , "Säure", 8, Category.COCKTAILS);
            case "Watermelon Man": logger.info("Creating instance");
                return new Drinks("Watermelon Man", "Wassermelone", 8, Category.COCKTAILS);
            case "Long Island IceTea": logger.info("Creating instance");
                return new Drinks("Long Island IceTea" , "Tee", 10, Category.COCKTAILS);
            case "Espresso Martini": logger.info("Creating instance");
                return new Drinks("Espresso Martini", "Espresso und Alkoholll", 10, Category.COCKTAILS);
            case "Jäger Bomb": logger.info("Creating instance");
                return new Drinks("Jäger Bomb","Bomben" ,7, Category.COCKTAILS);
            case "Sommerschorle": logger.info("Creating instance");
                return new Drinks("Sommerschorle", "was Leon sagt", 4, Category.COCKTAILS);
            default: logger.error("Cocktail doesn't exist, please pick another one!");
                return null;

        }



    }


}
