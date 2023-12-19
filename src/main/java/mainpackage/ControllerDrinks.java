package mainpackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerDrinks implements Initializable{

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerDrinks.class);

    // Order
    OrderManager orderManager = new OrderManager();

    // @FXML
    @FXML
    private ListView<Drinks> listViewCocktails;
    @FXML
    private ListView<Drinks> listViewShots;
    @FXML
    private ListView<Drinks> listViewDriverDrinks;

    // Methoden
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Getränkeliste erstellen
        DrinkFactory.initDrinks();
        Collection<Drinks> allDrinks = DrinkFactory.getAllDrinks();

        // Getränkeliste in die 3 Kategorien filtern
        ObservableList<Drinks> cocktailsList = FXCollections.observableArrayList(allDrinks
                .stream().filter(drink -> drink.getCategory() == Category.COCKTAILS).collect(Collectors.toList()));
        ObservableList<Drinks> shotsList = FXCollections.observableArrayList(allDrinks
                .stream().filter(drink -> drink.getCategory() == Category.SHOTS).collect(Collectors.toList()));
        ObservableList<Drinks> driverDrinkList = FXCollections.observableArrayList(allDrinks
                .stream().filter(drink -> drink.getCategory() == Category.DRIVERSDRINKS).collect(Collectors.toList()));
        // -> sollen wir hier Threads nutzen

        // Befüllung der einzelnen ListViews mit den jeweiligen Inhalten
        listViewCocktails.setCellFactory(lv -> new DrinkListCell());
        listViewCocktails.setItems(cocktailsList);
        listViewShots.setCellFactory(lv -> new DrinkListCell());
        listViewShots.setItems(shotsList);
        listViewDriverDrinks.setCellFactory(lv -> new DrinkListCell());
        listViewDriverDrinks.setItems(driverDrinkList);

        logger.info("The menu card with the drinks was created according to the individual categories.");
    }

    // SceneSwitcher

    @FXML
    public void changeToBasket(){
        System.out.println("Welcome to Basket");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.BASKET, "Basket");
        logger.info("Welcome to Basket");
    }

    @FXML
    public void logout(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to login");
    }
}
