package mainpackage.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import mainpackage.Logic.IDrinks;
import mainpackage.Logic.OrderManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DrinkListCell extends ListCell<IDrinks> {

    // Logger
    private static final Logger logger = LogManager.getLogger(DrinkListCell.class);

    // Methoden

    // Wenn eine Drink-Objekt vorhanden ist, dann wird eine passende DrinkPane erstellt
    @Override
    protected void updateItem(IDrinks drink, boolean empty) {
        super.updateItem(drink, empty);
        if (empty || drink == null) {
            // Zeigt nichts an, wenn die Zelle leer ist
            setGraphic(null);
            logger.info("This line is empty because no drink was specified.");
            // Zeigt nichts an, wenn die Zelle leer ist
        } else {
            // Erzeugt die Pane für das Drink-Objekt
            setGraphic(createDrinkPane(drink));
            logger.info("DrinkPane is now created.");
        }
    }

    // createDrinkPane(): erstellt eine Pane mit einem vorgegebenen Layout
    private Pane createDrinkPane(IDrinks drink) {
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
        Label priceLabel = new Label("Price: " + drink.getPrice() + " €");

        // Button "Add to basket"
        Button addButton = new Button("Add to basket");
        addButton.setOnAction(event -> {
            OrderManager.getInstance().addDrink(drink);
            logger.info(drink.getName() + " has been added to the order.");
        });


        // Fügen Sie alle Komponenten zur VBox hinzu
        vbox.getChildren().addAll(nameLabel, textFlow, priceLabel, addButton);

        // Fügen Sie ImageView und VBox zur HBox hinzu
        drinkItem.getChildren().addAll(imageView, vbox);

        logger.info("The pane for " + drink.getName() + " has been created.");

        return drinkItem;
    }
}
