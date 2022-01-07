package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    private static int dealerTotal = 0;
    private static int playerTotal = 0;
    Scanner takeIn = new Scanner(System.in);
    // extra functionality... to show before program ends.
    List<CardHelper> playerDraws = new ArrayList<>();
    List<CardHelper> dealerDraws = new ArrayList<>();
    private int cardStart = 2;
    private int cardEnd = 11;
    private Card drewDeck = new Card(cardStart, cardEnd);

    /*********** Constructors ***********/
    BlackJack() {
        System.out.println("\nWelcome to the blackJack program.\n");
        Firststart();
    }

    BlackJack(int cardStart, int cardEnd) {
        // constructor for case when need different card range...
        this.cardStart = cardStart;
        this.cardEnd = cardEnd;
        System.out.println("\nWelcome to the blackJack program.\n");
        Firststart();
    }

    /*********** Constructors ***********/

    // first run
    void Firststart() {

        // get 2 draws for player and 2 for dealer
        this.playerDraws.add(drewDeck.DrawCard());
        this.playerDraws.add(drewDeck.DrawCard());

        this.dealerDraws.add(drewDeck.DrawCard());
        this.dealerDraws.add(drewDeck.DrawCard());

        this.playerTotal = (playerDraws.get(0).getN() + playerDraws.get(1).getN());
        this.dealerTotal = (dealerDraws.get(0).getN() + dealerDraws.get(1).getN());


        // Display initial dealing
        System.out.println("You get " + playerDraws.get(0).toString() + " and " + playerDraws.get(1).toString() + ".");
        System.out.println("Your total is " + this.playerTotal + ".\n");
        System.out.println("The dealer has " + dealerDraws.get(0).toString() + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.\n");

        // Player Turn now
        DrawPlayer();

        // GameOver
        // Another condition`

        System.out.print("\nWould you like to display all draws by you and dealer? (y/n) : ");
        char ans = takeIn.next().charAt(0);
        if (ans == 'y') {
            ShowAllDraws("You drew", playerDraws);
            ShowAllDraws("Dealer drew", dealerDraws);
        }

        return;
    }

    void DrawPlayer() {
        if (this.playerTotal > 21) {
            System.out.println("\nYou LOSE!");
            return;
        } else if (this.playerTotal == 21) {
            System.out.println("\nYou WIN!");
            return;
        }

        System.out.print("\nWould you like to hit or stay? : ");
        String ans = this.takeIn.next();

        if (ans.equals("hit")) {
            this.playerDraws.add(drewDeck.DrawCard());
            this.playerTotal += this.playerDraws.get(this.playerDraws.size() - 1).getN();

            System.out.println("You drew a " + this.playerDraws.get(this.playerDraws.size() - 1).toString());
            System.out.println("Your total is " + this.playerTotal);

            // recurse this func and ask again
            DrawPlayer();
        } else if (ans.equals("stay")) {
            DealerTurn();
            return;
        } else {
            // One does not back out of a game of blackjack. Keep asking for correct input
            DrawPlayer();
        }
    }

    void DealerTurn() {
        System.out.println("\nOkay, dealer's turn.");
        System.out.println("His hidden card was " + this.dealerDraws.get(this.dealerDraws.size() - 1).toString());
        System.out.println("His total was " + this.dealerTotal + ".\n");

        DrawDealer();
    }

    void DrawDealer() {
        if (this.dealerTotal <= 16) { // dealer will hit
            System.out.println("\nDealer chooses to hit.");
            this.dealerDraws.add(drewDeck.DrawCard());
            this.dealerTotal += this.dealerDraws.get(this.dealerDraws.size() - 1).getN();

            System.out.println("He draws " + this.dealerDraws.get(this.dealerDraws.size() - 1).toString());
            System.out.println("His total is " + this.dealerTotal);

            DrawDealer();
        } else if (this.dealerTotal == 21) {
            System.out.println("\nDealer WINS!");
        } else if (this.dealerTotal > 21) {
            System.out.println("\nYou WIN!");
        } else {
            // if dealer total is greater than 16 but less than 21
            // dealer stays so compare both total and show results.
            System.out.println("\nDealer total is : " + this.dealerTotal + ".");
            System.out.println("Your total is : " + this.playerTotal + ".");

            BothAtStay();
        }
    }

    void BothAtStay() {
        if (this.playerTotal == this.dealerTotal) { // In theory this should never execute
            System.out.println("\nVoila, it's a DRAW! NO ONE WINS");
        } else if (this.playerTotal > this.dealerTotal)
            System.out.println("\nYou WIN!");
        else
            System.out.println("\nDealer WIN!");
    }

    void ShowAllDraws(String whos, List<CardHelper> list) {
        System.out.println("\n" + whos + " : ");
        for (CardHelper l : list) {
            System.out.println(l.toString());
        }
    }
}
