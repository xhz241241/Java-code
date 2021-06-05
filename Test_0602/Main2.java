package Test_0602;
//最长公共子序列

import java.util.*;

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            System.out.println(LSC(a, b));
        }
    }
    public static int LSC(String a, String b){
        int row = a.length();
        int col = b.length();
        int[][] dp = new int[row+1][col+1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                //如果当前字符相等
                //当前的最长公共子序列就是 第[i-1][j-1] 个最长公共子序列 + 1
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //反之不相等
                    //当前的最长公共子序列就是 第[i-1][j] 个最长公共子序列
                    //或者第[i][j-1] 个最长公共子序列
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }
}
