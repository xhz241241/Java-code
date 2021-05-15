package Test_0513;
//找出字符串中第一个只出现一次的字符

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            firstSingle(s);
        }
    }
    public static void firstSingle(String s){
        //新创建一个数组用来把出现一次以上的字符标记为-1
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                //遇到相同的字符就把该下标标记为-1
                if(s.charAt(i) == s.charAt(j)){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        int res = -1;
        //在新数组中查找内容为 0 的第一个下标
        //根据该下标找字符并输出
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                //此处输出的是字符串中下标为 i 的字符 不是 i
                System.out.println(s.charAt(i));
                return;
            }
        }
        System.out.println(res);
    }
}