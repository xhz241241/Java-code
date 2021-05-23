package Test_0522;
//因子个数

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //从该数的最小因字数到最大因字数(该数的平方根)依次判断是否能够除余
            //可以就继续除直到除余结果不为0
            //最后剩余的数字如果不为 1 那么也是因子
            int count = 0;
            for(int i = 2; i < Math.sqrt(n); i++){
                if(n % i == 0){
                    while(n % i == 0){
                        n = n/i;
                    }
                    count++;
                }
            }
            if(n != 1){
                count++;
            }
            System.out.println(count);
        }
    }
}