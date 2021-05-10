package Test_0510;
//汽水瓶

import java.util.*;

public class Main{
    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //此题表明输入 0 表示退出 所以需要单独判断
            if(n == 0){
                return;
            }
            System.out.println(drink(n));
        }
    }

    public static int drink(int n){
        //只有 1 个瓶盖时不能喝
        //有两个瓶盖时可以问老板先借一瓶喝完再还给老板一瓶
        if(n < 2){
            return 0;
        }
        int total = 0;
        while(n > 2){
            //能喝到汽水的瓶数
            total = total + n / 3;
            //喝完后还剩几个瓶子
            n = n / 3 + n % 3;
        }
        //这时还需要判断 如果还剩两个瓶子则再问老板借一个瓶子喝完后再还给老板
        if(n == 2){
            total = total + 1;;
        }
        return total;
    }
}
