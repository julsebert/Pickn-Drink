package mainpackage;

import mainpackage.Logic.Category;
import mainpackage.Logic.Drinks;
import mainpackage.Logic.IDrinks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DrinksTest {

    private Drinks testDrink;

    @BeforeEach
    public void setupDrink(){
        testDrink = new Drinks("Himbeermojito", "Havana Club rum, white cane sugar, lime juice, mint, raspberries", 8, Category.COCKTAILS, "/Himbeermojito.png");
    }

    @Test
    public void testDrinksNormalfall() {
        assertEquals("Himbeermojito", testDrink.getName());
        assertEquals("Havana Club rum, white cane sugar, lime juice, mint, raspberries", testDrink.getDescription());
        assertEquals(8, testDrink.getPrice());
        assertEquals(Category.COCKTAILS, testDrink.getCategory());
        assertEquals("/Himbeermojito.png", testDrink.getImagePath());
    }

    @AfterEach
    public void teardownDrink(){
        testDrink = null;
    }

    @Test
    public void testDrinksFehlerfall(){
        assertThrows(IllegalArgumentException.class, () -> new Drinks( "Himbeermojito", "Havana Club rum, white cane sugar, lime juice, mint, raspberries", -8, Category.COCKTAILS, "/Himbeermojito.png"));
        assertThrows(IllegalArgumentException.class, () -> new Drinks( "Himbeermojito", "Havana Club rum, white cane sugar, lime juice, mint, raspberries", -12, Category.COCKTAILS, "/Himbeermojito.png"));
    }


}
