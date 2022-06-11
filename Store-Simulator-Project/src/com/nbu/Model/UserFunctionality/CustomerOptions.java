package com.nbu.Model.UserFunctionality;


import com.nbu.Model.Customer;
import com.nbu.Model.GlobalDataStructures;
import com.nbu.Model.Product;
import com.nbu.Model.Store;

import java.util.Scanner;

/*
        (1)  See available items
        (2)  Enter Budget ;
        (3)  Make a purchase;
        (4)  Check Budget;
        (0)  Exit;
 */
public class CustomerOptions {
    Scanner input = new Scanner (System.in);

    public void showAllGoodsAvailable_Customer() {
        System.out.println ("You have chosen to view all available products");
        //Show all goods in the store
        System.out.println ("Goods in the list:" + Store.productArrayList.size ());
        //Print the information for every store object saved in the Arraylist of objects
        for (Product product : Store.productArrayList) {
            product.getProductDetails ();
        }
    }


    public void enterBudget() {
        System.out.println ("You have chosen to enter budget.");
        System.out.println ("What is your budget?");
        Double budget;
        budget = input.nextDouble ();
        String customerID;
        System.out.println ("What is your CustomerID?");
        customerID = input.next ();
        GlobalDataStructures.storeCustomersArrList.add (new Customer (customerID, budget));
    }


    public void showBudget() {
        System.out.println ("You have chosen to check you budget.");
        System.out.println ("Please select your customer ID from the list");
        for (Customer customer : GlobalDataStructures.storeCustomersArrList) {
            int i = 1;
            System.out.println (i + ". " + customer.getCustomerNumber ());
            i++;
        }
        String cNumber = input.next ();
        for (Customer customer : GlobalDataStructures.storeCustomersArrList) {
            if (cNumber.equals (customer.getCustomerNumber ()))
                System.out.println ("Your Budget is:" + customer.getBudget ());
        }
    }
}
