package Test_0513;
//小易的升级之路

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int energy = sc.nextInt();
            int[] arr = new int[num];
            for(int i = 0; i < num; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < num; i++){
                if(arr[i] <= energy){
                    energy = energy + arr[i];
                }else{
                    energy = energy + help(arr[i], energy);
                }
            }
            System.out.println(energy);
        }
    }
    //求最大公约数
    public static int help(int a, int b){
        int min = a > b ? b : a;
        int res = 0;
        for(int i = min; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
                res = i;
                break;
            }
        }
        return res;
    }
}