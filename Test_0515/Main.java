package Test_0515;
//年终奖

import java.util.*;

public class Main {
    public int getMost(int[][] board) {
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(i == 0){
                    //目前处在第一行, 只能向右走
                    //向右走之前需要把当前行左一个位置上的值加入到结果中
                    board[i][j] = board[i][j] + board[i][j-1];
                }
                else if(j == 0){
                    //目前处在第一列 只能向下走
                    //向下走之前需要把当前列上一个元素的值加到当前结果中
                    board[i][j] = board[i][j] + board[i-1][j];
                }
                else{
                    //当前既不是第一行也不是第一列
                    //所以可以向下走也可以向右走
                    //此时我们需要把这两种走法的值都算一遍 并求出较大者
                    //再加到当前结果中
                    int temup = board[i-1][j];
                    int temleft = board[i][j-1];
                    board[i][j] += Math.max(temup, temleft);
                }
            }
        }
        return board[5][5];
    }
}
