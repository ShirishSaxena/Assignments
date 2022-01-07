package com.backJack;

import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        // Main assignment runner obj
        Scanner s = new Scanner(System.in);
        String replay = "y";

        while(replay.equals("y") || replay.equals("yes")){
            new BlackJack();

            System.out.print("\n\nPlay again? (y/n) : ");
            replay = s.next();

            System.out.println("\n\n");
        }

        System.out.println("Thanks for playing.");
    }
}
