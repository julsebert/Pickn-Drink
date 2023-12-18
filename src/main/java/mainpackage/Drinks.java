package mainpackage;

public class Drinks {

    // Eigenschaften der Klasse Drinks
    private final String name;
    private final String description;
    private double price;
    private Category category;

    private String path;

    // Methoden der Klasse Drinks
    public Drinks(String name, String description, double price, Category category, String path) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.path = path;
    }

    public String getName(){
        return name;
    }

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
    // kann eventuell entfernt werden, da wir die HashMap haben
}
