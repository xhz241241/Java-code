package Test_0428;
//查找输入整数二进制中 1 的个数

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int res = findNumberOf1(n);
            System.out.println(res);
        }
    }

    public static int findNumberOf1(int n){
        //把int类型的整数转换成二进制字符串
        String s = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}