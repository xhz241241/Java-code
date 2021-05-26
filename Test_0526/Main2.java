package Test_0526;
//客似云来

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //注意: 计算斐波那契数列的数组应该用long存 否则牛客编译不通过
        long[] fib = new long[81];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < 81; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        while(sc.hasNext()){
            int from = sc.nextInt()-1;
            int to = sc.nextInt();
            long sum = 0;
            for(int i = from; i < to; i++){
                sum += fib[i];
            }
            System.out.println(sum);
        }
    }
}