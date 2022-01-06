package com.sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SudokuSolver {
    int size = 9;
    int sqrtSize = (int) Math.sqrt(size);
    Integer[][] input = new Integer[size][size];

    /*************** constructors ***************/
    SudokuSolver() {
    }

    SudokuSolver(Integer[][] input) {
        this.input = input;
    }

    /*************** Methods ***************/

    // main function that calls the solver, and returns 0 in case sudoku is solvable/solved otherwise 1.
    int SudokuSolve() {
        Integer[][] temp = this.input;
        if (SudokuSol()) {
            print(temp);
            return 0;
        } else
            return 1;
    }

    // Starter function for sudoku solver
    // finds 0 and calls isValid function\
    boolean SudokuSol() {
        // iterate over the board and find zero
        int row, col;
        row = col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.input[i][j] == 0) {
                    // change val of row and col and break the loop
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) break;
        }

        // check if sudoku is fully filled
        if (isEmpty) return true;

        for (int i = 1; i <= 9; i++) {
            if (isValid(row, col, i)) {
                this.input[row][col] = i;
                if (SudokuSol()) {
                    return true;
                } else {
                    this.input[row][col] = 0;
                }
            }
        }
        return false;
    }


    // Helper function for Sudoku solver
    // checks row/col and subgrid/subbox for number if exists we won't update that number to array
    boolean isValid(int row, int col, int n) {
        // check if row is valid
        for (int i = 0; i < this.size; i++) {
            if (this.input[row][i] == n) return false;
        }

        // check if column is valid
        for (int i = 0; i < 9; i++) {
            if (this.input[i][col] == n) return false;
        }

        // check grid/sub-box
        int rowStart = row - (row % this.sqrtSize);
        int rowEnd = rowStart + this.sqrtSize;
        int colStart = col - (col % this.sqrtSize);
        int colEnd = colStart + this.sqrtSize;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (this.input[i][j] == n)
                    return false;
            }
        }

        return true;
    }

    public boolean isInputSudokuValid(Integer[][] board) {
        for(int i=0; i < 9; i++){
            HashSet<Integer> row = new HashSet();
            HashSet<Integer> col = new HashSet();
            HashSet<Integer> Box = new HashSet();

            for(int j=0; j < 9; j++){
                if(board[i][j] != 0 && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != 0 && !col.add(board[j][i]))
                    return false;
                int box_row = 3 * (i/3) + j/3;
                int box_col = 3 * (i%3) + j%3;
                if(board[box_row][box_col] != '.' && !Box.add(board[box_row][box_col]))
                    return false;
            }
        }

        return true;
    }


    void takeInput() {
        Scanner s = new Scanner(System.in);
        Integer[][] input = new Integer[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("Input[" + i + "]" + "[" + j + "]" + " : ");
                int temp = s.nextInt();
                while(temp < 0 || temp > 9)
                {
                    System.out.print("Input[" + i + "]" + "[" + j + "]" + " (Err.1) : ");
                    temp = s.nextInt();
                }
                input[i][j] = temp;
            }
        }
        this.input = input;

        System.out.println("Input Sudoku : ");
        print();
        if(SudokuSolve() == 1) {
            System.out.println("\nSolved : ");
            System.out.println("This one has no solution.");
            return;
        }
    }

    void print(Integer[][] temp) {
        // reason to use Integer wrapper class
        if (temp == null) {
            System.out.println("\nError : No Valid Input Found.");
            return;
        }
        System.out.println("\n -------------------------");
        for (int i = 0, k = 1; i < 9; i++, k++) {
            for (int j = 0; j < 9; j++) {
                if ((j % 3 == 0)) {
                    System.out.print(" | " + temp[i][j]);
                } else
                    System.out.print(" " + temp[i][j]);

                if (j == 8)
                    System.out.print(" |");
            }
            if ((k % 3) == 0) System.out.print("\n -------------------------");
            System.out.println();
        }
    }

    // overload function to allow printing sudoku that is in this class Scope.
    void print() {
        print(this.input);
    }
}
