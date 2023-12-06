package mainpackage;
import javafx.fxml.FXML;
public class ControllerRegister {

    @FXML
    public void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
    }


}
