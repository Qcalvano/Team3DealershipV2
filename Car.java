package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: Car Class
Course: IST 242
Author: Quenten Calvano
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Car {

    //Class level variables
    private int carID;
    private int carMileage;
    private String carDescription;
    private String carColor;
    //TODO: change the dateAdded value to a date...
    private String dateAdded; //TODO: change to a date format to fix data inconsistency.
    private int modelYear;
    private boolean available;
    private double carPrice;

    //Constructor method;
    public void Car (int _carID, int _carMileage, String _carDescription
            , String _carColor, String _dateAdded, int _modelYear, boolean _available, double _carPrice){
        this.carID = _carID;
        this.carMileage = _carMileage;
        this.carDescription = _carDescription;
        this.carColor = _carColor;
        this.dateAdded = _dateAdded;
        this.modelYear = _modelYear;
        this.available = _available;
        this.carPrice = _carPrice;
    }

    //Getters and Setters
    //Car ID...
    public int getCarID() { return carID; }
    public void setCarID(int carID) { this.carID = carID; }

    //Car mileage...
    public int getCarMileage() { return carMileage; }
    public void setCarMileage(int carMileage) { this.carMileage = carMileage; }

    //Car Description...
    public String getCarDescription() { return carDescription; }
    public void setCarDescription(String carDescription) { this.carDescription = carDescription; }

    //Car Color...
    public String getCarColor() { return carColor; }
    public void setCarColor(String carColor) { this.carColor = carColor; }

    //Date Added...
    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }

    //Model Year...
    public int getModelYear() { return modelYear; }
    public void setModelYear(int modelYear) { this.modelYear = modelYear; }

    //Availability...
    public boolean getAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    //Car Price
    public double getCarPrice() {
        return carPrice;
    }
    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public static void viewCarInventory (ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println("\nCar ID: " + car.getCarID());
            System.out.println("Mileage: " + car.getCarMileage());
            System.out.println("Description: " + car.getCarDescription());
            System.out.println("Color: " + car.getCarColor());
            System.out.println("Date Added: " + car.getDateAdded());
            System.out.println("Model Year: " + car.getModelYear());
            System.out.print("Availability: ");
            if (car.getAvailable()) {
                System.out.println("Available");
            }
            else {
                System.out.println("Unavailable");
            }
            System.out.printf("Car Price: $%.2f\n", car.getCarPrice());
            System.out.println();
        }
    }

    public static void createSampleCars (ArrayList<Car> carList) {
        //Create the first sample car...
        Car car1 = new Car();
        car1.setCarID(1);
        car1.setCarMileage(30000);
        car1.setCarDescription("Toyota Avalon");
        car1.setCarColor("Black");
        car1.setDateAdded("3/12/2020");
        car1.setModelYear(2019);
        car1.setCarPrice(40000.00);
        carList.add(car1);

        //Create the second sample car...
        Car car2 = new Car();
        car2.setCarID(2);
        car2.setCarMileage(134563);
        car2.setCarDescription("Ford Fusion");
        car2.setCarColor("Slate Gray");
        car2.setDateAdded("11/20/2019");
        car2.setModelYear(2011);
        car2.setCarPrice(8000.00);
        carList.add(car2);

        //Create the third sample car...
        Car car3 = new Car();
        car3.setCarID(3);
        car3.setCarMileage(45039);
        car3.setCarDescription("Honda Accord");
        car3.setCarColor("Red");
        car3.setDateAdded("2/22/2020");
        car3.setModelYear(2017);
        car3.setCarPrice(35000.00);
        carList.add(car3);
    }

    //This method allows the user to view financing options for a vehicle //FIXME: Formatting on the financing options.
    public static void viewFinancingOptions(ArrayList<Car> carList) {
        Scanner scnr = new Scanner(System.in);
        boolean exitFinancingMenu = false;
        int userInput;
        do {
            System.out.println("\nWhat car would you like to view financing for? \nEnter a vehicle ID to view vehicles." +
                    "\n\t\tor" + "\nEnter '0' to list vehicles.");
            userInput = scnr.nextInt();
            if (userInput == 0){
                Car.viewCarInventory(carList);
            }
            else if (idExists(userInput, carList)) {
                double carPrice = Car.findCarPriceByID(userInput, carList);
                System.out.println("Financing options for Car ID: " + userInput);
                System.out.printf("List price: $%.2f\n", carPrice);
                double thirtySixMonth = carPrice / 36.00 + carPrice * 0.11; //do the calculation
                double fortyEightMonth = carPrice / 48.00 + carPrice * 0.09; //do the calculation
                System.out.print("\tMonthly payments for 36 months at 11% interest: " +
                        new DecimalFormat("$#.00").format(thirtySixMonth)); //Format the decimal via DecimalFormat because it was coming back
                                                                                    // with exceptions with the regular format print
                System.out.print("\n\tMonthly payments for 48 months at 9% interest: " +
                        new DecimalFormat("$#.00").format(fortyEightMonth));
                boolean stopSearching = false;
                do {
                    System.out.println("\nType 'C' to continue viewing financing options or 'E' to exit.");
                    String userKeepLooking = scnr.next();

                    if (userKeepLooking.equalsIgnoreCase("E")) {
                        return;
                    } else if (userKeepLooking.equalsIgnoreCase("C")) {
                        System.out.println("You entered: 'C'");
                        stopSearching = true;
                    }
                    else {
                        System.out.println("ERROR. Invalid input.");
                    }
                } while (!stopSearching);
            }
        } while (exitFinancingMenu == false);
    }

    //This method returns a double with the price of the car that corresponds to a user entered integer
    public static double findCarPriceByID(int userInput, ArrayList<Car> carList) {
        double carPrice = 0.0;
        for (Car car : carList) {
            if (car.getCarID() == userInput){
                carPrice = car.getCarPrice();
            }
        }
        return carPrice;
    }

    //This method returns a boolean value indicating whether the user-entered
    // car ID is assigned to a car in the vehicle inventory
    public static boolean idExists(int userInput, ArrayList<Car> carList){
        boolean exists = false;
        for (Car car : carList) {
            if (car.getCarID() == userInput){
                exists = true;
            }
        }
        return exists;
    }
}
