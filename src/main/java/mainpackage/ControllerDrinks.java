package mainpackage;

import javafx.fxml.FXML;

public class ControllerDrinks {

    @FXML
    public void changeToCurrentOrder(){

        System.out.println("Welcome to Current Order");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.CURRENT_ORDER, "Current Order");

    }

    @FXML
    public void changeToBasket(){

        System.out.println("Welcome to Basket");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.BASKET, "Basket");

    }

}
