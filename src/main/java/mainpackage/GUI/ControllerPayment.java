package mainpackage.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerPayment implements Initializable {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerPayment.class);

    // Verknüpfung zu FXML
    @FXML
    private Label randomID;
    @FXML
    private ProgressBar timer;

    // SceneSwitcher
    @FXML
    private void logout(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to Login");
    }

    @FXML
    private void changeToDrinks(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
        logger.info("Welcome to Drinks");
    }

    @FXML
    private void changeToBasket(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.BASKET, "Basket");
        logger.info("Welcome to the basket.");
    }

    // Methoden

    // Beim Laden der Scene wird direkt eine random ID generiert
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ID-Nummer wird zu Beginn direkt generiert
        setRandomNumber();

        // ProgressBar wird auf 75 % gesetzt
        timer.setProgress(0.75);
        logger.info("PaymentScene has been initialized");
    }

    // Methode, um eine zufällige 5-stellige Ganzzahl zu generieren
    private int generateRandomNumber() {
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        logger.info("Random Number has been created.");
        return random.nextInt(max - min + 1) + min;
    }

    // Setzen der zufälligen Zahl im Label
    private void setRandomNumber() {
        int randomNumber = generateRandomNumber();
        randomID.setText("#" + String.format("%05d", randomNumber));
        logger.info("Random Number for the Order-ID");
    }
}
