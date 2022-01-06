package com.sudoku;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
/*        Integer[][] board = {
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
        sudo.SudokuSolve();*/

        // Uncomment below lines to generate random sudoku

        int generateRange = 20000;
        List<Integer[][]> list = new ArrayList<>();
        for(int i = 0; i < generateRange; i++){
            GenerateRandomSudoku generateRandomSudoku = new GenerateRandomSudoku();
            list.add(generateRandomSudoku.GenerateRandom());
        }

        System.out.println("List size : " + list.size());
        int invalid = 0;
        long start = System.currentTimeMillis();
        for(Integer[][] temp : list){

            SudokuSolver s = new SudokuSolver(temp);
            //s.print(temp);
            invalid += s.SudokuSolve();

        }

        long end = System.currentTimeMillis();
        System.out.println("Time took to execute " + list.size() + " sudoku : " + (double)(end - start)/1000 + " secs");
        System.out.println("\nInvalid Sudoku's : " + invalid + "\nValid Sudoku's : " + (list.size() - invalid));

    }
}
