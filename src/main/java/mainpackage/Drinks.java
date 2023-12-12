package mainpackage;

public class Drinks {

    // Eigenschaften der Klasse Drinks
    private final String name;
    private final String description;
    private double price;
    private Category category;

    // Methoden der Klasse Drinks
    public Drinks(String name, String description, double price, Category category){
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public Category getCategory(){
        return category;
    }

    public double getPrice(){       //darf die public sein??
        return price;
    }
    // kann eventuell entfernt werden, da wir die HashMap haben
}
