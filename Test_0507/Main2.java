package Test_0507;
//超长正整数相加

//import java.util.*;
//import java.math.BigInteger;
//
//public class Main2{
//    public static void main(String[] args){
//        Scanner sc = new Scanner (System.in);
//        while(sc.hasNext()){
//            String a = sc.nextLine();
//            String b = sc.nextLine();
//            BigInteger n1 = new BigInteger (a);
//            BigInteger n2 = new BigInteger (b);
//            System.out.println(n1.add(n2));
//        }
//    }
//}

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String[] str = a.split(" ");
            System.out.println(Add(str[0], str[1]));
        }
    }
    public static String Add(String a, String b){
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        //判断合法性
        if(!check(ch1)){
            return "error";
        }
        if(!check(ch2)){
            return "error";
        }
        if(ch1.length < ch2.length){
            char[] tem = ch1;
            ch1 = ch2;
            ch2 = tem;
        }
        int q = 0;
        int i = ch1.length-1;
        int j = ch2.length-1;
        for(; j >= 0; j--, i--){
            int add = ch1[i]-'0' + ch2[i]-'0' + q;
            ch1[i] = (char)(add % 10 +'0');
            q = add / 10;
        }
        for(; i >= 0; i--){
            int add = ch1[i]-'0' + q;
            ch1[i] = (char)(add % 10 +'0');
            q = add / 10;
        }
        StringBuffer stringbuffer = new StringBuffer();
        if(q != 0){
            stringbuffer.append(q);
        }
        for(i = 0; i < ch1.length; i++){
            stringbuffer.append(ch1[i]);
        }
        return stringbuffer.toString();
    }
    public static boolean check(char[] c){
        for(int i = 0; i < c.length; i++){
            if(c[i] > '9' || c[i] < '0'){
                return false;
            }
        }
        return true;
    }
}