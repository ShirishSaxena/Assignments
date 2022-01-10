package com.calc.CalcHelper;

import java.util.List;

public class Calc3Split {
    String firstOp, secondOp;
    String sign;

    String prevResult;

    public Calc3Split(String prevResult) {
        this.prevResult = prevResult;
    }

    public String getAns(List<String> parsedIn) {
        this.firstOp = parsedIn.get(0);
        this.secondOp = parsedIn.get(2);

        if (firstOp.equals("prev")) firstOp = prevResult;
        if (secondOp.equals("prev")) secondOp = prevResult;

        this.sign = parsedIn.get(1);

        return doOperations(isInteger());
    }

    private String doOperations(boolean allInt) {
        double result = 0;

        double a = String2Double(firstOp), b = String2Double(secondOp);
        switch (sign) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "^":
                result = Math.pow(a, b);
                break;
            case "%":
                result = a % b;
                break;
            default:
                return "Error : Invalid Operator '" + sign + "'";
        }
        // beautify result only return int if result is in int otherwise double
        if ((result == Math.floor(result)) && !Double.isInfinite(result))
            return "" + (int) result;
        else
            return "" + result;
    }

    private boolean isInteger() {
        try {
            Integer.parseInt(firstOp);
            Integer.parseInt(secondOp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInteger(double n) {
        try {
            Integer.parseInt(String.valueOf(n));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double String2Double(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing (Calc3) : " + str);
            return 0;
        }
    }
}
