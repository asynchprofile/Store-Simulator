package com.nbu.UI;

//A class to hold all information and messages relevant to the user
public class ConsoleMessages {

    public void printMsg(String content) {
        System.out.println (content);
    }

    ;

    public void showIdentificationMenu() {
        System.out.println ();
        printMsg ("Welcome, please identify yourself ");
        printMsg ("You are: \n(1) A Manager \n(2) A Client. \n Please select one of the given options:");
    }

    /***************************************************/

    //Menu for Managers only
    public void showManagerMenu() {
        System.out.println (" ---- Manager Actions ----- ");
        System.out.println ("(1)  Show all stores information");
        System.out.println ("(2)  Create a new store");
        System.out.println ("(3)  Show all goods available in the store");
        System.out.println ("(4)  Show all cashiers working in the store");
        System.out.println ("(5)  Show the total amount of all receipts");
        System.out.println ("(6) - Add new cashier: ID, Name, workplace number[1-5]");
        System.out.println ("(7) - Add a new item/good: ID, Name, Price, expiry date");
        System.out.println ("(0)  Exit");
        System.out.println ("-------------------------------------\n");
    }

    //Menu for Clients only
    public void showCustomerMenu() {
        System.out.println ("------ Client Actions --------");
        System.out.println ("(1)  Enter Budget ");
        System.out.println ("(2)  Make a purchase");
        System.out.println ("(3)  Check Budget");
        System.out.println ("(0)  Exit");
        System.out.println ("----------------------\n");
    }

}


