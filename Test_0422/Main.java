package Test_0422;
//斐波那契数列

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //right 表示 n 后一个斐波那契数
            int right = 1;
            //left 表示 n 前一个斐波那契数
            int left = 0;
            int sum = 0;
            //我们让后一个数一直小于 n
            //当有一天后一个数大于 n 时
            //那就证明 n 在两个斐波那契数之间了
            //此时跳出循环
            //再判断 n 离前面近还是离后面近即可
            while(right < n){
                sum = right + left;
                left = right;
                right = sum;
            }
            System.out.println(Math.min(right-n, n-left));
        }
    }
}
