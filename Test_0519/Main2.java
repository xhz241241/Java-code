package Test_0519;
//三角形

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            //三条边有可能是浮点数
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            //能构成三角形的充要条件是两边之和大于第三边
            if((a+b>c) && (a+c>b) && (b+c>a)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
