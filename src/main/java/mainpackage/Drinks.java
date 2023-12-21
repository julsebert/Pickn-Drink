package mainpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Drinks implements IDrinks{

    // Logger
    private static final Logger logger = LogManager.getLogger(Drinks.class);

    // Eigenschaften der Klasse Drinks
    private final String name;
    private final String description;
    private final double price;
    private final Category category;
    private final String path;

    // Konstruktor der Klasse Drinks
    public Drinks(String name, String description, double price, Category category, String path) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.path = path;

        logger.info("The values for the " + name + " have been set.");
    }

    // Implementierung der Methoden aus dem IDrinks-Interface
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getImagePath() {
        return path;
    }
}
