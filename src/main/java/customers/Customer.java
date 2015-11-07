package customers;

public class Customer {
    String name;
    int user_id;
    double latitude;
    double longitude;

    public Customer(String name, int user_id, double latitude, double longitude){
        this.name = name;
        this.user_id = user_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Customer) {
            Customer cust = (Customer) obj;
            return this.getName().equals(cust.getName()) &&
                    this.getUser_id() == cust.getUser_id() &&
                    this.getLatitude() == cust.getLatitude() &&
                    this.getLongitude() == cust.getLongitude();
        }
        return false;
    }
}
