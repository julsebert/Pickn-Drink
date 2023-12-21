package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Objects;

public class Driver extends Application{

    // Logger
    private static final Logger logger = LogManager.getLogger(Driver.class);

    // main-Methode
    public static void main(String[] args) {
        try {
            launch(args);
        }catch(Exception e){
            logger.error("Something happened :/", e);
        }
    }

    // start-Methode
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("login.fxml");
        // FXML Datei wird geladen
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));

        Scene login = new Scene(root, 400,680);
        login.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("styles.css")).toExternalForm());

        SceneSwitcher.getInstance().setPrimaryStage(primaryStage);

        primaryStage.setScene(login);
        primaryStage.setTitle("Pick 'n Drink");
        primaryStage.setWidth(400);
        primaryStage.setHeight(680);
        // Größe der Stage

        primaryStage.show();
        // dem User die Stage zeigen

        logger.info("Switching to the new scene.");
    }
}
