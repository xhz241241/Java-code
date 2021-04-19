package Test_0415;
//计算糖果

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            //使用数学公式计算出ABC的值的表达式
            //其中B有两个表达式
            //我们只需要判断两个表达式中的B 是否相等
            //相等代表计算正确 不等代表不存在这样的数
            int A = (n1+n3)/2;
            int B1 = (n3-n1)/2;
            int B2 = (n4+n2)/2;
            int C = (n4-n2)/2;

            if(B1 != B2){
                System.out.println("No");
            }else{
                System.out.println(A+" " + B1 + " " + C);
            }
        }
    }
}