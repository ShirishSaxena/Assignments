package com.calc;

import com.calc.CalcHelper.Calc1Split;
import com.calc.CalcHelper.Calc2Split;
import com.calc.CalcHelper.Calc3Split;

import java.util.*;

public class Calculator {
    private String LastStoredResult = "0"; // prevents null exception if called at fresh run.

    // Using LinkedHashMap to store and display input and their results.
    // Why? because LinkedHashMap allows insertion-order iteration
    private Map<List<String>, String> saveInputs= new LinkedHashMap<>();

    // Main method that does calculation depending on the split size
    String Calculate(String line){
        return line;
    }

    String Calculate(List<String> parsedIn){
        int size = parsedIn.size();
        String result;
        switch(size){
            case 1:
                Calc1Split calc1Split = new Calc1Split(LastStoredResult);
                result = calc1Split.getAns(parsedIn.get(0));
                changeLastResult(result);
                saveInputs.put(parsedIn, result);
                return result;
            case 2:
                Calc2Split calc2Split = new Calc2Split(LastStoredResult);
                result = calc2Split.getAns(parsedIn);
                changeLastResult(result);
                saveInputs.put(parsedIn, result);
                return result;
            case 3:
                Calc3Split calc3Split = new Calc3Split(LastStoredResult);
                result = calc3Split.getAns(parsedIn);
                changeLastResult(result);
                saveInputs.put(parsedIn, result);
                return result;
            default:
                return "Error : No valid Input found.\nType 'help' for available commands.";
        }
    }


    // Method that checks if new prev is integer or double, if not than don't change it
    void changeLastResult(String newResult){
        try{
            Integer.parseInt(newResult);
            this.LastStoredResult = newResult;
        } catch(NumberFormatException e1){
            try{
                Double.parseDouble(newResult);
                this.LastStoredResult = newResult;
            } catch (NumberFormatException e2){
                return;
            }
        }
    }
    // shows input history and their answers...
    void recall(){
        Set<List<String>> keys = saveInputs.keySet();
        for(List<String> l : keys){
            System.out.println(l.toString() + " -> " + saveInputs.get(l));
        }
    }

    // Self-explanatory
    void showSyntax(){
        System.out.println("\nShow previous results -> 'recall'\n");
        System.out.println("Basic : A o B **");
        System.out.println("Factorial : N !");
        System.out.println("Logarithms : log N");
        System.out.println("Negation : +/- N");
        System.out.println("Trigonometry : sin/cos/tan N");
        System.out.println("Square roots : sqrt N");

        System.out.println("\n** Where A, B & N are operands and 'o' is an operator");
        System.out.println("'o' supports : + | - | * | / | ^ | %");

        System.out.println("\nUse 'prev' anywhere in operand to calculate result based on previous result");
    }
}
