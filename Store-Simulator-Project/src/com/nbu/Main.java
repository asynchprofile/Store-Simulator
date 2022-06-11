package com.nbu;

import com.nbu.Controller.StoreManager_Controller;
import com.nbu.Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.print ("::: Store Simulator App :::");

        //Create Stores with names and locations
        Store store1 = new Store ("Office 1 Superstore", "Sofia, Bul. Tsarigradsko shushe 119");
        Store store2 = new Store ("Fantastico", "Sofia, Studentski Grad");

        //Create products to be added in the store
        Product bread = new Product ("ID-100", "Dobrudjanski Bread", Category.FOOD, "30/08/2022", 1.20, 65);
        Product milk = new Product ("ID-101", "Vereya Milk", Category.FOOD, "31/08/2022", 1.50, 80);
        Product sugar = new Product ("ID-102", "Sugar", Category.FOOD, "31/08/2022", 0.99, 100);
        Product salt = new Product ("ID-103", "Salt", Category.FOOD, "11/06/2022", 1.0, 100);


        //Create cashier object instances
        Cashier cashier1 = new Cashier ("Martin", "0001", 1500.50, 3);
        Cashier cashier2 = new Cashier ("Victoria", "0002", 1650.50, 2);

        //Create customers
        //  Customer customer1 = new Customer("001", 100.5, "Sugar");
        // Customer customer2 = new Customer("001", 100.5, "Salt");

      //  customer1.getCustomerInfo ();
      //  customer2.getCustomerInfo ();


        // Start process
       new StoreManager_Controller ();

    }
}
