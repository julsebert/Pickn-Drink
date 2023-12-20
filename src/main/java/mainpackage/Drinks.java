package mainpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Drinks {

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

    // Methoden der Klasse Drinks
    public String getName(){ return name; }

    public String getDescription() { return description; }

    public Category getCategory(){
        return category;
    }

    public double getPrice(){       //darf die public sein??
        return price;
    }

    public String getImagePath() {
        return path;
    }
}
