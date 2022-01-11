package com.AddressBook.InputOutput;


import com.AddressBook.Model.AddressBookEntry;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressFileReader {
    String fileName;

    public boolean init(String fileName){
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("\nNew File created: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
            }
            else{
                System.out.println("\nLoaded : " + fileName);
            }
            this.fileName = fileName;
        } catch (IOException e) {
            System.out.println("Error : creating new file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<String> getDataInFile(){
        List<String> Line2Object = new ArrayList<>();
        if(fileName == null){
            System.out.println("\nError : fileName is null");
            return Line2Object;
        }
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            if(sc.hasNextLine()) {
                while (sc.hasNextLine()) {
                    Line2Object.add(sc.nextLine());
                }
            }
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return Line2Object;
    }

    public void showAddressFile(){
        if(fileName == null){
            System.out.println("\nError : fileName is null");
            return ;
        }
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            if(sc.hasNextLine()) {
                System.out.println("\nData in address book (" + fileName + ") :-\n");
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
            else
                System.out.println("\nAddress book (" + fileName + ") is empty.");
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }



}
