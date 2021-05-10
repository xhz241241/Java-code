package Test_0510;
//查找两个字符串a,b中的最长公共子串

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            //取出较大的字符串和较小的字符串
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = s1.length() >= s2.length() ? s2 : s1;
            String s = "";
            //定义一个当前子串的最大长度
            int len = 0;
            //遍历较小字符串每次取出一部分
            //判断较大字符串中是否包含该子串
            for(int i = 0; i < min.length(); i++){
                for(int j = i + 1; j < min.length(); j++){
                    //如果包含并长度大于当前子串的最大值才替换
                    if(max.contains(min.substring(i, j)) && j-i > len){
                        len = j-i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s);
        }
    }
}