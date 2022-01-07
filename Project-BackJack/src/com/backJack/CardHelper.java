package com.backJack;

// Helper function for card return...
public class CardHelper {
    private int n;
    private String cardName;

    public CardHelper(int n, String cardName) {
        this.n = n;
        this.cardName = cardName;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String toString(){
        return "[" + ((this.n == 11) ? "ACE" : this.n) + "] of '" + this.cardName + "'";
    }

}
