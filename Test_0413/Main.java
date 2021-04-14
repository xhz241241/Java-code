package Test_0413;
//排序子序列

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            //flag 为标志符 0代表不增不减 1代表递增 -1 代表递减
            int flag = 0;
            //count 表示子序列的个数
            int count = 1;
            for(int i = 1; i < n; i++){
                if(arr[i-1] < arr[i]){
                    //开始递增
                    if(flag == 0){
                        //如果当前标志符为 0  就把标志符改成 1
                        flag = 1;
                    }
                    if(flag == -1){
                        //如果当前标志符为 -1 就把当前标志符改为 0
                        //并将子序列个数 +1
                        flag = 0;
                        count++;
                    }
                }
                else if(arr[i-1] > arr[i]){
                    //开始递减
                    if(flag == 0){
                        flag = -1;
                    }
                    if(flag == 1){
                        flag = 0;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
