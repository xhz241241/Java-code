package Test_0511;
//公共子串计算

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            //取出长字符串和短字符串
            String max = a.length() > b.length() ? a : b;
            String min = a.length() > b.length() ? b : a;
            int len = 0;
            //遍历短字符串
            //依次取出短字符串中的所有子串
            //和当前最大子串进行比较
            //保存较大者
            //最后输出最大子串长度即可
            for(int i = 0; i < min.length(); i++){
                for(int j = i +1; j < min.length(); j++){
                    if(max.contains(min.substring(i, j)) && j-i > len){
                        len = j-i;
                    }
                }
            }
            System.out.println(len);
        }
    }
}
