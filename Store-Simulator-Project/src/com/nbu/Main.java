package com.nbu;

import com.nbu.Controller.StoreManager_Controller;
import com.nbu.Model.GlobalDataStructures;
import com.nbu.Model.Store;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.print ("::: Store Simulator App :::");

        //Create Stores with names and locations
        Store store1 = new Store ("Office 1 Superstore", "Sofia, Bul. Tsarigradsko shushe 119");
        Store store2 = new Store ("Fantastico", "Sofia, Studentski Grad");

        //Start process
        new StoreManager_Controller ();


    }
}
