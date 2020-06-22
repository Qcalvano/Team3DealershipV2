package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: Customer Class
Course: IST 242
Author: Yashika Patel
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    private int CustomerID = 1;
    private String CustomerName;
    private String CustomerPhoneNumber;
    private String CustomerAddress;

    public Customer(int _customerId) {
        this.CustomerID = _customerId;  //Increments the ID count
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int _CustomerID) {
        this.CustomerID = _CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String _CustomerName) {
        this.CustomerName = _CustomerName;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String _CustomerPhoneNumber) {
        this.CustomerPhoneNumber = _CustomerPhoneNumber;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String _CustomerAddress) {
        this.CustomerAddress = _CustomerAddress;
    }

    public static void printCustomer(ArrayList<Customer> cList) {
        for (Customer cust : cList) {
            System.out.println("Customer Id:" + cust.getCustomerID());
            System.out.println("Customer Name:" + cust.getCustomerName());
            System.out.println("Customer Phone:" + cust.getCustomerPhoneNumber());
            System.out.println("Customer Address:" + cust.getCustomerAddress());
        }

    }
}
