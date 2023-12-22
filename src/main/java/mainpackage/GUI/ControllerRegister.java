package mainpackage.GUI;
import javafx.fxml.FXML;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerRegister {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerRegister.class);

    @FXML
    public void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("Welcome to Login.");
    }


}
