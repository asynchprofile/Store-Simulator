package com.nbu.Controller;

import com.nbu.Model.ManagerOptions;
import com.nbu.UI.ConsoleMessages;
import com.nbu.UI.UiManagerImplementation;

import java.util.Scanner;

import static java.lang.System.exit;


enum UserType {
    MANAGER, CUSTOMER, UNKNOWN
}

//A class to facilitate the business logic between UI, user interactions and
public class StoreManager_Controller {

    private final ConsoleMessages consoleMessages;
    private final UiManagerImplementation uiManager;
    private final ManagerOptions managerOptions;

    public StoreManager_Controller() {
        this.managerOptions = new ManagerOptions ();
        this.consoleMessages = new ConsoleMessages ();
        this.uiManager = new UiManagerImplementation ();
        startProcess ();
    }


    private void startProcess() {
        uiManager.showUserActionMenu ();
        //Ask user to identify in order to show the applicable options
        UserType userIdentification = getUserType ();
        //Display the Manager or Customer menu based on the user type
        defineUserMenuView (userIdentification);
        //Handle user input and call appropriate methods
        // getUserChoice (userIdentification);

    }


    //A method to facilitate user identification - manager or customer
    private UserType getUserType() {
        Scanner input = new Scanner (System.in);
        String userChoice = input.next ();
        UserType userType = UserType.UNKNOWN;
        switch (userChoice) {
            case "1":
                System.out.println ("You have chosen option (1) Manager ");
                userType = UserType.MANAGER;
                break;
            case "2":
                System.out.println ("You have chosen option (2) Client ");
                userType = UserType.CUSTOMER;
                break;
            default:
                consoleMessages.printMsg ("No such option, please try again!");
                break;
        }
        return userType;
    }

    //Display the corresponding menu based on the user type
    private void defineUserMenuView(UserType userX) {
        switch (userX) {
            case MANAGER:
                getManagerUserChoice ();
                break;
            case CUSTOMER:
                consoleMessages.showCustomerMenu ();
                break;
            case UNKNOWN:
                consoleMessages.printMsg ("Error.No such option.");
                break;
            default:
                consoleMessages.printMsg ("Problem Identifying the type of user. Please try again!");
                break;
        }
    }

    private void getManagerUserChoice() {
        char quit = 'y';
        int userChoice = 0;
        String quitMenu = "no";
        Scanner input = new Scanner (System.in);

        while (quit != 'n') {
            consoleMessages.showManagerMenu ();
            System.out.print ("Please choose an option from the Manager menu. Exit process with [0]:");
            userChoice = input.nextInt ();
            try {
                switch (userChoice) {
                    case 1:
                        managerOptions.printAvailableStoresInfo ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 2:
                        managerOptions.createANewStore ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 3:
                        System.out.println ("Case 3");
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 0:
                        exit (0);
                }
                quit = quitMenu.charAt (0);
            } catch (Exception ex) {
                System.out.println ("Please enter an integer value between 1 and 7. Enter 0 to exit");
                input.next ();
            }
        }
    }
}



