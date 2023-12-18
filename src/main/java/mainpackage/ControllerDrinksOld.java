package mainpackage;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerDrinksOld implements Initializable {

    private static Logger logger = LogManager.getLogger(ControllerDrinks.class);

    //FXML für Cocktails
    @FXML
    private TableView<Drinks> CTableAllDrinks;
    @FXML
    private TableColumn<Drinks, String> CTableName;
    @FXML
    private TableColumn<Drinks, String> CTableDescription;
    @FXML
    private TableColumn<Drinks, Double> CTablePrice;
    @FXML
    private TableColumn<Drinks, Void> CTableSelect;

    // Klasse auslagern!!
    private class ButtonCell extends TableCell<Drinks, Void> {
        private final Button addButton = new Button("Add");

        ButtonCell() {
            addButton.setOnAction(event -> {
                Drinks drink = getTableView().getItems().get(getIndex());
                order.addDrink(drink);
                logger.info("Added " + drink.getName() + " to the order.");
            });
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            setGraphic(empty ? null : addButton);
        }
    }

    //FXML für Shots
    @FXML
    private TableView<Drinks> STableAllDrinks;
    @FXML
    private TableColumn<Drinks, String> STableName;
    @FXML
    private TableColumn<Drinks, String> STableDescription;
    @FXML
    private TableColumn<Drinks, Double> STablePrice;
    @FXML
    private TableColumn<Drinks, Void> STableSelect;

    //FXML für DriversDrinks
    @FXML
    private TableView<Drinks> DTableAllDrinks;
    @FXML
    private TableColumn<Drinks, String> DTableName;
    @FXML
    private TableColumn<Drinks, String> DTableDescription;
    @FXML
    private TableColumn<Drinks, Double> DTablePrice;
    @FXML
    private TableColumn<Drinks, Void> DTableSelect;
    Order order = new Order();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DrinkFactory.initDrinks();
        Collection<Drinks> allDrinks = DrinkFactory.getAllDrinks();

        for (Drinks drink: allDrinks) {

            try {
                if (drink.getCategory() == Category.COCKTAILS) {

                    CTableAllDrinks.getItems().add(drink);

                    CTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    CTableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                    CTablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

                    CTableSelect.setCellFactory(col -> new ButtonCell());

                } else if (drink.getCategory() == Category.SHOTS) {

                    STableAllDrinks.getItems().add(drink);

                    STableName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    STableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                    STablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

                } else if (drink.getCategory() == Category.DRIVERSDRINKS){

                    DTableAllDrinks.getItems().add(drink);

                    DTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    DTableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                    DTablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

                } else {
                    throw new IllegalArgumentException("This category does not exist.");
                }
            }
            catch (Exception e){
                //ausfüllen Fehler behandeln
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
