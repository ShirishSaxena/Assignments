package com.sudoku;

import java.util.HashSet;
import java.util.Random;

public class GenerateRandom {

    // Base board
    Integer[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    GenerateRandom(int times){
        GenerateRandom(times);
    }
    public void GenerateRandom(int times) {
        // generate random sudoku and save to List
        long start = System.currentTimeMillis();
        int invalid = 0, size = times;
        while(times-- > 0){
            SudokuSolver solver = new SudokuSolver(Randomize());
            invalid += solver.SudokuSolve();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time took to execute " + size + " sudoku : " + (double) (end - start) / 1000 + " secs");
        System.out.println("\nInvalid Sudoku's : " + invalid + "\nValid Sudoku's : " + (size - invalid));
    }

    private Integer[][] Randomize(){
        AddRandomDiagonally();
        return this.board;
    }

    private void AddRandomDiagonally() {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            Integer tempNo = getRandomNumberUsingNextInt(1, 10);
            while (set.contains(tempNo)) {
                tempNo = getRandomNumberUsingNextInt(1, 10);
            }

            if (!set.contains(tempNo)) {
                this.board[i][i] = tempNo;
                set.add(tempNo);
            }
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
