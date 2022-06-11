package com.nbu.Model.UserFunctionality;

import com.nbu.Model.*;

import java.util.Scanner;

/*
Manager menu options:
       (1)  Show all stores information");
       (2)  Create a new store");
       (3)  Show all goods available in the store");
       (4)  Show all cashiers working in the store");
       (5)  -Show the total amount of all receipts");
       (6)  Add new cashier: ID, Name, workplace number[1-5]");
       (7)  Add a new item/good: ID, Name, Price, expiry date, Price by delivery, quantity");
       (0)  Exit");
 */


public class ManagerOptions {

    Scanner scanner = new Scanner (System.in);

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
        System.out.println ("Please enter a name for the new store:");
        storeName = scanner.next ();
        System.out.println ("Please enter a location for the new store:");
        storeLocation = scanner.next ();
        GlobalDataStructures.storeArrayList.add (new Store (storeName, storeLocation));
    }


    public void showAllGoodsAvailable() {
        //Show all goods in the store
        System.out.println ("Goods in the list:" + Store.productArrayList.size ());
        //Print the information for every store object saved in the Arraylist of objects
        for (Product product : Store.productArrayList) {
            product.getProductDetails ();
        }
    }

    public void showAllCashiersWorking() {
        //Show all goods in the store
        System.out.println ("Cashiers working in the store:" + Store.cashierArrayList.size ());
        //Print the information for every store object saved in the Arraylist of objects
        for (Cashier cashier : Store.cashierArrayList) {
            cashier.getEmployeeDetails ();
        }
    }


    public void addNewCashier() {
        System.out.println ("You have chosen to add new cashier.");
        System.out.println ("Please write his/her name:");
        String cName = scanner.next ();
        System.out.println ("Please write cashier ID:");
        String cID = scanner.next ();
        System.out.println ("Please write salary:");
        Double cSalary = scanner.nextDouble ();
        System.out.println ("Please write workstation:");
        int workplace = scanner.nextInt ();
        Store.cashierArrayList.add (new Cashier (cName, cID, cSalary, workplace));
        System.out.println ("You have successfully added a new cashier!");

    }

    public void addNewItemGood() {
        System.out.println ("You have chosen to add a new idem/good.");
        System.out.println ("Please write item ID in the format [ID-10X]:");
        String itemID = scanner.next ();
        System.out.println ("Please write item Name:");
        String itemName = scanner.next ();
        System.out.println ("Please write item Category [Food/Other]:");
        String itemCategory = scanner.next ();
        Category itemCategory1 = Category.UNKNOWN;

        if(itemCategory.equalsIgnoreCase ("Food")) {
            itemCategory1 = Category.FOOD;
        }
        else if (itemCategory.equalsIgnoreCase ("Other")) {
            itemCategory1 = Category.OTHER;
        }

        System.out.println ("Please write expiry date in the format dd/MMM/yyyy :");
        String expDate = scanner.next ();
        System.out.println ("Please enter price by delivery:");
        Double itemPriceByD = scanner.nextDouble ();
        System.out.println ("Please enter quantity:");
        int quantity = scanner.nextInt ();
        Store.productArrayList.add (new Product (itemID, itemName, itemCategory1, expDate, itemPriceByD, quantity));
        System.out.println ("You have successfully added a new item to the store!");
    }
}



