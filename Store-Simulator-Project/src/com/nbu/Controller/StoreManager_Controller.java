package com.nbu.Controller;

import com.nbu.Model.UserFunctionality.CustomerOptions;
import com.nbu.Model.UserFunctionality.ManagerOptions;
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
    private final CustomerOptions customerOptions;

    public StoreManager_Controller() {
        this.customerOptions = new CustomerOptions ();
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
                getManagerUserChoiceMenu ();
                break;
            case CUSTOMER:
                getCustomerUserChoiceMenu ();
            break;
            case UNKNOWN:
                consoleMessages.printMsg ("Error.No such option.");
                break;
            default:
                consoleMessages.printMsg ("Problem Identifying the type of user. Please try again!");
                break;
        }
    }

    private void getManagerUserChoiceMenu() {
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
                        System.out.println ("You have chosen to see all stores available");
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
                        System.out.println ("You have chosen to see all goods available");
                        managerOptions.showAllGoodsAvailable ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 4:
                        System.out.println ("You have chosen to see all cashiers working in the store");
                        managerOptions.showAllCashiersWorking ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 5:
                        System.out.println ("You have chosen to see all recepits");
                        managerOptions.showAllCashiersWorking ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 6:
                        managerOptions.addNewCashier ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;

                    case 7:
                        managerOptions.addNewItemGood ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 0:
                        System.out.println("No such option, please try again!");
                        exit (0);
                }
                quit = quitMenu.charAt (0);
            } catch (Exception ex) {
                System.out.println ("Please enter an integer value between 1 and 7. Enter 0 to exit");
                input.next ();
            }
        }
    }


    private void getCustomerUserChoiceMenu() {
        char quit = 'y';
        int userChoice = 0;
        String quitMenu = "no";
        Scanner input = new Scanner (System.in);

        while (quit != 'n') {
            consoleMessages.showCustomerMenu ();
            System.out.print ("Please choose an option from the Customer menu. Exit process with [0]:");
            userChoice = input.nextInt ();
            try {
                switch (userChoice) {
                    case 1:
                        customerOptions.showAllGoodsAvailable_Customer ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 2:
                        customerOptions.enterBudget ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;
                    case 3:

                        customerOptions.showBudget ();
                        System.out.println ("Would you like to continue? [yes/no]");
                        quitMenu = input.next ();
                        break;

                    case 0:
                        System.out.println("No such option, please try again!");
                        exit (0);
                }
                quit = quitMenu.charAt (0);
            } catch (Exception ex) {
                System.out.println ("Please enter an integer value between 1 and 3. Enter 0 to exit");
                input.next ();
            }
        }
    }



}



