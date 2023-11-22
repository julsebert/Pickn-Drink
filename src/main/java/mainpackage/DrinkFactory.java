package mainpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrinkFactory {

    private static Logger logger = LogManager.getLogger(Driver.class);

    public static Cocktails pickCocktail(CocktailType type){

        switch(type){

            case HIMBEERMOJITO: logger.info("Creating " + CocktailType.HIMBEERMOJITO + " instance");
                return new Cocktails();
            case APEROLSOUR: logger.info("Creating " + CocktailType.APEROLSOUR + " instance");
                return new Cocktails();
            case WHISKEYSOUR:  logger.info("Creating " + CocktailType.WHISKEYSOUR + " instance");
                return new Cocktails();
            case WATERMELONMAN: logger.info("Creating " + CocktailType.WATERMELONMAN + " instance");
                return new Cocktails();
            case LONGISLANDICETEA: logger.info("Creating " + CocktailType.LONGISLANDICETEA + " instance");
                return new Cocktails();
            case ESPRESSOMARTINI: logger.info("Creating " + CocktailType.ESPRESSOMARTINI + " instance");
                return new Cocktails();
            case JAEGERBOMB: logger.info("Creating " + CocktailType.JAEGERBOMB + " instance");
                return new Cocktails();
            case SOMMERSCHORLE: logger.info("Creating " + CocktailType.SOMMERSCHORLE + " instance");
                return new Cocktails();
            default: logger.error("Cocktail doesn't exist, please pick another one!");
                return null;

        }

        /*if (type == CocktailType.HIMBEERMOJITO) {
            logger.info("Creating " + CocktailType.HIMBEERMOJITO + " instance");
            return new Cocktails();
        } else if (type == CocktailType.APEROLSOUR) {
            logger.info("Creating " + CocktailType.APEROLSOUR + " instance");
            return new Cocktails();
        } else if (type == CocktailType.WHISKEYSOUR) {
            logger.info("Creating " + CocktailType.WHISKEYSOUR + " instance");
            return new Cocktails();
        } else if (type == CocktailType.WATERMELONMAN) {
            logger.info("Creating " + CocktailType.WATERMELONMAN + " instance");
            return new Cocktails();
        } else if (type == CocktailType.LONGISLANDICETEA) {
            logger.info("Creating " + CocktailType.LONGISLANDICETEA + " instance");
            return new Cocktails();
        } else if (type == CocktailType.ESPRESSOMARTINI) {
            logger.info("Creating " + CocktailType.ESPRESSOMARTINI + " instance");
            return new Cocktails();
        } else if (type == CocktailType.JAEGERBOMB) {
            logger.info("Creating " + CocktailType.JAEGERBOMB + " instance");
            return new Cocktails();
        } else if (type == CocktailType.SOMMERSCHORLE) {
            logger.info("Creating " + CocktailType.SOMMERSCHORLE + " instance");
            return new Cocktails();
        }
        logger.error("Cocktail doesn't exist, please pick another one!");
        return null;

         */


    }


}
