package Test_0415;
//进制转化

import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            StringBuilder stringbuilder = new StringBuilder();
            String table = "0123456789ABCDEF";
            boolean flag = false;
            if(m < 0){
                m = -m;
                flag = true;
            }
            while(m != 0){
                stringbuilder.append(table.charAt(m%n));
                m = m / n;
            }
            if(flag){
                stringbuilder.append("-");
            }
            stringbuilder.reverse();
            System.out.println(stringbuilder);
        }
    }
}