package com.nbu;

import com.nbu.Controller.StoreManager_Controller;
import com.nbu.Model.Category;
import com.nbu.Model.ManagerOptions;
import com.nbu.Model.Product;
import com.nbu.Model.Store;

public class Main {

    public static void main(String[] args) {
        System.out.print ("::: Store Simulator App :::");

        //Create Stores with names and locations
        Store store1 = new Store ("Office 1 Superstore", "Sofia, Bul. Tsarigradsko shushe 119");
        Store store2 = new Store ("Fantastico", "Sofia, Studentski Grad");

        //Create products to be added in the store
        Product bread = new Product ("ID-100", "Dobrudjanski Bread", Category.FOOD, "30/08/2022", 1.20, 65);
        Product milk = new Product ("ID-101", "Vereya Milk", Category.FOOD, "31/08/2022", 1.50, 80);


       // Start process
        new StoreManager_Controller ();


    }
}
