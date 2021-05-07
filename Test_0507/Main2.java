package Test_0507;
//超长正整数相加

import java.util.*;
import java.math.BigInteger;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            BigInteger n1 = new BigInteger (a);
            BigInteger n2 = new BigInteger (b);
            System.out.println(n1.add(n2));
        }
    }
}