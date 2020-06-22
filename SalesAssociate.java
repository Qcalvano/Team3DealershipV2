package edu.psu.abington.ist.ist242;
import java.util.ArrayList;
public class SalesAssociate extends User {
    //class variable -Protect Data
    private int carId;
    private int salesmanId;
    private boolean carSold;
    private String carDescription;
    private int customerId;
    private String CustomerName;
    private String CustomerPhoneNumber;

    //Constructor
    public SalesAssociate(int _carId, int _salesmanId, boolean _carSold, String _carDescription, int _customerId, String _CustomerName, String _CustomerPhoneNumber) {
        this.carId = _carId;
        this.salesmanId = _salesmanId;
        this.carSold = _carSold;
        this.carDescription = _carDescription;
        this.customerId = _customerId;
        this.CustomerName= _CustomerName;
        this.CustomerPhoneNumber= _CustomerPhoneNumber;
    }

    //setter & getter
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }
    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }
    public boolean getCarSold() {
        return carSold;
    }
    public void setCarSold(boolean carSold) {
        this.carSold = carSold;
    }
    public String getCarDescription() {
        return carDescription;
    }
    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getCustomerName(){return CustomerName;}
    public void setCustomerName(String CustomerName){this.CustomerName= CustomerName;}
    public String getCustomerPhoneNumber(){return CustomerPhoneNumber;}
    public void setCustomerPhoneNumber(String CustomerPhoneNumber){this.CustomerPhoneNumber = CustomerPhoneNumber;}



    // Printing info
    public void viewRecordSales() {
        System.out.println("Car Id: " + getCarId());
        System.out.println("Salesman Id: " + getSalesmanId());
        System.out.println("Car sold: " + getCarSold());
        System.out.println("Car Description: " + getCarDescription());
    }
    public void updateCarEntries() {
        System.out.println("Car Id: " + getCarId());
        System.out.println("Car Description: " + getCarDescription());
    }
    public void viewCustomerContacts() {
        System.out.println("Car ID: " + getCarId());
        System.out.println("Customer Contact Id: " + getCustomerId());
        System.out.println("Customer Phone Number:"+getCustomerPhoneNumber());
        System.out.println("Customer Name:"+getCustomerName());
    }

    //This method creates sample users for the Sales asscoiate class which is called in main
    public static void createSalesAssociateSampleUsers (ArrayList<User> uList) {
        User user1 = new User();
        user1.setUserName("Frank Friend");
        user1.setPassword("password");
        user1.setTypeID(1);
        user1.generateUserRole(user1.getTypeID());
        uList.add(user1);

        User user2 = new User();
        user2.setUserName("Chris Romero");
        user2.setPassword("password");
        user2.setTypeID(1);
        user2.generateUserRole(user1.getTypeID());
        uList.add(user2);

    }

}