package Test_0520;
//猴子分桃

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                return;
            }
            //假设最初由x个桃子，我们借给猴子4个，则此时 有x+4个。
            //第一个猴子得到（x+4）/5，剩余（x+4）*（4/5）个
            //第二个猴子分完后剩余（x+4） (4/5)^ 2个
            //第三个 猴子分完后剩余（x+4） (4/5)^ 3个 依次类推，
            //第n个猴子分完后剩余（x+4）（4/5）^ n
            //要满足最后剩余的为整 数，并且x最小，则当 x+4=5^ n时，满足要求
            //此时，x = 5^n - 4 即原来的桃子个数
            //老猴子得到的桃子数量为 4^n + n - 4
            double old = Math.pow(4, n) + n - 4;
            double sum = Math.pow(5, n) - 4;
            System.out.println((long)sum + " " + (long)old);
        }
    }
}