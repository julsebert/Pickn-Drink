package mainpackage;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerBasket implements Initializable {
    private static final Logger logger = LogManager.getLogger(ControllerBasket.class);

    @FXML
    public void changeToPayment () {
        System.out.println("Now you can pay and set your order");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.PAYMENT, "Payment");
        logger.info("Welcome to Payment");
    }

    @FXML
    public void changeToDrinks() {
        System.out.println("You can add more Items");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
        logger.info("Welcome to Drinks");
    }

    @FXML
    public void logout() {
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("You're logged out, welcome to Login");
    }

    @FXML
    private TableView<Drinks> Orderlist;

    @FXML
    private TableColumn<Drinks, Integer> count;

    @FXML
    private TableColumn<Drinks, String> tableViewDrink;

    @FXML
    private TableColumn<Drinks, Void> add;

    @FXML
    private TableColumn<Drinks, Void> remove;

    @FXML
    private TableColumn<Drinks, Double> tableViewPrice;

    @FXML
    private Label labelPrice;



    // Methoden


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        count.setCellValueFactory(cellData -> {
            Drinks drink = cellData.getValue();
            int drinkCount = OrderManager.getInstance().getCount(drink);
            return new SimpleObjectProperty<>(drinkCount);
        });

        tableViewPrice.setCellValueFactory(cellData -> {
            Drinks drink = cellData.getValue();
            double drinkPrice = OrderManager.getInstance().getPriceForIdenticalDrinks(drink);
            return new SimpleObjectProperty<>(drinkPrice);
        });


        tableViewDrink.setCellValueFactory(new PropertyValueFactory<>("name"));
        add.setCellFactory(col -> new addButton());
        remove.setCellFactory(col -> new removeButton());


        Collection<Drinks> orderedDrinks = OrderManager.getInstance().getOrderItems();

        for (Drinks drink : orderedDrinks) {
            if (!isDrinkInTableView(drink)) {
                Orderlist.getItems().add(drink);
            }
        }

        labelPrice.setText(calculateTotalPrice());
    }


    // Methode um dafür zu sorgen, dass Getränk nicht doppelt angezeigt wird. Die Anzahl wird in count angegeben.
    private boolean isDrinkInTableView(Drinks drink) {
        ObservableList<Drinks> items = Orderlist.getItems();
        for (Drinks item : items) {
            if (item.equals(drink)) {
                return true;
            }
        }
        return false;
    }

    // addButton um weitere Getränke der Bestellung hinzuzufügen
    private class addButton extends TableCell<Drinks, Void> {
        addButton() {
                Button addButton = new Button("+");
                addButton.setOnAction(event -> {
                    Drinks drink = getTableView().getItems().get(getIndex());
                    OrderManager.getInstance().addDrink(drink);
                    logger.info("Added " + drink.getName() + " to the order.");
                    updateOrderList();
                    updateTotalPrice();
                });
                setGraphic(addButton);
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                setGraphic(null);
            }
        }
    }

    // removeButton um Getränke der Bestellung zu entfernen
    private class removeButton extends TableCell<Drinks, Void> {
        removeButton() {
                Button removeButton = new Button("-");
                removeButton.setOnAction(event -> {
                    Drinks drink = getTableView().getItems().get(getIndex());
                    OrderManager.getInstance().removeDrink(drink);
                    logger.info("Removed " + drink.getName() + " from the order.");
                    updateOrderList();
                    updateTotalPrice();
                });
                setGraphic(removeButton);
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                setGraphic(null);
            }
        }
    }

    private void updateOrderList(){
        Orderlist.refresh();

        List<Drinks> drinksToRemove = Orderlist.getItems()
                .stream()
                .filter(drink -> OrderManager.getInstance().getCount(drink) == 0)
                .toList();

        Orderlist.getItems().removeAll(drinksToRemove);
    }

    // Berechnung Gesamtpreis
    private String calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Drinks drink : Orderlist.getItems()) {
            double drinkPrice = OrderManager.getInstance().getPriceForIdenticalDrinks(drink);
            int drinkCount = OrderManager.getInstance().getCount(drink);
            totalPrice += drinkPrice * drinkCount;
        }
        return (String.format("%.2f", totalPrice) + " €");
    }

    private void updateTotalPrice() {
        labelPrice.setText(calculateTotalPrice());
    }

}
