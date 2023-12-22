package mainpackage.GUI;

import javafx.fxml.FXML;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ControllerLogin {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerLogin.class);

    // SceneSwitcher
    @FXML
    public void changeToDrinks(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
        logger.info("Welcome to Drinks.");
    }

    @FXML
    public void changeToRegister(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.REGISTER, "Register");
        logger.info("Now you can sign in.");
    }
}
