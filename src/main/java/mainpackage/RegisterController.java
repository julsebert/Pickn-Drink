package mainpackage;
import javafx.fxml.FXML;
public class RegisterController {

    @FXML
    public void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
    }


}
