package com.AddressBook;

import com.AddressBook.InputOutput.AddressFileReader;
import com.AddressBook.InputOutput.AddressFileWriter;
import com.AddressBook.Services.AddressBookServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AppStarter {

    private int addressLimit;
    private HashSet<String> recentFiles = new HashSet<>();

    private Scanner takeIn = new Scanner(System.in);
    private String fileName;

    private AddressBookServices addressBook = new AddressBookServices();


    AppStarter(int addressLimit){
        this.addressLimit = addressLimit;
    }

    void init(){
        showMenu(fileName);
        char choice = takeIn.nextLine().trim().charAt(0);

        switch(choice){
            case '1':
                String newFileName = addressBook.openFile();
                if(newFileName != null) this.fileName = newFileName;
                break;
            case '2':
                addressBook.add();
                break;
            case '3':
                addressBook.Sort();
                break;
            case '4':
                addressBook.readFile();
                break;
            default:
                System.out.println("Bye, now.");
                System.exit(0);
        }
        init();

    }




    void showMenu(String opened){
        System.out.print("\n########################## \n" +
                            "1) Load from file " + ((opened != null) ? "(" + opened + ")": "") + "\n" +
                            "2) Add entry/entries \n" +
                            "3) Sort the address book \n" +
                            "4) Show all in address book \n" +
                            "x) Quit \n" +
                            "########################## \n" +
                            "\nAnswer : "
        );
    }

}
