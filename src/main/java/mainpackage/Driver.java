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

public class Driver {
    private static Logger logger = LogManager.getLogger(Driver.class);


    public static void main(String[] args) {

        try {

        }catch(Exception e){
            logger.error("Something happened :/", e);

        }
    }
}
