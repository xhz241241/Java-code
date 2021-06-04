package Test_0601;
//蘑菇街

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[][] map = new int[n+1][m+1];
            while(k != 0){
                //放蘑菇
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
                k--;
            }
            double[][] dp = new double[n+1][m+1];
            dp[1][1] = 1.0;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    //不是左上角元素的话
                    if(!(i == 1 && j == 1)){
                        dp[i][j] = dp[i-1][j] * (j == m ? 1.0 : 0.5)
                                + dp[i][j-1] * (i == n ? 1.0 : 0.5);
                    }
                    //此处有蘑菇不能走 走不通
                    if(map[i][j] == 1){
                        dp[i][j] = 0.0;
                    }
                }
            }
            System.out.printf("%.2f\n", dp[n][m]);
        }
    }
}