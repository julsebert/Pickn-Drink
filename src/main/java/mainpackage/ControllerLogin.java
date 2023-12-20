package mainpackage;

import javafx.fxml.FXML;


public class ControllerLogin {

    // SceneSwitcher
    @FXML
    public void changeToDrinks(){
        System.out.println("Welcome to Drinks");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
    }

    @FXML
    public void changeToRegister(){
        System.out.println("Now you can sign in");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.REGISTER, "Register");
    }
}
