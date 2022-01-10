package com.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHelper {

    Calculator calculator = new Calculator();

    Scanner input = new Scanner(System.in);
    String inputStr;

    // Constructors
    InputHelper(){
        getInput();
    }

    // Helper functions
    void getInput(){
        System.out.print("\n> ");
        this.inputStr = input.nextLine().trim();

        if(this.inputStr.length() == 0){
            System.out.println("Bye, now.");
            return ;
        }

        if(this.inputStr.equals("help")){
            calculator.showSyntax();
        }
        else if(this.inputStr.equals("recall"))
        {
            calculator.recall();
        }
        else{
            List<String> temp = InputSplitter();
            if (isOperandZero(temp)){
                System.out.print("Bye, now.");
                return;
            }
            if(temp.get(0).equals("quit") || temp.get(0).equals("exit")){
                System.out.print("Bye, now.");
                return;
            }
            doCalculations(temp);
            // do calculations and show them
        }
        getInput(); // recursively call until 0 is encounted
    }

    // Calls the calculators main calculator class after parsing String Input.
    void doCalculations(List<String> temp){ //
        System.out.println(calculator.Calculate(temp));
    }


    // Splits input in parts
    List<String> InputSplitter(){
        int len = this.inputStr.length();
        List<String> list = new ArrayList<>();

        // loop to get input by spaces, save and return list.
        StringBuilder sb = new StringBuilder();

        // way faster than using regex String.split(" +");
        for(int i=0; i < len; i++){
            if(inputStr.charAt(i) == ' '){
                list.add(sb.toString());
                sb.setLength(0); // clean prev input
            }
            // incase there are more spaces
            while(i < len && inputStr.charAt(i) == ' ') i++;

            sb.append(inputStr.charAt(i));
        }

        list.add(sb.toString()); // add the last element
        return list;
    }

    boolean isOperandZero(List<String> list){
        if(list.size() == 0) return true;

        // could've used String.equals("0") but trusting user to only input 0 instead of 0.000 is a risky move!
        String x = list.get(0);
        try {
            if(Integer.parseInt(x) == 0) return true;
        } catch (NumberFormatException e) {
            try {
                if(Double.parseDouble(x) == 0) return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return false;
    }
}
