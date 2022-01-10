package com.calc.CalcHelper;

import java.util.List;

/* String with 2 inputs
    - factorial -> N !
    - trigonometric func -> sin/cos/tan degree
    - negation -> +/- N
    - log base(e) -> log 1.00
*/

public class Calc2Split {
    String firstIn;
    String lastIn;

    String prevResult;
    int parsedInt = 0;
    double parsedDouble = 0;
    public Calc2Split(String prevResult) {
        this.prevResult = prevResult;
    }

    public String getAns(List<String> parsedIn) {
        this.firstIn = parsedIn.get(0);
        this.lastIn = parsedIn.get(1);

        if (firstIn.equals("prev")) this.firstIn = prevResult;
        if (lastIn.equals("prev")) this.lastIn = prevResult;

        String firstIn_Type = findInputType(firstIn);
        String secondIn_Type = findInputType(lastIn);

        if (firstIn_Type.equals("str") && (secondIn_Type.equals("int") || secondIn_Type.equals("double"))) {
            // first input is string and second is either integer or double
            switch (firstIn) {
                case "log":
                case "Log":
                    return findLog(Double.parseDouble(lastIn));
                case "-":
                case "+":
                    return getNegation(secondIn_Type);
                case "sqrt":
                case "squareroot":
                    return findSquareRoot();
                default:
                    return findTrigonometry(secondIn_Type);
            }
        } else if ((firstIn_Type.equals("int") || firstIn_Type.equals("double")) && secondIn_Type.equals("str")) {
            if (lastIn.equals("!")) {
                int n = (int) Double.parseDouble(firstIn);
                int result = getFactorial(n);
                return "" + ((result == 0) ? ("Error : result out of bound for no. " + n + ".") : result);
            }
        }
        return "";
    }

    private int getFactorial(int N) {
        if (N == 0) return 1;
        else return (N * getFactorial(N - 1));
    }

    private String findTrigonometry(String type) {
        double radians = Math.toRadians(Double.parseDouble(lastIn));

        switch (firstIn) {
            case "sin":
                return "" + Math.sin(radians);
            case "cos":
                return "" + Math.cos(radians);
            case "tan":
                return "" + Math.tan(radians);
            default:
                return "Error : " + firstIn + " not supported.";
        }
    }

    private String findSquareRoot() {
        return "" + Math.pow(Double.parseDouble(lastIn), 0.5);
    }

    private String findLog(double N) {
        return "" + Math.log(N);
    }

    private String getNegation(String type) {
        int sign = (firstIn.equals("-")) ? -1 : 1;
        if (type.equals("double")) {
            return "" + (sign * Double.parseDouble(lastIn));
        } else
            return "" + (sign * Integer.parseInt(lastIn));
    }

    private String findInputType(String check) {
        try {
            Integer.parseInt(check);
            return "int";
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(check);
                return "double";
            } catch (NumberFormatException e2) {
                return "str";
            }
        }
    }
}
