package com.AddressBook.InputOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressFileWriter {
    String fileName;

    Scanner takeIn = new Scanner(System.in);
    public void init(String fileName){
        this.fileName = fileName;
    }

    public void Write2File(String line){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write("\n" + line);
            fileWriter.close();
            System.out.println("\nSuccess : 1 record added.");
        }
        catch (IOException e) {
            System.err.println("IOException : " + e.getMessage());
        }
    }

    public void Write2File(List<String> multiList){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            for(String s : multiList)
                fileWriter.write("\n" + s);
            fileWriter.close();
            System.out.println("\nSuccess : " + multiList.size() +" records added.");
        }
        catch (IOException e) {
            System.err.println("IOException : " + e.getMessage());
        }
    }

}
