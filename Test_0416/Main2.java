package Test_0416;
//连续最大和
import java.util.*;

public class Main2{
    //这道题使用了动态规划的思想
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int cur = arr[0];
            int max = arr[0];
            //遍历当前数组, 如果加上arr[i]比arr[i]要大的话就把arr[i]加上
            //如果加上arr[i]比arr[i]要小的话就从arr[i]开始
            //核心思想就是dp[i] = getmax(dp[i-1] + arr[i], arr[i])
            for(int i = 1; i < n; i++){
                cur = Math.max(cur+arr[i], arr[i]);
                if(cur > max){
                    max = cur;
                }
            }
            System.out.println(max);
        }
    }
}
