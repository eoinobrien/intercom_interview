package customers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CustomerInvites {
    public static Customer jsonStringToCustomer(String customerString) {
        JSONObject jsonCustomer = new JSONObject(customerString);
        return new Customer(jsonCustomer.getString("name"), jsonCustomer.getInt("user_id"),
                jsonCustomer.getDouble("latitude"), jsonCustomer.getDouble("longitude"));
    }

    public static ArrayList<Customer> getCustomerList() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/home/eoin/Code/Intercom/customers.json.txt"));
        String jsonCustomerString;

        ArrayList<Customer> customers = new ArrayList<Customer>();
        while ((jsonCustomerString = in.readLine()) != null) {
            customers.add(jsonStringToCustomer(jsonCustomerString));
        }

        return customers;
    }

    public static double distanceFromOffice(double customerLatitude, double customerLongitude) {
        final double OFFICE_LATITUDE = 53.3381985;
        final double OFFICE_LONGITUDE = -6.2592576;
        final double EARTH_RADIUS = 6372.8;

        double latitudeDistance = Math.toRadians(customerLatitude - OFFICE_LATITUDE);
        double longitudeDistance = Math.toRadians(customerLongitude - OFFICE_LONGITUDE);

        double underSqRoot = Math.pow(Math.sin(latitudeDistance / 2), 2) + Math.pow(Math.sin(longitudeDistance / 2), 2)
                * Math.cos(Math.toRadians(customerLatitude)) * Math.cos(Math.toRadians(OFFICE_LATITUDE));
        double c = 2 * Math.asin(Math.sqrt(underSqRoot));

        return EARTH_RADIUS * c;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Customer> customers = getCustomerList();
            TreeMap<Integer, Customer> customersToInvite = new TreeMap<>();

            for (Customer customer : customers) {
                if(distanceFromOffice(customer.getLatitude(), customer.getLongitude()) < 100){
                    customersToInvite.put(customer.getUser_id(), customer);
                }
            }

            for (Map.Entry<Integer, Customer> entry : customersToInvite.entrySet()){
                Customer customer = entry.getValue();
                System.out.printf("%2d %s\n", customer.getUser_id(), customer.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
