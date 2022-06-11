package com.nbu.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private String customerNumber;
    private double Budget;
    private ArrayList<Product> desiredProducts;
    private double totalAmount;

    //Getters
    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public double getBudget() {
        return this.Budget;
    }

    public String getDesiredProducts() {
        String allProducts = "";
        for(Product prod : desiredProducts) {
            allProducts = prod.getName () + " ";
        }
        return allProducts;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    //Setters
    public void setCustomerNumber(String number) {
        this.customerNumber = number;
    }

    public void setBudget(double budget) {
        if (budget > 0) {
            this.Budget = budget;
        }
    }

    //TODO - Find out why is DesiredProduct Null.
    public void setDesiredProduct(String productX) {
        //Check if the product name exists in the products array list
        for (Product product : Store.productArrayList) {
            if (productX.equals (product.getName ())) {
                //if yes, add it to the desired products list
                if(this.Budget > product.getPrice ()) {
                this.desiredProducts.add (product);}
            } else {
                System.out.println ("No such product. Try again!");
            }
        }
    }


    public void setTotalAmount() {
        for (int i = 0; i < desiredProducts.size (); i++) {
            for (Product product : Store.productArrayList) {
                if (product.getName ().equals (desiredProducts.get (i))) {
                    this.totalAmount += product.getPrice ();
                }
            }
        }
    }

    Customer() {
        this.Budget = 0;
        this.totalAmount = 0;
    }

    public Customer(String number, double budget) {
        setCustomerNumber (number);
        setBudget (budget);
    }

    public Customer(String number, double budget, String product) {
        setCustomerNumber (number);
        setBudget (budget);
        setDesiredProduct (product);
        setTotalAmount ();
        GlobalDataStructures.storeCustomersArrList.add (this);
    }


    public void getCustomerInfo() {
        System.out.println ("----- Customer Information -----");
        System.out.println ("Customer Number: " + getCustomerNumber ());
        System.out.println ("Budget: " + getBudget ());
        System.out.println ("Desired Products: " + getDesiredProducts ());
        System.out.println ("Total Amount:" + getTotalAmount ());
        System.out.println ();


    }
}
