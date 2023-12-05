package mainpackage;

import javafx.fxml.FXML;

public class basketController {

    @FXML
    public void changeToPayment () {
        System.out.println("Now you can pay and set your order");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.PAYMENT, "Payment");
    }

    @FXML
    public void changeToCocktails () {
        System.out.println("You can add more Items");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.COCKTAILS, "Cocktails");
    }
}
