package Test_0421;
//末尾0的个数

import java.util.*;
//因为 0 是靠 乘 5 乘出来的, 所以我们只需要看输入进来的数字里面有几个 因数5 即可

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            for(int i = n; i >= 1; i--){
                int tem = i;
                //这里需要有一个临时变量
                //分解到没有 5 为止
                while(tem % 5 == 0){
                    count++;
                    tem = tem / 5;
                }
            }
            System.out.println(count);
        }
    }
}