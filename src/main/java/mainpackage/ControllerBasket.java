package mainpackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

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
    private TableColumn<Drinks, String> count;

    @FXML
    private TableColumn<Drinks, String> tableViewDrink;

    @FXML
    private TableColumn<Drinks, Void> add;

    @FXML
    private TableColumn<Drinks, Void> remove;


    OrderManager orderManager = new OrderManager();
    // Methoden


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Collection<Drinks> orderedDrinks = OrderManager.getOrderItems();
        for(Drinks drink: orderedDrinks){
            Orderlist.getItems().add(drink);

            tableViewDrink.setCellValueFactory(new PropertyValueFactory<>("name"));
            add.setCellFactory(col -> new addButton());
            remove.setCellFactory(col -> new removeButton());
        }


    }

    private class addButton extends TableCell<Drinks, Void> {
        private final Button addButton = new Button("Add");

        addButton() {
            addButton.setOnAction(event -> {
                Drinks drink = getTableView().getItems().get(getIndex());
                orderManager.addDrink(drink);
                logger.info("Added " + drink.getName() + " to the order.");
            });
        }
    }

    private class removeButton extends TableCell<Drinks, Void> {
            private final Button removeButton = new Button("Add");

            removeButton() {
                removeButton.setOnAction(event -> {
                    Drinks drink = getTableView().getItems().get(getIndex());
                    orderManager.addDrink(drink);
                    logger.info("Removed " + drink.getName() + " from the order.");
                });
            }
    }







}
