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
    private ListView<String> ListCocktails;
    @FXML
    private ListView<String> ListShots;
    @FXML
    private ListView<String> ListDriversDrinks;
    Order order = new Order();
    DrinkFactory drinkFactory = new DrinkFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drinkFactory.initDrinks(); // muss ich nicht hier eine instanz erstellen
        Collection<Drinks> allDrinks = drinkFactory.getAllDrinks();
        for (Drinks drink: allDrinks){
            if (drink.getCategory() == Category.COCKTAILS){
                ListCocktails.getItems().add(drink.getName());
            } else if (drink.getCategory() == Category.SHOTS){
                ListShots.getItems().add(drink.getName());
            } else {
                ListDriversDrinks.getItems().add(drink.getName());
            }
        }
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
