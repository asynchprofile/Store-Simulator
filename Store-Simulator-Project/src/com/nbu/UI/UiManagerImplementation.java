package com.nbu.UI;
//Class to implement the UiManager interface and combine the functionality of classes in this package


public class UiManagerImplementation implements UiManager {

    private ConsoleMessages messagesManager;

    //Constructor
    public UiManagerImplementation() {
        this.messagesManager = new ConsoleMessages ();
    }


    @Override
    public void showUserActionMenu() {
        //Ask user to identify
        messagesManager.showIdentificationMenu ();

    }

}
