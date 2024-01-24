package mainpackage;

import mainpackage.Logic.Category;
import mainpackage.Logic.DrinkFactory;
import mainpackage.Logic.DrinkNotFound;
import mainpackage.Logic.IDrinks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkFaktoryTest {

    @BeforeEach
    public void setUp(){
        DrinkFactory.initDrinks();
    }

    @Test
    public void testDrinkFactoryNormalfall(){
        Collection<IDrinks> allDrinks = DrinkFactory.getAllDrinks();
        assertNotNull(allDrinks);
        assertEquals(18, allDrinks.size());
    }

    @Test
    public void testGetDrinkNormalfall() {
        IDrinks drink = DrinkFactory.getDrink("Himbeermojito");
        assertNotNull(drink);
        assertEquals("Himbeermojito", drink.getName());
        assertEquals(Category.COCKTAILS, drink.getCategory());
    }

    @Test
    public void testDrinkFactoryFehlerfall() {
        assertThrows( DrinkNotFound.class, () -> DrinkFactory.getDrink("NonExistentDrink"));
    }
}
