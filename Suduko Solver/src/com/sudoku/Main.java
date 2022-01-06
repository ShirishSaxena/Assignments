package com.sudoku;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        /*
        *   Error 1 : Input is not in range of 0-9 (inclusive)
        * */
        // Uncomment below lines to generate random sudoku
        Scanner s = new Scanner(System.in);

        System.out.print("\nWelcome to Sudoku Solver\n1). Hardcoded Sudoku\n2). Input a sudoku\n3). Randomize Sudokus\n4). Exit\n\n");
        System.out.print("Your choice : ");

        int choice = s.nextInt();

        while(choice <= 0 || choice > 4){
            System.out.print("Invalid choice : ");
            choice = s.nextInt();
        }

        switch(choice){
            case 1:
                Choice1();
                break;
            case 2:
                Choice2();
                break;
            case 3:
                System.out.print("\nEnter no of sudoku to generate : ");
                GenerateRandom generateRandom = new GenerateRandom(s.nextInt());
                break;
            default:
                System.out.println("\nThank you");
                System.exit(0);
        }
    }

    static public void Choice1(){
        Integer[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        SudokuSolver sudo = new SudokuSolver(board);
        System.out.print("\nHardcoded sudoku is : ");
        sudo.print();
        System.out.print("\nSolution : ");
        if(sudo.SudokuSolve() == 1) System.out.print("\nThis one has no solution.");

    }

    static public void Choice2(){
        SudokuSolver sudo = new SudokuSolver();
        sudo.takeInput();
    }
}
