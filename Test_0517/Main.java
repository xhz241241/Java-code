package Test_0517;
//星际迷航

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] fib = new int[10001];
        fib[1] = 1;
        fib[2] = 2;
        //提前计算好斐波那契数列
        for(int i = 3; i <= 10000; i++){
            fib[i] = (fib[i-1] +fib[i-2]) % 10000;
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                //把输入的每个数字都在对应的斐波那契数中查询到相应的结果并判断
                help(fib[arr[i]]);
            }
            System.out.println();
        }
    }
    public static void help(int num){
        String str = "" + num;
        int len = str.length();
        //判断数字长度
        // == 4 直接输出
        if(len == 4){
            System.out.print(str);
        }
        // > 4 只输出后4位
        else if(len > 4){
            System.out.print(str.substring(len-4));
        }
        // < 4 前面补 0
        else if(len < 4){
            for(int i = 0; i < 4-len; i++){
                System.out.print('0');
            }
            System.out.print(str);
        }
    }
}
