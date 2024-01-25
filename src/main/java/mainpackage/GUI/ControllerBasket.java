package mainpackage.GUI;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpackage.Logic.IDrinks;
import mainpackage.Logic.OrderManager;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerBasket implements Initializable {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerBasket.class);

    // Verknüpfung zu FXML
    @FXML
    private TableView<IDrinks> Orderlist;
    @FXML
    private TableColumn<IDrinks, Integer> count;
    @FXML
    private TableColumn<IDrinks, String> tableViewDrink;
    @FXML
    private TableColumn<IDrinks, Void> add;
    @FXML
    private TableColumn<IDrinks, Void> remove;
    @FXML
    private TableColumn<IDrinks, Double> tableViewPrice;
    @FXML
    private Label labelPrice;

    // SceneSwitcher
    @FXML
    private void changeToPayment () {
        OrderManager.getInstance().clearOrder();
        // nach dem Bezahlen wird der Warenkorb auf 0 gesetzt
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.PAYMENT, "Payment");
        logger.info("Welcome to Payment");
    }

    @FXML
    private void changeToDrinks() {
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
        logger.info("Welcome to Drinks");
    }

    @FXML
    private void logout() {
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to Login");
    }

    // Methoden
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Spalte 'count'
        count.setCellValueFactory(cellData -> {
            IDrinks drink = cellData.getValue();
            int drinkCount = OrderManager.getInstance().getCount(drink);
            return new SimpleObjectProperty<>(drinkCount);
        });

        // Spalte 'price'
        tableViewPrice.setCellValueFactory(cellData -> {
            IDrinks drink = cellData.getValue();
            double drinkPrice = OrderManager.getInstance().getPriceForIdenticalDrinks(drink);
            return new SimpleObjectProperty<>(drinkPrice);
        });

        // Spalten 'drink', 'add'- und 'remove'-Button
        tableViewDrink.setCellValueFactory(new PropertyValueFactory<>("name"));
        add.setCellFactory(col -> new addButton());
        remove.setCellFactory(col -> new removeButton());

        // die Inhalte der Bestellung werden in einer Collection zwischengespeichert
        Collection<IDrinks> orderedDrinks = OrderManager.getInstance().getOrderItems();

        // Collection wird auf Object Drinks überprüft
        for (IDrinks drink : orderedDrinks) {
            if (!isDrinkInTableView(drink)) {
                Orderlist.getItems().add(drink);
                logger.info(drink.getName() + " has been added to the basket.");
            }
        }

        // Gesamtpreis aller Getränke aus der Bestellung wird berechnet
        logger.info("Set new text for label.");
        labelPrice.setText(calculateTotalPrice());
    }


    // Methode um dafür zu sorgen, dass Getränk nicht doppelt angezeigt wird. Die Anzahl wird in count angegeben.
    private boolean isDrinkInTableView(IDrinks drink) {
        ObservableList<IDrinks> items = Orderlist.getItems();
        for (IDrinks item : items) {
            if (item.equals(drink)) {
                logger.info("Item equals drink");
                return true;
            }
        }
        logger.info("Item doesn't equal drink");
        return false;
    }

    // Warenkorb wird aktualisiert
    private void updateOrderList(){
        Orderlist.refresh();

        List<IDrinks> drinksToRemove = Orderlist.getItems()
                .stream()
                .filter(drink -> OrderManager.getInstance().getCount(drink) == 0)
                .toList();

        Orderlist.getItems().removeAll(drinksToRemove);

        logger.info("The basket has been updated.");
    }

    // Berechnung Gesamtpreis
    private String calculateTotalPrice() {
        double totalPrice = 0.0;
        for (IDrinks drink : Orderlist.getItems()) {
            double drinkPrice = OrderManager.getInstance().getPriceForIdenticalDrinks(drink);
            totalPrice += drinkPrice;
        }
        logger.info("The total price has been calculated.");
        return String.format("%.2f €", totalPrice);
    }

    // Gesamtpreis wird aktualisiert
    private void updateTotalPrice() {
        labelPrice.setText(calculateTotalPrice());
        logger.info("The total price has been updated.");
    }

    // Innere Klassen
    // addButton um weitere Getränke der Bestellung hinzuzufügen
    private class addButton extends TableCell<IDrinks, Void> {
        addButton() {
                Button addButton = new Button("+");
                addButton.setOnAction(event -> {
                    IDrinks drink = getTableView().getItems().get(getIndex());
                    OrderManager.getInstance().addDrink(drink);
                    updateOrderList();
                    updateTotalPrice();

                    logger.info("Added " + drink.getName() + " to the order.");
                });
                setGraphic(addButton);
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                logger.info("The Item is null");
                setGraphic(null);
            }
        }
    }

    // removeButton um Getränke der Bestellung zu entfernen
    private class removeButton extends TableCell<IDrinks, Void> {
        removeButton() {
                Button removeButton = new Button("-");
                removeButton.setOnAction(event -> {
                    IDrinks drink = getTableView().getItems().get(getIndex());
                    OrderManager.getInstance().removeDrink(drink);
                    updateOrderList();
                    updateTotalPrice();

                    logger.info("Removed " + drink.getName() + " from the order.");
                });
                setGraphic(removeButton);
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                logger.info("The Item is null");
                setGraphic(null);
            }
        }
    }
}
