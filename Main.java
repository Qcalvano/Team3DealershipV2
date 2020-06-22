package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: A program that simulates a car dealership system.
Course: IST 242
Author: Quenten Calvano, Michael Mandia, Yashika Patel
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<SalesAssociate> saList = new ArrayList<>();
        ArrayList<Car> carList = new ArrayList<>();
        ArrayList<Dealership> dList = new ArrayList<>();
        ArrayList<User> uList = new ArrayList<>();

        Car.createSampleCars(carList);
        Dealership.createSampleDealerships(dList, carList, saList);
        SalesAssociate.createSalesAssociateSampleUsers(uList);
        userLogin(uList, carList, dList);
    }

    //This method allows a user to login or create an account. From the login screen, a user is able to access the user menu
    public static void userLogin(ArrayList<User> uList, ArrayList<Car> carList, ArrayList<Dealership> dList){
        Scanner scnr = new Scanner(System.in);

        boolean processComplete = false;
        do {
            System.out.println("Login: (Enter 1) or Create Account: (Enter 2)");
            String input = scnr.next();
            if (input.equals("1")) {

                boolean accessVerified = User.verifyUserLogin(uList);
                if (accessVerified == true) {
                    User.userMenu(carList, dList, uList);
                    processComplete = true;
                }
                else {
                    System.out.println();
                }
            } else if (input.equals("2")) {
                User.addUser(uList);
            } else {
                System.out.println("ERROR: Invalid command. Please Try Again");
            }
        } while(processComplete == false);
    }
}
