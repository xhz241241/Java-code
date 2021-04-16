package Test_0412;
//组队竞赛

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            long[] arr = new long[3 * n];
            for(int i = 0; i < 3 * n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long sum = 0;
            // 每组的中间数字的下标为
            // arr.length - 2 * (i + 1)
            for(int i = 0; i < n; i++){
                sum = sum + arr[arr.length - 2 * (i+1)];
            }
            System.out.println(sum);
        }
    }
}
