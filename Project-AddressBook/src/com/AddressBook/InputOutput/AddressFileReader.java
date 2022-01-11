package com.AddressBook.InputOutput;


import com.AddressBook.Model.AddressBookEntry;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class AddressFileReader {
    String fileName;
    List<AddressBookEntry> addressList;

    public boolean init(String fileName){
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("\nNew File created: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
                addressList = new ArrayList<>();
            }
            else{
                addressList = getDataInFile(fileName);
                System.out.println("\nLoaded (" + addressList.size() + " records) : " + fileName);
            }
            this.fileName = fileName;
        } catch (IOException e) {
            System.out.println("Error : creating new file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<AddressBookEntry> getDataInFile(String fileName){
        List<AddressBookEntry> Line2Object = new ArrayList<>();
        if(fileName == null){
            System.out.println("\nError : fileName is null");
            return null;
        }
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            if(sc.hasNextLine()) {
                while (sc.hasNextLine()) {
                    String currLine = sc.nextLine();
                    if(currLine.length() > 1)
                        Line2Object.add(new AddressBookEntry(currLine));
                }
            }
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return Line2Object;
    }

    public void refreshFileData(){
        if(fileName == null){
            System.out.println("\nError : fileName is null");
            return ;
        }
        try {
            addressList.clear();
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            if(sc.hasNextLine()) {
                while (sc.hasNextLine()) {
                    String currLine = sc.nextLine();
                    if(currLine.length() > 1)
                        addressList.add(new AddressBookEntry(currLine));
                }
            }
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void showAddressFile(){
        System.out.println("\nRecords in " + fileName + " :-\n");
        if(addressList != null && addressList.size() > 0){
            int index = 0;
            for(AddressBookEntry add : addressList)
                System.out.println(add.toString());
        }
    }

    public List<AddressBookEntry> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressBookEntry> addressList) {
        this.addressList = addressList;
    }
}
