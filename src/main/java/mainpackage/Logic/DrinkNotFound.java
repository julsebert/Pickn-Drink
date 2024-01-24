package mainpackage.Logic;

public class DrinkNotFound extends RuntimeException{
    public DrinkNotFound(String drinkName){
        super ("Drink Not Found: " + drinkName);
    }
}
