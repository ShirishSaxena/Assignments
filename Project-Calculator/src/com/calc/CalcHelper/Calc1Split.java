package com.calc.CalcHelper;

/* String with 1 input
    - Rounding doubles
    - For base 10 to binary
*/
public class Calc1Split {
    String prevResult;

    public Calc1Split(String prevResult) {
        this.prevResult = prevResult;
    }

    public String getAns(String str) {
        if (str.equals("prev"))
            str = this.prevResult;
        String result = "";

        // Boilerplate code to check if input is Integer/Double or a string.
        try {
            result = Integer2Binary(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            try {
                result = RoundDouble(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                return "Error : No command found by name '" + str + "'";
            }
        }
        return result;
    }

    // Methods
    String Integer2Binary(int N) {
        return Integer.toBinaryString(N);
    }

    String RoundDouble(Double N) {
        return "" + (Math.round(N * 100.0) / 100.0);
    }
}
