package Test_0423;
//连续最大bit数

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //把int类型的数字转成二进制字符串
            String s = Integer.toBinaryString(n);
            int count = 0;
            int max = 0;
            //遍历字符串, 遇到 1 计数器就+1
            //并和当前 max 比较 把最大值赋给 max
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                    max = Math.max(max, count);
                }else{
                    count = 0;
                }
            }
            //最后输出 max
            System.out.println(max);
        }
    }
}