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
        //保证 ch1 是长的那一个字符串
        if(ch1.length < ch2.length){
            char[] tem = ch1;
            ch1 = ch2;
            ch2 = tem;
        }
        int q = 0;
        int i = ch1.length-1;
        int j = ch2.length-1;
        //把短的字符串加到长的字符串上
        for(; j >= 0; j--, i--){
            //把两个字符串的末尾数字取出加和
            int add = ch1[i]-'0' + ch2[i]-'0' + q;
            //取出加和的个位数
            ch1[i] = (char)(add % 10 +'0');
            //把加和的十位数放入进位中, 下一轮遍历加到前一个数字上
            q = add / 10;
        }
        //短的加完了 再更新长的字符串的进位
        for(; i >= 0; i--){
            int add = ch1[i]-'0' + q;
            ch1[i] = (char)(add % 10 +'0');
            q = add / 10;
        }
        //最后的结果放进一个可变的字符串中
        StringBuffer stringbuffer = new StringBuffer();
        //还需要判断首位进位的情况 比如(9999)需要进位成(10000)
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