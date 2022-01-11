package com.AddressBook;

public class Driver {

    public static void main(String[] args) {
	    try{
            AppStarter appStarter = new AppStarter(10);
            appStarter.init();
        } catch(Exception e){
            System.out.println("Error -> can not start the app.");
        }
    }
}
