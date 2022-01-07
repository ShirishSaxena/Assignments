package com.backJack;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Card {
    private final static int suitInDeck = 4;
    // Java 9 API - Map.of;
    private static final Map<Integer, String> NoToCardSuit = Map.of(0, "Clubs", 1, "Diamonds",
            2, "Hearts", 3, "Spades");
    private int cardStart = 2, cardEnd = 11;
    private HashSet<String> alreadyDrew = new HashSet<>();

    // constructors
    Card(int cardStart, int cardEnd) {
        this.cardStart = cardStart;
        this.cardEnd = cardEnd;
    }

    // draw card and prevent duplicate draw
    public CardHelper DrawCard() {
        int cardNo = generate();
        int suitNo = generate(this.suitInDeck); // Clubs, Diamonds, Hearts, Spades

        String checkIfDrew = cardNo + NoToCardSuit.get(suitNo);

        // check if already drew no {duplicate check}
        while (alreadyDrew.contains(checkIfDrew)) {
            // not an efficient loop but would do for this assignment //(not to be used in prod.)
            cardNo = generate();
            suitNo = generate(this.suitInDeck);
            checkIfDrew = cardNo + NoToCardSuit.get(suitNo);
        }
        alreadyDrew.add(checkIfDrew); // add to hashmap for next call
        //System.out.println(suitNo + " " + NoToCardSuit.get(suitNo) + " || " + cardNo + " ");
        return new CardHelper(cardNo, NoToCardSuit.get(suitNo));
    }


    // main method to generate number with equal probability
    public int generate() {
        // end is exclusive
        return new Random().nextInt(this.cardEnd) + 1;
    }

    // for deckSuit only
    public int generate(int range) {
        return new Random().nextInt(range - 0) + 0;
    }
}
