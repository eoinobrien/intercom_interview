package customers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Eoin O'Brien on 07/11/15.
 */
public class CustomerTest {

    @Test
    public void testEquals() {
        assertEquals(new Customer("name", 1, 0.0, 0.3), new Customer("name", 1, 0.0, 0.3));
    }

    @Test
    public void testNotEquals() {
        assertNotEquals(new Customer("name", 1, 0.0, 0.3), new Customer("other name", 2, 0.0, 0.3));
        assertNotEquals(new Customer("name", 1, 0.0, 0.3), new Customer("name", 2, 0.0, 0.3));
        assertNotEquals(new Customer("name", 1, 0.0, 0.3), new Customer("name", 1, 0.1, 0.3));
        assertNotEquals(new Customer("name", 1, 0.0, 0.3), new Customer("name", 1, 0.0, 0.4));
        assertNotEquals(new Customer("name", 1, 0.0, 0.3), new Customer("other name", 2, 0.1, 0.4));
    }
}
