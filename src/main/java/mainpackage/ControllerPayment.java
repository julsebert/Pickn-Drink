package mainpackage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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

    // Methoden

    // Beim Laden der Scene wird direkt eine random ID generiert
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ID-Nummer wird zu Beginn direkt generiert
        setRandomNumber();

        // ProgressBar wird auf 75 % gesetzt
        timer.setProgress(0.75);
    }

    // Methode, um eine zufällige 5-stellige Ganzzahl zu generieren
    private int generateRandomNumber() {
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        return random.nextInt(max - min + 1) + min;
    }

    // Setzen der zufälligen Zahl im Label
    public void setRandomNumber() {
        int randomNumber = generateRandomNumber();
        randomID.setText("#" + String.format("%05d", randomNumber));
    }
}
