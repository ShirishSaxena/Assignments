package com.sudoku;

import java.util.HashSet;
import java.util.Random;

public class GenerateRandomSudoku {
    Integer[][] board = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
    };

    public Integer[][]  GenerateRandom(){
        // add diagonally using hashset to prevent duplicate in sub box
        AddRandomDiagonally();
        return this.board;
    }

    private void AddRandomDiagonally(){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i < 9; i++){
            Integer tempNo = getRandomNumberUsingNextInt(0,10);
            while(set.contains(tempNo)){
                tempNo = getRandomNumberUsingNextInt(0,10);
            }
            if(!set.contains(tempNo)){
                this.board[i][i] = tempNo;
                set.add(tempNo);
            }
        }
    }


    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
            return random.nextInt(max - min) + min;
    }


}
