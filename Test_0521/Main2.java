package Test_0521;
//有假币

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long n = sc.nextLong();
            if(n == 0){
                return;
            }
            System.out.println(help(n));
        }
    }
    public static int help(long n){
        int count = 0;
        //当一堆币被分成只剩下一个了 那么假币就是最后剩下的那个 不需要在比较了
        while(n >= 2){
            //当一堆币不能被刚好分为三组 比如 5
            //那么余数只有可能是 1 或者 2
            //那么就让 n = 2
            if(n % 3 != 0){
                n = n/3 + 1;
            }else{
                //如果可以被刚好分成三组
                //那么就取出两两进行比较
                n = n/3;
            }
            count++;
        }
        return count;
    }
}
