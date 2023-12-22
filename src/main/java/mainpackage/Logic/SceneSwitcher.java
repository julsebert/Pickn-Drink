package mainpackage.Logic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class SceneSwitcher {

    // Logger
    private static final Logger logger = LogManager.getLogger(SceneSwitcher.class);

    // Eigenschaften
    private Stage primaryStage = null;
    public static final String LOGIN = "login.fxml";
    public static final String REGISTER = "Register.fxml";
    public static final String DRINKS = "drinks.fxml";
    public static final String BASKET = "basket.fxml";
    public static final String PAYMENT = "payment.fxml";
    private static SceneSwitcher instance;

    // Konstruktor
    private SceneSwitcher(){
        super();
    }

    // Methoden
    public static SceneSwitcher getInstance(){
        if (instance == null){
            instance = new SceneSwitcher();
            logger.info("Instance has been created.");
        }
        logger.info("Instance already exists.");
        return instance;
    }

    public void setPrimaryStage(Stage primarayStage) {
        logger.info("Get primaryStage.");
        this.primaryStage = primarayStage;
    }

    public void switchScene(String scenePath, String windowTitle){

        try {
            URL fxmlFileUrl = getClass().getClassLoader().getResource(scenePath);
            Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
            primaryStage.setTitle(windowTitle);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("styles.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
            logger.info("Switching to the new scene.");
        } catch (IOException e) {
            logger.error("Scene path not found: " + scenePath, e);
            throw new RuntimeException("Scene path not found: " + scenePath, e);
        }
    }

}
