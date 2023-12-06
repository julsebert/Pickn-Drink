package mainpackage;

public class Drinks {
   private String name;
    private String description;
    private double price;

    private Category category;

    public Drinks(String name, String description, double price, Category category){
        this.category = category;
        this.price = price;
        this.name = name;
        this.description = description;

    }
}
