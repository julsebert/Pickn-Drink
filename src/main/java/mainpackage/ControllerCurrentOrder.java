package mainpackage;

import javafx.fxml.FXML;

public class ControllerCurrentOrder {

    @FXML
    public void changeToDrinks() {
        System.out.println("You can add more Items");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
    }
}
