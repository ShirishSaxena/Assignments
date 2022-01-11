package com.AddressBook.Services;

import com.AddressBook.InputOutput.AddressFileReader;
import com.AddressBook.InputOutput.AddressFileWriter;
import com.AddressBook.Model.AddressBookEntry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookServices {
    private String fileName;
    private List<List<String>> addressBook = new ArrayList<>();

    private Scanner takeIn = new Scanner(System.in);

    private AddressFileReader addressFileReader = new AddressFileReader();
    private AddressFileWriter addressFileWriter = new AddressFileWriter();

    public void init(String fileName){
        this.fileName = fileName;
        addressFileWriter.init(fileName);
        addressFileReader.init(fileName);
    }

    public void Sort(){
        System.out.println("\nSorry, it's not implemented yet.");
//        System.out.print("\nShow By :\n" +
//                "1). LastName | 2). FirstName | 3). Email ? : ");
//
//        char choice = takeIn.nextLine().trim().charAt(0);
    }
    public void tempFunc(){
        System.out.println(addressFileReader.getDataInFile().size());
    }
    public String openFile(){
        System.out.print("File name ? (file.ncx) : ");
        String currFileName = takeIn.nextLine().trim();

        if(currFileName.endsWith(".ncx")) {
            if (addressFileReader.init(currFileName)) {
                this.fileName = currFileName;
                addressFileWriter.init(currFileName);
            } else {
                System.out.println("Error : openFile, AppStarter");
                return null;
            }
        }
        else
            openFile();

        return currFileName;
    }

    public void readFile(){
        addressFileReader.showAddressFile();
    }

    public void add(){
        if(this.fileName == null) {
            System.out.println("Error : Filename is null");
            return ;
        }

        System.out.print("\n1). Single entry | 2). Multiple entry ? : ");
        char choice = takeIn.nextLine().trim().charAt(0);
        switch(choice){
            case '1':
                addSingleEntry();
                break;
            case '2':
                addMultipleEntry();
                break;
            default:
                System.out.println("\nWrong choice, try again.");
        }
    }

    private void addMultipleEntry(){
        List<String> multiEntryList = new ArrayList<>();
        System.out.println("\nEnter multiple entries in the following format (enter 'q' when finished)");
        System.out.println("FirstName | lastName | Address | email | PhoneNo\n");

        String currInput = "";
        do{
            currInput = takeIn.nextLine().trim();

            if(currInput.equalsIgnoreCase("q"))
                break;

            multiEntryList.add(currInput);
        } while(!currInput.equalsIgnoreCase("q"));

        addressFileWriter.Write2File(multiEntryList);
    }

    private void addSingleEntry(){
        String firstName, lastName, address, email;
        Integer phoneNo;

        System.out.print("First Name : ");
        firstName = takeIn.nextLine().trim();

        System.out.print("Last Name : ");
        lastName = takeIn.nextLine().trim();

        System.out.print("Address : ");
        address = takeIn.nextLine().trim();

        System.out.print("Email : ");
        email = takeIn.nextLine().trim();

        System.out.print("phoneNo : ");
        phoneNo = Integer.parseInt(takeIn.nextLine().trim());

        addressFileWriter.Write2File(firstName + " | " + lastName +  " | " + address +  " | " + email +  " | " + phoneNo);
    }
}
