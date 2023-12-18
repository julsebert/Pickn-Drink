package mainpackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerCurrentOrder implements Initializable{
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DrinkFactory.initDrinks();
        Collection<Drinks> allDrinks = DrinkFactory.getAllDrinks();

        ObservableList<Drinks> cocktailsList = FXCollections.observableArrayList(
                allDrinks.stream().filter(drink -> drink.getCategory() == Category.COCKTAILS).collect(Collectors.toList()));

        currentOrder.setCellFactory(lv -> new DrinkListCell());
        currentOrder.setItems(cocktailsList);
    }

    public class DrinkListCell extends ListCell<Drinks> {
        @Override
        protected void updateItem(Drinks drink, boolean empty) {
            super.updateItem(drink, empty);
            if (empty || drink == null) {
                setGraphic(null); // Zeigt nichts an, wenn die Zelle leer ist
            } else {
                setGraphic(createDrinkPane(drink)); // Erzeugt die Pane für das Drink-Objekt
            }
        }
    }

    private Pane createDrinkPane(Drinks drink) {
        // Haupt-Pane (HBox) für das Drink-Item
        HBox drinkItem = new HBox(10); // 10 ist der Abstand zwischen den Elementen
        drinkItem.setPrefSize(280, 150); // Setzt die bevorzugte Größe

        // ImageView für das Bild des Getränks
        ImageView imageView = new ImageView(new Image(drink.getImagePath()));
        imageView.setFitHeight(150);
        imageView.setFitWidth(140);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        // VBox für Text und Button
        VBox vbox = new VBox(10); // 10 ist der Abstand zwischen den Elementen in der VBox
        vbox.setPrefSize(225, 150);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(7));

        // Label für den Namen
        Label nameLabel = new Label(drink.getName());
        nameLabel.setFont(new Font(18));

        // TextFlow für die Beschreibung
        TextFlow textFlow = new TextFlow(new Text(drink.getDescription()));
        textFlow.setPrefSize(200, 200); // Setzen Sie die gewünschte Größe

        // Label für den Preis
        Label priceLabel = new Label("Preis: $" + drink.getPrice());

        // Button "Add to basket"
        Button addButton = new Button("Add to basket");
        // Hier können Sie einen Event-Handler für den Button hinzufügen, falls nötig

        // Fügen Sie alle Komponenten zur VBox hinzu
        vbox.getChildren().addAll(nameLabel, textFlow, priceLabel, addButton);

        // Fügen Sie ImageView und VBox zur HBox hinzu
        drinkItem.getChildren().addAll(imageView, vbox);

        return drinkItem;
    }

    @FXML
    private ListView<Drinks> currentOrder;


    @FXML
    public void changeToDrinks() {
        System.out.println("You can add more Items");
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
    }
}
