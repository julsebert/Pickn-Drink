package mainpackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerDrinks implements Initializable {

    @FXML
    private ListView<Drinks> ListCocktails;
    Order order = new Order();
    DrinkFactory drinkFactory = new DrinkFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drinkFactory.initDrinks(); // muss ich nicht hier eine instanz erstellen
        Collection<Drinks> allDrinks = drinkFactory.getAllDrinks();
        ListCocktails.getItems().addAll(allDrinks);
    }

    // Funktionen
    @FXML
    public void ListShots(){

    }

    @FXML
    public void ListDriversDrinks(){

    }


    // SceneSwitcher
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
