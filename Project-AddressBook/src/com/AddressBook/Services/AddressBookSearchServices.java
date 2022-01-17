package com.AddressBook.Services;

import com.AddressBook.Model.AddressBookEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSearchServices {
    public List<AddressBookEntry> getResultByEmail(List<AddressBookEntry> addressBookEntries, int searchBy, String search){

        List<AddressBookEntry> searchList = new ArrayList<>();

        // Search by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match
        for(AddressBookEntry bookEntry : addressBookEntries){
            switch(searchBy){
                case 1:
                    if(bookEntry.getEmail().contains(search))
                        searchList.add(bookEntry);
                    break;
                case 2:
                    if(bookEntry.getEmail().startsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 3:
                    if(bookEntry.getEmail().endsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 4:
                    if(bookEntry.getEmail().equals(search))
                        searchList.add(bookEntry);
                    break;
            }
        }
        return searchList;
    }

    public List<AddressBookEntry> getResultByPhone(List<AddressBookEntry> addressBookEntries, int searchBy, String search){

        List<AddressBookEntry> searchList = new ArrayList<>();

        // Search by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match
        for(AddressBookEntry bookEntry : addressBookEntries){
            switch(searchBy){
                case 1:
                    if(bookEntry.getPhoneNo().contains(search))
                        searchList.add(bookEntry);
                    break;
                case 2:
                    if(bookEntry.getPhoneNo().startsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 3:
                    if(bookEntry.getPhoneNo().endsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 4:
                    if(bookEntry.getPhoneNo().equals(search))
                        searchList.add(bookEntry);
                    break;
            }
        }
        return searchList;
    }

    public List<AddressBookEntry> getResultByFirstName(List<AddressBookEntry> addressBookEntries, int searchBy, String search){

        List<AddressBookEntry> searchList = new ArrayList<>();

        // Search by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match
        for(AddressBookEntry bookEntry : addressBookEntries){
            switch(searchBy){
                case 1:
                    if(bookEntry.getFirstName().contains(search))
                        searchList.add(bookEntry);
                    break;
                case 2:
                    if(bookEntry.getFirstName().startsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 3:
                    if(bookEntry.getFirstName().endsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 4:
                    if(bookEntry.getFirstName().equals(search))
                        searchList.add(bookEntry);
                    break;
            }
        }
        return searchList;
    }

    public List<AddressBookEntry> getResultByLastName(List<AddressBookEntry> addressBookEntries, int searchBy, String search){

        List<AddressBookEntry> searchList = new ArrayList<>();

        // Search by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match
        for(AddressBookEntry bookEntry : addressBookEntries){
            switch(searchBy){
                case 1:
                    if(bookEntry.getLastName().contains(search))
                        searchList.add(bookEntry);
                    break;
                case 2:
                    if(bookEntry.getLastName().startsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 3:
                    if(bookEntry.getLastName().endsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 4:
                    if(bookEntry.getLastName().equals(search))
                        searchList.add(bookEntry);
                    break;
            }
        }
        return searchList;
    }


    public List<AddressBookEntry> getResultByAddress(List<AddressBookEntry> addressBookEntries, int searchBy, String search){

        List<AddressBookEntry> searchList = new ArrayList<>();

        // Search by? 1) Contains 2) StartsWith 3) EndsWith 4) Full Match
        for(AddressBookEntry bookEntry : addressBookEntries){
            switch(searchBy){
                case 1:
                    if(bookEntry.getAddress().contains(search))
                        searchList.add(bookEntry);
                    break;
                case 2:
                    if(bookEntry.getAddress().startsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 3:
                    if(bookEntry.getAddress().endsWith(search))
                        searchList.add(bookEntry);
                    break;
                case 4:
                    if(bookEntry.getAddress().equals(search))
                        searchList.add(bookEntry);
                    break;
            }
        }
        return searchList;
    }
}
