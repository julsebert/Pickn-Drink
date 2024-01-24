package mainpackage.Logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Drinks implements IDrinks {

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

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (category == null) {
            throw new NullPointerException("Category cannot be null.");
        }

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
        logger.info("GetName was executed.");
        return name;
    }
    @Override
    public String getDescription() {
        logger.info("GetDescription was executed.");
        return description;
    }
    @Override
    public Category getCategory() {
        logger.info("GetCategory was executed.");
        return category;
    }
    @Override
    public double getPrice() {
        logger.info("GetPrice was executed.");
        return price;
    }
    @Override
    public String getImagePath() {
        logger.info("GetImagePath was executed.");
        return path;
    }
}
