package com.nbu.Model;

import com.nbu.Model.GlobalDataStructures;
import com.nbu.Model.Store;

import java.util.Scanner;

/*
Manager menu options:
        (1)  Show all available stores and their information
        (2)  Create a new store";
        (3)  Show all goods available in the store");
        (4)  Show all cashiers working in the store");
        (5)  Show the total amount of all receipts");
        (6) - Add new cashier: ID, Name, workplace number[1-5]");
        (7) - Add a new item/good: ID, Name, Price, expiry date");
 */


public class ManagerOptions {

    public void printAvailableStoresInfo() {
        //Check the number of stores in the global array list
        System.out.print ("Stores in the list:" + GlobalDataStructures.storeArrayList.size ());
        //Print the information for every store object saved in the Arraylist of objects
        for (Store store : GlobalDataStructures.storeArrayList) {
            store.getStoreInfo ();
        }


    }

    public void createANewStore() {
     String storeName, storeLocation;
     Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter a name for the new store:");
     storeName = scanner.next ();
        System.out.println("Please enter a location for the new store:");
     storeLocation = scanner.next ();
     GlobalDataStructures.storeArrayList.add (new Store (storeName,storeLocation));
    }

}
