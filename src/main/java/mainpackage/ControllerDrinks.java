package mainpackage;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerDrinks implements Initializable{

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerDrinks.class);

    // Verknüpfung zu FXML
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
        /*ObservableList<Drinks> cocktailsList = FXCollections.observableArrayList(allDrinks
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

         */
        // Das Filtern nach den einzelnen Kategorien wird in Threads unterteilt
        Thread cocktailsThread = new Thread(() -> {
            List<Drinks> cocktails = allDrinks
                    .parallelStream()
                    .filter(drink -> drink.getCategory() == Category.COCKTAILS)
                    .collect(Collectors.toList());

            // GUI aktualisieren
            Platform.runLater(() -> {
                ObservableList<Drinks> cocktailsList = FXCollections.observableArrayList(cocktails);
                listViewCocktails.setCellFactory(lv -> new DrinkListCell());
                listViewCocktails.setItems(cocktailsList);
            });

            logger.info("Thread Nr.1 is now finished.");
        });

        Thread shotsThread = new Thread(() -> {
            List<Drinks> shots = allDrinks
                    .parallelStream()
                    .filter(drink -> drink.getCategory() == Category.SHOTS)
                    .collect(Collectors.toList());

            // GUI aktualisieren
            Platform.runLater(() -> {
                ObservableList<Drinks> shotsList = FXCollections.observableArrayList(shots);
                listViewShots.setCellFactory(lv -> new DrinkListCell());
                listViewShots.setItems(shotsList);
            });

            logger.info("Thread Nr.2 is now finished.");
        });

        Thread driverDrinksThread = new Thread(() -> {
            List<Drinks> driverDrinks = allDrinks
                    .parallelStream()
                    .filter(drink -> drink.getCategory() == Category.DRIVERSDRINKS)
                    .collect(Collectors.toList());

            // GUI aktualisieren
            Platform.runLater(() -> {
                ObservableList<Drinks> driverDrinkList = FXCollections.observableArrayList(driverDrinks);
                listViewDriverDrinks.setCellFactory(lv -> new DrinkListCell());
                listViewDriverDrinks.setItems(driverDrinkList);
            });

            logger.info("Thread Nr.3 is now finished.");
        });

        // Threads starten
        cocktailsThread.start();
        shotsThread.start();
        driverDrinksThread.start();

        logger.info("The menu card with the drinks was created according to the individual categories.");
    }

    // SceneSwitcher
    @FXML
    public void changeToBasket(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.BASKET, "Basket");
        logger.info("Welcome to Basket");
    }

    @FXML
    public void logout(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to login");
    }
}
