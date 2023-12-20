package mainpackage;

import javafx.fxml.FXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerPayment {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerPayment.class);

    // SceneSwitcher
    @FXML
    public void logout(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to Login");
    }

    @FXML
    public void changeToDrinks(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
        logger.info("Welcome to Drinks");
    }

    @FXML
    public void changeToBasket(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.BASKET, "Basket");
        logger.info("Welcome to the basket.");
    }
}
