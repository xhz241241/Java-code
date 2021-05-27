package Test_0527;
//养兔子

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long[] fib = new long[91];
        fib[1] = 1;
        fib[2] = 2;
        for(int i = 3; i < 91; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(fib[n]);
        }
    }
}