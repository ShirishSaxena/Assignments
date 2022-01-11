package com.AddressBook.Services;

import com.AddressBook.InputOutput.AddressFileReader;
import com.AddressBook.InputOutput.AddressFileWriter;
import com.AddressBook.Model.AddressBookEntry;
import com.AddressBook.Model.AddressBookEntryComparator;

import java.io.File;
import java.util.*;

public class AddressBookServices {
    private String fileName;

    private Scanner takeIn = new Scanner(System.in);

    private AddressFileReader addressFileReader = new AddressFileReader();
    private AddressFileWriter addressFileWriter = new AddressFileWriter();

    public void init(String fileName){
        this.fileName = fileName;
        addressFileWriter.init(fileName);
        addressFileReader.init(fileName);
    }

    public void remove(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to remove data from");
            return ;
        }
        System.out.print("Enter email to remove from record : ");
        String email2Delete = takeIn.nextLine().trim();
        List<AddressBookEntry> addList = addressFileReader.getAddressList();
        int deleted = 0;
        // Not an efficient loop, could've used LinkedHashMap for better searching and deletion
        // But it works for now... o(N)
        for(int i = 0; i < addList.size(); i++){
            if(addList.get(i).getEmail().equalsIgnoreCase(email2Delete)){
                deleted++;
                addList.remove(i--);
            }
        }

        if(deleted > 0){
            addressFileReader.setAddressList(addList);
            System.out.println("\nDeleted : " + deleted + " records.\n" +
                               "Type 2 to save these changes.");
        }

    }

    public void Sort(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to sort records from");
            return ;
        }

        System.out.print("\nSort By :\n" +
                "1) FirstName | 2) LastName | 3) Email | 4) Phone No | 5) Address" +
                "\nAnswer :  ");
        char choice = takeIn.nextLine().trim().charAt(0);
        List<AddressBookEntry> sortedBook = addressFileReader.getAddressList();
        switch(choice){
            case '1':
                Collections.sort(sortedBook, new AddressBookEntryComparator().new FirstNameComparator());
                addressFileReader.setAddressList(sortedBook);
                System.out.println("\nSuccess : Sorted by 'firstName'. Type 5 to show and 2 to save sorted data to file");
                break;
            case '2':
                Collections.sort(sortedBook, new AddressBookEntryComparator().new LastNameComparator());
                addressFileReader.setAddressList(sortedBook);
                System.out.println("\nSuccess : Sorted by 'lastName'. Type 5 to show and 2 to save sorted data to file");
                break;

            case '3':
                Collections.sort(sortedBook, new AddressBookEntryComparator().new EmailComparator());
                addressFileReader.setAddressList(sortedBook);
                System.out.println("\nSuccess : Sorted by 'email'. Type 5 to show and 2 to save sorted data to file");
                break;
            case '4':
                Collections.sort(sortedBook, new AddressBookEntryComparator().new PhoneComparator());
                addressFileReader.setAddressList(sortedBook);
                System.out.println("\nSuccess : Sorted by 'PhoneNo'. Type 5 to show and 2 to save sorted data to file");
                break;
            case '5':
                Collections.sort(sortedBook, new AddressBookEntryComparator().new AddressComparator());
                addressFileReader.setAddressList(sortedBook);
                System.out.println("\nSuccess : Sorted by 'Address'. Type 5 to show and 2 to save sorted data to file");
                break;
            default:
                System.out.println("Error : invalid choice, try again.");
        }
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
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to show records");
            return ;
        }
        addressFileReader.showAddressFile();
    }

    public void updateRecords(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to update records on");
            return ;
        }
        if(addressFileWriter.updateRecords(addressFileReader.getAddressList()))
            System.out.println("\nUpdated file : " + this.fileName);
        else
            System.out.println("\nError update file");
    }


    public void add(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to add records");
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
        addressFileReader.refreshFileData();
    }

    private void addSingleEntry(){
        String firstName, lastName, address, email, phoneNo;

        System.out.print("First Name : ");
        firstName = takeIn.nextLine().trim();

        System.out.print("Last Name : ");
        lastName = takeIn.nextLine().trim();

        System.out.print("Address : ");
        address = takeIn.nextLine().trim();

        System.out.print("Email : ");
        email = takeIn.nextLine().trim();

        System.out.print("phoneNo : ");
        phoneNo = takeIn.nextLine().trim();

        addressFileWriter.Write2File(firstName + " | " + lastName +  " | " + address +  " | " + email +  " | " + phoneNo);
        addressFileReader.getDataInFile(this.fileName);
        addressFileReader.refreshFileData();
    }
}
