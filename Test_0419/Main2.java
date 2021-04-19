package Test_0419;
//求最小公倍数

import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int min = a < b ? a : b;
            //找到两者之间的较小者
            //再从小的一方开始, 依次判断是否能够整除两者
            //最不济就是两数相乘
            for(int i = min; i <= a * b; i++){
                if(i % a == 0 && i % b == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
