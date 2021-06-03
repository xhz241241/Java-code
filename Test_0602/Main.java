package Test_0602;
//字符串计数

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            System.out.println((help(s2) - help(s1) - 1 ) % 1000007);
        }
    }
    public static int help(String s){
        int tem = 0;
        for(int i = 0; i < s.length(); i++){
            tem = tem * 26 + s.charAt(i) - 'a';
        }
        return tem;
    }
}
