package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class ControllerLogin {

    /*@FXML
    private ImageView logo1;

     */
    /*@FXML
    public void initialize(){
        Image logo = new Image(getClass().getResourceAsStream("../resources/Logo.png"));
        logo1.setImage(logo);
    }

     */

    @FXML
    public void changeToDrinks(){

        System.out.println("Welcome to Drinks");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");

    }

    @FXML
    public void changeToRegister(ActionEvent event){

        System.out.println("Now you can sign in");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.REGISTER, "Register");
    }
}
