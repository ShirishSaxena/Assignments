package com.sudoku;

import java.util.Scanner;

public class SudokuSolver {
    int size = 9;
    int sqrtSize = (int) Math.sqrt(size);
    Integer[][] input = new Integer[size][size];
        // i0j0 , 5

    // constructors
    SudokuSolver(){}
    SudokuSolver(Integer[][] input){
        this.input = input;
    }

    // check if row is valid then column then grid/sub-boxes
    boolean isValid(int row, int col, int n){
        // check if row is valid
        for(int i=0; i < this.size; i++){
            if(this.input[row][i] == n) return false;
        }

        // check if column is valid
        for(int i=0; i < 9; i++){
            if(this.input[i][col] == n) return false;
        }

        // check grid/sub-box
        int rowStart = row - (row % this.sqrtSize);
        int rowEnd = rowStart + this.sqrtSize;
        int colStart = col - (col % this.sqrtSize);
        int colEnd = colStart + this.sqrtSize;

        for(int i = rowStart; i < rowEnd; i++){
            for(int j = colStart; j < colEnd; j++){
                if(this.input[i][j] == n)
                    return false;
            }
        }

        return true;

    }
    int SudokuSolve(){
        Integer[][] temp = this.input;
        if(SudokuSol()) {
            print();
            return 0;
        }
        else
            return 1;
    }
    boolean SudokuSol(){
        // iterate over the board and find zero
        int row, col;
        row = col = -1;
        boolean isEmpty = true;

        for(int i=0; i < this.size; i++){
            for(int j=0; j < this.size; j++)
            {
                if(this.input[i][j] == 0){
                    // change val of row and col and break the loop
                    row = i; col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) break;
        }

        // check if sudoku is fully filled
        if(isEmpty) return true;

        for(int i = 1; i <= 9; i++){
            if(isValid(row, col, i)){
                this.input[row][col] = i;
                if(SudokuSol()){
                    return true;
                }
                else{
                    this.input[row][col] = 0;
                }
            }
        }

        return false;
    }


    void takeInput(){
        Scanner s = new Scanner(System.in);
        Integer[][] input = new Integer[9][9];
        for(int i = 0; i < 9; i++){
            for(int j=0; j < 9; j++){
                System.out.println("Input[" + i + "]" + "[" + j + "]" + " : ");
                input[i][j] = s.nextInt();
            }
        }

        this.input = input;
    }

    void print(){
        if(this.input == null) {
            System.out.println("\nError : No Valid Input Found.");
            return;
        }
        System.out.println("\n -------------------------");
        for(int i = 0, k = 1; i < 9; i++, k++){
            for(int j=0; j < 9; j++){
                if((j%3 == 0)){
                    System.out.print(" | " + this.input[i][j]);
                }
                else
                    System.out.print(" " + this.input[i][j]);

                if(j == 8)
                    System.out.print(" |");
            }
            if((k%3) == 0) System.out.print("\n -------------------------");
            System.out.println();
        }
    }

    void print(Integer[][] temp){
        if(temp == null) {
            System.out.println("\nError : No Valid Input Found.");
            return;
        }
        System.out.println("\n -------------------------");
        for(int i = 0, k = 1; i < 9; i++, k++){
            for(int j=0; j < 9; j++){
                if((j%3 == 0)){
                    System.out.print(" | " + temp[i][j]);
                }
                else
                    System.out.print(" " + temp[i][j]);

                if(j == 8)
                    System.out.print(" |");
            }
            if((k%3) == 0) System.out.print("\n -------------------------");
            System.out.println();
        }
    }
}
