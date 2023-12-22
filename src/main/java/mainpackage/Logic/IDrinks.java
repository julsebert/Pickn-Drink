package mainpackage.Logic;


import mainpackage.Logic.Category;

public interface IDrinks {
    String getName();
    String getDescription();
    Category getCategory();
    double getPrice();
    String getImagePath();
}
