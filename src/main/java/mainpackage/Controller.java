package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {

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
