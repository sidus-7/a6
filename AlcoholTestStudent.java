import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTestStudent {

    @Test
    void testCalcPrice() {
        // Test case for medium size and no weekend offer
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, false);
        assertEquals(2.5, alcohol1.calcPrice());

        // Test case for large size and weekend offer
        Alcohol alcohol2 = new Alcohol("Wine", Size.LARGE, true);
        assertEquals(3.1, alcohol2.calcPrice());
    }

    @Test
    void testToString() {
        // Test case for medium size and no weekend offer
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, false);
        assertEquals("Alcohol: Beverage [name=Beer, size=MEDIUM], weekendOffer= false, price= 2.5", alcohol1.toString());

        // Test case for large size and weekend offer
        Alcohol alcohol2 = new Alcohol("Wine", Size.LARGE, true);
        assertEquals("Alcohol: Beverage [name=Wine, size=LARGE], weekendOffer= true, price= 3.1", alcohol2.toString());
    }

    @Test
    void testEquals() {
        // Test case for equality
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol alcohol2 = new Alcohol("Beer", Size.MEDIUM, false);
        assertEquals(alcohol1, alcohol2);

        // Test case for inequality
        Alcohol alcohol3 = new Alcohol("Wine", Size.LARGE, true);
        assertNotEquals(alcohol1, alcohol3);
    }
}

