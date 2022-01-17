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

    public void search(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to search records");
            return ;
        }
        System.out.print("\nSearch from 1) email 2) PhoneNo 3) FirstName 4) LastName 5) Address\nAnswer : ");
        char getIn = takeIn.nextLine().trim().charAt(0);

        if(Character.isLetter(getIn)) {
            System.out.println("\nchar encountered -> going back to the main menu.");
            return;
        }
        else if(getIn > '5' || getIn < '1') {
            System.out.println("\nError : ans not in range of 1 - 5");
            search();
        }

        System.out.print("\nSearch by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match\nAnswer : ");
        char getSearchBy = takeIn.nextLine().trim().charAt(0);

        if(Character.isLetter(getSearchBy)) {
            System.out.println("\nchar encountered -> going back to the main menu.");
            return;
        }
        else if (getSearchBy > '4' || getSearchBy < '1') {
            System.out.println("\nError : ans not in range of 1 - 4");
            search();
        }

        System.out.print("\nEnter a string to search : ");
        String searchStr = takeIn.nextLine().trim();
        List<AddressBookEntry> entries = searchCondition(getIn - '0', getSearchBy -'0', searchStr);

        System.out.println("\n||****  Search result  ****||");
        addressFileReader.showAddressFile(entries);
        return;
    }

    private List<AddressBookEntry> searchCondition(int searchFrom, int searchBy, String searchStr){
        List<AddressBookEntry> entries = null;
        AddressBookSearchServices addressBookSearchServices = new AddressBookSearchServices();
        // get current addressList
        List<AddressBookEntry> currList = addressFileReader.getAddressList();

        // Search from 1) email 2) PhoneNo 3) FirstName 4) LastName 5) Address
        switch(searchFrom){
            case 1:
                entries = addressBookSearchServices.getResultByEmail(currList, searchBy, searchStr);
                break;
            case 2:
                entries = addressBookSearchServices.getResultByPhone(currList, searchBy, searchStr);
                break;
            case 3:
                entries = addressBookSearchServices.getResultByFirstName(currList, searchBy, searchStr);
                break;
            case 4:
                entries = addressBookSearchServices.getResultByLastName(currList, searchBy, searchStr);
                break;
            case 5:
                entries = addressBookSearchServices.getResultByAddress(currList, searchBy, searchStr);
                break;
        }
        return entries;
    }

    public void updateRecords(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to update records on");
            return ;
        }
        if(addressFileWriter.updateRecords(addressFileReader.getAddressList()))
            System.out.println("\nUpdated file : " + this.fileName);
        else
            System.out.println("\nError updating file");
    }

    public void edit(){
        if(this.fileName == null) {
            System.out.println("\nError : no file defined to edit records");
            return ;
        }

        System.out.println("\nSelect any index below to edit that record : ");
        int idx = 0;
        List<AddressBookEntry> getEntries = addressFileReader.getAddressList();
        for(AddressBookEntry entry : getEntries){
            System.out.println(idx++ + " -> " + entry.toString());
        }
        System.out.print("\nAnswer : ");
        char answer = takeIn.nextLine().trim().charAt(0);

        while(!Character.isLetter(answer) && (answer < '0' || answer > (idx + '0'))){
            System.out.print("\nAnswer (Not in range, q to quit) : ");
            answer = takeIn.nextLine().trim().charAt(0);
        }

        if(Character.isLetter(answer)){
            System.out.println("\nError : character encountered going back to main menu");
            return;
        }

        System.out.println("What would you like to edit in record " + idx + " ?");
        System.out.print("1) FirstName 2)LastName 3) Address 4) Email 5) PhoneNo 6) All ? : ");
        char editans = takeIn.nextLine().trim().charAt(0);

        String changeWith;
        switch(editans){
            case '1':
                System.out.print("\nEnter to replace with : ");
                changeWith = takeIn.nextLine().trim();
                getEntries.get(answer - '0').setFirstName(changeWith);
                break;
            case '2':
                System.out.print("\nEnter to replace with : ");
                changeWith = takeIn.nextLine().trim();
                getEntries.get(answer - '0').setLastName(changeWith);
                break;
            case '3':
                System.out.print("\nEnter to replace with : ");
                changeWith = takeIn.nextLine().trim();
                getEntries.get(answer - '0').setAddress(changeWith);
                break;
            case '4':
                System.out.print("\nEnter to replace with : ");
                changeWith = takeIn.nextLine().trim();
                getEntries.get(answer - '0').setEmail(changeWith);
                break;
            case '5':
                System.out.print("\nEnter to replace with : ");
                changeWith = takeIn.nextLine().trim();
                getEntries.get(answer - '0').setPhoneNo(changeWith);
                break;
            case '6':
                System.out.println("Pattern to edit all elements in record is\n" +
                                    "FirstName | LastName | address | email | phoneNo :-");
                changeWith = takeIn.nextLine().trim();

                if(getEntries.get(answer - '0').setAll(changeWith))
                    System.out.println("\nError : wrong pattern entered.");
                break;
        }
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
