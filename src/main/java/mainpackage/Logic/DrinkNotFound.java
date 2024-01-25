package mainpackage.Logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrinkNotFound extends RuntimeException{

    // Logger
    private static final Logger logger = LogManager.getLogger(DrinkNotFound.class);

    // Methode
    public DrinkNotFound(String drinkName){

        super ("Drink Not Found: " + drinkName);
        logger.error("DrinkNotFound-Exception occured.");
    }
}
