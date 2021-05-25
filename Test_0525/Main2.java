package Test_0525;
//斐波那契凤尾

import java.util.*;


public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100001];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < 100001; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000;
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n < 25){
                System.out.println(arr[n]);
            }else{
                System.out.printf("%06d\n", arr[n]);
            }
        }
    }
}