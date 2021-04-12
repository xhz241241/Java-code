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
            for(int i = 3 * n - 2; i >= n; i = i - 2){
                sum = sum + arr[i];
            }
            System.out.println(sum);
        }
    }
}
