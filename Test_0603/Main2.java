package Test_0603;
//最长上升子序列

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = 1;
            int max = 1;
            for(int i = 1; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(arr[j] < arr[i] && (dp[i]-1 < dp[j])){
                        dp[i] = dp[i] + 1;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            System.out.println(max);
        }
    }
}