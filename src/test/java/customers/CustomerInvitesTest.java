package customers;

import org.junit.Test;

import static customers.CustomerInvites.jsonStringToCustomer;
import static customers.CustomerInvites.distanceFromOffice;
import static org.junit.Assert.assertEquals;


/**
 * Created by eoin on 07/11/15.
 */
public class CustomerInvitesTest {

    @Test
    public void testJsonStringToCustomer() {
        String jsonString = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";

        assertEquals(jsonStringToCustomer(jsonString), new Customer("Christina McArdle", 12, 52.986375, -6.043701));
    }

    @Test
    public void testDistanceFromOffice() {
        assertEquals(distanceFromOffice(53.344433, -6.259509), 0.6938, 0.01);
    }
}
