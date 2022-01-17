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
                addressBook.updateRecords();
                break;
            case '3':
                addressBook.add();
                break;
            case '4':
                addressBook.Sort();
                break;
            case '5':
                addressBook.readFile();
                break;
            case '6':
                addressBook.remove();
                break;
            case '7':
                addressBook.search();
                break;
            case '8':
                addressBook.edit();
                break;
            case 'x':
            case 'q':
                System.out.println("Bye, now.");
                System.exit(0);
            default:
                System.out.println("\nError : Invalid input, try again.");
        }
        init();

    }


    void showMenu(String opened){
        System.out.print("\n########################## \n" +
                            "1) Load from file " + ((opened != null) ? "(" + opened + ")": "") + "\n" +
                            "2) Save to file\n" +
                            "3) Add entry/entries \n" +
                            "4) Sort the address book \n" +
                            "5) Show all in address book \n" +
                            "6) Delete record\n" +
                            "7) Search records\n" +
                            "8) Edit records\n" +
                            "x) Quit \n" +
                            "########################## \n" +
                            "\nAnswer : "
        );
    }

}
