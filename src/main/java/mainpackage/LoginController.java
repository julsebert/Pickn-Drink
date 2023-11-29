package mainpackage;

import javafx.fxml.FXML;


public class LoginController {

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
    }

    @FXML
    public void changeToRegister(){
        System.out.println("Now you can sign in");
    }
}
