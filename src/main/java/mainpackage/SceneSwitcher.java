package mainpackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class SceneSwitcher {
    private Stage primaryStage = null;

    public static final String LOGIN = "login.fxml";
    public static final String REGISTER = "Register.fxml";
    public static final String DRINKS = "drinks.fxml";

    public static final String BASKET = "basket.fxml";
    public static final String CURRENT_ORDER = "currentOrder.fxml";
    public static final String PAYMENT = "payment.fxml";


    private static SceneSwitcher instance;

    private SceneSwitcher(){
        super();
    }


    public static SceneSwitcher getInstance(){
        if (instance == null){
            instance = new SceneSwitcher();
        }
        return instance;
    }

    public void setPrimaryStage(Stage primarayStage) {
        this.primaryStage = primarayStage;
    }

    public void switchScene(String scenePath, String windowTitle){

        try {
            URL fxmlFileUrl = getClass().getClassLoader().getResource(scenePath);
            Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
            primaryStage.setTitle(windowTitle);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException("Scene path not found: " + scenePath, e);
        }
    }

}
